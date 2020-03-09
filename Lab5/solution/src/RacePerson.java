
public abstract class RacePerson {
	protected java.lang.String name;

	protected int age;

	protected int ID;

	protected int skill;

	public RacePerson(String name, int age, int iD) {
		this.name = name;
		this.age = age;
		ID = iD;
	}
	
	public int getSkill() {
		return this.skill;
	}
	
	public abstract boolean verifyValidity();
	
	public abstract void calculateSkill();
	
	public abstract java.lang.String getInfo();
	
	@Override
	public String toString() {
		return this.ID +" " + this.name + " (" + this.age + " yrs)";
	}
	
	

}
