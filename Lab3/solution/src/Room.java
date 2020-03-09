
public class Room {
	private int length;

	private int breadth;

	private int height;

	public Room(int length, int breadth, int height) {
		this.length = length;
		this.breadth = breadth;
		this.height = height;
	}
	
	public int getVolume​() {
		return this.length*this.breadth*this.height;
	}
	
	public int getSurfaceArea​() {
		return 2*(this.length*this.breadth + this.length*this.height + this.height*this.breadth);
	}
	
	public int calculateMaintenanceCost​() {
		return 5*this.getVolume​() + 2*this.getSurfaceArea​();
	}
	
}
