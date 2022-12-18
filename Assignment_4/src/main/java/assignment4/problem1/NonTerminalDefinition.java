package assignment4.problem1;

import java.util.List;
import java.util.Objects;
import java.util.Random;

/**
 * Represents a Non-terminal node definition
 */
public class NonTerminalDefinition {

  private final List<List<Node>> rules;
  private final String name;
  private Random random;

  /**
   * Constructs a Non-terminal node definition using below params
   *
   * @param rules List of node list rules
   * @param name  node name
   */
  public NonTerminalDefinition(List<List<Node>> rules, String name) {
    this.rules = rules;
    this.name = name;
    this.random = new Random();
  }

  /**
   * Returns name of the rule
   *
   * @return rule name
   */
  public String getName() {
    return this.name;
  }

  /**
   * Returns random rule of a non-terminal node
   *
   * @return List of node
   */
  public List<Node> getRule() {
    return this.rules.get(random.nextInt(rules.size()));
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
    if (!(o instanceof NonTerminalDefinition that)) {
      return false;
    }
    return rules.equals(that.rules)
        && name.equals(that.name)
        && random.equals(that.random);
  }

  /**
   * Generates hashcode of class object
   *
   * @return integer
   */
  @Override
  public int hashCode() {
    return Objects.hash(rules, name, random);
  }

  /**
   * String representation of the class
   *
   * @return String
   */
  @Override
  public String toString() {
    return "NonTerminalDefinition{" +
        "rules=" + rules +
        ", name='" + name + '\'' +
        ", random=" + random +
        '}';
  }
}
