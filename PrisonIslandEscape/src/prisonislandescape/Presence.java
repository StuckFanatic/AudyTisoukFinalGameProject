package prisonislandescape;

//The Presence is something that will chase the player

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Presence {

	private int awarenessLevel;
	private Location currentLocation;
	private boolean chasing;
	private boolean justStartedChase;

    public Presence(Location startingLocation) {
        this.awarenessLevel = 0;
        this.currentLocation = startingLocation;
        this.chasing = false;
        this.justStartedChase = false;
    }

    public int getAwarenessLevel() {
        return awarenessLevel;
    }

    public void increaseAwareness(int amount) {
        awarenessLevel += amount;
        
        if (awarenessLevel >= 100) {
        	awarenessLevel = 100;
        	chasing = true;
        	justStartedChase = true;
        }
    }

    public void decreaseAwareness(int amount) {
        awarenessLevel -= amount;

        if (awarenessLevel < 0) {
            awarenessLevel = 0;
        }
    }

    public boolean hasFoundPlayer() {
        return awarenessLevel >= 100;
    }
    
    public boolean isChasing() {
    	return chasing;
    }
    
    public boolean justStartedChase() {
    	return justStartedChase;
    }
    
    public void resetChaseFlag() {
    	justStartedChase = false;
    }
    
    public void checkTension() {
    	
    	if (chasing) {
            System.out.println("It is hunting you.");
            return;
        }

        if (awarenessLevel >= 75) {
            System.out.println("You feel something close. Breathing. Watching.");
        }
        else if (awarenessLevel >= 50) {
            System.out.println("The air feels heavier. The Island is aware.");
        }
        else if (awarenessLevel >= 25) {
            System.out.println("A distant metallic echo rings somewhere unseen.");
        }
    	
    }
    
    public Location getCurrentLocation() {
    	
    	return currentLocation;
    }
    
    public void moveTo(Location newLocation) {
        currentLocation = newLocation;
    }
    
    public void roam(Location playerLocation) {

    	    if (currentLocation == null) return;

    	    // ----- CHASE MODE -----
    	    if (chasing) {

    	        for (Location loc : currentLocation.getExits().values()) {
    	            if (loc == playerLocation) {
    	                System.out.println("(DEBUG) Presence lunges toward you!");
    	                currentLocation = loc;
    	                return;
    	            }
    	        }

    	        return;
    	    }

    	    // ----- HUNTING MODE (50–99) -----
    	    if (awarenessLevel >= 50) {

    	        for (Location loc : currentLocation.getExits().values()) {
    	            if (loc == playerLocation) {
    	                System.out.println("(DEBUG) Presence moves with purpose...");
    	                currentLocation = loc;
    	                return;
    	            }
    	        }
    	    }

    	    // ----- WANDERING MODE -----
    	    List<Location> possibleMoves =
    	            new ArrayList<>(currentLocation.getExits().values());

    	    if (possibleMoves.isEmpty()) return;

    	    Random random = new Random();
    	    Location next = possibleMoves.get(random.nextInt(possibleMoves.size()));

    	    System.out.println("(DEBUG) Presence moving from "
    	            + currentLocation + " to " + next);

    	    currentLocation = next;
    }
	
    
}
