package Lab3.Problem1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RunnerTest {
  private Runner harry;

  @BeforeEach
  void setUp() {
    this.harry = new Runner((new Name("James", "Johnny", "Joe")), 5.4 , 70.5, "league", 20.5, 40.5, "Event" );

  }

  @Test
  void getBest5kTime() {
    Assertions.assertEquals(20.5, this.harry.getBest5kTime());
  }

  @Test
  void setBest5kTime() {
  }

  @Test
  void getBestHalfMarathonTime() {
    Assertions.assertEquals(40.5, this.harry.getBestHalfMarathonTime());
  }

  @Test
  void setBestHalfMarathonTime() {
  }

  @Test
  void getRunningEvent() {
    Assertions.assertEquals("Event", this.harry.getRunningEvent());

  }

  @Test
  void setRunningEvent() {
  }
}