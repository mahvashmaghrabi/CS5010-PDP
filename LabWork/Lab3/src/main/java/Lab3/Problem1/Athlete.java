package Lab3.Problem1;

import Lab3.Problem1.Name;

public class Athlete {
  private Name athletesName;
  private Double height;
  private Double weight;
  private String league;

  public Athlete(Name athletesName, Double height, Double weight, String league) {
    this.athletesName = athletesName;
    this.height = height;
    this.weight = weight;
    this.league = league;
  }
  public Athlete(Name athletesName, Double height, Double weight) {
    this.athletesName = athletesName;
    this.height = height;
    this.weight = weight;
    this.league = null;
  }


  public Name getAthletesName() {
    return athletesName;
  }

  public Double getHeight() {
    return height;
  }

  public Double getWeight() {
    return weight;
  }

  public String getLeague() {
    return league;
  }
}