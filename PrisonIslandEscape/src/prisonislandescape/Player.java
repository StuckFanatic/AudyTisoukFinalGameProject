package prisonislandescape;

public class Player {
	
	
	private int health;			//Players health
	private int detectionlevel;		//Will help with player judgment on certain interactions
	private Location location;		//Player location
	
	
	public Player(Location startingLocation) {
		
		
		this.health = 100; 		//Starts at 100
		this.detectionlevel = 0;		// 0 is hidden, 100 is captured
		this.location = startingLocation;		//Starting location?
		
	}
	
	public int getHealth() {
		
		return health;
	}
	
	public int getDetectionLevel()	{
		
		
		return detectionlevel;
		
	}

	public Location getLocation() {
		
        return location;
        
    }
	
	public void move(Location newLocation) {
		location = newLocation;
		
		health -= 4;		//Moving causes your health to deteriorate, sense of creeping death
		
		detectionlevel += 3;		//Moving causes your detection level to rise from noise
		
		
	}
	
	public void hide() {
		
		detectionlevel -= 10;		//Greatly reduce detection level. If any below 0 still will be 0
		
		if (detectionlevel < 0) {
			
			detectionlevel = 0;
		}
		
	}
	
	
	public boolean isAlive() {
		
		return health > 0;
	}	
	
}
