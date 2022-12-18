package assignment5.problem1.concurrentSolution;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class EntryPointTest {

  @BeforeEach
  void setUp() {
  }

  @Test
  void main() {
    EntryPoint.main(new String[]{"csvFiles", "2"});
  }
}