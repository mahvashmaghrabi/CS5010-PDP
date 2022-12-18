package assignment6.problem1.Client;

import static assignment6.problem1.Client.ClientOptions.WHO_OPTION;
import static org.junit.jupiter.api.Assertions.assertTrue;

import assignment6.problem1.Client.ClientOptions.OptionDetails;
import java.util.Map;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ClientOptionsTest {

  @BeforeEach
  void setUp() {
  }

  @Test
  void generateOptions() {
    Map<String, OptionDetails> options = new ClientOptions().generateOptions();
    assertTrue(options.containsKey(WHO_OPTION));
  }

  @Test
  void getHelpCommand() {
    Assertions.assertNotNull(ClientOptions.getHelpCommand());
  }

  @Test
  void getCommandOptions() {
    Assertions.assertNotNull(new ClientOptions().getCommandOptions());
  }
}