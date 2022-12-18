package assignment4.problem1;

import java.util.Objects;

/**
 * Represents a Punctuation node
 */
public class PunctuationNode implements Node {

  private final char punctuation;

  /**
   * Constructs a Punctuation node using below param
   *
   * @param punctuation punctuation
   */
  public PunctuationNode(char punctuation) {
    this.punctuation = punctuation;
  }

  /**
   * Generates string recursively
   *
   * @param sb      StringBuilder
   * @param grammar Grammar
   */
  @Override
  public void generateString(StringBuilder sb, Grammar grammar) {

    sb.append(punctuation);
    if (sb.charAt(sb.length() - 2) == ' ') {
      sb.replace(sb.length() - 2, sb.length() - 1, "");
    }
  }

  /**
   * Returns a punctuation as a character
   *
   * @return punctuation as a character
   */
  public char getPunctuation() {
    return this.punctuation;
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
    if (!(o instanceof PunctuationNode that)) {
      return false;
    }
    return punctuation == that.punctuation;
  }

  /**
   * Generates hashcode of class object
   *
   * @return integer
   */
  @Override
  public int hashCode() {
    return Objects.hash(punctuation);
  }

  /**
   * String representation of the class
   *
   * @return String
   */
  @Override
  public String toString() {
    return "PunctuationNode{" +
        "punctuation=" + punctuation +
        '}';
  }
}
