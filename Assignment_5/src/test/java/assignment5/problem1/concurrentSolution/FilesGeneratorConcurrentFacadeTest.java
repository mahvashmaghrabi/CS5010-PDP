package assignment5.problem1.concurrentSolution;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FilesGeneratorConcurrentFacadeTest {

  FilesGeneratorConcurrentFacade facade;

  @BeforeEach
  void setUp() {
    this.facade = new FilesGeneratorConcurrentFacade();
  }

  @Test
  void generateFiles() {
    this.facade.generateFiles(new String[]{"out_SequentialSolution", "2"});
    this.facade.generateFiles(new String[]{".src/test/resources/test_empty", "2"});
  }
}