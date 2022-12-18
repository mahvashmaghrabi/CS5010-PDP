package assignment6.problem1.Messages;

import java.io.DataOutputStream;
import java.io.IOException;

/**
 * Represents a Response class
 */
public abstract class Response extends Message {


  private boolean isSuccess;
  private int msgSize;
  private byte[] msg;

  /**
   * Constructs a Response object using below params
   *
   * @param msgIdentifier msgIdentifier
   * @param isSuccess     isSuccess
   * @param msg           msg
   */
  public Response(MessageIdentifier msgIdentifier, boolean isSuccess, byte[] msg) {
    super(msgIdentifier, new byte[0]);
    this.isSuccess = isSuccess;
    this.msgSize = msg.length;
    this.msg = msg;
  }

  /**
   * Gets message size
   *
   * @return as int
   */
  public int getMsgSize() {
    return this.msgSize;
  }

  /**
   * gets is success
   *
   * @return as boolean
   */
  public boolean isSuccess() {
    return this.isSuccess;
  }


  /**
   * Gets message
   *
   * @return message as byte array
   */
  public byte[] getMessage() {
    return this.msg;
  }

  public void serialize(DataOutputStream outputStream) throws IOException {
    super.serialize(outputStream);
    outputStream.writeChar(' ');
    outputStream.writeBoolean(isSuccess);
    outputStream.writeChar(' ');
    outputStream.writeInt(getMsgSize());
    outputStream.writeChar(' ');
    outputStream.write(getMessage());
  }

}
