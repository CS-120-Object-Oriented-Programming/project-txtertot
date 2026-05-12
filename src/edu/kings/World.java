package edu.kings;
import java.util.HashMap;

/**
 * This class represents the entire world that makes up the "Campus of Kings"
 * application. "Campus of Kings" is a very simple, text based adventure game.
 * Users can walk around some scenery. That's all. It should really be extended
 * to make it more interesting!
 *
 * This world class creates the world where the game takes place.
 *
 * @author Maria Jump
 * @version 2015.02.01
 *
 * Used with permission from Dr. Maria Jump at Northeastern University
 */
public class World {
	/** The rooms in the world. */
	private HashMap<String, Room> rooms;

	/**
	 * Constructor for the world.
	 */
	public World() {
		rooms = new HashMap<String, Room>();
		createRooms();
	}

	/**
	 * This method takes care of creating all of the aspects of the world for
	 * the "Campus of Kings" application.
	 *
	 * @param name
	 *            The provided name of the room.
	 * @return The room associated with the provided name
	 */
	public Room getRoom(String name) {
		return rooms.get(name.toLowerCase());
	}

	/////////////////////////////////////////////////////////////////////////////////////
	// Start of private helper methods

	/**
	 * Helper method for recreating a Room. Ensure that the room is created and
	 * installed in to the collection of Rooms
	 *
	 * @param theRoom
	 *            The room to add to the world.
	 */
	private void addRoom(Room theRoom) {
		rooms.put(theRoom.getName().toLowerCase(), theRoom);
	}

	/**
	 * Helper method for creating doors between rooms.
	 *
	 * @param from
	 *            The room where the door originates.
	 * @param direction
	 *            the direction
	 * @param to
	 * 			where to
	 */
	private void createDoor(Room from, String direction, Room to) {
		Door newDoor = new Door(to);
		rooms.get(from.getName().toLowerCase()).allDoors.put(direction, newDoor);
	}
		
