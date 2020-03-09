
public class Hostel extends CampusBuilding{
	private HostelRoom[] hostelRooms;

	static int MAX_NUMBER_OF_HOSTEL_ROOMS = 100;
	
	public Hostel(java.lang.String name) {
		super(name);
		this.hostelRooms = new HostelRoom[MAX_NUMBER_OF_HOSTEL_ROOMS];
	}
	
	public boolean addHostelRoom​(HostelRoom hostelRoom) {
		if(this.numberOfRooms < MAX_NUMBER_OF_HOSTEL_ROOMS) {
			this.hostelRooms[this.numberOfRooms] = hostelRoom;
			this.numberOfRooms++;
			return true;
		}
		return false;
	}
	
	public int calculateMaintenanceCost​() {
		int mc = 0;
		
//		for(HostelRoom h: this.hostelRooms) {
//			mc += h.calculateMaintenanceCost​();
//		}
		for(int i=0; i<this.numberOfRooms; i++) {
			mc += this.hostelRooms[i].calculateMaintenanceCost​();
		}
		return mc;
	}
	
}
