package extracurriculars;

public class CSA {
	private Organization[] orgList;

	private int orgCount;

	private static final int MAX_NO_OF_ORGANIZATIONS  = 30;

	public CSA() {
		this.orgList = new Organization[MAX_NO_OF_ORGANIZATIONS];
		this.orgCount = 0;
	}
	
	public boolean createNewOrganization​(Organization o) {
		if(this.orgCount < MAX_NO_OF_ORGANIZATIONS) {
			this.orgList[this.orgCount] = o;
			this.orgCount++;
			return true;
		}
		return false;
	}

	public int allocateBudget() {
		int b = 0;
		for(int i=0; i<this.orgCount; i++) {
			b += this.orgList[i].calculateBudget();
		}
		return b;
	}
	
	
	
}
