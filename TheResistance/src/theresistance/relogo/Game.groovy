package theresistance.relogo

import static repast.simphony.relogo.Utility.*;
import static repast.simphony.relogo.UtilityG.*;

import repast.simphony.relogo.AgentSet
import repast.simphony.relogo.Plural;
import repast.simphony.relogo.Stop;
import repast.simphony.relogo.Utility;
import repast.simphony.relogo.UtilityG;
import repast.simphony.relogo.schedule.Go;
import repast.simphony.relogo.schedule.Setup;
import theresistance.ReLogoTurtle;

class Game extends ReLogoTurtle {
//Class which determines the order of the game
	

		Player leader;
		def missionStatus =  [];
		def missionCount = 0;
		def missionSucceed = 0;
		def missionRound = 0;
		List<Integer> maxTeam = Arrays.asList(2, 3, 2, 3, 3);
		def currentOrder = 0;
	
	
	def setLeader(Player leader){
		this.leader = leader;
	}
	
	def setNewLeader(){
		increaseCurrentOrder();
		println "the current order is:" + currentOrder 
		for(player in players()){
			if(player.getOrder() == getCurrentOrder()){
				setLeader(player)
			}
		}
	}
	
	def increaseCurrentOrder(){
		currentOrder++;
	}
	
	def getCurrentOrder(){
		return currentOrder;
	}
	
	def getLeader(){
		System.out.println("The leader is " + leader.toString())
		return leader;
	}
	
	
	def addMissionStatus(String status){
		missionStatus.add(status);
	}
	
	def getMissionstatus(){
		return missionStatus;
	}
	
	def getChosen(){
		return chosen;
	}
	def getMissionRound(){
		return missionRound;
	}
	
	def increaseMissionRound(){
		missionRound++;
	}
	
	def getTeamSize(){
		return maxTeam[missionRound]
	}
	
	def setChosen(boolean chosen){
		this.chosen = chosen;
	}
	
	def setMissionCount(int missionCount){
		this.missionCount = missionCount
	}
	
	def getMissionCount(){
		return missionCount;
	}
	
	def increaseMissionSucceed(){
		missionSucceed++;
	}
	
	
}
