
public class AcadBlock extends CampusBuilding {
	private ClassRoom[] classRooms;

	static int MAX_NUMBER_OF_CLASS_ROOMS = 200;
	
	public AcadBlock(java.lang.String name) {
		super(name);
		this.classRooms = new ClassRoom[MAX_NUMBER_OF_CLASS_ROOMS];
	}
	
	public boolean addClassRoom​(ClassRoom classRoom) {
		if(this.numberOfRooms < MAX_NUMBER_OF_CLASS_ROOMS) {
			this.classRooms[this.numberOfRooms] = classRoom;
			this.numberOfRooms++;
			return true;
		}
		return false;
	}
	
	public int calculateMaintenanceCost​() {
		int mc = 0;
//		for(ClassRoom c: this.classRooms) {
//			mc += c.calculateMaintenanceCost​();
//		}
		for(int i=0; i<this.numberOfRooms; i++) {
			mc += this.classRooms[i].calculateMaintenanceCost​();
		}
		return mc;
	}
}
