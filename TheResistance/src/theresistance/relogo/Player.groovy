package theresistance.relogo

import static repast.simphony.relogo.Utility.*;
import static repast.simphony.relogo.UtilityG.*;

import repast.simphony.relogo.AgentSet;
import repast.simphony.relogo.Plural;
import repast.simphony.relogo.Stop;
import repast.simphony.relogo.Utility;
import repast.simphony.relogo.UtilityG;
import repast.simphony.relogo.schedule.Go;
import repast.simphony.relogo.schedule.Setup;
import theresistance.ReLogoTurtle;

class Player extends ReLogoTurtle {
	private String role
	private int order
	private boolean leader = false
	private Array


	def communicate(){
		if (leader == true){

			//System.out.println(myOutTrustLinks());
			def mostTrustedPlayer = getPlayerwithLargestTV(myOutTrustLinks(), 1);
			def leastTrustedPlayer = getPlayerwithLowestTV(myOutTrustLinks());


			//TODO
			// get all trustLinks from the most trusted player
			def trustLinksMostTrustedPlayer
			ask(mostTrustedPlayer){
				trustLinksMostTrustedPlayer = myOutTrustLinks();
			}
			//adjust own trustLink according to formula t = t + tp* diff
			//System.out.println("These are the trustlinks of my most trusted player:")
			for (link in trustLinksMostTrustedPlayer){
				//System.out.println("Next")
				//System.out.println(link)
				//System.out.println(trustLink(this, link.getEnd2())) == corresponding trustlink with
				//new value for each link:
				def TI = trustLink(this, link.getEnd2());
				if (TI != null){
					double ti = TI.getTrustValue(); // current trust in player X
					double tp = trustLink(this, mostTrustedPlayer).getTrustValue(); // current trust in most Trusted player
					// scale tp to range [-1 1] via formula y = 2x - 1
					tp = 2*tp -1;
					double tpi = link.getTrustValue(); // trust of most trusted player in other player X

					double new_ti = ti + tp * (tpi - ti);
					System.out.println("Ti: " + ti + " tp: " + tp + " tpi: " + tpi + " new_ti: " + new_ti)
					trustLink(this, link.getEnd2()).setTrustValue(new_ti);
				}
			}

		}
	}



	def chooseTeam(int teamSize){
		AgentSet<theresistance.relogo.Player> team = new ArrayList()
		team.add(this)
		team.add(getPlayerwithLargestTV(myOutTrustLinks(), 1))
		if (teamSize == 3){
			team.add(getPlayerwithLargestTV(myOutTrustLinks(), 2))
		}
		return team
	}

	def AgentSet<TrustLink> adjustTrustValue(){

		return trustset;
	}

	public Player getPlayerwithLowestTV(AgentSet<TrustLink> trustLinkSet){
		def list = trustLinkSet;
		list.sort({m1, m2 -> m1.trustValue <=> m2.trustValue})
		return list[0].getEnd2()
		//beacuse list[0] is self
	}

	public Player getPlayerwithLargestTV(AgentSet<TrustLink> trustLinkSet, int nr) {
		def list = trustLinkSet;
		list.sort({m1, m2 -> m1.trustValue <=> m2.trustValue})
		list = list.reverse()


		if (nr == 1){
			return list[0].getEnd2()
		}
		else if (nr == 2){
			return list[1].getEnd2()
		}
		return index;
	}

	//update trustvalues based on observation



	def voteForTeam(AgentSet<Player> team){
		//System.out.println("I voted " + 1 + "and I am  " + order)
		return 1;
	}

	def voteResultMission(){
		if (role == "Spy"){
			return 1;
		}else{
			return 0;
		}
	}

	// set and get functions
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
