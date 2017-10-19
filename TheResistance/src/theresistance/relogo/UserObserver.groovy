package theresistance.relogo

import static repast.simphony.relogo.Utility.*;
import static repast.simphony.relogo.UtilityG.*;
import repast.simphony.relogo.AgentSet
import repast.simphony.relogo.Stop
import repast.simphony.relogo.Turtle;
import repast.simphony.relogo.Utility;
import repast.simphony.relogo.UtilityG
import repast.simphony.relogo.builder.ReLogoBuilderGeneratedFor;
import repast.simphony.relogo.schedule.Go;
import repast.simphony.relogo.schedule.Setup;
import theresistance.ReLogoObserver;

class UserObserver extends ReLogoObserver{
	/**
	 * setup the initial state of the game
	 */
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
			if (order ==1){
				setLeader(true);
				label = order.toString() + "*"
				ask(games()){
					setNewLeader()
				}
			}else{
				label = order.toString();
			}
			//set ID and leader order
			order = order+1
			// also tells this to the game
			
			
			
			//set players initial trust values
			for (player in players()){
				testValue = generator.nextDouble()
				if (player.getOrder() != getOrder()){
					l = createTrustLinkTo(player)
					l.setTrustValue(testValue)
				}
				
			}
			//testValue = 1;
			
			//visualisation
			size = 4
			setxy(randomXcor(), randomYcor())
		}
		
		
		
	/*end setup*/	
	}
	
	@Go
	def go(){
		//define initial variables
		def chosen = false
		def leader= [];
		def List team;
		// start round!
		System.out.println("Go!")
		
		// first the leader is allowed to communicate
		System.out.println("Communicate!")
		for (game in games()){
			leader.add( game.getLeader())
		}
		
		println leader;
		ask(leader[0]){communicate()}
		
		
		// while there is no team
		while(chosen == false){
			// ask leader to choose a team with a specific nr of players
			System.out.println("choose team")
			
			def int teamSize;
			for (g in games()){
				teamSize = g.getTeamSize()
			}
			println teamSize
			team = leader[0].chooseTeam(teamSize);
			println team
			//after the leader has chosen a team, other players will vote in favor of or against the team
			System.out.println("vote for team!")
			
			//collect votes
			def votes = [0];
			ask(players()){
				// ask all players to vote on the team
				votes.add(voteForTeam(team));
			}
			//if a majority of the votes is in favor of the team, the team is chosen
			System.out.println("The sum = " + votes.value.sum() )
			if (votes.value.sum() > 2){
				chosen = true;
			}
		}
		// end while loop
		
		//the team is on mission, so ask them for their vote
		def vote = 0;
		ask(team){
			vote = vote + voteResultMission()
		}
		
		// if the mission has not succeeded:
		if (vote != 0){
			updateMissionStatus("failed");
			// update trustvalues of each player
			
		//if the mission has succeeded	
		}else{
			// ask game to record this
			updateMissionStatus('succeed');
			// update trustvalues of each player
		
		}
		
		//continue with the next round
		ask(games()){
				println getMissionStatus();
				increaseMissionRound();
				setNewLeader();
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