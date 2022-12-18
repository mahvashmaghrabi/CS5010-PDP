package Problem1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CheeseTest {
  private Cheese cheese;

  @BeforeEach
  void setUp() {

    this.cheese = new Cheese("Beechers","Cheese1",15.5,0, 12 );

  }

  @Test
  void getOunces() {
    Assertions.assertEquals(12, this.cheese.getOunces());
  }

  @Test
  void setOunces() {
    this.cheese.setOunces(10);
    Assertions.assertEquals(10, this.cheese.getOunces());
  }
}