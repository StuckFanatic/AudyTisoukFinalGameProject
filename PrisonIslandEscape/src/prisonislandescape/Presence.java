package prisonislandescape;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Presence {

    private int awarenessLevel;
    private Location currentLocation;
    private boolean chasing;
    private boolean justStartedChase;
    private final Random random = new Random();

    public Presence(Location startLocation) {
        awarenessLevel = 0;
        currentLocation = startLocation;
        chasing = false;
        justStartedChase = false;
    }

    public int getAwarenessLevel() {
        return awarenessLevel;
    }

    public Location getCurrentLocation() {
        return currentLocation;
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

    // Increase awareness and trigger chase if maxed
    public void increaseAwareness(int amount) {
        awarenessLevel += amount;
        if (awarenessLevel >= 100) {
            awarenessLevel = 100;
            chasing = true;
            justStartedChase = true;
            System.out.println("Something is hunting you!");
        }
    }

    public void decreaseAwareness(int amount) {
        awarenessLevel = Math.max(0, awarenessLevel - amount);
    }

    // --- Presence behavior ---
    public void update(Player player) {
        // If chasing, move towards player with weighted chance
        List<Location> exits = new ArrayList<>(currentLocation.getExits().values());

        if (chasing) {
            // 70% chance to move directly towards the player if adjacent
            for (Location loc : exits) {
                if (loc == player.getLocation() && random.nextInt(100) < 70) {
                    currentLocation = loc;
                    System.out.println("You hear footsteps grow closer...");
                    return;
                }
            }
            // Otherwise move randomly
            currentLocation = exits.get(random.nextInt(exits.size()));
        } else if (awarenessLevel >= 50) {
            // Hunting mode: move randomly, may detect player
            currentLocation = exits.get(random.nextInt(exits.size()));
        } else {
            // Wandering mode: randomly move
            currentLocation = exits.get(random.nextInt(exits.size()));
        }
    }

    // Atmospheric suspense messages
    public void printSuspense() {
        if (chasing) {
            System.out.println("It is hunting you!");
        } else if (awarenessLevel >= 75) {
            System.out.println("You feel a presence very close. Breathing, watching...");
        } else if (awarenessLevel >= 50) {
            System.out.println("The air is heavy. Something is nearby.");
        } else if (awarenessLevel >= 25) {
            System.out.println("A distant metallic echo rings somewhere unseen.");
        }
    }
}