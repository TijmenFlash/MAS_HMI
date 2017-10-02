package theresistance.relogo

import static repast.simphony.relogo.Utility.*;
import static repast.simphony.relogo.UtilityG.*;

import repast.simphony.relogo.Plural;
import repast.simphony.relogo.Stop;
import repast.simphony.relogo.Utility;
import repast.simphony.relogo.UtilityG;
import repast.simphony.relogo.schedule.Go;
import repast.simphony.relogo.schedule.Setup;
import theresistance.ReLogoLink;

class TrustLink extends ReLogoLink {
	private double trustValue = 0;
	private int playerNr;
	
	def getPlayerNr(){
		return playerNr;
	}
	
	def setPlayerNr(int player){
		playerNr = player;
	}
	
	def getTrustValue(){
		return trustValue;
	}
	
	def setTrustValue(double trust){
		trustValue = trust;
		if (trust >0.5){
		setColor(55);
		} else{
		setColor(15);
		}
	}
	
}
