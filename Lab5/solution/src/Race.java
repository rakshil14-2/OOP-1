
public class Race {
	private Team[] teams;

	private java.lang.String raceType;

	private int numTeams;

	public static final int MAX_TEAMS = 10;
	
	public Race(java.lang.String raceType) {
		this.teams = new Team[MAX_TEAMS];
		this.raceType = raceType;
		this.numTeams = 0;
	}
	
	public boolean addTeam(Team team) {
		if(team.verifyValidity(raceType) && this.numTeams<MAX_TEAMS) {
			this.teams[this.numTeams] = team;
			team.getDriver().participateInNewRace();	
			this.numTeams++;
			return true;
		}
		return false;
	}
	
	
	public Team findWinner() {
		
		Team winner = null;
		int max_skill = 0;
		for(int i=0; i<this.numTeams;i++) {
			if(this.teams[i].getTeamSkill() > max_skill) {
				winner = this.teams[i];
				max_skill = this.teams[i].getTeamSkill();
			}
		}
		return winner;
	}
	
	
	
	
}
