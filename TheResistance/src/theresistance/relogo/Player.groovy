package theresistance.relogo

import static repast.simphony.relogo.Utility.*;
import static repast.simphony.relogo.UtilityG.*;

import bsh.This;
import repast.simphony.relogo.AgentSet;
import repast.simphony.relogo.Plural;
import repast.simphony.relogo.Stop;
import repast.simphony.relogo.Utility;
import repast.simphony.relogo.UtilityG;
import repast.simphony.relogo.schedule.Go;
import repast.simphony.relogo.schedule.Setup;
import theresistance.ReLogoTurtle;
import java.lang.Math;

class Player extends ReLogoTurtle {
	private String role
	private int order
	private boolean leader = false
	private Array

	// functions of action in the game
	def voteForTeam(AgentSet<Player> team, int count){
		if ( count >= 3 & role == "Resistance"){
			System.out.println("I voted " + 1 + "and I am  " + this.toString())
			return 1;
		}

		if (team.contains(getPlayerwithLowestTV(myOutTrustLinks(), 1)) | team.contains(getPlayerwithLowestTV(myOutTrustLinks(), 2)  ) ){
			System.out.println("I voted " + 0 + "and I am  " + this.toString())
			return 0;

		}else {
			System.out.println("I voted " + 1 + "and I am  " + this.toString())
			return 1;
		}
	}

	def voteResultMission(){
		if (role == "Spy"){
			return 1;
		}else{
			return 0;
		}
	}

	def chooseTeam(int teamSize){
		// this function determines which team is chosen
		AgentSet<theresistance.relogo.Player> team = new ArrayList()
		team.add(this)
		// if you are not a spy, then choose the player(s) you trust most
		if (role == "Resistance"){
			team.add(getPlayerwithLargestTV(myOutTrustLinks(), 1))
			if (teamSize == 3){
				team.add(getPlayerwithLargestTV(myOutTrustLinks(), 2))
			}
			// if you are a spy, then choose random two other players, but not your fellow spy
		}else{
			Random randomizer = new Random();
			def teamfull = false;
			while(!teamfull){
				println "choosing team for spy"
				Player random = players().get(randomizer.nextInt(players().size()));
				println random
				if (random.getRole() != "Spy"){
					team.add(random);
					if (team.size() >= teamSize){
						teamfull = true;
					}
				}
			}
		}
		return team
	}

	def printMe(){
		println this.toString();
	}
	def communicate(){
		// the agent gets its most trusted friend and asks this friend for information about the other agents.
		// the agent updates its own values depending on the trust it has in the receiver and the receivers trust in the other agents

		//System.out.println(myOutTrustLinks());
		def mostTrustedPlayer = getPlayerwithLargestTV(myOutTrustLinks(), 1);
		//def leastTrustedPlayer = getPlayerwithLowestTV(myOutTrustLinks(), 1);
		double tp = trustLink(this, mostTrustedPlayer).getTrustValue(); // current trust in most Trusted player

		println "I am asking " + mostTrustedPlayer + " and my trust in him is " + tp;

		// get all trustLinks from the most trusted player
		def trustLinksMostTrustedPlayer
		ask(mostTrustedPlayer){
			trustLinksMostTrustedPlayer = myOutTrustLinks();
		}
		//adjust own trustLink according to formula t = t + tp* diff
		for (link in trustLinksMostTrustedPlayer){
			//new value for each link:
			def TI = trustLink(this, link.getEnd2());
			//println TI
			if (TI != null){
				double ti = TI.getTrustValue(); // current trust in player X
				// scale tp to range [-1 1] via formula y = 2x - 1
				tp = 2*tp -1;
				double tpi = link.getTrustValue(); // trust of most trusted player in other player X

				double new_ti = ti + tp * (tpi - ti);
				if (new_ti <= 0){
					new_ti = 0.01;
				}
				if (new_ti>=1){
					new_ti = 0.99;
				}

				// scale tp back for printing purposes
				tp = tp/2.0 +0.5;
				System.out.println("Ti: " + ti + " tp: " + tp + " tpi: " + tpi + " new_ti: " + new_ti)
				trustLink(this, link.getEnd2()).setTrustValue(new_ti);
			}
		}
	}


