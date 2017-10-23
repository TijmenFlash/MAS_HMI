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
public class ReLogoObserver extends BaseObserver{

	/**
	 * Makes a number of randomly oriented games and then executes a set of commands on the
	 * created games.
	 * 
	 * @param number
	 *            a number
	 * @param closure
	 *            a set of commands
	 * @return created games
	 */
	@ReLogoBuilderGeneratedFor("theresistance.relogo.Game")
	public AgentSet<theresistance.relogo.Game> createGames(int number, Closure closure) {
		AgentSet<theresistance.relogo.Game> result = new AgentSet<>();
		AgentSet<Turtle> createResult = this.crt(number,closure,"Game");
		for (Turtle t : createResult){
			if (t instanceof theresistance.relogo.Game){
				result.add((theresistance.relogo.Game)t);
			}
		} 
		return result; 
	}

	/**
	 * Makes a number of randomly oriented games and then executes a set of commands on the
	 * created games.
	 * 
	 * @param number
	 *            a number
	 * @param closure
	 *            a set of commands
	 * @return created games
	 */
	@ReLogoBuilderGeneratedFor("theresistance.relogo.Game")
	public AgentSet<theresistance.relogo.Game> createGames(int number) {
		return createGames(number,null);
	}

	/**
	 * Makes a number of uniformly fanned games and then executes a set of commands on the
	 * created games.
	 * 
	 * @param number
	 *            a number
	 * @param closure
	 *            a set of commands
	 * @return created games
	 */
	@ReLogoBuilderGeneratedFor("theresistance.relogo.Game")
	public AgentSet<theresistance.relogo.Game> createOrderedGames(int number, Closure closure) {
		AgentSet<theresistance.relogo.Game> result = new AgentSet<>();
		AgentSet<Turtle> createResult = this.cro(number,closure,"Game");
		for (Turtle t : createResult){
			if (t instanceof theresistance.relogo.Game){
				result.add((theresistance.relogo.Game)t);
			}
		} 
		return result; 
	}

	/**
	 * Makes a number of uniformly fanned games and then executes a set of commands on the
	 * created games.
	 * 
	 * @param number
	 *            a number
	 * @param closure
	 *            a set of commands
	 * @return created games
	 */
	@ReLogoBuilderGeneratedFor("theresistance.relogo.Game")
	public AgentSet<theresistance.relogo.Game> createOrderedGames(int number) {
		return createOrderedGames(number,null);
	}

	/**
	 * Queries if object is a game.
	 * 
	 * @param o
	 *            an object
	 * @return true or false based on whether the object is a game
	 */
	@ReLogoBuilderGeneratedFor("theresistance.relogo.Game")
	public boolean isGameQ(Object o){
		return (o instanceof theresistance.relogo.Game);
	}

	/**
	 * Returns an agentset containing all games.
	 * 
	 * @return agentset of all games
	 */
	@ReLogoBuilderGeneratedFor("theresistance.relogo.Game")
	public AgentSet<theresistance.relogo.Game> games(){
		AgentSet<theresistance.relogo.Game> a = new AgentSet<theresistance.relogo.Game>();
		for (Object e : this.getContext().getObjects(theresistance.relogo.Game.class)) {
			if (e instanceof theresistance.relogo.Game){
				a.add((theresistance.relogo.Game)e);
			}
		}
		return a;
	}

	/**
	 * Returns the game with the given who number.
	 * 
	 * @param number
	 *            a number
	 * @return turtle number
	 */
	@ReLogoBuilderGeneratedFor("theresistance.relogo.Game")
	public theresistance.relogo.Game game(Number number){
		Turtle turtle = Utility.turtleU(number.intValue(), this);
		if (turtle instanceof theresistance.relogo.Game)
			return (theresistance.relogo.Game) turtle;
		return null;
	}

	/**
	 * Returns an agentset of games on a given patch.
	 * 
	 * @param p
	 *            a patch
	 * @return agentset of games on patch p
	 */
	@ReLogoBuilderGeneratedFor("theresistance.relogo.Game")
	public AgentSet<theresistance.relogo.Game> gamesOn(Patch p){
		AgentSet<theresistance.relogo.Game> result = new AgentSet<theresistance.relogo.Game>();						
		for (Turtle t : Utility.getTurtlesOnGridPoint(p.getGridLocation(),this,"game")){
			if (t instanceof theresistance.relogo.Game)
			result.add((theresistance.relogo.Game)t);
		}
		return result;
	}

