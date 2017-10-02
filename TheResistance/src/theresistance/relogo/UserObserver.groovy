package theresistance.relogo

import static repast.simphony.relogo.Utility.*;
import static repast.simphony.relogo.UtilityG.*;
import repast.simphony.relogo.Stop;
import repast.simphony.relogo.Utility;
import repast.simphony.relogo.UtilityG;
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
		
		int gameRound = 1
		
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
			
			setxy(xcor, ycor)
			
			xcor+=2; ycor+=2;
			order = order+1
			
		}
	/*end setup*/	
	}
	
	@Go
	def go(){
		ask(players()){
			chooseTeam()
				
		}
		for (int i = 1; i < 10; i++){
			ask(players()){voteForTeam(i.toString())}
		}
		
		ask(players()){
			
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