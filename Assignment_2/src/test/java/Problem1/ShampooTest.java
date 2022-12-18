package Problem1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ShampooTest {
  private Shampoo shamp;

  @BeforeEach
  void setUp() {
    this.shamp=new Shampoo("Beechers","Salmon",20.5,20,10);
  }

  @Test
  void getNoOfUnits() {
    Assertions.assertEquals(10, this.shamp.getNoOfUnits());

  }

  @Test
  void setNoOfUnits() {
    this.shamp.setNoOfUnits(15);
    Assertions.assertEquals(15, this.shamp.getNoOfUnits());
  }
}