	def updateTrustValueBasedonDO(AgentSet<Player> team, String missionStatus, int vote){
		def ab;
		// if the mission has succeeded
		if (missionStatus == "succeed"){
			// if the player is part of the team
			if (team.contains(this)){
				// and the teamSize is 2
				if (team.size() == 2){
					// then
					//ab = 0.4;
					ab = DI_s_2
				} else {
					// if team size == 3:
					//ab = 0.1;
				// ab = DI_s_3, but since DI_s_3 == DO_s_2, we use that
					ab = DO_s_2
				}
				// if the players is NOT part of the team
			} else {
				if (team.size() == 2){
					// then
					//					ab = 0.2;
					ab = DO_s_2
				} else {
					// if team size == 3:
					//					ab = 0.1;
					ab = DO_s_3
				}
			}
			// if the mission failed
		} else{
			// if the player is part of the team
			if (team.contains(this)){
				if (vote == 2 ){
					ab = DI_doublefail;
				}else{
					// and the teamSize is 2
					if (team.size() == 2){
						// then
						//ab = -0.99;
						ab = DI_f_2
					} else {
						// if team size == 3:
						//ab = -0.1;
						// ab = DI_f_3, but since DI_f_3 == DO_f_2, we use that
						ab = DO_f_2
					}
				}
				// if the players is NOT part of the team
			} else {

				if (team.size() == 2){
					if (vote == 2){
						ab = DI_doublefail;
					}else{
						// then
						//					ab = -0.2;
						ab = DO_f_2
					}
				} else {
					// if team size == 3:
					//ab = -0.1;
					if (vote == 2){
						ab = DO_doublefail;
					}	else{
						ab = DO_f_3
					}

				}
			}
		}
		println this.toString() + " " + missionStatus + " alphabeta = " + ab
		updateTrustValueAlphaBeta(ab, team);
	}

	// update trustvalue based on direct observation based on formula
	def updateTrustValueAlphaBeta(double alphabeta, AgentSet<Player> team){
		def newValue;

		// if alphabeta >=0 cooperation, if alphabeta <0 dan defection
		if (alphabeta >= 0){
			//Cooperation by j:
			// if t > 0: t + alpha(1-t)
			// if t<0: (t + alpha) /(1-min{|t|, |a|}
			// if t = 0: alpha
			for (p in team){

				def link = trustLink(this, p);
				if (link != null){
					def tp = link.getTrustValue();
					// scale trustvalue in range [-1, 1] with 2x-1
					tp = 2*tp -1;
					if (tp > 0){
						newValue = tp+alphabeta*(1-tp);
					} else if (tp < 0) {
						newValue = (tp+alphabeta)/(1-Math.min(Math.abs(tp), alphabeta));
					} else if (tp == 0){
						newValue = alphabeta;
					}
					// scale the newValue back to [0, 1]
					newValue = (newValue/2.0) +0.5;
					if (newValue  <= 0){
						newValue  = 0.01;
					}
					if (newValue >=1){
						newValue  = 0.99;
					}
					tp = (tp/2.0) +0.5;
					trustLink(this, link.getEnd2()).setTrustValue(newValue);
					println "I am: " + this.toString() + " and I update " + p.toString() + " from " + tp + " to " + newValue;

				}
			}
		} else {
			// defection by j:
			// if t > 0: (t + beta)(1-min{|t|, |beta|})
			// if t < 0: t + beta(1 + t)
			// if t = 0: beta
			for (p in team){
				def link = trustLink(this, p);
				if (link != null){
					def tp = link.getTrustValue();
					// scale trustvalue in range [-1, 1] with 2x-1
					tp = 2*tp -1;
					if (tp > 0){
						newValue = (tp+alphabeta)/(1-Math.min(abs(tp), Math.abs(alphabeta)));
					} else if (tp < 0) {
						newValue = tp+alphabeta*(1+tp);
					} else if (tp == 0){
						newValue = alphabeta;
					}

					// scale the newValue back to [0, 1]
					//println "new Value before scaling: " + newValue;
					newValue = (newValue/2.0) +0.5;
					//println "new Value after scaling: " + newValue;
					if (newValue  <= 0){
						newValue  = 0.01;
					}
					if (newValue >=1){
						newValue  = 0.99;
					}
					tp = (tp/2.0) +0.5;
					trustLink(this, link.getEnd2()).setTrustValue(newValue);
					println "I am: " + this.toString() + " and I update " + p.toString() + " from " + tp + " to " + newValue;

				}
			}
		}


	}



	// helper functions
	public Player getPlayerwithLowestTV(AgentSet<TrustLink> trustLinkSet, Integer nr){
		def list = trustLinkSet;
		list.sort({m1, m2 -> m1.trustValue <=> m2.trustValue})


		if (nr == 1){
			return list[0].getEnd2()
		}
		else if (nr == 2){
			return list[1].getEnd2()
		}
		return index;
	}


	public Player getPlayerwithLargestTV(AgentSet<TrustLink> trustLinkSet, Integer nr) {
		def list = trustLinkSet;
		list.sort({m1, m2 -> m1.trustValue <=> m2.trustValue})
		list = list.reverse();

		if (nr == 1){
			return list[0].getEnd2()
		}
		else if (nr == 2){
			return list[1].getEnd2()
		}
		return index;
	}


	// set and get functions
	def AgentSet<TrustLink> adjustTrustValue(){

		return trustset;
	}


	def setRole(String role){
		this.role = role;
	}
	def getRole(){
		return role;
	}
	def setOrder(int order){
		this.order = order
	}

	def getOrder(){
		return order
	}
	def setLeader(boolean leader){
		this.leader = leader
	}
	def getLeader(){
		return leader
	}

	def returnSelf(){
		return this;
	}

}
