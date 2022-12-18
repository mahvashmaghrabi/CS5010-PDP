package Lab3.Problem5;

public class Pieces {
  private String fName;
  private String lName;
  private int age;

  public String getFName() {
    return fName;
  }

  public void setFName(String fName) {
    this.fName = fName;
  }

  public String getLName() {
    return lName;
  }

  public void setlName(String lName) {
    this.lName = lName;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public Pieces(String fName, String lName, int age) {
    this.fName = fName;
    this.lName = lName;
    this.age = age;
  }
}
