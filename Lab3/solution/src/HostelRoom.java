import java.util.StringTokenizer;

public class HostelRoom extends Room {
	private boolean[] workingAppliances;

	static int NUMBER_OF_APPLIANCES = 3;

	public HostelRoom(int length, int breadth, int height) {
		super(length, breadth, height);
		this.workingAppliances = new boolean[NUMBER_OF_APPLIANCES];
		this.workingAppliances[0] = false;
		this.workingAppliances[1] = false;
		this.workingAppliances[2] = false;
	}

	public void setStateOfAppliances​(java.lang.String state) {
		StringTokenizer st = new StringTokenizer(state.toLowerCase(), ",");
//		this.workingAppliances[0] = Boolean.parseBoolean(st.nextToken());
//		this.workingAppliances[1] = Boolean.parseBoolean(st.nextToken());
//		this.workingAppliances[2] = Boolean.parseBoolean(st.nextToken());
		if(st.nextToken().equals("true")) {
			this.workingAppliances[0] = true;
		}
		else {
			this.workingAppliances[0] = false;
		}
		if(st.nextToken().equals("true")) {
			this.workingAppliances[1] = true;
		}
		else {
			this.workingAppliances[1] = false;
		}
		if(st.nextToken().equals("true")) {
			this.workingAppliances[2] = true;
		}
		else {
			this.workingAppliances[2] = false;
		}
	}

	public int calculateMaintenanceCost​() {
		int cost = super.calculateMaintenanceCost​();
		if(!this.workingAppliances[0]) {
			cost += 5;
		}
		if(!this.workingAppliances[1]) {
			cost += 3;
		}
		if(!this.workingAppliances[2]) {
			cost += 2;
		}
		return cost;
	}
	
}
