package assignment6.problem1.Messages;

import assignment6.problem1.Server.MessageHandler;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Arrays;

/**
 * Represents a BroadcastMessage class
 */
public class BroadcastMessage extends Message {

  private final byte[] messageContent;

  /**
   * Constructs a BroadCast message
   *
   * @param username       username
   * @param messageContent content of message
   */
  public BroadcastMessage(byte[] username, byte[] messageContent) {
    super(MessageIdentifier.BROADCAST_MESSAGE, username);
    this.messageContent = messageContent;
  }

  /**
   * Gets message details
   *
   * @return message details as string
   */
  public byte[] getMessageContent() {
    return this.messageContent;
  }

  @Override
  public void serialize(DataOutputStream outputStream) throws IOException {
    super.serialize(outputStream);
    outputStream.writeChar(' ');

    outputStream.writeInt(messageContent.length);
    outputStream.writeChar(' ');
    outputStream.write(messageContent);
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
    if (this == o) {
      return true;
    }
    if (!(o instanceof BroadcastMessage)) {
      return false;
    }
    if (!super.equals(o)) {
      return false;
    }
    BroadcastMessage that = (BroadcastMessage) o;
    return Arrays.equals(getMessageContent(), that.getMessageContent());
  }

  /**
   * Generates hashcode of class object
   *
   * @return integer
   */
  @Override
  public int hashCode() {
    int result = super.hashCode();
    result = 31 * result + Arrays.hashCode(getMessageContent());
    return result;
  }

  /**
   * String representation of the class
   *
   * @return String
   */
  @Override
  public String toString() {
    return "BroadcastMessage{" +
        "messageContent=" + Arrays.toString(messageContent) +
        "} " + super.toString();
  }
}