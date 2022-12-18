package assignment6.problem1.Client;

import assignment6.problem1.Client.ClientOptions.OptionDetails;
import assignment6.problem1.Messages.BroadcastMessage;
import assignment6.problem1.Messages.ComplimentMessage;
import assignment6.problem1.Messages.DirectMessage;
import assignment6.problem1.Messages.DisconnectMessage;
import assignment6.problem1.Messages.Message;
import assignment6.problem1.Messages.QueryUsersMessage;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Map;

/**
 * Represents a UserInputHandler
 */
public class UserInputHandler extends Thread {

  private final byte[] username;
  private final DataOutputStream outputStream;
  private final Map<String, OptionDetails> options;

  /**
   * Constructs a UserInputHandler using below details
   *
   * @param outputStream outputStream
   * @param username     username
   */
  public UserInputHandler(DataOutputStream outputStream, byte[] username) {
    this.outputStream = outputStream;
    this.username = username;
    this.options = new ClientOptions().generateOptions();
  }

  /**
   * Continuously reads input from keyboard
   */
  @Override
  public void run() {

    try {
      BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
      while (!isInterrupted()) {
        try {
          String userInput = in.readLine();
          if (userInput != null && !userInput.trim().isBlank()) {
            if (userInput.equals("?")) {
              System.out.println(ClientOptions.getHelpCommand());
            } else {
              var message = parseUserInput(userInput);
              if (message == null) {
                System.out.println("Wrong command is entered. Here is help command for your help.\n"
                    + ClientOptions.getHelpCommand());
              } else {
                message.serialize(outputStream);
              }
            }
          }
        } catch (IOException e) {
          System.out.println(e.getMessage());
        }
      }

    } catch (Exception e) {
      System.out.println("Error occurred while reading input from users.");
      System.out.println(e.getMessage());
    }
  }

  /**
   * Parses passed input into Message
   *
   * @param userInput input by user
   * @return message object
   */
  Message parseUserInput(String userInput) {
    String[] parts = userInput.split(" ");
    byte[] message = new byte[0];

    if (parts.length > 1) {
      message = userInput.substring(userInput.indexOf(' ')).getBytes(StandardCharsets.UTF_8);
    }

    switch (parts[0]) {
      case "logoff": {
        if (validateMessageWithNoArgs(parts)) {
          return null;
        }
        return new DisconnectMessage(username);
      }
      case "who": {
        if (validateMessageWithNoArgs(parts)) {
          return null;
        }
        return new QueryUsersMessage(username);
      }
      case "@all": {
        if (validateMessageWithArgs(parts)) {
          return null;
        }
        return new BroadcastMessage(username,
            message);

      }
      default: {
        if (parts[0].startsWith("@")) {
          if (parts.length == 1) {
            return null;
          }
          return new DirectMessage(username, parts[0].substring(1).getBytes(StandardCharsets.UTF_8),
              message);
        }
        if (parts[0].startsWith("!")) {
          if (parts.length > 1) {
            return null;
          }
          return new ComplimentMessage(username,
              parts[0].substring(1).getBytes(StandardCharsets.UTF_8));
        }
      }
    }
    return null;
  }

  private boolean validateMessageWithArgs(String[] parts) {
    //expecting arguments but not passed from keyboard
    if (this.options.containsKey(parts[0])
        && this.options.get(parts[0]).isHasArgs()
        && parts.length == 1) {
      return true;
    }
    return false;
  }

  private boolean validateMessageWithNoArgs(String[] parts) {
//Not expecting arguments but passed from keyboard
    if (this.options.containsKey(parts[0])
        && !this.options.get(parts[0]).isHasArgs()
        && parts.length > 1) {
      return true;
    }
    return false;
  }

  /**
   * Returns a string representation of this thread, including the thread's name, priority, and
   * thread group.
   *
   * @return a string representation of this thread.
   */
  @Override
  public String toString() {
    return super.toString();
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
}
