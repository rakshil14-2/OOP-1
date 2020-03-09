package extracurriculars;

public class Department implements Organization{
	private static java.lang.String name;

	private int sessionCountPerWeek;

	private int budget;

	private int memberCount;

	private int maxMemberCount;
	
	public Department(java.lang.String name,int sessionCountPerWeek,int memberCount) {
		this.name = name;
		this.sessionCountPerWeek = sessionCountPerWeek;
		this.memberCount = memberCount;
		this.budget = 0;
		this.maxMemberCount = 30*this.sessionCountPerWeek;
	}
	
	public static java.lang.String getName(){
		return name;
	}

	public int getSessionCountPerWeek() {
		return this.sessionCountPerWeek;
	}

	public int getMemberCount() {
		return this.memberCount;
	}
	
	@Override
	public int calculateBudget() {
		this.budget=5000*this.sessionCountPerWeek*this.memberCount;
		return this.budget;
	}

	@Override
	public boolean addNewMember() {
		if(this.memberCount < this.maxMemberCount) {
			this.memberCount++; 
			return true;
		}
		return false;
	}
	
	
}
