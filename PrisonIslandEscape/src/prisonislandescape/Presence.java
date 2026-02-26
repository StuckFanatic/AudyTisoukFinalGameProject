package prisonislandescape;

//The Presence is something that will chase the player

public class Presence {

	private int awarenessLevel;

    public Presence() {
        this.awarenessLevel = 0;
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
	
	
}
