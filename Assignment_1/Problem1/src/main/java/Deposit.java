public class Deposit {
  private String firstname;
  private String lastname;
  private double deposit_amount;

  public Deposit(String firstname, String lastname, double deposit_amount) {
    this.firstname = firstname;
    this.lastname = lastname;
    this.deposit_amount = deposit_amount;
  }

  public String getFirstname() {
    return firstname;
  }

  public String getLastname() {
    return lastname;
  }

  public double getDeposit_amount() {
    return deposit_amount;
  }

  public void setFirstname(String firstname) {
    this.firstname = firstname;
  }

  public void setLastname(String lastname) {
    this.lastname = lastname;
  }

  public void setDeposit_amount(double deposit_amount) {
    this.deposit_amount = deposit_amount;
  }
}