	/**
	 * Returns an agentset of games on the same patch as a turtle.
	 * 
	 * @param t
	 *            a turtle
	 * @return agentset of games on the same patch as turtle t
	 */
	@ReLogoBuilderGeneratedFor("theresistance.relogo.Game")
	public AgentSet<theresistance.relogo.Game> gamesOn(Turtle t){
		AgentSet<theresistance.relogo.Game> result = new AgentSet<theresistance.relogo.Game>();						
		for (Turtle tt : Utility.getTurtlesOnGridPoint(Utility.ndPointToGridPoint(t.getTurtleLocation()),this,"game")){
			if (tt instanceof theresistance.relogo.Game)
			result.add((theresistance.relogo.Game)tt);
		}
		return result;
	}

	/**
	 * Returns an agentset of games on the patches in a collection or on the patches
	 * that a collection of turtles are.
	 * 
	 * @param a
	 *            a collection
	 * @return agentset of games on the patches in collection a or on the patches
	 *         that collection a turtles are
	 */
	@ReLogoBuilderGeneratedFor("theresistance.relogo.Game")
	public AgentSet<theresistance.relogo.Game> gamesOn(Collection c){

		if (c == null || c.isEmpty()){
			return new AgentSet<theresistance.relogo.Game>();
		}

		Set<theresistance.relogo.Game> total = new HashSet<theresistance.relogo.Game>();
		if (c.iterator().next() instanceof Turtle){
			for (Object o : c){
				if (o instanceof Turtle){
					Turtle t = (Turtle) o;
					total.addAll(gamesOn(t));
				}
			}
		}
		else {
			for (Object o : c){
				if (o instanceof Patch){
					Patch p = (Patch) o;
					total.addAll(gamesOn(p));
				}
			}
		}
		return new AgentSet<theresistance.relogo.Game>(total);
	}

	/**
	 * Makes a number of randomly oriented players and then executes a set of commands on the
	 * created players.
	 * 
	 * @param number
	 *            a number
	 * @param closure
	 *            a set of commands
	 * @return created players
	 */
	@ReLogoBuilderGeneratedFor("theresistance.relogo.Player")
	public AgentSet<theresistance.relogo.Player> createPlayers(int number, Closure closure) {
		AgentSet<theresistance.relogo.Player> result = new AgentSet<>();
		AgentSet<Turtle> createResult = this.crt(number,closure,"Player");
		for (Turtle t : createResult){
			if (t instanceof theresistance.relogo.Player){
				result.add((theresistance.relogo.Player)t);
			}
		} 
		return result; 
	}

	/**
	 * Makes a number of randomly oriented players and then executes a set of commands on the
	 * created players.
	 * 
	 * @param number
	 *            a number
	 * @param closure
	 *            a set of commands
	 * @return created players
	 */
	@ReLogoBuilderGeneratedFor("theresistance.relogo.Player")
	public AgentSet<theresistance.relogo.Player> createPlayers(int number) {
		return createPlayers(number,null);
	}

	/**
	 * Makes a number of uniformly fanned players and then executes a set of commands on the
	 * created players.
	 * 
	 * @param number
	 *            a number
	 * @param closure
	 *            a set of commands
	 * @return created players
	 */
	@ReLogoBuilderGeneratedFor("theresistance.relogo.Player")
	public AgentSet<theresistance.relogo.Player> createOrderedPlayers(int number, Closure closure) {
		AgentSet<theresistance.relogo.Player> result = new AgentSet<>();
		AgentSet<Turtle> createResult = this.cro(number,closure,"Player");
		for (Turtle t : createResult){
			if (t instanceof theresistance.relogo.Player){
				result.add((theresistance.relogo.Player)t);
			}
		} 
		return result; 
	}

