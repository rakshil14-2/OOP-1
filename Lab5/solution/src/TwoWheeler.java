
public class TwoWheeler extends Vehicle {
	
	public static final int TWO_WHEELER_MAX_LENGTH = 10;

	public static final int TWO_WHEELER_MAX_WIDTH = 3;

	public static final int TWO_WHEELER_MAX_COST = 15;

	public TwoWheeler(String name, int length, int width, int cost) {
		super(name, length, width, cost);
		this.numWheels =2;
	}

	@Override
	public boolean verifyValidity() {
		if(this.length <= TWO_WHEELER_MAX_LENGTH && this.width <= TWO_WHEELER_MAX_WIDTH && this.cost <= TWO_WHEELER_MAX_COST) {
			return true;
		}
		return false;
	}

	@Override
	public String getInfo() {
		return super.toString() + "\nWheels : " + this.numWheels;
	}
	
	
	
}
