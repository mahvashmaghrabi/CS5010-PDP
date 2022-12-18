package assignment6.problem1.Messages;

import java.nio.charset.StandardCharsets;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class QueryUsersMessageTest {

  QueryUsersMessage message;
  byte[] name;

  @BeforeEach
  void setUp() {
    name = "a".getBytes(StandardCharsets.UTF_8);
    this.message = new QueryUsersMessage(name);
  }

  @Test
  void accept() {
  }

  @Test
  void testEquals() {
    QueryUsersMessage EqualDM = new QueryUsersMessage(this.name);
    Assertions.assertTrue(this.message.equals(EqualDM));
    QueryUsersMessage equalDiffDM = new QueryUsersMessage
        ("bc".getBytes(StandardCharsets.UTF_8));
    Assertions.assertFalse(this.message.equals(equalDiffDM));
    QueryUsersMessage equalDM = this.message;
    Assertions.assertTrue(this.message.equals(equalDM));
    Assertions.assertTrue(this.message.equals(this.message));
    Assertions.assertFalse(this.message.equals(null));
  }

  @Test
  void testHashCode() {
    Assertions.assertEquals(this.message.hashCode(), this.message.hashCode());
    Assertions.assertEquals(this.message.hashCode(),
        new QueryMessage(name).hashCode());
    Assertions.assertNotEquals(this.message.hashCode(),
        new QueryMessage("fff".getBytes(StandardCharsets.UTF_8)).hashCode());
  }

  @Test
  void testToString() {
    System.out.println(this.message.toString());
    Assertions.assertTrue(!this.message.toString().isEmpty());
    Assertions.assertTrue(this.message.toString().contains("Message{"));
  }
}