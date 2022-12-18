package Problem1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SalmonTest {
  private Salmon sal;

  @BeforeEach
  void setUp() {
    this.sal=new Salmon("Beechers","Salmon",20.5,20,10);

  }

  @Test
  void getOunces() {
    Assertions.assertEquals(10, this.sal.getOunces());

  }

  @Test
  void setOunces() {
    this.sal.setOunces(15);
    Assertions.assertEquals(15, this.sal.getOunces());
  }
}