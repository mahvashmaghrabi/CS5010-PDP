package Lab3.Problem2;

public class Address {
  private String streetAndNumber;
  private String city;
  private String ZIPCode;
  private String state;
  private String country;


  public Address(String streetAndNumber, String city, String ZIPCode, String state, String country) {
    this.streetAndNumber = streetAndNumber;
    this.city = city;
    this.ZIPCode = ZIPCode;
    this.state = state;
    this.country = country;
  }

  public String getStreetAndNumber() {
    return streetAndNumber;
  }

  public void setStreetAndNumber(String streetAndNumber) {
    this.streetAndNumber = streetAndNumber;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public String getZIPCode() {
    return ZIPCode;
  }

  public void setZIPCode(String ZIPCode) {
    this.ZIPCode = ZIPCode;
  }

  public String getState() {
    return state;
  }

  public void setState(String state) {
    this.state = state;
  }

  public String getCountry() {
    return country;
  }

  public void setCountry(String country) {
    this.country = country;
  }

}
