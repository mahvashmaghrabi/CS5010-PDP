package assignment6.problem1.Client;

import java.util.HashMap;
import java.util.Map;

/**
 * Represents a Command Options
 */
public class ClientOptions {

  /**
   * Initializes logoff option
   */
  public static final String LOGOFF_OPTION = "logoff";
  /**
   * Initializes who option
   */
  public static final String WHO_OPTION = "who";
  /**
   * Initializes user option
   */
  public static final String USER_OPTION = "@user";
  /**
   * Initializes all option
   */
  public static final String ALL_OPTION = "@all";
  /**
   * Initializes insult to given user option
   */
  public static final String COMPLIMENT_OPTION = "!user";
  private static String helpCommand;
  Map<String, OptionDetails> commandOptions = new HashMap<>();


  /**
   * Returns help command
   *
   * @return as String
   */
  public static String getHelpCommand() {
    return helpCommand;
  }

  /**
   * Generates all expected command options
   *
   * @return Options object
   */
  public Map<String, OptionDetails> generateOptions() {
    try {
      this.commandOptions.put(LOGOFF_OPTION, new OptionDetails(false, "Logs off user"));
      this.commandOptions.put(WHO_OPTION, new OptionDetails(false,
          "Sends user identification such as username"));
      this.commandOptions.put(USER_OPTION,
          new OptionDetails(true, "Sends message to specified user"));
      this.commandOptions.put(ALL_OPTION,
          new OptionDetails(true, "Send users messages to all users"));
      this.commandOptions.put(COMPLIMENT_OPTION, new OptionDetails(false,
          "Sends a compliment message for a specified user to all connected users."));
      setOptionsList();
    } catch (Exception ex) {
      System.out.println(ex.getMessage());
    }
    return commandOptions;
  }

  private void setOptionsList() {
    StringBuilder sb = new StringBuilder();
    sb.append("Command  |  Arguments needed  |  Command Description.\n");
    for (String option : this.commandOptions.keySet()) {
      sb.append(option).append("  |  ")
          .append(commandOptions.get(option).isHasArgs()).append("  |  ")
          .append(commandOptions.get(option).getDescription()).append("\n");
    }
    helpCommand = sb.toString();
  }

  /**
   * Gets command options list
   *
   * @return map
   */
  public Map<String, OptionDetails> getCommandOptions() {
    return commandOptions;
  }

  /**
   * Returns a hash code value for the object.
   *
   * @return a hash code value for this object.
   */
  @Override
  public int hashCode() {
    return super.hashCode();
  }

  /**
   * Indicates whether some other object is "equal to" this one.
   *
   * @param obj the reference object with which to compare.
   */
  @Override
  public boolean equals(Object obj) {
    return super.equals(obj);
  }

  /**
   * Returns a string representation of the object.
   */
  @Override
  public String toString() {
    return super.toString();
  }

  /**
   * Represents Command options details
   */
  protected class OptionDetails {

    boolean hasArgs;
    String description;

    /**
     * Constructs Command option details
     *
     * @param hasArgs     boolean
     * @param description strin
     */
    OptionDetails(boolean hasArgs, String description) {
      this.hasArgs = hasArgs;
      this.description = description;
    }

    /**
     * Returns Description of command
     *
     * @return string
     */
    public String getDescription() {
      return this.description;
    }

    /**
     * Returns boolean
     *
     * @return boolean
     */
    public boolean isHasArgs() {
      return this.hasArgs;
    }
  }
}
