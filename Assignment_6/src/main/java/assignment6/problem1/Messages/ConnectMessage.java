package assignment6.problem1.Messages;

import assignment6.problem1.Server.MessageHandler;

/**
 * Represents a ConnectMessage class
 */
public class ConnectMessage extends Message {

  /**
   * Constructs a ConnectMessage object using below params
   *
   * @param userName username in byte array
   */
  public ConnectMessage(byte[] userName) {
    super(MessageIdentifier.CONNECT_MESSAGE, userName);
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

  /**
   * String representation of the class
   *
   * @return String
   */
  @Override
  public String toString() {
    return super.toString();
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
}
