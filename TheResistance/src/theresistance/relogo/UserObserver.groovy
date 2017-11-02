package theresistance.relogo

import static repast.simphony.relogo.Utility.*;
import static repast.simphony.relogo.UtilityG.*;
import repast.simphony.parameter.Parameters;
import repast.simphony.relogo.AgentSet
import repast.simphony.relogo.Stop
import repast.simphony.relogo.Turtle;
import repast.simphony.relogo.Utility;
import repast.simphony.relogo.UtilityG
import repast.simphony.relogo.builder.ReLogoBuilderGeneratedFor;
import repast.simphony.relogo.schedule.Go;
import repast.simphony.relogo.schedule.Setup;
import theresistance.ReLogoObserver;
import repast.simphony.engine.environment.RunEnvironment;

class UserObserver extends ReLogoObserver{
	/**
	 * setup the initial state of the game
	 * 
	 * 
	 */
	def winner;

	@Setup
	def Setup(){
		clearAll()
		int order = 1;
		int xcor = 1;
		int ycor = 1;
		TrustLink l;
		double testValue = 1;
		int maxPlayers = 5;
		int count = 1;
		int spyCount = 0;
		Random generator = new Random();

		Parameters p = RunEnvironment.getInstance().getParameters();
		DI_f_2 = p.getValue("DI_f_2");
		DI_f_3= p.getValue("DI_f_3");
		DI_s_2= p.getValue("DI_s_2");
		DI_s_3= p.getValue("DI_s_3");
		DO_f_2= p.getValue("DO_f_2");
		DO_f_3= p.getValue("DO_f_3");
		DO_s_2= p.getValue("DO_s_2");
		DO_s_3= p.getValue("DO_s_3");
		DO_doublefail = p.getValue("DO_doublefail");
		DI_doublefail = p.getValue("DI_doublefail");
		createGames(1){

		}
		

		// create maximum number of players
		createPlayers(maxPlayers){
			// make sure that the spies are randomized
			int spyChance = random(4)

			if (spyCount < 2 & (spyChance == 0 |(count == maxPlayers & spyCount != 2) |(count == 4 & spyCount==0)))  {
				setRole("Spy");
				spyCount+=1
				shape = "zombie"
			}else{
				setRole("Resistance")
				shape = "person"
			}
			count+=1

			//determine the player order
			setOrder(order);

			if(order==1){
				setxy(0, 10)
				setLeader(true);
				label = "agent"
				ask(games()){
					setNewLeader()
				}
			}
			if(order==2){
				setxy(12, 2)
				label = "agent"
			}
			if(order==3){
				setxy(7, -11)
				label = "agent"
			}
			if(order==4){
				setxy(-7, -11)
				label = "agent"
			}
			if(order==5){
				setxy(-12, 2)
				label = "agent"
			}


			//set ID and leader order
			order = order+1

			//set players initial trust values
			for (player in players()){
				//testValue = generator.nextDouble()
				testValue = 0.5 + generator.nextDouble()/10.0;
				if (player.getOrder() != getOrder()){
					l = createTrustLinkTo(player)
					l.setTrustValue(testValue)
				}

			}
			//testValue = 1;

			//visualisation
			size = 4
			//setxy(randomXcor(), randomYcor())
		}



		/*end setup*/	
	}

