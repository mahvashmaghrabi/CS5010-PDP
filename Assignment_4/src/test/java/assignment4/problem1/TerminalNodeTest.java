package assignment4.problem1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TerminalNodeTest {

  TerminalNode terminalNode;
  String text;

  @BeforeEach
  void setUp() {
    this.text = "Hello";
    this.terminalNode = new TerminalNode(this.text);
  }

  @Test
  void generateString() {
    StringBuilder sb = new StringBuilder();
    this.terminalNode.generateString(sb, null);
    Assertions.assertEquals(this.text, sb.toString());

    Assertions.assertNotEquals(this.text, "hello");
  }

  @Test
  void testHashCode() {
    Assertions.assertEquals(this.terminalNode.hashCode(), this.terminalNode.hashCode());
    Assertions.assertNotEquals(this.terminalNode.hashCode(), new TerminalNode("hello").hashCode());
  }

  @Test
  void testToString() {
    Assertions.assertTrue(!this.terminalNode.toString().isEmpty());
    Assertions.assertTrue(this.terminalNode.toString().contains("TerminalNode{"));
  }

  @Test
  void testEquals() {
    TerminalNode notEqualTN = new TerminalNode("hello");
    Assertions.assertFalse(this.terminalNode.equals(notEqualTN));
    TerminalNode equalTN = this.terminalNode;
    Assertions.assertTrue(this.terminalNode.equals(equalTN));
    TerminalNode diffEqualTN = new TerminalNode(this.text);
    Assertions.assertFalse(this.terminalNode.equals(diffEqualTN));
    Assertions.assertTrue(this.terminalNode.equals(this.terminalNode));
    Assertions.assertFalse(this.terminalNode.equals(null));
  }

  @Test
  void getText() {
    Assertions.assertEquals(this.text, this.terminalNode.getText());
  }
}