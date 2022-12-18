package Problem1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PaperTowelsTest {
  private PaperTowels towel;

  @BeforeEach
  void setUp() {
    this.towel=new PaperTowels("Beechers","PaperTowels",20.5,21, 5);
  }

  @Test
  void getNoOfUnits() {
    Assertions.assertEquals(5, this.towel.getNoOfUnits());
  }

  @Test
  void setNoOfUnits() {
    this.towel.setNoOfUnits(10);
    Assertions.assertEquals(10, this.towel.getNoOfUnits());
  }
}