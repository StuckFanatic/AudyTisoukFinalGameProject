package prisonislandescape;

import java.util.Scanner;

public class IslandEscape {

	public static void main(String[] args) {
		
		//Creates locations thus far
		Location cell = new Location(
				"Your Cell",
				"A damp stone cell. Rust stains the walls. The door slightly ajar.",
				false
				);
		
		Location blockA = new Location(
				"Cell Block A",
				"Your nehborhood of empty cells. Rows of empty homes.",
				false
				);
		
		Location yard = new Location(
				"Prison Yard",
				"An open yard surrounded by high crumbling walls. The sea crashing in the distance."
				+ "The winds howling at you.",
				false
				);
		
		Location shore = new Location(
				"Shoreline",
				"Jagged rocks that cut into the sea. Freedom lies somewhere beyond the infinite black waters.",
				true
				);
				
		//Define exits(for now add this to define movement. Details later
		cell.addExit("forward", blockA);
		
		blockA.addExit("back", cell);
		blockA.addExit("forward", yard);
		
		yard.addExit("back", blockA);
		yard.addExit("forward", shore);
		
		shore.addExit("back", yard);
		
		
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

		        case QUIT:
		            System.out.println("You stop struggling for survival. It was futile anyway.");
		            gameRunning = false;
		            break;

		        default:
		            System.out.println("Time passes.");
		            break;
		    }

		    // Presence moves after player action
		    presence.roam();

		    // Debug print
		    System.out.println("(DEBUG) Presence is in: " + presence.getCurrentLocation());

		    // Atmospheric tension messages
		    presence.checkTension();

		    // End condition
		    if (presence.hasFoundPlayer()) {
		        System.out.println("\nYou've made too much noise. The Presence knows where you are."
		                + " There is no running.");
		        gameRunning = false;
		    }
		}
		
		scanner.close();
	}
	
}
