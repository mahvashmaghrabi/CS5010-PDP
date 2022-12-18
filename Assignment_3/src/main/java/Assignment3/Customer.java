package Assignment3;
/**
 * Creating a Customer class which has customer details and has Address and Personal Details of the Customer
 */

public class Customer {

  private String first_name;
  private String last_name;
  private String company_name;
  private Address address;
  private PersonalDetails personal;

  /**
   * Generating an empty Construstor
   */
  public Customer() {
  }

  /**
   * Generating a parameterized Constructor
   * @param first_name of the Customer
   * @param last_name of the Customer
   * @param company_name the Customer works at
   * @param address Customer has an address
   * @param personal Customer has Personal Details
   */
  public Customer(String first_name, String last_name, String company_name, Address address, PersonalDetails personal) {
    this.first_name = first_name;
    this.last_name = last_name;
    this.company_name = company_name;
    this.address = address;
    this.personal = personal;
  }

  /**
   * Generating a getter
   * @return first name of the customer
   */
  public String getFirst_name() {
    return first_name;
  }

  /**
   * Generating a setter
   * @param first_name sets the first name of the customer
   */
  public void setFirst_name(String first_name) {
    this.first_name = first_name;
  }

  /**
   * Generating a getter
   * @return the last name of the customer
   */
  public String getLast_name() {
    return last_name;
  }

  /**
   * Generating a setter
   * @param last_name sets the the last name of the Customer
   */
  public void setLast_name(String last_name) {
    this.last_name = last_name;
  }

  /**
   * Generating a getter
   * @return gets the company name
   */
  public String getCompany_name() {
    return company_name;
  }

  /**
   * Generating a setter
   * @param company_name sets the name of the company
   */
  public void setCompany_name(String company_name) {
    this.company_name = company_name;
  }

  /**
   * Customer has an Address : HAS-A Relationship
   * @return the Address
   */
  public Address getAddress() {
    return address;
  }

  /**
   * generating a setter
   * @param address sets the address values
   */
  public void setAddress(Address address) {
    this.address = address;
  }

  /**
   * Customer has an Personal : HAS-A Relationship
   * @return Personal details of the Customer
   */
  public PersonalDetails getPersonal() {
    return personal;
  }

  /**
   * Generating a setter
   * @param personal sets the personal details of the customer
   */
  public void setPersonal(PersonalDetails personal) {
    this.personal = personal;
  }
}


