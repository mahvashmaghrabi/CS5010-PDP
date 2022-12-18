package assignment6.problem1.Messages;

import assignment6.problem1.Server.MessageHandler;
import java.io.DataOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;

/**
 * Represents a QueryResponse class
 */
public class QueryResponse extends Message {

  private final List<byte[]> userDetails;

  /**
   * Constructs a QueryResponse object using below params
   *
   * @param userDetails userDetails
   */
  public QueryResponse(List<byte[]> userDetails) {
    super(MessageIdentifier.QUERY_USER_RESPONSE, new byte[0]);
    this.userDetails = userDetails;
  }

  /**
   * Returns list of user details
   *
   * @return list of byte array
   */
  public List<byte[]> getUserDetails() {
    return userDetails;
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

    outputStream.writeInt(userDetails.size());

    for (byte[] user : userDetails) {
      System.out.println("Connected user = " + (new String(user, StandardCharsets.UTF_8)));
      outputStream.writeChar(' ');
      outputStream.writeInt(user.length);
      outputStream.writeChar(' ');
      outputStream.write(user);
    }
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

