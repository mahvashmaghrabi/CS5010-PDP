package assignment4.problem1;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Represents a Grammar deserializer class its default final values.
 */
public class GrammarDeserializer implements JsonDeserializer {

  private static final String START_GRAMMAR = "start";
  private static final String GRAMMAR_DESC = "grammarDesc";
  private static final String GRAMMAR_TITLE = "grammarTitle";
  private static final char NON_TERMINAL_NODE_BRACES_START = '<';
  private static final char NON_TERMINAL_NODE_BRACES_END = '>';
  private static final String PUNCTUATION_LIST = "!\"#$%&\\'()*+,-./:;=\\?@[\\]^_`{|}~";
  private static final int RANDOM_SEED = -1;

  /**
   * Parses given grammar from file according to provided Grammar class
   *
   * @param grammarJson File contents in String format
   * @return Grammar
   */
  public static Grammar parseGrammar(String grammarJson) {
    Gson gson = new GsonBuilder()
        .registerTypeAdapter(Grammar.class, new GrammarDeserializer())
        .create();

    return gson.fromJson(grammarJson, Grammar.class);
  }

  /**
   * Deserializes the grammar json into different nodes
   *
   * @param json    json data to deserialize,
   * @param typeOfT indicates type in which to deserialize
   * @param context indicates context used during custom deserializer
   * @return a Grammar class object
   * @throws JsonParseException throws exception in case invalid data found or improper custom class
   *                            found of type T
   */
  @Override
  public Object deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
      throws JsonParseException {
    JsonObject object = json.getAsJsonObject();

    JsonObject copy = object.deepCopy();
    String grammarDesc = null;
    try {
      if (!copy.has(GRAMMAR_TITLE)) {
        throw new RuntimeException(
            "Required " + GRAMMAR_TITLE + " tag is not provided in the grammar file");
      }
      copy.remove(GRAMMAR_TITLE);

      if (copy.has(GRAMMAR_DESC)) {
        grammarDesc = copy.get(GRAMMAR_DESC).getAsString();
        copy.remove(GRAMMAR_DESC);
      }
      if (!copy.has(START_GRAMMAR)) {
        throw new RuntimeException(
            "Required " + START_GRAMMAR + " tag is not provided in the grammar file");
      }
      copy.remove(START_GRAMMAR);
    } catch (Exception ex) {
      System.out.println("Error occurred : " + ex.getMessage());
      return null;
    }
    return new Grammar(object.get(GRAMMAR_TITLE).getAsString(), grammarDesc,
        deserializeStart(object), deserializeNonTerminalNode(copy), RANDOM_SEED);
  }

  /**
   * Converts json object into Non-terminal nodes
   *
   * @param copy Json Object
   * @return map of non-terminal node name and its definition
   */
  private Map<String, NonTerminalDefinition> deserializeNonTerminalNode(JsonObject copy) {

    Map<String, NonTerminalDefinition> definitionMap = new HashMap<>();
    //serializing non terminal nodes from json file data
    for (Map.Entry<String, JsonElement> entry : copy.entrySet()) {
      List<List<Node>> rules = new LinkedList<>();

      for (JsonElement rule : entry.getValue().getAsJsonArray()) {
        String strRule = rule.getAsString();
        List<Node> children = generateChildrenNodeList(strRule);
        rules.add(children);
      }
      definitionMap.put(entry.getKey(), new NonTerminalDefinition(rules, entry.getKey()));
    }
    return definitionMap;
  }

  /**
   * Searches for punctuation in given string to make it as a Punctuation Node
   *
   * @param target Target character to be searched
   * @return true if found, else false
   */
  private boolean searchPunctuation(char target) {
    return Arrays.stream(PUNCTUATION_LIST.split("")).toList().contains(String.valueOf(target));
  }

  /**
   * Main logic for identifying and converting into respective nodes
   *
   * @param strRule rules in String format
   * @return List of nodes
   */
  private List<Node> generateChildrenNodeList(String strRule) {
    int i = 0;
    List<Node> children = new LinkedList<>();
    while (i < strRule.length()) {
      //first, find NT node
      //then, find punctuation node
      //at last, assume its terminal node
      if (strRule.charAt(i) == NON_TERMINAL_NODE_BRACES_START) {
        int indexOfClosingBracket = strRule.indexOf(NON_TERMINAL_NODE_BRACES_END, i);
        String nonTerminalNodeValue = strRule.substring(i + 1, indexOfClosingBracket).trim();
        // check for empty braces
        if (!nonTerminalNodeValue.equals("")) {
          if (children.size() > 0) {
            children.add(new PunctuationNode(' '));
          }
          children.add(new NonTerminalNode(nonTerminalNodeValue));
        }
        i = indexOfClosingBracket + 1;
      } else if (strRule.charAt(i) == ' ') {
        i++;
      } else if (searchPunctuation(strRule.charAt(i))) {
        children.add(new PunctuationNode(strRule.charAt(i)));
        i++;
      } else {
        int indexOfNextNonTerminal = strRule.indexOf(NON_TERMINAL_NODE_BRACES_START, i);
        int indexOfNextWhiteSpace = strRule.indexOf(' ', i);
        int endIndex = -1;
        // check for immediate next whitespace or non-terminal node
        if (indexOfNextWhiteSpace > -1) {
          // if ws is found but no non-terminal node, then split the string at whitespace
          if (indexOfNextWhiteSpace < indexOfNextNonTerminal || indexOfNextNonTerminal == -1) {
            endIndex = indexOfNextWhiteSpace;
          }
        } else {
          // else split before start of non-terminal node
          endIndex = (indexOfNextNonTerminal < 0) ? strRule.length() : indexOfNextNonTerminal;
        }

        String terminalNodeValue = strRule.substring(i, endIndex).trim();
        if (terminalNodeValue.length() > 0) {
          if (children.size() > 0) {
            children.add(new PunctuationNode(' '));
          }
          children.add(new TerminalNode(terminalNodeValue));
        }
        i = endIndex;
      }
    } // end of while loop
    return children;
  }

  /**
   * Deserializes start node
   *
   * @param object Json Object
   * @return List of Node lists
   */
  private List<List<Node>> deserializeStart(JsonObject object) {
    List<List<Node>> startNodeList = new LinkedList<>();
    //serializing start node from json file data
    for (JsonElement start : object.get(START_GRAMMAR).getAsJsonArray()) {
      String strRule = start.getAsString();
      List<Node> children = generateChildrenNodeList(strRule);
      startNodeList.add(children);
    }
    return startNodeList;
  }

  /**
   * String representation of the class
   *
   * @return String
   */
  @Override
  public String toString() {
    return "GrammarDeserializer{}";
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
