package Lab3.Problem5;

public class Civilian extends Pieces{
  private int wealth;

  public Civilian(String fName, String lName, int age, int wealth) {
    super(fName, lName, age);
    this.wealth = wealth;
  }

  public int getWealth() {
    return wealth;
  }

  public void setWealth(int wealth) {
    this.wealth = wealth;
  }

  public Civilian(String fName, String lName, int age) {
    super(fName, lName, age);
  }
}
