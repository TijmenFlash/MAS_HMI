package theresistance.relogo

import static repast.simphony.relogo.Utility.*;
import static repast.simphony.relogo.UtilityG.*;

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
	
	def setRole(String role){
		this.role = role;
	}
	def setOrder(int order){
		this.order = order
	}
	def setLeader(boolean leader){
		this.leader = leader
	}
	
	def chooseTeam(){
		if (leader == true){
			
			
			
		}
	}
	
	def voteForTeam(){
		
	}
	
	def voteResultMission(){
		
	}
}
