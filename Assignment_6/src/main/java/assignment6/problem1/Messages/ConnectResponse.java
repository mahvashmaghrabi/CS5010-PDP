package assignment6.problem1.Messages;

import assignment6.problem1.Server.MessageHandler;

/**
 * Represents a ConnectResponse class
 */
public class ConnectResponse extends Response {

  /**
   * Constructs a ConnectResponse object using below params
   *
   * @param isSuccess if success
   * @param msg       message as byte array
   */
  public ConnectResponse(boolean isSuccess, byte[] msg) {
    super(MessageIdentifier.DISCONNECT_RESPONSE, isSuccess, msg);
  }

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
    return "ConnectResponse{} " + super.toString();
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
