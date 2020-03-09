
public class InvalidBrokenAppliances extends Exception {
	private int no_of_broken_fans;

	private int no_of_broken_tables;

	private int no_of_broken_lights;

	public InvalidBrokenAppliances(int broken_lights, int broken_fans, int broken_tables) {
		this.no_of_broken_tables = broken_tables;
		this.no_of_broken_fans = broken_fans;
		this.no_of_broken_lights = broken_lights;
	}

	@Override
	public String getMessage() {
		return "Number of broken appliances invalid.";
	}
	
}
