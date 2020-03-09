public class HostelRoom extends Room {

	private boolean[] workingAppliances;
	static int NUMBER_OF_APPLIANCES = 3;

	public HostelRoom(int length, int breadth, int height, int broken_lights, int broken_fans, int broken_tables) throws InvalidDimensionException,
    InvalidBrokenAppliances {
		super(length, breadth, height, broken_lights, broken_fans, broken_tables);
		
		this.workingAppliances = new boolean[3];
		this.workingAppliances[0] = false;
		this.workingAppliances[1] = false;
		this.workingAppliances[2] = false;
		/*
		Complete the constructor. In case negative dimensions/appliances are passed as an argument then 
		throw the relevant exception i.e InvalidDimensionException or InvalidBrokenAppliances
		*/
	}


	/*
	Modify the function such that it throws invalid state exception when invalid state is passed
	*/
	public void setStateOfAppliances(String state) throws InvalidStateException {
			String[] tempArr = state.toUpperCase().split(",");
			for(int i = 0; i<tempArr.length; i++) {
				if(tempArr[i].equals("TRUE"))
					workingAppliances[i] = true;
				else if(tempArr[i].equals("FALSE"))
					workingAppliances[i] = false;
				else
					throw new InvalidStateException();
			}
	}

}