package assignment6.problem1.Messages;

import assignment6.problem1.Server.MessageHandler;

/**
 * Represents a QueryResponse class
 */
public class QueryUsersMessage extends Message {

  /**
   * Constructs a QueryResponse object using below params
   *
   * @param userName username
   */
  public QueryUsersMessage(byte[] userName) {
    super(MessageIdentifier.QUERY_CONNECTED_USERS, userName);
  }

  @Override
  public void accept(MessageHandler messageHandler) {
    messageHandler.handleMessage(this);
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
}
