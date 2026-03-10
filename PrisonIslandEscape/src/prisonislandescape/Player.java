package prisonislandescape;

import java.util.ArrayList;
import java.util.List;

public class Player {

    private int health;
    private final int maxHealth = 100;
    private Location location;
    private List<Item> inventory;
    private final int maxInventory = 4;

    public Player(Location startingLocation) {
        this.health = maxHealth;
        this.location = startingLocation;
        this.inventory = new ArrayList<>();
    }

    // --- Movement ---
    public void move(Location newLocation) {
        location = newLocation;
        // Moving costs some health to simulate exhaustion
        health -= 3;
        System.out.println("You move to " + newLocation.getName() + ". You feel the strain...");
    }

    public Location getLocation() {
        return location;
    }

    // --- Health ---
    public void heal(int amount) {
        health += amount;
        if (health > maxHealth) health = maxHealth;
        System.out.println("You feel a little more alive.");
    }

    public boolean isAlive() {
        return health > 0;
    }

    public int getHealth() {
        return health;
    }

    // --- Inventory Management ---
    public void addItem(Item item) {
        if (inventory.size() >= maxInventory) {
            System.out.println("Your pockets are full. Drop something first!");
            System.out.println("Drop something beofre picking this up.");
            return;
        }
        inventory.add(item);
        System.out.println("Picked up: " + item.getName());
    }
    
    public Item dropItem(String itemName) {
    	
    	for (Item item : inventory) {
    		if (item.getName().equalsIgnoreCase(itemName)) {
    			inventory.remove(item);
    			System.out.println("You dropped: " + item.getName());
    			return item;
    		}
    	}
    	return null;
    }

    public void removeItem(String itemName) {
        inventory.removeIf(i -> i.getName().equalsIgnoreCase(itemName));
    }

    public boolean hasItem(String itemName) {
        return inventory.stream().anyMatch(i -> i.getName().equalsIgnoreCase(itemName));
    }

    public Item getItem(String itemName) {
        return inventory.stream().filter(i -> i.getName().equalsIgnoreCase(itemName)).findFirst().orElse(null);
    }

    public void showInventory() {
        if (inventory.isEmpty()) {
            System.out.println("You are carrying nothing.");
            return;
        }
        System.out.println("Inventory:");
        inventory.forEach(i -> System.out.println("- " + i.getName()));
    }

    // --- Hiding ---
    public void hide() {
        System.out.println("You melt into the shadows, holding your breath...");
    }
}