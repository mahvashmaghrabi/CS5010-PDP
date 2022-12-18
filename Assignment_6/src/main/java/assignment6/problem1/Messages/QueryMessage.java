package assignment6.problem1.Messages;

/**
 * Represents a QueryMessage class
 */
public class QueryMessage extends Message {

  /**
   * Constructs a QueryMessage object using below params
   *
   * @param userName username
   */
  public QueryMessage(byte[] userName) {
    super(MessageIdentifier.QUERY_USER_RESPONSE, userName);
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
