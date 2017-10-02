package theresistance;

import static repast.simphony.relogo.Utility.*;
import static repast.simphony.relogo.UtilityG.*;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import groovy.lang.Closure;
import repast.simphony.relogo.*;
import repast.simphony.relogo.builder.GeneratedByReLogoBuilder;
import repast.simphony.relogo.builder.ReLogoBuilderGeneratedFor;

@GeneratedByReLogoBuilder
@SuppressWarnings({"unused","rawtypes","unchecked"})
public class ReLogoLink<T> extends BaseLink<T>	{

	/**
	 * Returns an agentset of players on a given patch.
	 * 
	 * @param p
	 *            a patch
	 * @return agentset of players on patch p
	 */
	@ReLogoBuilderGeneratedFor("theresistance.relogo.Player")
	public AgentSet<theresistance.relogo.Player> playersOn(Patch p){
		AgentSet<theresistance.relogo.Player> result = new AgentSet<theresistance.relogo.Player>();						
		for (Turtle t : Utility.getTurtlesOnGridPoint(p.getGridLocation(),getMyObserver(),"player")){
			if (t instanceof theresistance.relogo.Player)
			result.add((theresistance.relogo.Player)t);
		}
		return result;
	}

	/**
	 * Returns an agentset of players on the same patch as a turtle.
	 * 
	 * @param t
	 *            a turtle
	 * @return agentset of players on the same patch as turtle t
	 */
	@ReLogoBuilderGeneratedFor("theresistance.relogo.Player")
	public AgentSet<theresistance.relogo.Player> playersOn(Turtle t){
		AgentSet<theresistance.relogo.Player> result = new AgentSet<theresistance.relogo.Player>();						
		for (Turtle tt : Utility.getTurtlesOnGridPoint(Utility.ndPointToGridPoint(t.getTurtleLocation()),getMyObserver(),"player")){
			if (tt instanceof theresistance.relogo.Player)
			result.add((theresistance.relogo.Player)tt);
		}
		return result;
	}

	/**
	 * Returns an agentset of players on the patches in a collection or on the patches
	 * that a collection of turtles are.
	 * 
	 * @param a
	 *            a collection
	 * @return agentset of players on the patches in collection a or on the patches
	 *         that collection a turtles are
	 */
	@ReLogoBuilderGeneratedFor("theresistance.relogo.Player")
	public AgentSet<theresistance.relogo.Player> playersOn(Collection c){

		if (c == null || c.isEmpty()){
			return new AgentSet<theresistance.relogo.Player>();
		}

		Set<theresistance.relogo.Player> total = new HashSet<theresistance.relogo.Player>();
		if (c.iterator().next() instanceof Turtle){
			for (Object o : c){
				if (o instanceof Turtle){
					Turtle t = (Turtle) o;
					total.addAll(playersOn(t));
				}
			}
		}
		else {
			for (Object o : c){
				if (o instanceof Patch){
					Patch p = (Patch) o;
					total.addAll(playersOn(p));
				}
			}
		}
		return new AgentSet<theresistance.relogo.Player>(total);
	}

	/**
	 * Queries if object is a player.
	 * 
	 * @param o
	 *            an object
	 * @return true or false based on whether the object is a player
	 */
	@ReLogoBuilderGeneratedFor("theresistance.relogo.Player")
	public boolean isPlayerQ(Object o){
		return (o instanceof theresistance.relogo.Player);
	}

	/**
	 * Returns the player with the given who number.
	 * 
	 * @param number
	 *            a number
	 * @return turtle number
	 */
	@ReLogoBuilderGeneratedFor("theresistance.relogo.Player")
	public theresistance.relogo.Player player(Number number){
		Turtle turtle = Utility.turtleU(number.intValue(), getMyObserver());
		if (turtle instanceof theresistance.relogo.Player)
			return (theresistance.relogo.Player) turtle;
		return null;
	}

	/**
	 * Returns an agentset containing all players.
	 * 
	 * @return agentset of all players
	 */
	@ReLogoBuilderGeneratedFor("theresistance.relogo.Player")
	public AgentSet<theresistance.relogo.Player> players(){
		AgentSet<theresistance.relogo.Player> a = new AgentSet<theresistance.relogo.Player>();
		for (Object e : this.getMyObserver().getContext().getObjects(theresistance.relogo.Player.class)) {
			if (e instanceof theresistance.relogo.Player){
				a.add((theresistance.relogo.Player)e);
			}
		}
		return a;
	}

	/**
	 * Returns an agentset of userTurtles on a given patch.
	 * 
	 * @param p
	 *            a patch
	 * @return agentset of userTurtles on patch p
	 */
	@ReLogoBuilderGeneratedFor("theresistance.relogo.UserTurtle")
	public AgentSet<theresistance.relogo.UserTurtle> userTurtlesOn(Patch p){
		AgentSet<theresistance.relogo.UserTurtle> result = new AgentSet<theresistance.relogo.UserTurtle>();						
		for (Turtle t : Utility.getTurtlesOnGridPoint(p.getGridLocation(),getMyObserver(),"userTurtle")){
			if (t instanceof theresistance.relogo.UserTurtle)
			result.add((theresistance.relogo.UserTurtle)t);
		}
		return result;
	}

