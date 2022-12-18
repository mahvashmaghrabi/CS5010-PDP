package assignment4.problem1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class NonTerminalNodeTest {

  NonTerminalNode nonTerminalNode;
  String nodeName;

  @BeforeEach
  void setUp() {
    this.nodeName = "noun";
    this.nonTerminalNode = new NonTerminalNode(this.nodeName);
  }

  @Test
  void generateString() throws IOException {
    Grammar grammar = GrammarDeserializer.parseGrammar(Files.readString(Paths.get(
        "./json/test.json"
    )));
    StringBuilder sb = new StringBuilder();
    this.nonTerminalNode.generateString(sb, grammar);
    //System.out.println(sb.t);
    Assertions.assertTrue(sb != null);
  }

  @Test
  void testToString() {
    Assertions.assertTrue(this.nonTerminalNode.toString().contains("NonTerminalNode{"));
  }

  @Test
  void testEquals() {
    NonTerminalNode notEqualNTN = new NonTerminalNode("hello");
    Assertions.assertFalse(this.nonTerminalNode.equals(notEqualNTN));
    NonTerminalNode equalNTN = this.nonTerminalNode;
    Assertions.assertTrue(this.nonTerminalNode.equals(equalNTN));
    NonTerminalNode diffEqualNT = new NonTerminalNode(this.nodeName);
    Assertions.assertTrue(this.nonTerminalNode.equals(diffEqualNT));
    Assertions.assertTrue(this.nonTerminalNode.equals(this.nonTerminalNode));
    Assertions.assertFalse(this.nonTerminalNode.equals(null));
  }

  @Test
  void testHashCode() {
    Assertions.assertEquals(this.nonTerminalNode.hashCode(), this.nonTerminalNode.hashCode());
    Assertions.assertNotEquals(this.nonTerminalNode.hashCode(),
        new NonTerminalNode("hello").hashCode());
  }
}