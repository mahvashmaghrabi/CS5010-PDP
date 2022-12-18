package assignment5.problem1.sequentialSolution;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class EntryPointTest {

  String[] args;

  @BeforeEach
  void setUp() {
    this.args = new String[1];
    this.args[0] = "test_Files";
  }

  @Test
  void main() {
    EntryPoint.main(this.args);
    EntryPoint.main(new String[]{"test_empty"});
    EntryPoint.main(null);
//    Throwable exp_empty = Assertions.assertThrows(Exception.class,
//        () -> EntryPoint.main(new String[]{"test_empty"}));
//    Assertions.assertEquals("The given directory name does not have any file. Please start over",
//        exp_empty.getMessage());
//    Throwable exp1 = Assertions.assertThrows(Exception.class, () ->
//        EntryPoint.main(null));
//    Assertions.assertEquals("Arguments can not be null", exp1.getMessage());
  }
}