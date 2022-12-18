package assignment5.problem1.concurrentSolution;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;
import java.nio.file.Paths;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CommandLineParserTest {

  final String courseFileName = "courses.csv";
  final String studentFileName = "studentVle_small.csv";
  File file;

  @BeforeEach
  void setUp() {
    String folderPath = Paths.get("out_SequentialSolution").toAbsolutePath().toString();
    this.file = new File(folderPath);
  }

  @Test
  void parseCommand_Positive() {
    var result = CommandLineParser.parseCommand(new String[]{"out_SequentialSolution", "2"});
    assertTrue(result.contains(this.file.getAbsolutePath()));
  }

  @Test
  void parseCommand_Negative() {
    Throwable exp_empty = Assertions.assertThrows(Exception.class,
        () -> CommandLineParser.parseCommand(new String[]{"./src/test/resources/test_empty", "2"}));
    assertEquals("The given directory name does not have any file. Please start over",
        exp_empty.getMessage());

    Throwable exp_nfe = Assertions.assertThrows(Exception.class,
        () -> CommandLineParser.parseCommand(
            new String[]{"./src/test/resources/test_Files", "hello"}));
    assertEquals("Threshold Value should be a number", exp_nfe.getMessage());

    Throwable exp_null = Assertions.assertThrows(NullPointerException.class,
        () -> CommandLineParser.parseCommand(new String[]{null}));

    //System.out.println(exp_null);

    Throwable exp_args_null = Assertions.assertThrows(Exception.class,
        () -> CommandLineParser.parseCommand(null));
    Assertions.assertEquals("Arguments can not be null",
        exp_args_null.getMessage());

    Throwable exp_emptyArgs = Assertions.assertThrows(Exception.class,
        () -> CommandLineParser.parseCommand(new String[]{}));
    Assertions.assertEquals("Arguments can not be null", exp_emptyArgs.getMessage());

    Throwable exp_wrongFile = Assertions.assertThrows(Exception.class,
        () -> CommandLineParser.parseCommand(new String[]{"gradlew.bat"}));
    Assertions.assertEquals("Please enter valid directory name.",
        exp_wrongFile.getMessage());
  }

  @Test
  void testEquals() {
    CommandLineParser source = new CommandLineParser();
    CommandLineParser notEqual = source;
    Assertions.assertTrue(source.equals(notEqual));
    CommandLineParser diffEqual = new CommandLineParser();
    Assertions.assertFalse(source.equals(diffEqual));
    Assertions.assertTrue(source.equals(source));
    Assertions.assertFalse(source.equals(null));
  }

  @Test
  void testHashCode() {
    CommandLineParser source = new CommandLineParser();
    Assertions.assertTrue(source.hashCode() != new CommandLineParser().hashCode());
    Assertions.assertTrue(source.hashCode() == source.hashCode());
  }

  @Test
  void testToString() {
    CommandLineParser source = new CommandLineParser();
    Assertions.assertTrue(!source.toString().isEmpty());
    Assertions.assertTrue(source.toString().contains("CommandLineParser{"));
  }
}