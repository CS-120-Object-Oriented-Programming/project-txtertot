/**
 * 
 */
package edu.kings;

import java.util.ArrayList;

/**
 * Saves player information i think :).
 */
public class Player {
	
	/** players current location */
	private Room location;
	ArrayList <Item> inventory = new ArrayList<>();
	public int currentWeight = 0;
	public int maxCarryWeight = 30;
	
	public Player(Room local) {
		location = local;
	}
	
	public Room getLocation() {
		return location;
	}
	
	public void setLocation(Room newRoom) {
		location = newRoom;
	}
		
	public void setInventory(Item newItem) {
			if (newItem.getWeight() + currentWeight <= maxCarryWeight) {
				inventory.add(newItem);
				currentWeight = newItem.getWeight() + currentWeight;
				Writer.println(newItem.getName() + " added to inventory.");
			}
			else {
				Writer.println("Could not add" + newItem.getName() + "to inventory.");
			}
	}
	
	public Item removeItem(String itemName) {
		for (int i=0; i < inventory.size(); i++) {
			if (inventory.get(i).getName() == itemName) {
				inventory.remove(i);
				return inventory.get(i);
			}
		} return null;
	}
	
	public ArrayList<Item> getInventory() {
		return inventory;
	}

	public void take(Item item) {
		if (item != null) {
			if (currentWeight + item.getWeight() <= maxCarryWeight) {
				inventory.add(item);
				Writer.println(item.getName() + " has been picked up");
				currentWeight = item.getWeight() + currentWeight;
				location.removeItem(item);
			}
			else {
				Writer.println(item.getName() + " cannot be picked up.");
			}
		}else {
			Writer.println("There is no item for you to take.");
		}
		
	}
}
