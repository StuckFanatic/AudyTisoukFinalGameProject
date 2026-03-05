package prisonislandescape;

import java.util.Scanner;

public class IslandEscape {

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
				""
				);
		
		Location armory = new Location(
				"Armory",
				"",
				true,
				""
				);
		
		Location office = new Location(
				"Warden's Office",
				"",
				false,
				""
				);
		
		Location barracks = new Location(
				"Guard Station",
				"",
				false,
				""
				);
		
		Location tower = new Location(
				"Guard Tower",
				"",
				false,
				""
				);
		
		Location wall = new Location(
				"Prison Yard Wall",
				"",
				false,
				""
				);
		
		Location safeRoom = new Location(
				"Maintenance Room",
				"",
				true,
				""
				);
		
		Location cafeteria = new Location(
				"Cafeteria",
				"",
				false,
				""
				);
		
		Location recreational = new Location(
				"Recreational Room",
				"",
				false,
				""
				);
		
		Location hallway = new Location(
				"Long Hall",
				"",
				false,
				""
				);
		
		Location visiting  = new Location(
				"Visiting Rooms",
				"",
				false,
				""
				);
		
		Location frontDoor = new Location(
				"Entrance Gate",
				"",
				false,
				""
				);
		
		Location securityDoor = new Location(
				"Secure Door",
				"",
				false,
				""
				);
		
		Location labortory = new Location(
				"Research Lab",
				"",
				false,
				""
				);
		
		Location experiment = new Location(
				"Experiment Testing Room",
				"",
				false,
				""
				);
		
		Location contamination = new Location(
				"Contamination Room",
				"",
				false,
				""
				);
		
		Location panicRoom = new Location(
				"Panic Room",
				"",
				true,
				""
				);
		
		Location labStairwell = new Location(
				"Stairwell close to the lab",
				"",
				false,
				""
				);
		
		Location officeStairwell = new Location(
				"Stairwell close to the office",
				"",
				false,
				""
				);
		
		Location dockyard = new Location(
				"Receiving Port",
				"",
				false,
				""
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
		Item flashlight = new Item(
				"Flashlight",
				"A small flashlight. It may help you navigate dark areas."
				);
		Item key = new Item(
				"Rusty Key",
				"An old key that may unlock something."
				);
				
				
		//Define exits(for now add this to define movement. Details later
		cell.addExit("forward", blockA);
		
		blockA.addExit("back", cell);
		blockA.addExit("forward", recreational);
		
		recreational.addExit("back", blockA);
		recreational.addExit("forward", cafeteria);
		recreational.addExit("right", visiting);
		recreational.addExit("left", hallway);
		
		cafeteria.addExit("back", recreational);
		
		visiting.addExit("back", recreational);
		visiting.addExit("left", frontDoor);
		visiting.addExit("right", safeRoom);
		
		safeRoom.addExit("back", visiting);
		
		frontDoor.addExit("back", visiting);
		frontDoor.addExit("left", shore);
		
		hallway.addExit("back", recreational);
		hallway.addExit("left", barracks);
		hallway.addExit("right", medical);
		hallway.addExit("forward", yard);
		
		barracks.addExit("back", recreational);
		barracks.addExit("forward", office);
		barracks.addExit("left", armory);
		
		armory.addExit("back", barracks);
		
		office.addExit("back", barracks);
		office.addExit("forward", officeStairwell);
		
		officeStairwell.addExit("back", office);
		officeStairwell.addExit("forward", labStairwell);
		
		medical.addExit("back", hallway);
		medical.addExit("forward", securityDoor);
		
		securityDoor.addExit("back", medical);
		securityDoor.addExit("forward", labortory);
		
		labortory.addExit("back", securityDoor);
		labortory.addExit("forward", contamination);
		labortory.addExit("left", labStairwell);
		
		labStairwell.addExit("back", labortory);
		labStairwell.addExit("forward", officeStairwell);
		
		contamination.addExit("back", labortory);
		contamination.addExit("forward", experiment);
		
		experiment.addExit("back", contamination);
		experiment.addExit("forward", panicRoom);
		
		yard.addExit("back", hallway);
		yard.addExit("left", tower);
		yard.addExit("forward", shore);
		
		tower.addExit("back", yard);
		tower.addExit("forward", wall);
		
		wall.addExit("back", tower);
		wall.addExit("forward", shore);
		
		shore.addExit("back", yard);
		shore.addExit("forward", dockyard);
		shore.addExit("right", frontDoor);
		
		dockyard.addExit("back", shore);
		
		
		//Moved this down below locations
		Scanner scanner = new Scanner(System.in);
		Player player = new Player(cell);
		Presence presence = new Presence(shore);
		
		System.out.println("""
			    You awaken. Not to a paradise, but to a dark damp hell. You choke on your own blood and
			    the taste of salt plauges your mouth. You don't even remember why you are here.
			    Or who you even are. 
			    """);
		System.out.println("""
				Though fate has tempted you with a curious opportunity. The cell holding you 
				is slightly ajar. The path to discovery might be beyond.
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

		            System.out.println("Where do you want to move? Available: "
		                    + player.getLocation().getAvailableExits());

		            String direction = scanner.nextLine().toLowerCase();

		            Location nextLocation = player.getLocation().getExit(direction);

		            if (nextLocation != null) {

		                player.move(nextLocation);
		                System.out.println(nextLocation.getDescription());

		                if (nextLocation.isSafeZone()) {
		                    presence.decreaseAwareness(5);
		                } else {
		                    presence.increaseAwareness(5);
		                }

		            } else {
		                System.out.println("You can't go that way.");
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
		        
		        case INVENTORY: 
		        	player.showInventory();
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

		        case QUIT:
		            System.out.println("You stop struggling for survival. It was futile anyway.");
		            gameRunning = false;
		            break;

		        default:
		            System.out.println("Time passes.");
		            break;
		    }

		    // Presence moves after player action
		    presence.roam(player.getLocation());
		    
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
		    		
		    		presence.decreaseAwareness(60);
		    	} else {

		    	    System.out.println("\nIt lunges from the darkness.");
		    	    System.out.println("You were too slow to escape.");

		    	    break;
		    	}
		    }
		    	
		    //Presence will give a one turn window
		    presence.resetChaseFlag();
		    
		    // Debug print
		    System.out.println("(DEBUG) Presence is in: " + presence.getCurrentLocation());

		    // Atmospheric tension messages
		    presence.checkTension();

		}
		
		scanner.close();
	}
	
}
