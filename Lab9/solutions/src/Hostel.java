public class Hostel extends CampusBuilding  { 
	
	private HostelRoom[] hostelRooms;
	static int  MAX_NUMBER_OF_HOSTEL_ROOMS =  100 ;
	
	public   Hostel (String name) { 
		super (name);
		hostelRooms =  new HostelRoom[MAX_NUMBER_OF_HOSTEL_ROOMS];
	}

	public void addHostelRoom (HostelRoom hostelRoom) throws MaximumCapacityException{ 
		
		if(this.numberOfRooms < MAX_NUMBER_OF_HOSTEL_ROOMS) {
			this.hostelRooms[this.numberOfRooms] = hostelRoom;
		}
		else {
			throw new MaximumCapacityException("HostelRoom", "Hostel");
		}
		/*
		Add hostel room to Hostel and throw MaximumCapacityException
		when number of hostel rooms exceed the maximum limit
		*/

	}

	public   int   calculateRepairingCost () { 
		int  cost =  0 ;
		for (HostelRoom hostelRoom: hostelRooms) 
			if (hostelRoom !=  null )
                cost +=hostelRoom.calculateRepairingCost();
		return  cost; 
	}

	public   float   calculateAverageRepairingCost () throws DivideZeroException { 
		float avgCost;
		
		int numRooms = 0;
		
		for(HostelRoom hostelRoom: hostelRooms) {
			if(hostelRoom == null) {
				break;
			}
			numRooms++;
		}
		
		if(numRooms == 0) {
			throw new DivideZeroException("HostelRoom");
		}
		
		float totalCost = this.calculateRepairingCost();
		avgCost = totalCost / numRooms;
		
		/*
		Complete the function to calculate the average cost and throw DivideZeroException
		when divided by 0
		*/
		return avgCost;
	}
	
}