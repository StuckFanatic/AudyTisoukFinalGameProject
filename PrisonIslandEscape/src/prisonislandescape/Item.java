package prisonislandescape;

import java.io.Serializable;

public class Item implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private String name;
	private String description;
	
	//Start of items
	public Item(String name, String description) {
		this.name = name;
		this.description = description;
	}
	
	public String getName() {
		return name;
	}
	
	public String getDescription() {
		return description;
	}
	
	@Override 
	public String toString() {
		return name;
	}
	
	
	
}
