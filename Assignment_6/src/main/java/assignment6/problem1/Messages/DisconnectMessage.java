package assignment6.problem1.Messages;

import assignment6.problem1.Server.MessageHandler;

/**
 * Represents a DisconnectMessage class
 */
public class DisconnectMessage extends Message {

  /**
   * Constructs a DisconnectMessage object using below params
   *
   * @param userName username as byte array
   */
  public DisconnectMessage(byte[] userName) {
    super(MessageIdentifier.DISCONNECT_MESSAGE, userName);
  }

  /**
   * Handles operations based on message type
   *
   * @param messageHandler MessageHandler
   */
  @Override
  public void accept(MessageHandler messageHandler) {
    messageHandler.handleMessage(this);
  }

  /**
   * String representation of the class
   *
   * @return String
   */
  @Override
  public String toString() {
    return "DisconnectMessage{} " + super.toString();
  }

  /**
   * Checks equality of same type of different objects
   *
   * @param o current class object
   * @return true if matches, else false
   */
  @Override
  public boolean equals(Object o) {
    return super.equals(o);
  }

  /**
   * Generates hashcode of class object
   *
   * @return integer
   */
  @Override
  public int hashCode() {
    return super.hashCode();
  }
}
