package assignment6.problem1.Messages;

import java.nio.charset.StandardCharsets;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class QueryMessageTest {

  QueryMessage queryMessage;
  byte[] uname;

  @BeforeEach
  void setUp() {
    uname = "a".getBytes(StandardCharsets.UTF_8);
    this.queryMessage = new QueryMessage(uname);
  }

  @Test
  void testEquals() {
    QueryMessage EqualDM = new QueryMessage(this.uname);
    Assertions.assertTrue(this.queryMessage.equals(EqualDM));
    QueryMessage equalDiffDM = new QueryMessage
        ("bc".getBytes(StandardCharsets.UTF_8));
    Assertions.assertFalse(this.queryMessage.equals(equalDiffDM));
    QueryMessage equalDM = this.queryMessage;
    Assertions.assertTrue(this.queryMessage.equals(equalDM));
    Assertions.assertTrue(this.queryMessage.equals(this.queryMessage));
    Assertions.assertFalse(this.queryMessage.equals(null));
  }

  @Test
  void testHashCode() {
    Assertions.assertEquals(this.queryMessage.hashCode(), this.queryMessage.hashCode());
    Assertions.assertEquals(this.queryMessage.hashCode(),
        new QueryMessage(uname).hashCode());
    Assertions.assertNotEquals(this.queryMessage.hashCode(),
        new QueryMessage("fff".getBytes(StandardCharsets.UTF_8)).hashCode());
  }

  @Test
  void testToString() {
    System.out.println(this.queryMessage.toString());
    Assertions.assertTrue(!this.queryMessage.toString().isEmpty());
    Assertions.assertTrue(this.queryMessage.toString().contains("Message{"));
  }
}