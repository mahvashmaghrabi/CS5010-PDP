package Lab3.Problem5;

public class Soldier extends Pieces{
  private int stamina;

  public Soldier(String fName, String lName, int age, int stamina) {
    super(fName, lName, age);
    this.stamina = stamina;
  }

  public int getStamina() {
    return stamina;
  }

  public void setStamina(int stamina) {
    this.stamina = stamina;
  }

  public Soldier(String fName, String lName, int age) {
    super(fName, lName, age);
  }
}
