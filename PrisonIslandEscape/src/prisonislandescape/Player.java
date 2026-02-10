package prisonislandescape;

public class Player {
	
	
	private int health;			//Players health
	private int detectionlevel;		//Will help with player judgment on certain interactions
	private String location;		//Player location
	
	
	public Player() {
		
		
		this.health = 100; 		//Starts at 100
		this.detectionlevel = 0;		// 0 is hidden, 100 is captured
		this.location = "Your Cell";		//Starting location?
		
	}
	
	public int getHealth() {
		
		return health;
	}
	
	public int getDetectionLevel()	{
		
		
		return detectionlevel;
		
	}

	public String getLocation() {
		
        return location;
        
    }
	
	public void move(String newLocation) {
		location = newLocation;
		
		health -= 4;		//Moving causes your health to deteriorate, sense of creeping death
		
		detectionlevel += 3;		//Moving causes your detection level to rise from noise
		
		
	}
	
	public void hide() {
		
		detectionlevel -= 10;		//Greatly reduce detection level. If any below 0 still will be 0
		
		if (detectionlevel < 0) {
			
			detectionlevel = 0;
		}
		
		health -= 2;		//Even standing still you lose health
		
	}
	
	
	public boolean isAlive() {
		
		return health > 0;
	}	
	
}
