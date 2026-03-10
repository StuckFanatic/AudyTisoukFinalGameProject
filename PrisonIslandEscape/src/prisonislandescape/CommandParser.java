package prisonislandescape;

public class CommandParser {
	
	public static CommandType parse(String input) {
		
		if (input.startsWith("leave") || input.startsWith("leave") || input.startsWith("move")) {
			return CommandType.MOVE;
		}
		
		if (input.startsWith("hide") || input.startsWith("wait")) {
			return CommandType.HIDE;
		}
		
		if (input.startsWith("explore") || input.startsWith("search")) {
			return CommandType.EXPLORE;
		}
		
		if (input.startsWith("take") || input.startsWith("pick") || input.startsWith("grab")) {
			return CommandType.TAKE;
		}
		
		if (input.startsWith("drop")) {
			return CommandType.DROP;
		}
		
		if (input.startsWith("inventory") || input.startsWith("bag")) {
			return CommandType.INVENTORY;
		}
		
		if (input.startsWith("look") || input.startsWith("observe")) {
			return CommandType.LOOK;
		}
		
		if (input.startsWith("use")) {
			return CommandType.USE;
		}
		
		if (input.startsWith("quit") || input.startsWith("give up")) {
			return CommandType.QUIT;
		}
		
		return CommandType.UNKNOWN;
		
	}
	
	
}
