package assignment6.problem1.Messages;

import assignment6.problem1.Server.MessageHandler;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Arrays;

/**
 * Represents a DisconnectMessage class
 */
public class FailedMessage extends Message {

  private final byte[] messageContent;

  /**
   * Constructs a DisconnectMessage object using below params
   *
   * @param messageContent message content
   * @param username       username
   */
  public FailedMessage(byte[] username, byte[] messageContent) {
    super(MessageIdentifier.FAILED_MESSAGE, username);
    this.messageContent = messageContent;
  }

  /**
   * Gets message details
   *
   * @return as object
   */
  public byte[] getMessageContent() {
    return this.messageContent;
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
    if (!(o instanceof FailedMessage)) {
      return false;
    }
    FailedMessage that = (FailedMessage) o;
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
    return "FailedMessage{" +
        "messageContent=" + Arrays.toString(messageContent) +
        "} " + super.toString();
  }

  /**
   * Serializes message into data frame
   *
   * @param outputStream DataOutputStream
   * @throws IOException throws error in case it fails
   */
  @Override
  public void serialize(DataOutputStream outputStream) throws IOException {
    super.serialize(outputStream);

    outputStream.writeChar(' ');

    outputStream.writeInt(messageContent.length);
    outputStream.writeChar(' ');
    outputStream.write(messageContent);
  }

  /**
   * Accepts message handler that can handle this message
   *
   * @param messageHandler MessageHandler
   */
  @Override
  public void accept(MessageHandler messageHandler) {
    messageHandler.handleMessage(this);
  }

}
