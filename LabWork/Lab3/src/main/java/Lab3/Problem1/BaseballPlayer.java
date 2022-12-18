package Lab3.Problem1;

public class BaseballPlayer extends Athlete{

  private String team;
  private double averageBatting;
  private int homeRuns;

  public BaseballPlayer(Name athletesName, Double height, Double weight, String league, String team, double averageBatting, int homeRuns) {
    super(athletesName, height, weight, league);
    this.team = team;
    this.averageBatting = averageBatting;
    this.homeRuns = homeRuns;
  }

  public BaseballPlayer(Name athletesName, Double height, Double weight, String team, double averageBatting, int homeRuns) {
    super(athletesName, height, weight);
    this.team = team;
    this.averageBatting = averageBatting;
    this.homeRuns = homeRuns;
  }

  public BaseballPlayer(Name athletesName, Double height, Double weight, String league) {
    super(athletesName, height, weight, league);
  }

  public BaseballPlayer(Name athletesName, Double height, Double weight) {
    super(athletesName, height, weight);
  }


  public String getTeam() {
    return team;
  }

  public void setTeam(String team) {
    this.team = team;
  }

  public double getAverageBatting() {
    return averageBatting;
  }

  public void setAverageBatting(double averageBatting) {
    this.averageBatting = averageBatting;
  }

  public int getHomeRuns() {
    return homeRuns;
  }

  public void setHomeRuns(int homeRuns) {
    this.homeRuns = homeRuns;
  }
}