	/**
	 * Returns an agentset of userTurtles on the same patch as a turtle.
	 * 
	 * @param t
	 *            a turtle
	 * @return agentset of userTurtles on the same patch as turtle t
	 */
	@ReLogoBuilderGeneratedFor("theresistance.relogo.UserTurtle")
	public AgentSet<theresistance.relogo.UserTurtle> userTurtlesOn(Turtle t){
		AgentSet<theresistance.relogo.UserTurtle> result = new AgentSet<theresistance.relogo.UserTurtle>();						
		for (Turtle tt : Utility.getTurtlesOnGridPoint(Utility.ndPointToGridPoint(t.getTurtleLocation()),getMyObserver(),"userTurtle")){
			if (tt instanceof theresistance.relogo.UserTurtle)
			result.add((theresistance.relogo.UserTurtle)tt);
		}
		return result;
	}

	/**
	 * Returns an agentset of userTurtles on the patches in a collection or on the patches
	 * that a collection of turtles are.
	 * 
	 * @param a
	 *            a collection
	 * @return agentset of userTurtles on the patches in collection a or on the patches
	 *         that collection a turtles are
	 */
	@ReLogoBuilderGeneratedFor("theresistance.relogo.UserTurtle")
	public AgentSet<theresistance.relogo.UserTurtle> userTurtlesOn(Collection c){

		if (c == null || c.isEmpty()){
			return new AgentSet<theresistance.relogo.UserTurtle>();
		}

		Set<theresistance.relogo.UserTurtle> total = new HashSet<theresistance.relogo.UserTurtle>();
		if (c.iterator().next() instanceof Turtle){
			for (Object o : c){
				if (o instanceof Turtle){
					Turtle t = (Turtle) o;
					total.addAll(userTurtlesOn(t));
				}
			}
		}
		else {
			for (Object o : c){
				if (o instanceof Patch){
					Patch p = (Patch) o;
					total.addAll(userTurtlesOn(p));
				}
			}
		}
		return new AgentSet<theresistance.relogo.UserTurtle>(total);
	}

	/**
	 * Queries if object is a userTurtle.
	 * 
	 * @param o
	 *            an object
	 * @return true or false based on whether the object is a userTurtle
	 */
	@ReLogoBuilderGeneratedFor("theresistance.relogo.UserTurtle")
	public boolean isUserTurtleQ(Object o){
		return (o instanceof theresistance.relogo.UserTurtle);
	}

	/**
	 * Returns the userTurtle with the given who number.
	 * 
	 * @param number
	 *            a number
	 * @return turtle number
	 */
	@ReLogoBuilderGeneratedFor("theresistance.relogo.UserTurtle")
	public theresistance.relogo.UserTurtle userTurtle(Number number){
		Turtle turtle = Utility.turtleU(number.intValue(), getMyObserver());
		if (turtle instanceof theresistance.relogo.UserTurtle)
			return (theresistance.relogo.UserTurtle) turtle;
		return null;
	}

	/**
	 * Returns an agentset containing all userTurtles.
	 * 
	 * @return agentset of all userTurtles
	 */
	@ReLogoBuilderGeneratedFor("theresistance.relogo.UserTurtle")
	public AgentSet<theresistance.relogo.UserTurtle> userTurtles(){
		AgentSet<theresistance.relogo.UserTurtle> a = new AgentSet<theresistance.relogo.UserTurtle>();
		for (Object e : this.getMyObserver().getContext().getObjects(theresistance.relogo.UserTurtle.class)) {
			if (e instanceof theresistance.relogo.UserTurtle){
				a.add((theresistance.relogo.UserTurtle)e);
			}
		}
		return a;
	}

	/**
	 * Queries if object is a userLink.
	 * 
	 * @param o
	 *            an object
	 * @return true or false based on whether the object is a userLink
	 */
	@ReLogoBuilderGeneratedFor("theresistance.relogo.UserLink")
	public boolean isUserLinkQ(Object o){
		return (o instanceof theresistance.relogo.UserLink);
	}

	/**
	 * Returns an agentset containing all userLinks.
	 * 
	 * @return agentset of all userLinks
	 */
	@ReLogoBuilderGeneratedFor("theresistance.relogo.UserLink")
	public AgentSet<theresistance.relogo.UserLink> userLinks(){
		AgentSet<theresistance.relogo.UserLink> a = new AgentSet<theresistance.relogo.UserLink>();
		for (Object e : this.getMyObserver().getContext().getObjects(theresistance.relogo.UserLink.class)) {
			if (e instanceof theresistance.relogo.UserLink){
				a.add((theresistance.relogo.UserLink)e);
			}
		}
		return a;
	}

	/**
	 * Returns the userLink between two turtles.
	 * 
	 * @param oneEnd
	 *            an integer
	 * @param otherEnd
	 *            an integer
	 * @return userLink between two turtles
	 */
	@ReLogoBuilderGeneratedFor("theresistance.relogo.UserLink")
	public theresistance.relogo.UserLink userLink(Number oneEnd, Number otherEnd) {
		return (theresistance.relogo.UserLink)(this.getMyObserver().getNetwork("UserLink").getEdge(turtle(oneEnd),turtle(otherEnd)));
	}

	/**
	 * Returns the userLink between two turtles.
	 * 
	 * @param oneEnd
	 *            a turtle
	 * @param otherEnd
	 *            a turtle
	 * @return userLink between two turtles
	 */
	@ReLogoBuilderGeneratedFor("theresistance.relogo.UserLink")
	public theresistance.relogo.UserLink userLink(Turtle oneEnd, Turtle otherEnd) {
		return userLink(oneEnd.getWho(), otherEnd.getWho());
	}


}