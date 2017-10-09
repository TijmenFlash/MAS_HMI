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
		int gameRound = 1
		double testValue = 1;
		int maxPlayers = 5;
		int count = 1;
		int spyCount = 0;
		
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
				setLeader(true)
				label = order.toString() + "*"
			}else{
				label = order.toString();
			}
			
			//visualisation
			size = 4
			
			setxy(randomXcor(), randomYcor())
			
			//xcor+=2; ycor+=2;
			order = order+1
			
			for (player in players()){
				testValue-=0.2
				l = createTrustLinkTo(player)
				l.setTrustValue(testValue + random(1)/10)
			}
			testValue = 1;
		}
		
		
		
	/*end setup*/	
	}
	
	@Go
	def go(){
		System.out.println("Go!")
		ask(players()){voteForTeam()}
		def chosen = false;
		AgentSet<Player> team;
		
		
		while(chosen == false){
		// while there is no team
		// ask leader to choose a team with a specific nr of players
			System.out.println("choose leader")
		ask(getLeader()){
			team = chooseTeam(2)
		}
		
		System.out.println("vote for team")
		def votes = [0];
		ask(players()){
			// ask all players to vote on the team
			votes.add(voteForTeam(team));
			
		}
		System.out.println("The sum = " + votes.value.sum() )
		if (votes.value.sum() > 2){
			
			chosen = true;
		}
		
		}
		System.out.println("The end" )
		
		ask(players()){
			
		}
	}
	
	
	@ReLogoBuilderGeneratedFor("theresistance.relogo.Player")
	public theresistance.relogo.Player getLeader(){
		
		for (i in players()){
			if (i.getLeader() == true){
			return i;
			}
		}
		
	}
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