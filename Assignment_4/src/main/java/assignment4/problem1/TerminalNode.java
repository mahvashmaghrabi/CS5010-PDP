package assignment4.problem1;

/**
 * Represents a Terminal node
 */
public class TerminalNode implements Node {

  private final String text;

  /**
   * Constructs a Terminal node
   *
   * @param text text of terminal node
   */
  public TerminalNode(String text) {
    this.text = text;
  }

  /**
   * Appends a text
   *
   * @param sb      StringBuilder
   * @param grammar Grammar
   */
  @Override
  public void generateString(StringBuilder sb, Grammar grammar) {
    sb.append(text);
//    if (sb.charAt(sb.length() - 2) == ' ') {
//      sb.replace(sb.length() - 2, sb.length()-1, "");
//    }
  }

  /**
   * Returns a text of terminal node
   *
   * @return text in String
   */
  public String getText() {
    return this.text;
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
    return "TerminalNode{" +
        "text='" + text + '\'' +
        '}';
  }

  /**
   * Checks equality of same type of different objects
   *
   * @param obj current class object
   * @return true if matches, else false
   */
  @Override
  public boolean equals(Object obj) {
    return super.equals(obj);
  }
}
