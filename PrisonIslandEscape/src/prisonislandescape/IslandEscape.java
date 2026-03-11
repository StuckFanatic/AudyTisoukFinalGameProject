package prisonislandescape;

import java.util.Scanner;
import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class IslandEscape implements Serializable{
	
	private static final long serialVersionUID = 1L;
	static Player player;

	public static void main(String[] args) {
		
		//Creates locations thus far
		Location cell = new Location(
				"Your Cell",
				"A damp stone cell. Rust stains the walls. The door slightly ajar.",
				false,
				"You take a look around you. Stains of old blood and scratches surround you. Cell number 42."
				);
		
		Location blockA = new Location(
				"Block A",
				"Block A housed Your nehborhood of empty cells. Rows of empty homes.",
				false,
				"Each cell remains locked. Yours is the only one that can be opened."
				);
		
		Location yard = new Location(
				"Prison Yard",
				"An open yard surrounded by high crumbling walls. The sea crashing in the distance."
				+ "The winds howling at you.",
				false,
				"The large open yard for everyday prisoner execersise. The guard towers are no longer keeping watch as they sit crumbled."
				);
		
		Location shore = new Location(
				"Shoreline",
				"Jagged rocks that cut into the sea. Freedom lies somewhere beyond the infinite black waters.",
				false,
				"The stench of the sea fill your nose. The dark waters inviting you into deaths embrace."
				);
		
		Location medical = new Location(
				"Medical Wing",
				"A cold clinical hall. Rusted hospital beds and broken glass line the room.",
				false,
				"You search the ruined infirmary. Surgical tools are scattered across the floor. Dark stains coat the eaxmination tables"
				);
		
		Location armory = new Location(
				"Armory",
				"A reinforced weapons locker. Most racks are empty.",
				true,
				"You search the armory. Empty weapons racks line the walls. It seems like it was all left behind or used long ago."
				);
		
		Location office = new Location(
				"Warden's Office",
				"A large office overlooking the prison yard. Papers cover the desk.",
				false,
				"You sift through the papers and ledgers. Reports of prisoner behavior and experimental results appear throughout the files."
				);
		
		Location barracks = new Location(
				"Guard Station",
				"Old guard bunks line the walls. Adandonded uniforms lie scattered.",
				false,
				"You search the sleeping quarters of the guards. The bed were left in a hurry. Some lockers remain partially open."
				);
		
		Location tower = new Location(
				"Guard Tower",
				"A tall rusted tower overlooking the prison yard.",
				false,
				"You climb the tower and search the lookout station. The prison grounds streched beneath you."
				);
		
		Location wall = new Location(
				"Prison Yard Wall",
				"A broken defensive wall overlooking the raging sea.",
				false,
				"Walking along the wall you see the ocean scrashing violently below."
				);
		
		Location safeRoom = new Location(
				"Maintenance Room",
				"A cramped repair room filled with broken tools and machinery.",
				true,
				"You dig through toolboxes and broken machines. Spare parts and old equipment fill the shelves. Every phone line also cut."
				);
		
		Location cafeteria = new Location(
				"Cafeteria",
				"A run down sad eatery",
				false,
				"Metal benches line the place with chairs and trays scattered around the floor. The windows shuttered with no kitchen in sight."
				);
		
		Location recreational = new Location(
				"Recreational Room",
				"The empty silence of what was a gathering place for inmates.",
				false,
				"The gameboards, billiard tables and books of what could have been a respite now lay bare as nothing is playable now."
				);
		
		Location hallway = new Location(
				"Long Hall",
				"A long narrow hallway leading many places",
				false,
				"Many of the standard occupational roles for the prison with many unimportant doors closed shut."
				);
		
		Location visiting  = new Location(
				"Visiting Rooms",
				"A broken glass sets the place for inmates to speak to the outside.",
				false,
				"Shattered glass lines the room. It's been awhile since anyone else has been here. "
				);
		
		Location frontDoor = new Location(
			    "Entrance Gate",
			    "The main prison gate stands sealed shut.",
			    false,
			    "You inspect the heavy steel gate. A security lock blocks the control panel."
			);
		
		Location securityDoor = new Location(
			    "Security Door",
			    "A reinforced electronic security door blocks the hallway.",
			    false,
			    "You inspect the security panel. It requires a special access card."
			);
		
		Location labortory = new Location(
			    "Research Lab",
			    "A laboratory filled with shattered glass tubes and broken equipment.",
			    false,
			    "You search the lab benches. Strange research documents mention 'Subject 428'."
			);
		
		Location experiment = new Location(
			    "Experiment Testing Room",
			    "Large containment chambers line the walls.",
			    false,
			    "You search the experiment chamber. Several broken containment pods lie open."
			);
		
		Location contamination = new Location(
			    "Contamination Room",
			    "A sterilization chamber connecting the labs.",
			    false,
			    "You search the decontamination room. Protective suits hang lifelessly from hooks."
			);
		
		Location panicRoom = new Location(
			    "Panic Room",
			    "A sealed emergency bunker hidden deep in the lab.",
			    true,
			    "You search the emergency bunker. Emergency supplies were meant to keep someone alive for weeks nearly gone."
			);
		
		Location labStairwell = new Location(
			    "Lab Stairwell",
			    "A metal staircase connecting the upper prison and underground labs.",
			    false,
			    "You search the stairwell landing. Dust covers every step."
			);
		
		Location officeStairwell = new Location(
			    "Office Stairwell",
			    "A narrow staircase leading between the prison floors.",
			    false,
			    "You search the stairwell. The walls are scratched deeply."
			);
		
		Location dockyard = new Location(
			    "Receiving Port",
			    "An old supply dock where ships once delivered cargo. There is a old boat that needs to be repaired here. Prehaps there are parts"
			    + " that can be found around the prison.",
			    false,
			    "You search the empty docks. Broken crates and rusted chains lie scattered."
			);
		
		
		
		//Items for use
		Item knife = new Item(
				"Knife",
				"A small combat knife. It may save you."
				);
		
		Item herb = new Item(
				"Green Herb",
				"A medicinal plant that will restore some health."
				);
		
		
		Item rustyKey = new Item(
				"Rusty Key",
				"An old key that may unlock something."
				);
		
		//Keys
		Item goldKey = new Item(
				"Gold Key",
				"A polished key used by the warden."
				);
		Item redCard = new Item(
				"Red Keycard",
				"A high level security keycard"
				);
		
		Item smoothKey = new Item(
				"Smooth Key",
				"A smooth metal civilian door key"
				);
		
		//Boat parts
		Item hull = new Item(
			    "Boat Hull",
			    "The broken frame of a small escape boat."
			);

		Item motor = new Item(
			    "Boat Motor",
			    "An old but usable outboard motor."
			);

		Item fuel = new Item(
			    "Fuel Canister",
			    "A heavy container filled with fuel."
			);

		Item map = new Item(
			    "Navigation Map",
			    "A faded map showing safe water routes."
			);
		
				
				
		//Define exits(for now add this to define movement. Details later
		cell.addExit("forward", blockA);
		cell.addItem(knife);
		cell.addItem(herb);
		
		blockA.addExit("back", cell);
		blockA.addExit("forward", recreational);
		blockA.addItem(rustyKey);
		
		
		recreational.addExit("back", blockA);
		recreational.addExit("forward", cafeteria);
		recreational.addExit("right", visiting);
		recreational.addExit("left", hallway);
		recreational.setLocked("Rusty Key");
		
		cafeteria.addExit("back", recreational);
		cafeteria.addItem(knife);
		cafeteria.addItem(herb);
		
		visiting.addExit("back", recreational);
		visiting.addExit("left", frontDoor);
		visiting.addExit("right", safeRoom);
		visiting.addItem(herb);
		
		safeRoom.addExit("back", visiting);
		safeRoom.addItem(smoothKey);
		
		frontDoor.addExit("back", visiting);
		frontDoor.addExit("left", shore);
		frontDoor.setLocked("Smooth Key");
		
		hallway.addExit("back", recreational);
		hallway.addExit("left", barracks);
		hallway.addExit("right", medical);
		hallway.addExit("forward", yard);
		
		barracks.addExit("back", hallway);
		barracks.addExit("forward", office);
		barracks.addExit("left", armory);
		
		armory.addExit("back", barracks);
		armory.addItem(knife);
		
		office.addExit("back", barracks);
		office.addExit("forward", officeStairwell);
		office.setLocked("Gold Key");
		office.addItem(redCard);
		
		officeStairwell.addExit("back", office);
		officeStairwell.addExit("forward", labStairwell);
		
		medical.addExit("back", hallway);
		medical.addExit("forward", securityDoor);
		
		securityDoor.addExit("back", medical);
		securityDoor.addExit("forward", labortory);
		securityDoor.setLocked("Red Keycard");
		
		labortory.addExit("back", securityDoor);
		labortory.addExit("forward", contamination);
		labortory.addExit("left", labStairwell);
		
		labStairwell.addExit("back", labortory);
		labStairwell.addExit("forward", officeStairwell);
		
		contamination.addExit("back", labortory);
		contamination.addExit("forward", experiment);
		
		experiment.addExit("back", contamination);
		experiment.addExit("forward", panicRoom);
		
		panicRoom.addExit("back", experiment);
		panicRoom.addItem(knife);
		
		yard.addExit("back", hallway);
		yard.addExit("left", tower);
		yard.addExit("forward", shore);
		yard.addItem(herb);
		
		tower.addExit("back", yard);
		tower.addExit("forward", wall);
		tower.addItem(goldKey);
		
		wall.addExit("back", tower);
		wall.addExit("forward", shore);
		
		shore.addExit("back", yard);
		shore.addExit("forward", dockyard);
		shore.addExit("right", frontDoor);
		shore.addItem(herb);
		
		dockyard.addExit("back", shore);
		
		//Location boat parts
		armory.addItem(motor);
		labortory.addItem(fuel);
		tower.addItem(map);
		safeRoom.addItem(hull);
		
		
		//Moved this down below locations
		Scanner scanner = new Scanner(System.in);
		player = new Player(cell);
		Presence presence = new Presence(shore);
		int boatPartsDelivered = 0;
		final int TOTAL_PARTS = 4;
		
		System.out.println("""
			    You awaken. Not to a paradise, but to a dark damp hell. You choke on your own blood and
			    the taste of salt plauges your mouth. You don't even remember why you are here.
			    Or who you even are. 
			    """);
		System.out.println("""
				Though fate has tempted you with a curious opportunity. The cell holding you 
				is slightly ajar. You know you must escape. There must be a way to get off the island.
			    """);
		System.out.println("What do you do?");
	
		
		boolean gameRunning = true;
		
		while (gameRunning && player.isAlive()) {

		    System.out.println("\nHealth: " + player.getHealth());
		    System.out.println("Presence Awareness: " + presence.getAwarenessLevel());
		    System.out.println("Location: " + player.getLocation());

		    System.out.println("\nWhat do you do?");
		    String input = scanner.nextLine().toLowerCase();
		    CommandType command = CommandParser.parse(input);

		    switch (command) {

		    case MOVE: {

		        if (presence.isChasing()) {

		            System.out.println("\nRUN!");
		            System.out.println("Your mind is racing. Your eyes tunnel. You can't remember the halls.");
		            System.out.println("Where do you go?");

		        } else {

		            System.out.println("Where do you want to move? Available: "
		                    + player.getLocation().getAvailableExits());
		        }

		        String direction = scanner.nextLine().toLowerCase();

		        Location nextLocation = player.getLocation().getExit(direction);

		        if (nextLocation == null) {

		            System.out.println("You can't go that way.");
		            break;
		        }

		        // ----- LOCK CHECK -----

		        if (!nextLocation.tryUnlock(player)) {
		            break;
		        }

		        // ----- MOVE PLAYER -----

		        player.move(nextLocation);
		        System.out.println(nextLocation.getDescription());

		        if (nextLocation.isSafeZone()) {
		            presence.decreaseAwareness(5);
		        } else {
		            presence.increaseAwareness(5);
		        }

		        break;
		    }

		        case HIDE:
		            player.hide();
		            System.out.println("You find the nearest shadow and meld with it.");
		            break;
		            
		        case EXPLORE: 
		        	player.getLocation().explore();
		        	break;
		            
		            
		        case TAKE: {
		        	
		        	System.out.println("What do you want to take?");
		        	String itemName = scanner.nextLine();
		        	
		        	Item item = player.getLocation().removeItem(itemName);
		        	
		        	if (item != null) {
		        		player.addItem(item);
		        		System.out.println("You picked up: " + item.getName());
		        	} else {
		        		System.out.println("There is no such item here.");
		        	}
		        	
		        	break;
		        }
		        
		        case DROP: {

		            System.out.println("What do you want to drop?");
		            String itemName = scanner.nextLine();

		            Item item = player.getItem(itemName);

		            if (item == null) {
		                System.out.println("You don't have that.");
		                break;
		            }

		            // If player is at dock, assemble boat
		            if (player.getLocation().getName().equals("Receiving Port")) {

		                if (item.getName().equalsIgnoreCase("Boat Hull") ||
		                    item.getName().equalsIgnoreCase("Boat Motor") ||
		                    item.getName().equalsIgnoreCase("Fuel Canister") ||
		                    item.getName().equalsIgnoreCase("Navigation Map")) {

		                    player.removeItem(item.getName());   // FIX
		                    boatPartsDelivered++;

		                    System.out.println("You add the " + item.getName() + " to the escape boat.");
		                    System.out.println("Boat Parts: " + boatPartsDelivered + "/" + TOTAL_PARTS);

		                } else {

		                    System.out.println("That won't help build the boat.");
		                }

		            } else {

		                player.getLocation().addItem(item);
		                System.out.println("You dropped the " + item.getName());
		            }

		            break;
		        }
		        
		        case INVENTORY: 
		        	player.showInventory();
		        	break;
		        	
		        case LOOK:
		            System.out.println(player.getLocation().getDescription());
		            break;
		        	
		        case USE: {
		        	
		        	System.out.println("What do you want to use?");
		        	String itemName = scanner.nextLine();
		        	
		        	Item item = player.getItem(itemName);
		        	
		        	if (item == null) {
		        		System.out.println("You don't have that item.");
		        		break;
		        	}
		        	
		        	if (item.getName().equalsIgnoreCase("Green Herb")) {
		        		
		        		player.heal(50);
		        		player.removeItem("Green Herb");
		        		
		        	} else {
		        		
		        		System.out.println("You use the " + item.getName());
		        	}
		        	
		        	break;
		        }
		        
		        case SAVE:
		            saveGame(scanner);
		            break;

		        case QUIT:
		            System.out.println("You stop struggling for survival. It was futile anyway.");
		            gameRunning = false;
		            break;

		        default:
		            System.out.println("Time passes.");
		            break;
		    }

		 // Escape Victory Condition
		    if (boatPartsDelivered >= TOTAL_PARTS) {

		        System.out.println("\nYou finish assembling the makeshift boat.");

		        System.out.println("The motor sputters to life...");

		        System.out.println("Behind you, something screams from inside the prison.");

		        System.out.println("You push away from the island into the dark sea.");

		        System.out.println("\nYOU ESCAPED THE ISLAND.");

		        gameRunning = false;
		    }
		    
		    // Presence moves after player action
		    presence.roam(player.getLocation());
		    
		    presence.panicAtmosphere();
		    
		    
		    //Collision check for Presence
		    if (!presence.isChasing() &&
		    	    presence.getCurrentLocation() == player.getLocation()) {

		    	    System.out.println("\nThe air turns ice cold");
		    	    System.out.println("The Presence is here and it sees you.");

		    	    presence.increaseAwareness(100);
		    	}
		    
		    if (presence.isChasing()
		    	    && presence.getCurrentLocation() == player.getLocation()
		    	    && !presence.justStartedChase()) {
		    	
		    	if (player.hasItem("Knife")) {
		    		
		    		System.out.println("\nThe Presence lunges!");
		    		
		    		System.out.println("You instinctively stab wildly with your knife!");
		    		
		    		System.out.println("It recoils long enough for you to escape!");
		    		
		    		player.removeItem("Knife");
		    		
		    		presence.decreaseAwareness(40);
		    		
		    		presence.stun(2);
		    	} else {

		    	    System.out.println("\nIt lunges from the darkness.");
		    	    System.out.println("You were too slow to escape.");

		    	    break;
		    	}
		    }
		    	
		    //Presence will give a one turn window
		    presence.resetChaseFlag();
		    
		    // Debug print
		    //System.out.println("(DEBUG) Presence is in: " + presence.getCurrentLocation());

		    // Atmospheric tension messages
		    presence.checkTension();

		}
		
		scanner.close();
	}
	
	//save game for project 7 
	//and final
	public static void saveGame(Scanner scanner) {
		
		try {
			
			System.out.println("Enter the full path in the console for the save file");
			String path = scanner.nextLine();
			
			File saveFile = new File(path);
			
			ObjectOutputStream out =
					new ObjectOutputStream(new FileOutputStream(saveFile));
			
			out.writeObject(player);
			out.close();
			
			System.out.println("Game saved successfully!");
			
			System.out.println("File size: " + saveFile.length() + " bytes");
			
		} catch (Exception e) {
			System.out.println("Save failed.");
			e.printStackTrace();
		}
		
		
	}
	
}