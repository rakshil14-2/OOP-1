
public class Campus {
	private static java.lang.String name;

	private int hostelCount;

	private Hostel[] hostels;

	private AcadBlock acadBlock;

	static int MAX_NUMBER_OF_HOSTELS = 10;

	public Campus(java.lang.String name, AcadBlock acadBlock) {
		Campus.name = name;
		this.acadBlock = acadBlock;
		this.hostelCount = 0;
		this.hostels = new Hostel[MAX_NUMBER_OF_HOSTELS];
	}
	
	public static java.lang.String getName​(){
		return name;
	}
	
	public boolean addHostel​(java.lang.String hostelName) {
		if(this.hostelCount < MAX_NUMBER_OF_HOSTELS) {
			Hostel h = new Hostel(hostelName);
			this.hostels[this.hostelCount] = h;
			this.hostelCount++;
			return true;
		}
		return false;
	}
	
	public int calculateCampusMaintenance​() {
		int mc = this.acadBlock.calculateMaintenanceCost​();
		
//		for(Hostel h: this.hostels) {
//			mc += h.calculateMaintenanceCost​();
//		}
		
		for(int i=0; i<this.hostelCount; i++) {
			mc += this.hostels[i].calculateMaintenanceCost​();
		}
		return mc;
	}
	
}
