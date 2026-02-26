package prisonislandescape;

//The Presence is something that will chase the player

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Presence {

	private int awarenessLevel;
	private Location currentLocation;

    public Presence(Location startingLocation) {
        this.awarenessLevel = 0;
        this.currentLocation = startingLocation;
    }

    public int getAwarenessLevel() {
        return awarenessLevel;
    }

    public void increaseAwareness(int amount) {
        awarenessLevel += amount;
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
    
    public void checkTension() {
    	
    	if (awarenessLevel >= 75 && awarenessLevel < 100) {
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
    
    public void roam() {

        if (currentLocation == null) return;

        List<Location> possibleMoves = new ArrayList<>(currentLocation.getExits().values());

        if (possibleMoves.isEmpty()) {
            System.out.println("(DEBUG) Presence has no exits from " + currentLocation);
            return;
        }

        Random random = new Random();
        Location next = possibleMoves.get(random.nextInt(possibleMoves.size()));

        System.out.println("(DEBUG) Presence moving from " + currentLocation + " to " + next);

        currentLocation = next;
    }
	
	
}
