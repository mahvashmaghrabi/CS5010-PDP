package Assignment3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AddressTest {
  private Address address;

  @BeforeEach
  void setUp() {
    this.address = new Address("9th Avenue","Seattle","USA","Washington",98052);
  }

  @Test
  void getAddress() {
    Assertions.assertEquals("9th Avenue", this.address.getAddress());
  }

  @Test
  void setAddress() {
    this.address.setAddress("Leary Way");
    Assertions.assertEquals("Leary Way", this.address.getAddress());

  }

  @Test
  void getCity() {
    Assertions.assertEquals("Seattle", this.address.getCity());

  }

  @Test
  void setCity() {
    this.address.setCity("Redmond");
    Assertions.assertEquals("Redmond", this.address.getCity());

  }

  @Test
  void getCountry() {
    Assertions.assertEquals("USA", this.address.getCounty());
  }

  @Test
  void setCountry() {
    this.address.setCounty("US");
    Assertions.assertEquals("US", this.address.getCounty());
  }

  @Test
  void getState() {
    Assertions.assertEquals("Washington", this.address.getState());
  }

  @Test
  void setState() {
    this.address.setState("WA");
    Assertions.assertEquals("WA", this.address.getState());
  }

  @Test
  void getZip() {
    Assertions.assertEquals(98052, this.address.getZip());
  }

  @Test
  void setZip() {
    this.address.setZip(12345);
    Assertions.assertEquals(12345, this.address.getZip());
  }
}