package prisonislandescape;

import java.util.HashMap;
import java.util.Map;


public class Location {

	private String name;
	private String description;
	
	
	//Holds possible ways to leave locations
	private Map<String, Location> exits;
	
	//Allows the player using Map<String...> to go to each location making the game semi-open world
	public Location(String name, String description) {
		
		this.name = name;
		this.description = description;
		this.exits = new HashMap<>();
		
	}
	
	public String getName() {
		
		return name;
		
	}
	
	public String getDescription() {
		
		return description;
		
	}
	
	public void addExit(String direction, Location location) {
		
		exits.put(direction.toLowerCase(), location);
		
		
	}
	
	public Location getExit(String direction) {
		
		return exits.get(direction.toLowerCase());
		
	}
	
	public String getAvailableExits() {
		
		return exits.keySet().toString();
		
	}
	
	@Override
	public String toString() {
	    return name;
	}
	
	
}
