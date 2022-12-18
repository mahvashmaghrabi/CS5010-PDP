package assignment5.problem1.sequentialSolution;

import java.nio.file.Path;
import java.nio.file.Paths;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CommandLineParserTest {

  CommandLineParser command = new CommandLineParser();

  @BeforeEach
  void setUp() {
  }

  @Test
  void parseCommand_Positive() {
    Path resourceDirectory = Paths.get("src/test/resources", "test_Files");
    String absolutePath = resourceDirectory.toFile().getAbsolutePath();
    var result = CommandLineParser.parseCommand(new String[]{absolutePath, "2"});
    Assertions.assertEquals(2, result.size());
  }

  @Test
  void parseCommand_Negative() {
    Throwable exp_empty = Assertions.assertThrows(Exception.class,
        () -> CommandLineParser.parseCommand(new String[]{".src/test/resources/test_empty", "2"}));
    Assertions.assertEquals(
        "Please enter valid directory name.",
        exp_empty.getMessage());

    Throwable exp_null = Assertions.assertThrows(NullPointerException.class,
        () -> CommandLineParser.parseCommand(new String[]{null}));

    // System.out.println(exp_null);

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
    CommandLineParser command = new CommandLineParser();
    CommandLineParser equalCommandLineParser = command;
    Assertions.assertTrue(command.equals(equalCommandLineParser));
    CommandLineParser diffEqualTitle = new CommandLineParser();
    Assertions.assertFalse(command.equals(diffEqualTitle));
    Assertions.assertTrue(command.equals(command));
    Assertions.assertFalse(command.equals(null));
  }

  @Test
  void testHashCode() {
    Assertions.assertTrue(command.hashCode() != new CommandLineParser().hashCode());
    Assertions.assertTrue(this.command.hashCode() == this.command.hashCode());
  }

  @Test
  void testToString() {
    Assertions.assertTrue(!this.command.toString().isEmpty());
    Assertions.assertTrue(this.command.toString().contains("CommandLineParser"));
  }
}