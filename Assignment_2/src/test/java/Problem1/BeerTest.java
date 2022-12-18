package Problem1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BeerTest {
  private Beer beer;

  @BeforeEach
  void setUp() {
    this.beer = new Beer("Beechers","Beer1",20.5,21, 12);
  }

  @Test
  void getOunces() {
    Assertions.assertEquals(12, this.beer.getOunces());
  }

  @Test
  void setOunces() {
    this.beer.setOunces(10);
    Assertions.assertEquals(10, this.beer.getOunces());

  }
}