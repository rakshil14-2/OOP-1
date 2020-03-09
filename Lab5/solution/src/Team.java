
public class Team {
	private Driver driver;

	private CrewMember crewMember;

	private Vehicle vehicle;

	private int teamSkill;
	
	public Team(Driver driver,CrewMember crewMember,FourWheeler fourWheeler) {
		this.driver = driver;
		this.crewMember =crewMember;
		this.vehicle = fourWheeler;
		this.calculateTeamSkill();
	}
	
	public Team(Driver driver,CrewMember crewMember,TwoWheeler twoWheeler) {
		this.driver = driver;
		this.crewMember =crewMember;
		this.vehicle = twoWheeler;
		this.calculateTeamSkill();
	}
	
	public Driver getDriver() {
		return this.driver;
	}
	
	public int getTeamSkill() {
		return this.teamSkill;
	}
	
	public boolean verifyValidity(java.lang.String raceType) {
		if(!this.driver.verifyValidity() || !this.crewMember.verifyValidity()) {
			return false;
		}
		if(raceType.equals("TwoWheeler") && this.vehicle.numWheels == 4) {
			return false;
		}
		if(raceType.equals("FourWheeler") && this.vehicle.numWheels == 2) {
			return false;
		}
		if(this.vehicle.verifyValidity()) {
			return true;
		}
		return false;
			
	}
	
	public void calculateTeamSkill() {
		this.teamSkill = (5*this.driver.skill + 2*this.crewMember.skill);
	}
}
