package prisonislandescape;

import java.util.ArrayList;
import java.io.Serializable;
import java.util.List;

public class Player implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private int health;			//Players health
	private Location location;		//Player location
	private List<Item> inventory;
	private int maxInventory = 4;
	
	
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
		// Keys do NOT count toward inventory limit
	    if (!item.getName().toLowerCase().contains("key")
	        && !item.getName().toLowerCase().contains("keycard")) {

	        if (inventory.size() >= maxInventory) {
	            System.out.println("You cannot carry anything else.");
	            return;
	        }
	    }

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
	
	public Item getItem(String itemName) {
		
		for(Item item : inventory) {
			if (item.getName().equalsIgnoreCase(itemName)) {
				return item;
			}
		}
		return null;
	}
	
	public Item removeItem(String name) {

	    for (Item item : inventory) {
	        if (item.getName().equalsIgnoreCase(name)) {
	            inventory.remove(item);
	            return item;
	        }
	    }

	    return null;
	}
	
	public void heal(int amount) {
		health += amount;
		if (health > 100) {
			health = 100;
		}
		System.out.println("You feel like you've staved away death a little longer...");
	}
	
	
	
	
}