	@Go
	def go(){
		//define initial variables
		def chosen = false
		
		def List team;
		def boolean timeout = false;
		// start round!
		System.out.println("Go!")
		//print out trust values at that point
//		ask(players()){
//			println printMe() + " " + getRole()
//			for (t in myOutTrustLinks()){
//				println "My trust in " + t.getEnd2() + "(" + t.getEnd2().getRole()+ ")"+ " is " + t.getTrustValue()
//			}
//		}
		

		
		def int teamSize;
		for (g in games()){
			teamSize = g.getTeamSize()
		}
		// while there is no team
		int count = 0;
		while(chosen == false){
			def leader= [];
			
			// first the leader is allowed to communicate
			System.out.println("Communicate!")
			for (game in games()){
				leader.add( game.getLeader())
			}
			//println leader;
			ask(leader[0]){communicate()}
			
			//println "current count = " + count
			count++;
			
			// ask leader to choose a team with a specific nr of players
//			System.out.println("choose team")
//			println "the leader is " +  leader;
//			println teamSize
			team = leader[0].chooseTeam(teamSize);
			println team
			//after the leader has chosen a team, other players will vote in favor of or against the team
			System.out.println("vote for team!")
//			ask(leader[0]){
//				for (t in myOutTrustLinks()){
//					print t.getEnd2().toString() + " " + t.getTrustValue() + " "
//
//				}
//				println ""
//			}
			//collect votes
			def votes = [0];
			ask(players()){
				// ask all players to vote on the team
				votes.add(voteForTeam(team, count));
			}
			//if a majority of the votes is in favor of the team, the team is chosen
			System.out.println("The sum = " + votes.value.sum() )
			if (votes.value.sum() > 2){
				chosen = true;
			}else if (count >= 4){
				chosen = true;
				timeout = true;
			}else{
				// otherwise a new leader is selected
				ask(games()){
					//println "setting new leader"
					setNewLeader();
				}
			}
		}
		// end while loop

		if (timeout == false){
			//the team is on mission, so ask them for their vote
			def vote = 0;
			ask(team){
				vote = vote + voteResultMission()
			}

			if (vote == 2){
				println "double fail!"
			}
			// if the mission has not succeeded:
			if (vote != 0){
				updateMissionStatus("failed");
				// update trustvalues of each player
				// set alphabeta value for failed based on teamsize:
				ask(players()){
					updateTrustValueBasedonDO(team, "failed", vote);
				}
				//if the mission has succeeded
			}else{
				// ask game to record this
				updateMissionStatus('succeed');
				// update trustvalues of each player
				ask(players()){
					updateTrustValueBasedonDO(team, "succeed", vote);
				}
			}
		}else{
			println "Failed due to timeout"
			updateMissionStatus("failed");
			// update trustvalues of each player
			// set alphabeta value for failed based on teamsize:
		}
		
		
		boolean endrun = false;
		//continue with the next round
		ask(games()){
			println getMissionStatus();
			increaseMissionRound();
			setNewLeader();
			def missionFail = getMissionRound() - getMissionSucceed();
			if (getMissionRound()==5 | missionFail >=3 | getMissionSucceed() >=3){
				endrun = true;
			}
		}

		if (endrun == true){
			println "END OF GAME"
			RunEnvironment.getInstance().endRun();


			ask(games()){
				println getMissionStatus()
				if (getMissionSucceed() >= 3){
					ask(games()){
						setWinner("Resistance")
					}
					setWinner("Resistance")
					println "The winners are the resistance!"
				} else{
					ask(games()){
						setWinner("Spy")
					}
					setWinner("Spy")
					println "The winners are the spies!"
				}
			}

//			ask(players()){
//				println printMe() + " " + getRole()
//				for (t in myOutTrustLinks()){
//					println "My trust in " + t.getEnd2() + "(" + t.getEnd2().getRole()+ ")"+ " is " + t.getTrustValue()
//				}
//			}
		}
	}

	def updateMissionStatus(String status){
		ask(games()){
			addMissionStatus(status);
			if (status == "succeed"){
				increaseMissionSucceed();
			}
		}

	}

	def setWinner(String winner){
		this.winner = winner;
	}

	def getWinner(){
		return winner;
	}

	//	@ReLogoBuilderGeneratedFor("theresistance.relogo.Player")
	//	public theresistance.relogo.Player getLeader(){
	//
	//		for (i in players()){
	//			if (i.getLeader() == true){
	//			return i;
	//			}
	//		}
	//
	//	}
	/**
	 @Go
	 def go(){
	 ask(turtles()){
	 left(random(90))
	 right(random(90))
	 forward(random(10))
	 }
	 }
	 */

}