package assignment6.problem1.Messages;

import assignment6.problem1.Server.MessageHandler;
import java.io.DataOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Objects;

/**
 * Represents a Message class
 */
public abstract class Message {

  private int userNameSize;
  private byte[] userName;
  private MessageIdentifier msgIdentifier;

  /**
   * Constructs a Message object using below params
   *
   * @param msgIdentifier int
   * @param userName      username
   */
  public Message(MessageIdentifier msgIdentifier, byte[] userName) {
    this.msgIdentifier = msgIdentifier;
    this.userNameSize = userName.length;
    this.userName = userName;
  }

  /**
   * Returns msg Identifier
   *
   * @return as enum value
   */
  public MessageIdentifier getMsgIdentifier() {
    return this.msgIdentifier;
  }

  /**
   * Gets username
   *
   * @return as byte array
   */
  public byte[] getUserName() {
    return this.userName;
  }

  /**
   * Sets username
   *
   * @param userName as string
   */
  public void setUserName(byte[] userName) {
    this.userName = userName;
  }

  /**
   * Gets username
   *
   * @return as string
   */
  public String getUserNameAsString() {
    return new String(userName, StandardCharsets.UTF_8);
  }

  /**
   * Gets username length
   *
   * @return as int
   */
  public int getUserNameSize() {
    return this.userNameSize;
  }

  /**
   * Sets username length
   *
   * @param userNameSize as int
   */
  public void setUserNameSize(int userNameSize) {
    this.userNameSize = userNameSize;
  }

  /**
   * Serializes message into given format
   *
   * @param outputStream DataOutputStream
   * @throws IOException throws error in case it fails
   */
  public void serialize(DataOutputStream outputStream) throws IOException {
    int messageID = getMsgIdentifier().getMsgId();
    outputStream.writeInt(messageID);

    if (getUserNameSize() > 0) {
      outputStream.writeChar(' ');
      outputStream.writeInt(getUserNameSize());
      outputStream.writeChar(' ');
      outputStream.write(getUserName());
    }

  }

  /**
   * Handles operations based on message type
   *
   * @param messageHandler MessageHandler
   */
  public void accept(MessageHandler messageHandler) {
    throw new UnsupportedOperationException();
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
    if (!(o instanceof Message message)) {
      return false;
    }
    return getUserNameSize() == message.getUserNameSize()
        && Arrays.equals(getUserName(),
        message.getUserName());
  }

  /**
   * Generates hashcode of class object
   *
   * @return integer
   */
  @Override
  public int hashCode() {
    int result = Objects.hash(getUserNameSize());
    result = 31 * result + Arrays.hashCode(getUserName());
    return result;
  }

  /**
   * String representation of the class
   *
   * @return String
   */
  @Override
  public String toString() {
    return "Message{" +
        "userNameSize=" + userNameSize +
        ", userName=" + this.getUserName() +
        "} " + super.toString();
  }
}
