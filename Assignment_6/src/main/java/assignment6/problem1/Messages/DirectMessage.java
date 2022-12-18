package assignment6.problem1.Messages;

import assignment6.problem1.Server.MessageHandler;
import java.io.DataOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

/**
 * Represents a DirectMessage class
 */
public class DirectMessage extends Message {

  private final byte[] recipient;
  private byte[] messageContent;

  /**
   * Constructs a Direct message
   *
   * @param username       username
   * @param recipient      recipient
   * @param messageContent messageContent
   */
  public DirectMessage(byte[] username, byte[] recipient, byte[] messageContent) {
    super(MessageIdentifier.DIRECT_MESSAGE, username);
    this.recipient = recipient;
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
    if (!(o instanceof DirectMessage that)) {
      return false;
    }
    if (!super.equals(o)) {
      return false;
    }
    return Arrays.equals(recipient, that.recipient)
        && Arrays.equals(getMessageContent(), that.getMessageContent());
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
   * Returns recipient as string
   *
   * @return String
   */
  public String getRecipientAsString() {
    return new String(recipient, StandardCharsets.UTF_8);
  }

  /**
   * String representation of the class
   *
   * @return String
   */
  @Override
  public String toString() {
    return "DirectMessage{" +
        "messageContent=" + Arrays.toString(messageContent) +
        "} " + super.toString();
  }

  /**
   * Serializes message into given format
   *
   * @param outputStream DataOutputStream
   * @throws IOException throws error in case it fails
   */
  @Override
  public void serialize(DataOutputStream outputStream) throws IOException {
    super.serialize(outputStream);

    outputStream.writeChar(' ');
    outputStream.writeInt(recipient.length);
    outputStream.writeChar(' ');
    outputStream.write(recipient);

    outputStream.writeChar(' ');

    outputStream.writeInt(messageContent.length);
    outputStream.writeChar(' ');
    outputStream.write(messageContent);
  }

  @Override
  public void accept(MessageHandler messageHandler) {
    messageHandler.handleMessage(this);
  }
}