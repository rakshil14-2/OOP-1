
public class Driver extends RacePerson {
	private int points;

	private int numRacesParticipated;

	public static final int MAX_RACES = 20;

	public static final int MIN_AGE = 20;

	public static final int MIN_POINTS = 5;

	public Driver(java.lang.String name, int age, int ID, int points, int numRacesParticipated) {
		super(name, age, ID);
		this.points = points;
		this.numRacesParticipated = numRacesParticipated;
		this.calculateSkill();
	}

	@Override
	public boolean verifyValidity() {
		if(this.age >= MIN_AGE && this.points >= MIN_POINTS && this.numRacesParticipated < MAX_RACES) {
			return true;
		}
		return false;
	}

	@Override
	public void calculateSkill() {
		this.skill = (this.points*100)/this.numRacesParticipated;
	}

	@Override
	public String getInfo() {
		return super.toString() + "\nPoints : " + this.points + "\nNo. of races attempted : " + this.numRacesParticipated;
	}
	
	public void participateInNewRace() {
		this.numRacesParticipated++;
		this.calculateSkill();
	}
	
	
}
