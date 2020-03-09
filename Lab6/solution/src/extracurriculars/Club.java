package extracurriculars;

public class Club implements Organization{
	private static java.lang.String name;

	private int eventCount;

	private int budget;

	private int memberCount;

	private static final int MAX_NO_OF_MEMBERS  = 40;

	public Club(String name, int eventCount, int memberCount) {
		this.name = name;
		this.eventCount = eventCount;
		this.memberCount = memberCount;
		this.budget = 0;
	}
	
	public static java.lang.String getName(){
		return name;
	}

	public int getEventCount() {
		return this.eventCount;
	}

	public int getMemberCount() {
		return this.memberCount;
	}

	@Override
	public int calculateBudget() {
		this.budget = 3000*this.eventCount*this.memberCount;
		return this.budget;
	}

	@Override
	public boolean addNewMember() {
		if(this.getMemberCount() < MAX_NO_OF_MEMBERS) {
			this.memberCount++;
			return true;
		}
		return false;
	}
	
	
}
