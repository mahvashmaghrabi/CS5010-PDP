package Assignment3;
/**
 * Creating a class PersonalDetails which has the details of the Customer
 */
public class PersonalDetails {
  private String phone1;
  private String phone2;
  private String email;
  private String web;

  /**
   * Generating a constructor
   * @param phone1 Phone number 1 of the Customer
   * @param phone2 Phone number 1 of the Customer
   * @param email email address of the Customer
   * @param web URL of the Customer
   */
  public PersonalDetails(String phone1, String phone2, String email, String web) {
    this.phone1 = phone1;
    this.phone2 = phone2;
    this.email = email;
    this.web = web;
  }

  /**
   * Generating an empty constructor
   */
  public PersonalDetails() {
  }

  /**
   * Generating a getter
   * @return returns Phone Number 1 of the Customer
   */
  public String getPhone1() {
    return phone1;
  }

  /**
   * Generating a setter
   * @param phone1 sets the phone number 1 of the Customer
   */
  public void setPhone1(String phone1) {
    this.phone1 = phone1;
  }

  /**
   * Generating a getter
   * @return returns Phone Number 2 of the Customer
   */
  public String getPhone2() {
    return phone2;
  }

  /**
   * Generating a setter
   * @param phone2 sets the phone number 2 of the Customer
   */
  public void setPhone2(String phone2) {
    this.phone2 = phone2;
  }

  /**
   * Generating a getter
   * @return the email address of the Customer
   */
  public String getEmail() {
    return email;
  }

  /**
   * Generating a setter
   * @param email sets the email address of the Customer
   */
  public void setEmail(String email) {
    this.email = email;
  }

  /**
   * Generating a getter
   * @return web url of the Customer
   */
  public String getWeb() {
    return web;
  }

  /**
   * Generating a setter
   * @param web sets the url for the Customer
   */
  public void setWeb(String web) {
    this.web = web;
  }
}


