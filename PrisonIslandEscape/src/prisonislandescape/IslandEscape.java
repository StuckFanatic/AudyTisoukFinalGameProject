package prisonislandescape;

import java.util.Scanner;

public class IslandEscape {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		Player player = new Player();
		
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
			
			//Command move
			case MOVE:
		        player.move("Cell Block A");
		        System.out.println(
		            "You leave the cell for the first time in a long time. "
		          + "The pain aches but you've taken your first step into the unknown."
		        );
		        break;
			
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
