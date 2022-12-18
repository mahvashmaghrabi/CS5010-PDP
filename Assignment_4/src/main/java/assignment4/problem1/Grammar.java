package assignment4.problem1;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Random;

/**
 * Represents a Grammar class based on grammar json file definition
 */
public class Grammar {

  private final String title;
  private final String description;
  private final List<List<Node>> startList;
  private final Map<String, NonTerminalDefinition> nonTerminalDefinitionMap;
  private Random random;
  private String result;

  /**
   * Constructs a Grammar object using below params
   *
   * @param title                    title of the grammar provided
   * @param description              description of the grammar provided
   * @param startList                list of nodes for start tag
   * @param nonTerminalDefinitionMap map of node names and their definitions except title, start and
   *                                 desc tags
   * @param seed                     seed value for random
   */
  public Grammar(String title, String description, List<List<Node>> startList,
      Map<String, NonTerminalDefinition> nonTerminalDefinitionMap, int seed) {
    this.title = title;
    this.description = description;
    this.startList = startList;
    this.nonTerminalDefinitionMap = nonTerminalDefinitionMap;
    setRandom(seed);
    this.result = "";
  }

  /**
   * Sets seed for random object
   *
   * @param seed seed in int
   */
  public void setRandom(int seed) {
    if (seed == -1) {
      this.random = new Random();
    } else {
      this.random = new Random(seed);
    }
  }

  /**
   * Generates string calling respective generate node method
   */
  public void generateString() {
    StringBuilder sb = new StringBuilder();
    var startStr = this.startList.get(this.random.nextInt(this.startList.size()));
    for (Node node : startStr) {
      node.generateString(sb, this);
    }
    this.result = sb.toString();//.replaceAll("\\s+(\\p{Punct})", "$1").trim();
  }

  /**
   * Returns definition of the non-terminal node using name as key
   *
   * @param name name of node
   * @return map
   */
  public NonTerminalDefinition getDefinition(String name) {
    try {
      if (!this.nonTerminalDefinitionMap.containsKey(name)) {
        throw new RuntimeException("Error occurred : " + name + " rule is used but not defined");
      }
    } catch (Exception ex) {
      System.out.println(ex.getMessage());
      return null;
    }
    return this.nonTerminalDefinitionMap.get(name);
  }

  /**
   * Returns Title of the provided grammar.
   *
   * @return title in String
   */
  public String getTitle() {
    return this.title;
  }

  /**
   * Returns Description of the provided grammar.
   *
   * @return description in String
   */
  public String getDescription() {
    return this.description;
  }

  /**
   * Returns start tag list
   *
   * @return start list
   */
  public List<List<Node>> getStartList() {
    return this.startList;
  }

  /**
   * Returns definition of all non-terminal nodes
   *
   * @return map of node name and its definition
   */
  public Map<String, NonTerminalDefinition> getNonTerminalDefinitionMap() {
    return this.nonTerminalDefinitionMap;
  }

  /**
   * Prints random sentence generated
   *
   * @return sentence in String
   */
  public String printRandomSentence() {
    return this.result;//.replaceAll("\\s+(\\p{Punct})", "$1").trim();
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
    if (!(o instanceof Grammar grammar)) {
      return false;
    }
    return title.equals(grammar.title)
        && description.equals(grammar.description)
        && startList.equals(grammar.startList)
        && nonTerminalDefinitionMap.equals(grammar.nonTerminalDefinitionMap)
        && random.equals(grammar.random);
  }

  /**
   * Generates hashcode of class object
   *
   * @return integer
   */
  @Override
  public int hashCode() {
    return Objects.hash(title, description, startList, nonTerminalDefinitionMap, random);
  }

  /**
   * String representation of the class
   *
   * @return String
   */
  @Override
  public String toString() {
    return "Grammar{" +
        "title='" + title + '\'' +
        ", description='" + description + '\'' +
        ", startList=" + startList +
        ", nonTerminalDefinitionMap=" + nonTerminalDefinitionMap +
        ", random=" + random +
        '}';
  }
}
