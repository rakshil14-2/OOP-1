
public class ClassRoom extends Room {
	private boolean isAcOn;

	private boolean areLightsOn;

	public ClassRoom(int length, int breadth, int height) {
		super(length, breadth, height);
		this.areLightsOn = false;
		this.isAcOn = false;
	}
	
	public void flipApplianceState​(java.lang.String appliance) {
		if(appliance.toLowerCase().equals("ac")) {
			this.isAcOn = !this.isAcOn;
		}
		if(appliance.toLowerCase().equals("lights")) {
			this.areLightsOn = !this.areLightsOn;
		}
	}
	
	public int calculateMaintenanceCost​() {
		int cost = super.calculateMaintenanceCost​();
		if(this.isAcOn) {
			cost += 10;
		}
		if(this.areLightsOn) {
			cost += 5;
		}
		return cost;
	}
	
}
