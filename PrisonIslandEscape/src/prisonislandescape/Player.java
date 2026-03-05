package prisonislandescape;

import java.util.ArrayList;
import java.util.List;

public class Player {
	
	
	private int health;			//Players health
	private Location location;		//Player location
	private List<Item> inventory;
	
	
	public Player(Location startingLocation) {
		
		
		this.health = 100; 		//Starts at 100
		this.location = startingLocation;		//Starting location?
		this.inventory = new ArrayList<>();
		
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
	
	public void addItem(Item item) {
		inventory.add(item);
	}
	
	public boolean hasItem(String itemName) {
		for (Item item : inventory) {
			if (item.getName().equalsIgnoreCase(itemName)) {
				return true;
			}
		}
		return false;
	}
	
	public void showInventory() {
		if (inventory.isEmpty()) {
			System.out.println("Yoou are carrying nothing...");
			return;
		}
		
		System.out.println("You carry: ");
		
		for (Item item : inventory) {
			System.out.println("- " + item.getName());
		}
	}
	
	
	
	
}
