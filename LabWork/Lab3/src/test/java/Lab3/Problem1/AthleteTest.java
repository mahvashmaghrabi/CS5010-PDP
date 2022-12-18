package Lab3.Problem1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.junit.jupiter.api.Assertions.*;
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class AthleteTest {
  private Athlete james;

  @BeforeAll
  void setUp() {
    this.james = new Athlete(new Name("James", "Johnny", "Joe"), 5.4 , 70.5, "league");
  }

  @Test
  void getAthletesName() {
    Assertions.assertEquals(Name.class, this.james.getAthletesName().getClass());
    Assertions.assertEquals("James", this.james.getAthletesName().getFirstName());
    Assertions.assertEquals("Johnny", this.james.getAthletesName().getMiddleName());
    Assertions.assertEquals("Joe", this.james.getAthletesName().getLastName());

  }

  @Test
  void getHeight() {
    Assertions.assertEquals(5.4, this.james.getHeight());

  }

  @Test
  void getWeight() {
    Assertions.assertEquals(70.5, this.james.getWeight());

  }

  @Test
  void getLeague() {
    Assertions.assertEquals("league", this.james.getLeague());

  }

}