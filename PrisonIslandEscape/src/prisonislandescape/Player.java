package prisonislandescape;

public class Player {
	
	
	private int health;			//Players health
	private Location location;		//Player location
	
	
	public Player(Location startingLocation) {
		
		
		this.health = 100; 		//Starts at 100
		this.location = startingLocation;		//Starting location?
		
	}
	
	public int getHealth() {
		
		return health;
	}

	public Location getLocation() {
		
        return location;
        
    }
	
	public void move(Location newLocation) {
		location = newLocation;
		
		health -= 4;		//Moving causes your health to deteriorate, sense of creeping death
		
	}
	
	public void hide() {
		
		System.out.println("You steady your breathing, hide and remain still");
		
	}
	
	
	public boolean isAlive() {
		
		return health > 0;
	}	
	
}
