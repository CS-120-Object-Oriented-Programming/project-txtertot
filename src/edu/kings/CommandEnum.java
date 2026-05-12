package edu.kings;

public enum CommandEnum {

	GO("go"),
	
	QUIT("quit"),
	
	HELP("help"),
	
	LOOK("look"),
	
	EXAMINE("examine"),
	
	TAKE("take"),
	
	NOCLIP("noclip");
	
	/** Command word */
	
	private String command;
	
	private CommandEnum(String word) {
		this.command = word;
	}
	
	public String getCommand() {
		return command;
	}
	
}
