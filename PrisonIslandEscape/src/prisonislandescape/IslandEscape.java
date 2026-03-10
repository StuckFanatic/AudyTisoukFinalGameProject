package prisonislandescape;

import java.util.Scanner;

public class IslandEscape {

    public static void main(String[] args) {

        // --- LOCATIONS ---
        Location cell = new Location(
            "Cell 42",
            "A damp stone cell. Rust stains the walls. The door is slightly ajar.",
            false,
            "You wake disoriented, your mind blank. Scratches on the wall hint at others who were here."
        );

        Location blockA = new Location(
            "Block A",
            "Empty cells stretch in rows. Silence is heavy.",
            false,
            "You notice most cells are locked, some damaged, but one seems recently opened."
        );

        Location yard = new Location(
            "Prison Yard",
            "An open yard with crumbling walls. The sea crashes in the distance.",
            false,
            "The air is salty. Rusted guard towers loom, empty and silent."
        );

        Location shore = new Location(
            "Shoreline",
            "Jagged rocks cut into the dark waters. Freedom might be beyond them.",
            false,
            "The ocean looks menacing. Waves crash violently, daring you to escape."
        );

        Location medical = new Location(
            "Medical Wing",
            "A clinical hall gone to ruin. Rusted beds and broken glass everywhere.",
            false,
            "You see shattered syringes, dried blood, and broken cabinets. Something went horribly wrong here."
        );

        Location armory = new Location(
            "Armory",
            "Weapons racks, mostly empty, some smashed to pieces.",
            true,
            "You search the armory. Only remnants of weapons remain."
        );

        Location office = new Location(
            "Warden's Office",
            "A large office overlooking the prison yard. Papers scattered everywhere.",
            false,
            "Among the papers, you find ledgers detailing prisoners and experiments. One mentions 'Subject 428' and initials A.W."
        );

        Location barracks = new Location(
            "Guard Station",
            "Abandoned guard quarters. Uniforms and bunks lie in disarray.",
            false,
            "You see personal belongings, scattered logs, and a faint memory of authority."
        );

        Location tower = new Location(
            "Guard Tower",
            "A rusted tower looking over the yard.",
            false,
            "From above, the prison stretches beneath you. Something about the height unsettles you."
        );

        Location wall = new Location(
            "Yard Wall",
            "A broken defensive wall with a view of the sea.",
            false,
            "The sea crashes below, reminding you of the danger beyond."
        );

        Location safeRoom = new Location(
            "Maintenance Room",
            "Tools, broken machinery, and spare parts clutter the room.",
            true,
            "A safe place to regroup. Perhaps you can restore health here."
        );

        Location cafeteria = new Location(
            "Cafeteria",
            "A ruined eatery. Metal tables and trays scattered.",
            false,
            "Empty, but something smells faintly metallic in the air."
        );

        Location recreational = new Location(
            "Recreational Room",
            "An empty room for prisoners’ recreation.",
            false,
            "Billiard tables and game boards are broken. Dust covers everything."
        );

        Location hallway = new Location(
            "Long Hall",
            "A long hallway connecting many rooms.",
            false,
            "The hallway stretches into darkness. The silence is oppressive."
        );

        Location visiting = new Location(
            "Visiting Rooms",
            "Rooms with shattered glass and broken furniture.",
            false,
            "You see signs of past conversations. Maybe clues remain."
        );

        Location frontDoor = new Location(
            "Entrance Gate",
            "The main gate is sealed shut with a security lock.",
            false,
            "Freedom seems near but locked behind steel and codes."
        );

        Location securityDoor = new Location(
            "Security Door",
            "A reinforced electronic door blocks your path.",
            false,
            "It requires a high-level keycard."
        );

        Location laboratory = new Location(
            "Research Lab",
            "Shattered glass tubes and broken equipment litter the lab.",
            false,
            "Documents mention 'Subject 428' and experiments. This seems connected to you..."
        );

        Location experiment = new Location(
            "Experiment Testing Room",
            "Containment chambers, some broken open.",
            false,
            "Empty pods and stains hint at failed experiments. Some notes are torn."
        );

        Location contamination = new Location(
            "Contamination Room",
            "A decontamination chamber with empty protective suits.",
            false,
            "You feel the air here is toxic. Something was contained."
        );

        Location panicRoom = new Location(
            "Panic Room",
            "Emergency supplies, mostly looted.",
            true,
            "A safe space, but supplies are nearly gone."
        );

        Location labStairwell = new Location(
            "Lab Stairwell",
            "Metal stairs connecting upper prison and underground labs.",
            false,
            "Steps creak under your weight. The labs below look darker."
        );

        Location officeStairwell = new Location(
            "Office Stairwell",
            "A narrow staircase between prison floors.",
            false,
            "Scratched walls hint at desperate escape attempts."
        );

        Location dockyard = new Location(
            "Receiving Port",
            "Old dock where cargo once arrived.",
            false,
            "Broken crates and chains hint at long-abandoned shipments."
        );

        // --- ITEMS ---
        Item knife = new Item("Knife", "A small combat knife. Can help fend off danger.");
        Item herb = new Item("Green Herb", "A medicinal plant that restores health.");
        Item flashlight = new Item("Flashlight", "Helps navigate dark areas.");
        Item rustyKey = new Item("Rusty Key", "An old key, might unlock a door.");
        Item goldKey = new Item("Gold Key", "Used by the Warden for special access.");
        Item redCard = new Item("Red Keycard", "High-level security keycard.");
        Item smoothKey = new Item("Smooth Key", "A civilian-style door key.");
        Item ledgerAW = new Item("Ledger A.W.", "A detailed ledger about Subject 428 with initials A.W. You feel it relates to you.");
        Item noteAW = new Item("Note A.W.", "A note explaining Subject 428 was undercover. You start to believe you are important.");
        Item finalLedger = new Item("Final Ledger", "The truth about Subject 428. You were never undercover. Only a survivor.");

        // --- PLACE ITEMS ---
        cell.addItem(rustyKey);
        safeRoom.addItem(smoothKey);
        office.addItem(redCard);
        tower.addItem(goldKey);
        laboratory.addItem(ledgerAW);
        laboratory.addItem(noteAW);
        panicRoom.addItem(finalLedger);
        armory.addItem(knife);
        medical.addItem(herb);
        blockA.addItem(flashlight);

        // --- EXITS ---
        cell.addExit("forward", blockA);

        blockA.addExit("back", cell);
        blockA.addExit("forward", recreational);

        recreational.addExit("back", blockA);
        recreational.addExit("forward", cafeteria);
        recreational.addExit("left", hallway);
        recreational.addExit("right", visiting);

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

        barracks.addExit("back", hallway);
        barracks.addExit("forward", office);
        barracks.addExit("left", armory);
        
        armory.addExit("back", barracks);

        office.addExit("back", barracks);
        office.addExit("forward", officeStairwell);
        
        officeStairwell.addExit("back", office);
        officeStairwell.addExit("forward", labStairwell);

        labStairwell.addExit("back", officeStairwell);
        labStairwell.addExit("forward", laboratory);

        laboratory.addExit("back", labStairwell);
        laboratory.addExit("forward", contamination);
        
        contamination.addExit("back", laboratory);
        contamination.addExit("forward", experiment);
        
        experiment.addExit("back", contamination);
        experiment.addExit("forward", panicRoom);
        
        panicRoom.addExit("back", experiment);

        yard.addExit("back", hallway);
        yard.addExit("left", tower);
        yard.addExit("forward", shore);
        
        tower.addExit("back", yard);
        tower.addExit("forward", wall);
        
        wall.addExit("back", tower);
        wall.addExit("forward", shore);
        
        shore.addExit("back", yard);
        shore.addExit("forward", dockyard);
        
        dockyard.addExit("back", shore);

        // --- LOCKS ---
        frontDoor.setLocked("Smooth Key");
        office.setLocked("Gold Key");
        securityDoor.setLocked("Red Keycard");
        blockA.setLocked("Rusty Key");

        // --- PLAYER & PRESENCE ---
        Scanner scanner = new Scanner(System.in);
        Player player = new Player(cell);
        Presence presence = new Presence(shore);

        System.out.println("""
            You awaken. Your head throbs. Your cell is damp and silent. You remember nothing.
            Only the number on the cell: 42.
            Something tells you the path to discovery lies beyond.
        """);

        boolean gameRunning = true;

        // --- GAME ---
        while (gameRunning && player.isAlive()) {
            System.out.println("\nHealth: " + player.getHealth() +
                    " | Presence Awareness: " + presence.getAwarenessLevel() +
                    " | Location: " + player.getLocation());
            System.out.println("Exits: " + player.getLocation().getAvailableExits());
            System.out.println("Command:");

            String input = scanner.nextLine().toLowerCase();
            CommandType command = CommandParser.parse(input);

            switch (command) {
                case MOVE -> {
                    System.out.println("Where do you want to go?");
                    String dir = scanner.nextLine().toLowerCase();
                    
                    Location next = player.getLocation().getExit(dir);
                    
                    if (next == null) {
                        System.out.println("You can't go that way.");
                        break;
                        
                    }
                    
                    if (!next.tryUnlock(player)) 
                    	break;
                    
                    player.move(next);
                    
                    System.out.println(next.getDescription());
                    
                    break;
                    
                }
                
                case EXPLORE -> {
                	player.getLocation().explore();
                	
                	break;
                }
                
                case HIDE -> {
                    player.hide();
                    presence.decreaseAwareness(10);
                    break;
                }
                
                case TAKE -> {
                    System.out.println("Which item?");
                    String itemName = scanner.nextLine();
                    
                    Item item = player.getLocation().removeItem(itemName);
                    
                    if (item != null) 
                    	player.addItem(item);
                    
                    else System.out.println("No such item here.");
                }
                
                case DROP -> {
                	
                	System.out.println("What do you want to drop?");
                	String dropName = scanner.nextLine();
                	
                	Item dropped = player.dropItem(dropName);
                	
                	if (dropped != null) {
                		player.getLocation().addItem(dropped);
                	}
                	else {
                		System.out.println("You don't have that item.");
                	}
                }
                
                case USE -> {
                    System.out.println("Use what?");
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
                        break;
                    }
                    
                }
                
                case INVENTORY -> player.showInventory();
                	
                
                case LOOK -> {
                	System.out.println(player.getLocation().getDescription());
                }
                
                case QUIT -> {
                    System.out.println("You surrender to the darkness...");
                    gameRunning = false;
                    break;
                }
                
                default -> System.out.println("Time passes...");
            }

            // --- PRESENCE ---
            presence.update(player);

            // --- ENCOUNTER ---
            if (presence.isChasing() && presence.getCurrentLocation() == player.getLocation()) {
                if (player.hasItem("Knife")) {
                    System.out.println("The Presence lunges! You stab with your knife and escape!");
                    player.removeItem("Knife");
                    presence.decreaseAwareness(60);
                } else {
                    System.out.println("The Presence strikes! You have nowhere to run...");
                    gameRunning = false;
                }
            }

            // --- ATMOSPHERE ---
            presence.printSuspense();
        }

        if (!player.isAlive()) System.out.println("You succumbed to the Presence. Your story ends here.");
        else System.out.println("You escaped... but the truth about yourself lingers in your mind.");

        scanner.close();
    }
}