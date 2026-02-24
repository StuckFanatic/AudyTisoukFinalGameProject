package prisonislandescape;

import java.util.Scanner;

public class IslandEscape {

	public static void main(String[] args) {
		
		//Creates locations thus far
		Location cell = new Location(
				"Your Cell",
				"A damp stone cell. Rust stains the walls. The door slightly ajar."
				);
		
		Location blockA = new Location(
				"Cell Block A",
				"Your nehborhood of empty cells. Rows of empty homes."
				);
		
		Location yard = new Location(
				"Prison Yard",
				"An open yard surrounded by high crumbling walls. The sea crashing in the distance."
				+ "The winds howling at you."
				);
		
		Location shore = new Location(
				"Shoreline",
				"Jagged rocks that cut into the sea. Freedom lies somewhere beyond the infinite black waters."
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
		
		System.out.println("""
			    You awaken. Not to a paradise, but again to a dark damp hell. You choke on your own blood and
			    the taste of salt plauges your mouth. You don't even remember why you are here anymore.
			    Or how you are even still alive. All you know now is that due to years of imprisonment your body is failing slowly. 
			    """);
		System.out.println("""
				As unlucky as you are. Fate has tempted you with hope. The cell holding you 
				is slightly ajar. Staying still might give you relief in your final hours. Moving might kill you.
			    """);
		System.out.println("But what choice do you have?");
	
		
		boolean gameRunning = true;
		
		while (gameRunning && player.isAlive()) {
			
			
			System.out.println("\nHealth: " + player.getHealth());
			System.out.println("Awareness: " + player.getDetectionLevel());
			System.out.println("Location: " + player.getLocation());
			
			System.out.println("\nWhat do you do?");
			String input = scanner.nextLine().toLowerCase();
			CommandType command = CommandParser.parse(input);
			
			switch (command) {
			
			// Command move
			case MOVE: {

			    System.out.println("Where do you want to move? Available: "
			            + player.getLocation().getAvailableExits());

			    String direction = scanner.nextLine().toLowerCase();

			    Location nextLocation = player.getLocation().getExit(direction);

			    if (nextLocation != null) {

			        player.move(nextLocation);
			        System.out.println(nextLocation.getDescription());

			    } else {
			        System.out.println("You can't go that way.");
			    }

			    break;
			}
			
		        //Command Hide
			case HIDE:
				player.hide();
				System.out.println("You find the nearest shadow and meld with it"
				);
				break;
			
				
				//Command to quit the game early
			case QUIT:
				System.out.println("You stop struggling for survival. It was futile anyway."
				);
				gameRunning = false;
				break;

				//Pressing enter without an input will "pass time" 
			default:
		        System.out.println("Time passes."
		        );
		        break;
            }

			//If the player gets to a certain detection it will end the game
            if (player.getDetectionLevel() >= 100) {
                System.out.println("\nYou've made too much noise. The Island knows where you are."
                		+ " There is no running now.");
                gameRunning = false;
            }
			
			
		}
		
		scanner.close();
	}
	
}