	/**
	 * Makes a number of uniformly fanned players and then executes a set of commands on the
	 * created players.
	 * 
	 * @param number
	 *            a number
	 * @param closure
	 *            a set of commands
	 * @return created players
	 */
	@ReLogoBuilderGeneratedFor("theresistance.relogo.Player")
	public AgentSet<theresistance.relogo.Player> createOrderedPlayers(int number) {
		return createOrderedPlayers(number,null);
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
	 * Returns an agentset containing all players.
	 * 
	 * @return agentset of all players
	 */
	@ReLogoBuilderGeneratedFor("theresistance.relogo.Player")
	public AgentSet<theresistance.relogo.Player> players(){
		AgentSet<theresistance.relogo.Player> a = new AgentSet<theresistance.relogo.Player>();
		for (Object e : this.getContext().getObjects(theresistance.relogo.Player.class)) {
			if (e instanceof theresistance.relogo.Player){
				a.add((theresistance.relogo.Player)e);
			}
		}
		return a;
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
		Turtle turtle = Utility.turtleU(number.intValue(), this);
		if (turtle instanceof theresistance.relogo.Player)
			return (theresistance.relogo.Player) turtle;
		return null;
	}

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
		for (Turtle t : Utility.getTurtlesOnGridPoint(p.getGridLocation(),this,"player")){
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
		for (Turtle tt : Utility.getTurtlesOnGridPoint(Utility.ndPointToGridPoint(t.getTurtleLocation()),this,"player")){
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
	 * Makes a number of randomly oriented userTurtles and then executes a set of commands on the
	 * created userTurtles.
	 * 
	 * @param number
	 *            a number
	 * @param closure
	 *            a set of commands
	 * @return created userTurtles
	 */
	@ReLogoBuilderGeneratedFor("theresistance.relogo.UserTurtle")
	public AgentSet<theresistance.relogo.UserTurtle> createUserTurtles(int number, Closure closure) {
		AgentSet<theresistance.relogo.UserTurtle> result = new AgentSet<>();
		AgentSet<Turtle> createResult = this.crt(number,closure,"UserTurtle");
		for (Turtle t : createResult){
			if (t instanceof theresistance.relogo.UserTurtle){
				result.add((theresistance.relogo.UserTurtle)t);
			}
		} 
		return result; 
	}

	/**
	 * Makes a number of randomly oriented userTurtles and then executes a set of commands on the
	 * created userTurtles.
	 * 
	 * @param number
	 *            a number
	 * @param closure
	 *            a set of commands
	 * @return created userTurtles
	 */
	@ReLogoBuilderGeneratedFor("theresistance.relogo.UserTurtle")
	public AgentSet<theresistance.relogo.UserTurtle> createUserTurtles(int number) {
		return createUserTurtles(number,null);
	}

	/**
	 * Makes a number of uniformly fanned userTurtles and then executes a set of commands on the
	 * created userTurtles.
	 * 
	 * @param number
	 *            a number
	 * @param closure
	 *            a set of commands
	 * @return created userTurtles
	 */
	@ReLogoBuilderGeneratedFor("theresistance.relogo.UserTurtle")
	public AgentSet<theresistance.relogo.UserTurtle> createOrderedUserTurtles(int number, Closure closure) {
		AgentSet<theresistance.relogo.UserTurtle> result = new AgentSet<>();
		AgentSet<Turtle> createResult = this.cro(number,closure,"UserTurtle");
		for (Turtle t : createResult){
			if (t instanceof theresistance.relogo.UserTurtle){
				result.add((theresistance.relogo.UserTurtle)t);
			}
		} 
		return result; 
	}

	/**
	 * Makes a number of uniformly fanned userTurtles and then executes a set of commands on the
	 * created userTurtles.
	 * 
	 * @param number
	 *            a number
	 * @param closure
	 *            a set of commands
	 * @return created userTurtles
	 */
	@ReLogoBuilderGeneratedFor("theresistance.relogo.UserTurtle")
	public AgentSet<theresistance.relogo.UserTurtle> createOrderedUserTurtles(int number) {
		return createOrderedUserTurtles(number,null);
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
	 * Returns an agentset containing all userTurtles.
	 * 
	 * @return agentset of all userTurtles
	 */
	@ReLogoBuilderGeneratedFor("theresistance.relogo.UserTurtle")
	public AgentSet<theresistance.relogo.UserTurtle> userTurtles(){
		AgentSet<theresistance.relogo.UserTurtle> a = new AgentSet<theresistance.relogo.UserTurtle>();
		for (Object e : this.getContext().getObjects(theresistance.relogo.UserTurtle.class)) {
			if (e instanceof theresistance.relogo.UserTurtle){
				a.add((theresistance.relogo.UserTurtle)e);
			}
		}
		return a;
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
		Turtle turtle = Utility.turtleU(number.intValue(), this);
		if (turtle instanceof theresistance.relogo.UserTurtle)
			return (theresistance.relogo.UserTurtle) turtle;
		return null;
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
		for (Turtle t : Utility.getTurtlesOnGridPoint(p.getGridLocation(),this,"userTurtle")){
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
		for (Turtle tt : Utility.getTurtlesOnGridPoint(Utility.ndPointToGridPoint(t.getTurtleLocation()),this,"userTurtle")){
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
	 * Queries if object is a trustLink.
	 * 
	 * @param o
	 *            an object
	 * @return true or false based on whether the object is a trustLink
	 */
	@ReLogoBuilderGeneratedFor("theresistance.relogo.TrustLink")
	public boolean isTrustLinkQ(Object o){
		return (o instanceof theresistance.relogo.TrustLink);
	}

	/**
	 * Returns an agentset containing all trustLinks.
	 * 
	 * @return agentset of all trustLinks
	 */
	@ReLogoBuilderGeneratedFor("theresistance.relogo.TrustLink")
	public AgentSet<theresistance.relogo.TrustLink> trustLinks(){
		AgentSet<theresistance.relogo.TrustLink> a = new AgentSet<theresistance.relogo.TrustLink>();
		for (Object e : this.getContext().getObjects(theresistance.relogo.TrustLink.class)) {
			if (e instanceof theresistance.relogo.TrustLink){
				a.add((theresistance.relogo.TrustLink)e);
			}
		}
		return a;
	}

	/**
	 * Returns the trustLink between two turtles.
	 * 
	 * @param oneEnd
	 *            an integer
	 * @param otherEnd
	 *            an integer
	 * @return trustLink between two turtles
	 */
	@ReLogoBuilderGeneratedFor("theresistance.relogo.TrustLink")
	public theresistance.relogo.TrustLink trustLink(Number oneEnd, Number otherEnd) {
		return (theresistance.relogo.TrustLink)(this.getNetwork("TrustLink").getEdge(turtle(oneEnd),turtle(otherEnd)));
	}

	/**
	 * Returns the trustLink between two turtles.
	 * 
	 * @param oneEnd
	 *            a turtle
	 * @param otherEnd
	 *            a turtle
	 * @return trustLink between two turtles
	 */
	@ReLogoBuilderGeneratedFor("theresistance.relogo.TrustLink")
	public theresistance.relogo.TrustLink trustLink(Turtle oneEnd, Turtle otherEnd) {
		return trustLink(oneEnd.getWho(), otherEnd.getWho());
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
		for (Object e : this.getContext().getObjects(theresistance.relogo.UserLink.class)) {
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
		return (theresistance.relogo.UserLink)(this.getNetwork("UserLink").getEdge(turtle(oneEnd),turtle(otherEnd)));
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

	/**
	 * Returns the value of the global variable DI_f_2.
	 *
	 * @return the value of the global variable DI_f_2
	 */
	@ReLogoBuilderGeneratedFor("global: DI_f_2")
	public Object getDI_f_2(){
		return repast.simphony.relogo.ReLogoModel.getInstance().getModelParam("DI_f_2");
	}

	/**
	 * Sets the value of the global variable DI_f_2.
	 *
	 * @param value
	 *            a value
	 */
	@ReLogoBuilderGeneratedFor("global: DI_f_2")
	public void setDI_f_2(Object value){
		repast.simphony.relogo.ReLogoModel.getInstance().setModelParam("DI_f_2",value);
	}

	/**
	 * Returns the value of the global variable DI_f_3.
	 *
	 * @return the value of the global variable DI_f_3
	 */
	@ReLogoBuilderGeneratedFor("global: DI_f_3")
	public Object getDI_f_3(){
		return repast.simphony.relogo.ReLogoModel.getInstance().getModelParam("DI_f_3");
	}

	/**
	 * Sets the value of the global variable DI_f_3.
	 *
	 * @param value
	 *            a value
	 */
	@ReLogoBuilderGeneratedFor("global: DI_f_3")
	public void setDI_f_3(Object value){
		repast.simphony.relogo.ReLogoModel.getInstance().setModelParam("DI_f_3",value);
	}

	/**
	 * Returns the value of the global variable DI_s_2.
	 *
	 * @return the value of the global variable DI_s_2
	 */
	@ReLogoBuilderGeneratedFor("global: DI_s_2")
	public Object getDI_s_2(){
		return repast.simphony.relogo.ReLogoModel.getInstance().getModelParam("DI_s_2");
	}

	/**
	 * Sets the value of the global variable DI_s_2.
	 *
	 * @param value
	 *            a value
	 */
	@ReLogoBuilderGeneratedFor("global: DI_s_2")
	public void setDI_s_2(Object value){
		repast.simphony.relogo.ReLogoModel.getInstance().setModelParam("DI_s_2",value);
	}

	/**
	 * Returns the value of the global variable DI_s_3.
	 *
	 * @return the value of the global variable DI_s_3
	 */
	@ReLogoBuilderGeneratedFor("global: DI_s_3")
	public Object getDI_s_3(){
		return repast.simphony.relogo.ReLogoModel.getInstance().getModelParam("DI_s_3");
	}

	/**
	 * Sets the value of the global variable DI_s_3.
	 *
	 * @param value
	 *            a value
	 */
	@ReLogoBuilderGeneratedFor("global: DI_s_3")
	public void setDI_s_3(Object value){
		repast.simphony.relogo.ReLogoModel.getInstance().setModelParam("DI_s_3",value);
	}

	/**
	 * Returns the value of the global variable DO_f_2.
	 *
	 * @return the value of the global variable DO_f_2
	 */
	@ReLogoBuilderGeneratedFor("global: DO_f_2")
	public Object getDO_f_2(){
		return repast.simphony.relogo.ReLogoModel.getInstance().getModelParam("DO_f_2");
	}

	/**
	 * Sets the value of the global variable DO_f_2.
	 *
	 * @param value
	 *            a value
	 */
	@ReLogoBuilderGeneratedFor("global: DO_f_2")
	public void setDO_f_2(Object value){
		repast.simphony.relogo.ReLogoModel.getInstance().setModelParam("DO_f_2",value);
	}

	/**
	 * Returns the value of the global variable DO_f_3.
	 *
	 * @return the value of the global variable DO_f_3
	 */
	@ReLogoBuilderGeneratedFor("global: DO_f_3")
	public Object getDO_f_3(){
		return repast.simphony.relogo.ReLogoModel.getInstance().getModelParam("DO_f_3");
	}

	/**
	 * Sets the value of the global variable DO_f_3.
	 *
	 * @param value
	 *            a value
	 */
	@ReLogoBuilderGeneratedFor("global: DO_f_3")
	public void setDO_f_3(Object value){
		repast.simphony.relogo.ReLogoModel.getInstance().setModelParam("DO_f_3",value);
	}

	/**
	 * Returns the value of the global variable DO_s_2.
	 *
	 * @return the value of the global variable DO_s_2
	 */
	@ReLogoBuilderGeneratedFor("global: DO_s_2")
	public Object getDO_s_2(){
		return repast.simphony.relogo.ReLogoModel.getInstance().getModelParam("DO_s_2");
	}

	/**
	 * Sets the value of the global variable DO_s_2.
	 *
	 * @param value
	 *            a value
	 */
	@ReLogoBuilderGeneratedFor("global: DO_s_2")
	public void setDO_s_2(Object value){
		repast.simphony.relogo.ReLogoModel.getInstance().setModelParam("DO_s_2",value);
	}

	/**
	 * Returns the value of the global variable DO_s_3.
	 *
	 * @return the value of the global variable DO_s_3
	 */
	@ReLogoBuilderGeneratedFor("global: DO_s_3")
	public Object getDO_s_3(){
		return repast.simphony.relogo.ReLogoModel.getInstance().getModelParam("DO_s_3");
	}

	/**
	 * Sets the value of the global variable DO_s_3.
	 *
	 * @param value
	 *            a value
	 */
	@ReLogoBuilderGeneratedFor("global: DO_s_3")
	public void setDO_s_3(Object value){
		repast.simphony.relogo.ReLogoModel.getInstance().setModelParam("DO_s_3",value);
	}


}