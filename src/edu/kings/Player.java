/**
 * 
 */
package edu.kings;

/**
 * Saves player information i think :).
 */
public class Player {
	
	/** players current location */
	private Room location;
	
	public Player(Room local) {
		location = local;
	}
	
	public Room getLocation() {
		return location;
	}
	
	public void setLocation(Room newRoom) {
		location = newRoom;
	}

}
