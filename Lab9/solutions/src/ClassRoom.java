public class ClassRoom extends Room {

	private boolean isAcOn;
	private boolean areLightsOn;

	public ClassRoom(int length, int breadth, int height, int broken_lights, int broken_fans, int broken_tables)
			throws InvalidDimensionException, InvalidBrokenAppliances {
		
		super(length, breadth, height, broken_lights, broken_fans, broken_tables);
		this.isAcOn = false;
		this.areLightsOn = false;
		/*
		 * Complete the constructor. By default bot AC and Lights are off. In case
		 * negative number/ zero is passed as an argument throw the relevant exception
		 * i.e InvalidDimensionException or InvalidBrokenAppliances
		 */
	}

	public void flipApplianceState(String appliance) throws invalidDeviceException {
		
		if(!(appliance.toUpperCase().equals("AC") || appliance.toLowerCase().equals("lights"))) {
			throw new invalidDeviceException("ClassRoom", appliance);
		}
		
		if(appliance.toUpperCase().equals("AC")) {
			this.isAcOn = !this.isAcOn;
		}
		
		if(appliance.toLowerCase().equals("lights")) {
			this.areLightsOn = !this.areLightsOn;
		}
		
		/*
		 * Complete the function to flip the state of appliance. If given appliance is
		 * not known then throw InvalidDeviceException
		 */

	}

}