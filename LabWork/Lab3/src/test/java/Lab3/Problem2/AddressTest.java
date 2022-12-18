package Lab3.Problem2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AddressTest {
  private Address place;

  @BeforeEach
  void setUp() {
    this.place = new Address("9th Avenue","Seattle","98052","WA","USA" );
  }

  @Test
  void getStreetAndNumber() {
    Assertions.assertEquals("9th Avenue", this.place.getStreetAndNumber());
  }

  @Test
  void setStreetAndNumber() {
  }

  @Test
  void getCity() {
    Assertions.assertEquals("Seattle", this.place.getCity());
  }

  @Test
  void setCity() {
  }

  @Test
  void getZIPCode() {
    Assertions.assertEquals("98052", this.place.getZIPCode());

  }

  @Test
  void setZIPCode() {
  }

  @Test
  void getState() {
    Assertions.assertEquals("WA", this.place.getState());
  }

  @Test
  void setState() {
  }

  @Test
  void getCountry() {
  }

  @Test
  void setCountry() {
    Assertions.assertEquals("USA", this.place.getCountry());
  }
}