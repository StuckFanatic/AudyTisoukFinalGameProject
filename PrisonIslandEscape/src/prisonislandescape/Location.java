package prisonislandescape;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class Location {

	private String name;
	private String description;
	private boolean safeZone;
	private List<Item> items;
	private boolean explored;
	private String flavorText;
	
	//Holds possible ways to leave locations
	private Map<String, Location> exits;
	
	public Map<String, Location> getExits() {
	    return exits;
	}
	
	//Allows the player using Map<String...> to go to each location making the game semi-open world
	public Location(String name, String description, boolean safeZone) {
		
		this.name = name;
		this.description = description;
		this.safeZone = safeZone;
		this.flavorText = flavorText;
		
		this.exits = new HashMap<>();
		this.items = new ArrayList<>();
		this.explored = false;
		
	}
	
	public String getName() {
		
		return name;
		
	}
	
	public String getDescription() {
		
		return description;
		
	}
	
	public boolean isSafeZone() {
	    return safeZone;
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
	
	public void addItem(Item item) {
		items.add(item);
	}
	
	public List<Item> getItems() {
		return items;
	}
	
	public Item removeItem(String itemName) {
		for (Item item : items) {
			if (item.getName().equalsIgnoreCase(itemName)) {
				items.remove(item);
				return item;
			}
		}
		return null;
	}
	
	public void explore() {
		
		if(explored) {
			System.out.println("You search again but find nothing new.");
			return;
		}
		
		System.out.println(flavorText);
		
		
		explored = true;
		
		System.out.println("\nYou carefully search the area...");
		
		if(!items.isEmpty()) {
			System.out.println("You find:");
			
			for(Item item : items) {
				System.out.println("- " + item.getName());	
			}
		}
		else {
			System.out.println("You find nothing useful.");
		}
	}
	
	@Override
	public String toString() {
	    return name;
	}
	
	
}
