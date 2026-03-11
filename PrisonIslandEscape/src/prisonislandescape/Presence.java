package prisonislandescape;

//The Presence is something that will chase the player

import java.util.ArrayList;
import java.io.Serializable;
import java.util.List;
import java.util.Random;

public class Presence implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private int awarenessLevel;
	private Location currentLocation;
	private boolean chasing;
	private boolean justStartedChase;
	private int stunnedTurns = 0;

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
    
    public void stun (int turns) {
    	stunnedTurns = turns;
    	chasing = false;
    	System.out.println("The Presence recoils in pain!");
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
    
    public void panicAtmosphere() {
    	if (!chasing) return;
    	
    	String[] messages = {
    			"Something moves in the dark behind you.",
    			"Your heartbeat pounds in your chest.",
    			"You hear something scraping against the walls.",
    			"The Presence is close."
    			
    	};
    	
    	Random rand = new Random();
    	System.out.println(messages[rand.nextInt(messages.length)]);
    	
    }
    
    public void roam(Location playerLocation) {

    	
        if (currentLocation == null) return;

        // STUN LOGIC FOR KNIFE
        if (stunnedTurns > 0) {
            stunnedTurns--;
            //System.out.println("(DEBUG) Presence is stunned and cannot move.");
            return;
        }
        
        Random random = new Random();

        List<Location> possibleMoves =
                new ArrayList<>(currentLocation.getExits().values());

        // ----- CHASE MODE -----
        if (chasing) {

            if (!possibleMoves.isEmpty()) {

                Location next = null;

                if (random.nextInt(100) < 70) {

                    for (Location loc : possibleMoves) {

                        if (loc == playerLocation) {

                            //System.out.println("(DEBUG) Presence lunges toward you!");
                            currentLocation = loc;
                            next = loc;
                            break;
                        }
                    }
                }

                if (next == null) {

                    next = possibleMoves.get(random.nextInt(possibleMoves.size()));

                    //System.out.println("(DEBUG) Presence searching nearby rooms...");
                    currentLocation = next;
                }
            }

            // Escape logic
            if (currentLocation != playerLocation) {

                decreaseAwareness(20);

                if (awarenessLevel <= 70) {

                    chasing = false;
                    System.out.println("The footsteps fade behind you...");
                }
            }

            return;
        }

        // ----- HUNTING MODE -----
        if (awarenessLevel >= 50) {

            for (Location loc : possibleMoves) {

                if (loc == playerLocation) {

                    //System.out.println("(DEBUG) Presence moves with purpose...");
                    currentLocation = loc;
                    return;
                }
            }
        }

        // ----- WANDERING MODE -----

        if (possibleMoves.isEmpty()) return;

        Location next = possibleMoves.get(random.nextInt(possibleMoves.size()));

        //System.out.println("(DEBUG) Presence wandering from "
                //+ currentLocation + " to " + next);

        currentLocation = next;
    }
	
    
}