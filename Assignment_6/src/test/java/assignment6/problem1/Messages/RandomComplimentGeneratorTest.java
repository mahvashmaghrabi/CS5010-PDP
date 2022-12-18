package assignment6.problem1.Messages;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RandomComplimentGeneratorTest {

  RandomComplimentGenerator generator;

  @BeforeEach
  void setUp() {
    this.generator = new RandomComplimentGenerator();
  }

  @Test
  void generateRandomCompliment() {
    Assertions.assertNotNull(this.generator.generateRandomCompliment());
  }
}