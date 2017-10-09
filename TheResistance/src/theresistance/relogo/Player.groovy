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
	
	

	
	def chooseTeam(int teamSize){
		if (leader == true){
			System.out.println("Volgende!")
			//Collections.sort(myOutTrustLinks(), Comparator.comparingDouble(getTrustValue()))
			
			for (connection in myOutTrustLinks()){
				ask(connection){String p = getEnd2().getRole()
					String x = getEnd2().getOrder()
					String y = getTrustValue()
					System.out.println(p + " " + x +" "+ y)
				}
			}
			Player test = getPlayerwithLargestTV(myOutTrustLinks(), 1);
			System.out.println("Order of max = " + test.getOrder().toString());
			
			
			
			AgentSet<theresistance.relogo.Player> team = new ArrayList()
			team.add(this)
			
		}
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
		
		// insert a set of trustvalues and returns the agent who is connected to the one with the highest
//		int largest = Integer.MIN_VALUE
//		int secondLargest = Integer.MIN_VALUE
//		Player one;
//		Player two;
//		for (TrustLink t : trustLinkSet){
//			if (t.getTrustValue()>largest){
//				largest = 
//				largest = t.getTrustValue();
//				index = t.getEnd2();
//			}
//		}
//		
		return index;	
	}
	

	 
	
	def voteForTeam(){
		
	}
	
	def voteResultMission(){
		
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
	
}