	private void createRooms() {
		
		Item almondWater = new Item("Almond Water", "A clear liquid with a sweet almond/vanilla taste mixed with purified rose water.", 10, 2);
		Item paper = new Item("Paper", "Hello, I'm not sure who will find this- if ANYONE will find this, but I must at the very least try to help my fellow man... or woman. or they/them. or-- you get the point. There are certain places here with this deeply unsettling feeling attached to them. Places that make you wish to leave immediately. Despite this feeling, these places are the key to your escape. You can 'noclip' through these spaces like... that one train platform in Harry Potter or something- phase right through physical boundaries and such into someplace new! into FREEDOM! The only 'downside' is that you cannot return, so I urge you to be certain in your choices before doing so.", 10, 100);
		// Creating all the rooms.
		Room outside = new Room("Outside", "You find yourself wandering toward the McGowan building late at night, having accidentally left your laptop in your earlier class. The air around you feels... wrong as you walk. Trees rustled despite a lack of wind, the usual crickets and insects are unusually quiet. A chilling sense of unease creeps up your spine.", almondWater);
		Room nope = new Room("Noooope!", "The atmosphere alone is enough to convince you to get the hell out of there. You can always get your laptop tomorrow (END).", null);
		Room backroomEntrance = new Room("???", "As you take a step toward the card scanner you find that your foot does not meet solid ground. Rather, the entirety of your body no-clips through the floor, sending you tumbling down past the concrete and Earth, into an unknown abyss. . . After an unknown amount of time, you begin to regain consciousness.", null);
		Room level0Description = new Room("Your New Home", "You awaken to the sound of buzzing flourescent lights and the distinct stench of soggy carpet. A barren labryinth of sickly-yellow wallpaper stretches before you, its hallways seemingly changing every time you look away. The entrance in which you came from-- if you could even call it that, is nowhere to be found. All you know is that you STILL need to get your laptop.", null);
		Room room1 = new Room("The intersection", "You're stood in the center of an intersection with a flickering light above you. Each direction seems to sprawl out endlessly, offering no clues on where the exit may be.", null);
		Room foreverNorth = new Room("The long hallway", "There is nothing but a series of black, hastily painted arrows pointing North on the lefthand wall. At the end of this hallway you can make out a door with a neon red 'EXIT' sign above it. Its quite far away, but patience is key, right?", null);
		Room quiterAlert = new Room("Giving up?!", "The way back to the intersection feels like a much shorter distance than your trip to the exit... But you were so close!! 99% of hallway explorers quit right before their big escape, y'know.", null);
		Room lostWoodsRipoffExplanation = new Room("Deja vu...", "As you walk, the way in which you came seems to shift and change into someplace unrecognizable. You are now within a new intersection, unable to return to where you began until you find the correct path.", null);
		Room lostWoodsRipoffStart = new Room("Deja vu", "The flourescent light above you is blindingly bright.", null);
		Room lostWoodsRipoffNorth = new Room("Deja vu?", "The flourescent light above you is... at an acceptable brightness!", null);
		Room lostWoodsRipoffWest = new Room("Deja vu?!", "The flourescent light above you is dim. There appears to be a paper stuck firmly to the North wall.", paper);
		Room lostWoodsRipoffSouth = new Room("Deja vu?!?!", "The flourescent light above you has died out, leaving the room in complete darkness.", null);
		Room lostWoodsRipoffExit = new Room("FREEDOM!!!!!", "As you walk through the pitch-black corridor, you eventually find yourself back where you began-- As in the starting intersection, NOT maze hell.", null);
		Room eastHallway = new Room("A strange wall", "A deadend. As you approach the wall at the end of this hallway, a familiar feeling returns. That unease you felt moments before noclipping into this strange place settles back into your bones, sticking the hairs on your arms straight up. You do not wish to linger here for long.", null);
		Room test = new Room("test", "test", null);
		// Adding all the rooms to the world.
		this.addRoom(outside);
		this.addRoom(backroomEntrance);
		this.addRoom(level0Description);
		this.addRoom(nope);
		this.addRoom(room1);
		this.addRoom(foreverNorth);
		this.addRoom(quiterAlert);
		this.addRoom(lostWoodsRipoffExplanation);
		this.addRoom(lostWoodsRipoffStart);
		this.addRoom(lostWoodsRipoffNorth);
		this.addRoom(lostWoodsRipoffWest);
		this.addRoom(lostWoodsRipoffSouth);
		this.addRoom(lostWoodsRipoffExit);
		this.addRoom(eastHallway);
		this.addRoom(test);
		// Creating all the doors between the rooms.
		this.createDoor(outside, "forward", backroomEntrance);
		this.createDoor(outside, "leave", nope);
		
		this.createDoor(backroomEntrance, "next", level0Description);
		this.createDoor(level0Description, "next", room1);
		
		this.createDoor(room1, "north", foreverNorth);
		this.createDoor(foreverNorth, "north", foreverNorth);
		this.createDoor(foreverNorth, "south", quiterAlert);
		this.createDoor(quiterAlert, "next", room1);
		
		this.createDoor(room1, "south", lostWoodsRipoffExplanation);
		this.createDoor(lostWoodsRipoffExplanation, "next", lostWoodsRipoffStart);
		
		this.createDoor(lostWoodsRipoffStart, "east", lostWoodsRipoffStart);
		this.createDoor(lostWoodsRipoffStart, "west", lostWoodsRipoffStart);
		this.createDoor(lostWoodsRipoffStart, "south", lostWoodsRipoffStart);
		this.createDoor(lostWoodsRipoffStart, "north", lostWoodsRipoffNorth);
		
		this.createDoor(lostWoodsRipoffNorth, "north", lostWoodsRipoffStart);
		this.createDoor(lostWoodsRipoffNorth, "east", lostWoodsRipoffStart);
		this.createDoor(lostWoodsRipoffNorth, "south", lostWoodsRipoffStart);
		this.createDoor(lostWoodsRipoffNorth, "west", lostWoodsRipoffWest);
		
		this.createDoor(lostWoodsRipoffWest, "north", lostWoodsRipoffStart);
		this.createDoor(lostWoodsRipoffWest, "east", lostWoodsRipoffStart);
		this.createDoor(lostWoodsRipoffWest, "west", lostWoodsRipoffStart);
		this.createDoor(lostWoodsRipoffWest, "south", lostWoodsRipoffSouth);
		
		this.createDoor(lostWoodsRipoffSouth, "north", lostWoodsRipoffStart);
		this.createDoor(lostWoodsRipoffSouth, "east", lostWoodsRipoffStart);
		this.createDoor(lostWoodsRipoffSouth, "south", lostWoodsRipoffStart);
		this.createDoor(lostWoodsRipoffSouth, "west", lostWoodsRipoffExit);
		
		this.createDoor(lostWoodsRipoffExit, "next", room1);
		
		this.createDoor(room1, "east", eastHallway);
		this.createDoor(eastHallway, "west", room1);
	}
	
}
