package prisonislandescape;

public class CommandParser {
	
	public static CommandType parse(String input) {
		
		if (input.startsWith("leave") || input.startsWith("move")) {
			return CommandType.MOVE;
		}
		
		if (input.startsWith("hide") || input.startsWith("wait")) {
			return CommandType.HIDE;
		}
		
		if (input.startsWith("take") || input.startsWith("grab")) {
			return CommandType.TAKE;
		}
		
		if (input.startsWith("inventory") || input.startsWith("bag")) {
			return CommandType.INVENTORY;
		}
		
		if (input.startsWith("quit") || input.startsWith("give up")) {
			return CommandType.QUIT;
		}
		
		return CommandType.UNKNOWN;
		
	}
	
	
}
