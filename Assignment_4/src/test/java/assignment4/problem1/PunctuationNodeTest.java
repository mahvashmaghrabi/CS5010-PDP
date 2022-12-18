package assignment4.problem1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PunctuationNodeTest {

  PunctuationNode punctuationNode;
  char punctuation;

  @BeforeEach
  void setUp() {
    this.punctuation = ',';
    this.punctuationNode = new PunctuationNode(this.punctuation);
  }

  @Test
  void generateString() {
    StringBuilder sb = new StringBuilder("hello");
    this.punctuationNode.generateString(sb, null);
    Assertions.assertEquals("hello,", sb.toString());

    Assertions.assertNotEquals(this.punctuation, ':');
  }

  @Test
  void testHashCode() {
    Assertions.assertEquals(this.punctuationNode.hashCode(), this.punctuationNode.hashCode());
    Assertions.assertNotEquals(this.punctuationNode.hashCode(),
        new PunctuationNode(':').hashCode());
  }

  @Test
  void testToString() {
    Assertions.assertTrue(!this.punctuationNode.toString().isEmpty());
    Assertions.assertTrue(this.punctuationNode.toString().contains("PunctuationNode{"));
  }

  @Test
  void testEquals() {
    PunctuationNode notEqualPN = new PunctuationNode(':');
    Assertions.assertFalse(this.punctuationNode.equals(notEqualPN));
    PunctuationNode equalPN = this.punctuationNode;
    Assertions.assertTrue(this.punctuationNode.equals(equalPN));
    PunctuationNode diffEqualPN = new PunctuationNode(this.punctuation);
    Assertions.assertTrue(this.punctuationNode.equals(diffEqualPN));
    Assertions.assertTrue(this.punctuationNode.equals(this.punctuationNode));
    Assertions.assertFalse(this.punctuationNode.equals(null));
  }

  @Test
  void getPunctuation() {
    Assertions.assertEquals(this.punctuation, this.punctuationNode.getPunctuation());
  }
}