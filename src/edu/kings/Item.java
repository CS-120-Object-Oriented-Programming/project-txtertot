package edu.kings;

public class Item {
String name;
String description;
int pts;
int weight;

	public Item(String newName, String newDescription, int newPts, int newWeight) {
		this.name = newName;
		this.description = newDescription;
		this.pts = newPts;
		this.weight = newWeight;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getPts() {
		return pts;
	}

	public void setPts(int pts) {
		this.pts = pts;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}
	
	public String toString() {
		String retVal = name + ": " + description + ", worth: " + pts + "points, weighs: " + weight + "lbs.";
		return retVal;
	}
		
}
