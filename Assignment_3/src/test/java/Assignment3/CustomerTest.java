package Assignment3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class CustomerTest {
  private Customer customer;
  private static Address ADDRESS = new Address("9th Avenue","Seattle","USA","WA",98052);
  private static PersonalDetails PERSONALDETAILS = new PersonalDetails("12345","678910","abc@gmail.com","www.java.com");



  @BeforeEach
  void setUp() {
    this.customer = new Customer("Jane","Mary","ABC Company",ADDRESS,PERSONALDETAILS);
  }


  @Test
  void getFirst_name() {
    Assertions.assertEquals("Jane", this.customer.getFirst_name());
  }

  @Test
  void setFirst_name() {
    this.customer.setFirst_name("Mary");
    Assertions.assertEquals("Mary", this.customer.getFirst_name());
  }

  @Test
  void getLast_name() {
    Assertions.assertEquals("Mary", this.customer.getLast_name());
  }

  @Test
  void setLast_name() {
    this.customer.setLast_name("Jane");
    Assertions.assertEquals("Jane", this.customer.getLast_name());
  }

  @Test
  void getCompany_name() {
    Assertions.assertEquals("ABC Company", this.customer.getCompany_name());
  }

  @Test
  void setCompany_name() {
    this.customer.setCompany_name("XYZ Company");
    Assertions.assertEquals("XYZ Company", this.customer.getCompany_name());
  }

  @Test
  void getAddress() {
    Assertions.assertEquals(ADDRESS, this.customer.getAddress());
  }

  @Test
  void setAddress() {
    Address address = new Address("7th Avenue","Redmond","US","Washington",12345);
    this.customer.setAddress(address);
    Assertions.assertEquals(address, this.customer.getAddress());
  }

  @Test
  void getPersonal() {
    Assertions.assertEquals(PERSONALDETAILS, this.customer.getPersonal());
  }

  @Test
  void setPersonal() {
    PersonalDetails personal = new PersonalDetails("45678","9101112","xyz@gmail.com","www.java-classes.com");
    this.customer.setPersonal(personal);
    Assertions.assertEquals(personal, this.customer.getPersonal());
  }
}