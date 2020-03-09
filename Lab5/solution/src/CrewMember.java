
public class CrewMember extends RacePerson {
	private int experience;

	public static int MIN_AGE = 20;

	public static int MIN_EXPERIENCE = 2;

	public CrewMember(java.lang.String name, int age, int ID, int experience) {
		super(name, age, ID);
		this.experience = experience;
		this.calculateSkill();
	}
	
	@Override
	public boolean verifyValidity() {
		if(this.age >= MIN_AGE && this.experience >= MIN_EXPERIENCE) {
			return true;
		}
		return false;
	}

	@Override
	public void calculateSkill() {
		this.skill = (this.experience)*100/this.age;
	}

	@Override
	public String getInfo() {
		return super.toString() + "\nExperience : " +this.experience; 
	}
	
	
}
