package Lab3.Problem1;

import Lab3.Problem1.Athlete;

public class Runner extends Athlete {
  private double best5kTime;
  private double bestHalfMarathonTime;
  private String runningEvent;


  public Runner(Name athletesName, Double height, Double weight, String league) {
    super(athletesName, height, weight, league);
  }

  public Runner(Name athletesName, Double height, Double weight, String league, double best5kTime, double bestHalfMarathonTime, String runningEvent) {
    super(athletesName, height, weight, league);
    this.best5kTime = best5kTime;
    this.bestHalfMarathonTime = bestHalfMarathonTime;
    this.runningEvent = runningEvent;
  }

  public Runner(Name athletesName, Double height, Double weight, double best5kTime, double bestHalfMarathonTime, String runningEvent) {
    super(athletesName, height, weight);
    this.best5kTime = best5kTime;
    this.bestHalfMarathonTime = bestHalfMarathonTime;
    this.runningEvent = runningEvent;
  }

  public double getBest5kTime() {
    return best5kTime;
  }

  public void setBest5kTime(double best5kTime) {
    this.best5kTime = best5kTime;
  }

  public double getBestHalfMarathonTime() {
    return bestHalfMarathonTime;
  }

  public void setBestHalfMarathonTime(double bestHalfMarathonTime) {
    this.bestHalfMarathonTime = bestHalfMarathonTime;
  }

  public String getRunningEvent() {
    return runningEvent;
  }

  public void setRunningEvent(String runningEvent) {
    this.runningEvent = runningEvent;
  }

  public Runner(Name athletesName, Double height, Double weight) {
    super(athletesName, height, weight);
  }
}
