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
			
			
			if (input.equals("leave cell")) {
				player.move("Cell Block A");
				System.out.println("You leave the cell for the first time in a long time. The pain aches but"
						+ "you've taken your first step into the unknown.");
			}
			
			else if (input.equals("hide")) {
				player.hide();
				System.out.println("You find the nearest shadow and meld with it");
			}
			
			else if (input.equals("quit")) {
				System.out.println("You stop stuggling for survival. It was futile anyway.");
				gameRunning = false;
			}
			
			else {
                System.out.println("Time passes.");
            }

            if (player.getDetectionLevel() >= 100) {
                System.out.println("\nYou've made too much noise. The Island knows where you are."
                		+ "There is no running now.");
                gameRunning = false;
            }
			
			
            if (!player.isAlive()) {
            	
            	System.out.println("\nYour body gives out. No more struggling.");
            	
            }
			
		}
		
		scanner.close();
	}
	
}
