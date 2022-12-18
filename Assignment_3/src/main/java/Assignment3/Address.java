package Assignment3;
/**
 * Creating a class Address that contains details of the address
 */
public class Address {
  private String address;
  private String city;
  private String county;
  private String state;
  private int zip;

  /**
   * Construstors for Address class
   * @param address of the Customer
   * @param city the customer lives in
   * @param county of the customer
   * @param state of the customer
   * @param zip of the city
   */
  public Address(String address, String city, String county, String state, int zip) {
    this.address = address;
    this.city = city;
    this.county = county;
    this.state = state;
    this.zip = zip;
  }

  /**
   * Creating an empty constructor
   */
  public Address() {
  }

  /**
   * Generating a getter for Adress
   * @return address of the customer
   */
  public String getAddress() {
    return address;
  }

  /**
   * Generating a setter
   * @param address sets the address
   */
  public void setAddress(String address) {
    this.address = address;
  }

  /**
   * Generating a getter
   * @return city of the customer
   */
  public String getCity() {
    return city;
  }

  /**
   * Generating a setter
   * @param city sets city value of Customer
   */
  public void setCity(String city) {
    this.city = city;
  }

  /**
   * Generating a getter
   * @return country of Customer
   */
  public String getCounty() {
    return county;
  }

  /**
   * Generating a setter
   * @param county sets country value
   */
  public void setCounty(String county) {
    this.county = county;
  }

  /**
   * Generating a getter
   * @return the state of the Customer
   */
  public String getState() {
    return state;
  }

  /**
   * Generating a setter
   * @param state sets the state value
   */
  public void setState(String state) {
    this.state = state;
  }

  /**
   * Generating a getter
   * @return zip code of the customer
   */
  public int getZip() {
    return zip;
  }

  /**
   * Generating a setter
   * @param zip sets the zip code
   */
  public void setZip(int zip) {
    this.zip = zip;
  }
}


