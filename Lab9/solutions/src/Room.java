public class Room {

	private int length;
	private int breadth;
	private int height;
	private int no_of_broken_lights;
	private int no_of_broken_fans;
	private int no_of_broken_tables;
	
	public Room(int length, int breadth, int height, int broken_lights, int broken_fans, int broken_tables) throws InvalidDimensionException, InvalidBrokenAppliances {
		
//		InvalidBrokenAppliances invalidBrokenApps = new InvalidBrokenAppliances(broken_lights, broken_fans, broken_tables);
//		
//		InvalidDimensionException invalidDim = new InvalidDimensionException(length, breadth, height);
//		
//		if(!invalidBrokenApps.getMessage().equals(null)) {
//			throw invalidBrokenApps;
//		}
//		if(!invalidDim.getMessage().equals(null)) {
//			throw invalidDim;
//		}
//		
		this.breadth = breadth;
		this.length = length;
		this.height = height;
		this.no_of_broken_fans = no_of_broken_fans;
		this.no_of_broken_lights = no_of_broken_lights;
		this.no_of_broken_tables = no_of_broken_tables;
		
		if(this.breadth <= 0 || this.length <= 0 || this.height <= 0) {
			throw new InvalidDimensionException(length, breadth, height);
		}
		
		if(this.no_of_broken_fans < 0 || this.no_of_broken_lights < 0 || this.no_of_broken_tables < 0) {
			throw new InvalidBrokenAppliances(broken_lights, broken_fans, broken_tables);
		}
	}

	public int calculateRepairingCost(){
		return (1*no_of_broken_lights + 2*no_of_broken_fans + 3*no_of_broken_tables);
	}
}