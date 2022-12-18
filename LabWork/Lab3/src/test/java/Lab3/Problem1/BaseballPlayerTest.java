package Lab3.Problem1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BaseballPlayerTest {

  private BaseballPlayer mark;

  @BeforeEach
  void setUp() {
    this.mark = new BaseballPlayer((new Name("James", "Johnny", "Joe")), 5.4 , 70.5, "league", "teamPlayers", 20.5,30 );
  }

  @Test
  void getTeam() {
    Assertions.assertEquals("teamPlayers", this.mark.getTeam());
  }

  @Test
  void setTeam() {
  }

  @Test
  void getAverageBatting() {
    Assertions.assertEquals(20.5, this.mark.getAverageBatting());
  }

  @Test
  void setAverageBatting() {
  }

  @Test
  void getHomeRuns() {
    Assertions.assertEquals(30, this.mark.getHomeRuns());
  }

  @Test
  void setHomeRuns() {
  }
}