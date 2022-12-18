package assignment6.problem1.Messages;

import assignment6.problem1.Server.MessageHandler;
import java.io.DataOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

/**
 * Represents a DisconnectMessage class
 */
public class ComplimentMessage extends Message {

  private byte[] recipient;
  //private byte[] messageContent;

  /**
   * Constructs a DisconnectMessage object using below params
   *
   * @param sender    sender Details
   * @param recipient recipient Details
   */
  public ComplimentMessage(byte[] sender, byte[] recipient) {//}, byte[] messageContent) {
    super(MessageIdentifier.SEND_COMPLIMENT, sender);
    this.recipient = recipient;
    // this.messageContent = messageContent;
  }

  /**
   * Gets sender details
   *
   * @return as object
   */
  public byte[] getSender() {
    return this.getUserName();
  }

  /**
   * Gets Recipient
   *
   * @return as object
   */
  public byte[] getRecipient() {
    return this.recipient;
  }

  /**
   * Gets Recipient
   *
   * @return as string
   */
  public String getRecipientAsString() {
    return new String(this.recipient, StandardCharsets.UTF_8);
  }

  /**
   * Returns Message content as string
   * @return message
   */
//  public String getMessageContentAsString() {
//    return new String(messageContent,StandardCharsets.UTF_8);
//  }

  /**
   * Sets message content
   * @param messageContent as byte array
   */
//  public void setMessageContent(byte[] messageContent) {
//    this.messageContent = messageContent;
//  }

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
    if (!(o instanceof ComplimentMessage)) {
      return false;
    }
    if (!super.equals(o)) {
      return false;
    }
    ComplimentMessage that = (ComplimentMessage) o;
    return Arrays.equals(getRecipient(), that.getRecipient());
  }

  /**
   * Generates hashcode of class object
   *
   * @return integer
   */
  @Override
  public int hashCode() {
    int result = super.hashCode();
    result = 31 * result + Arrays.hashCode(getRecipient());
    return result;
  }

  /**
   * String representation of the class
   *
   * @return String
   */
  @Override
  public String toString() {
    return "ComplimentMessage{" +
        "recipient=" + Arrays.toString(recipient) +
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
    outputStream.writeInt(recipient.length);
    outputStream.writeChar(' ');
    outputStream.write(recipient);

//    outputStream.writeChar(' ');
//
//    outputStream.writeInt(messageContent.length);
//    outputStream.writeChar(' ');
//    outputStream.write(messageContent);

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
