package assignment4.problem1;

import java.util.Objects;

/**
 * Represents a Non-terminal node
 */
public class NonTerminalNode implements Node {

  private final String name;

  /**
   * Constructs a Non-terminal node using below param
   *
   * @param name name of node
   */
  public NonTerminalNode(String name) {
    this.name = name;
  }

  /**
   * Generates string recursively
   *
   * @param sb      StringBuilder
   * @param grammar Grammar
   */
  @Override
  public void generateString(StringBuilder sb, Grammar grammar) {
    try {
      NonTerminalDefinition definition = grammar.getDefinition(name);
      if (definition == null) {
        return;
      }
      for (Node child : definition.getRule()) {
        child.generateString(sb, grammar);
      }
    } catch (Exception ex) {
      System.out.println("Error occurred : " + ex.getMessage());
      return;
    }
  }

  /**
   * Returns non-terminal node name
   *
   * @return non-terminal node name
   */
  public String getName() {
    return this.name;
  }

  /**
   * String representation of the class
   *
   * @return String
   */
  @Override
  public String toString() {
    return "NonTerminalNode{" +
        "name='" + name + '\'' +
        '}';
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
    if (!(o instanceof NonTerminalNode that)) {
      return false;
    }
    return name.equals(that.name);
  }

  /**
   * Generates hashcode of class object
   *
   * @return integer
   */
  @Override
  public int hashCode() {
    return Objects.hash(name);
  }
}
