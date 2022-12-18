package assignment6.problem1.Messages;

/**
 * Represents a enum list for different message types
 */
public enum MessageIdentifier {
  /**
   * CONNECT_MESSAGE
   */
  CONNECT_MESSAGE(19),
  /**
   * CONNECT_RESPONSE
   */
  CONNECT_RESPONSE(20),
  /**
   * DISCONNECT_MESSAGE
   */
  DISCONNECT_MESSAGE(21),
  /**
   * QUERY_CONNECTED_USERS
   */
  QUERY_CONNECTED_USERS(22),
  /**
   * QUERY_USER_RESPONSE
   */
  QUERY_USER_RESPONSE(23),
  /**
   * BROADCAST_MESSAGE
   */
  BROADCAST_MESSAGE(24),
  /**
   * DIRECT_MESSAGE
   */
  DIRECT_MESSAGE(25),
  /**
   * FAILED_MESSAGE
   */
  FAILED_MESSAGE(26),
  /**
   * SEND_COMPLIMENT
   */
  SEND_COMPLIMENT(27),
  /**
   * DISCONNECT_RESPONSE
   */
  DISCONNECT_RESPONSE(28);

  private final int msgId;

  MessageIdentifier(int value) {
    this.msgId = value;
  }

  /**
   * Returns message identifier
   *
   * @return integer
   */
  public int getMsgId() {
    return msgId;
  }


}