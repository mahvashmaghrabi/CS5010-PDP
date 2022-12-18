package assignment6.problem1.Messages;

import java.nio.charset.StandardCharsets;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ConnectMessageTest {

  ConnectMessage connectMessage;

  @BeforeEach
  void setUp() {
    String userName = "abc";
    this.connectMessage = new ConnectMessage(userName.getBytes(StandardCharsets.UTF_8));
  }

  @Test
  void testEquals() {
    ConnectMessage EqualCM = new ConnectMessage("abc".getBytes(StandardCharsets.UTF_8));
    Assertions.assertTrue(this.connectMessage.equals(EqualCM));
    ConnectMessage notEqualDiffCM = new ConnectMessage("test".getBytes(StandardCharsets.UTF_8));
    Assertions.assertFalse(this.connectMessage.equals(notEqualDiffCM));

    ConnectMessage equalCM = this.connectMessage;
    Assertions.assertTrue(this.connectMessage.equals(equalCM));
    ConnectMessage diffEqualCM = new ConnectMessage(this.connectMessage.getUserName());
    Assertions.assertTrue(this.connectMessage.equals(diffEqualCM));
    Assertions.assertTrue(this.connectMessage.equals(this.connectMessage));
    Assertions.assertFalse(this.connectMessage.equals(null));
  }

  @Test
  void testHashCode() {
    Assertions.assertEquals(this.connectMessage.hashCode(), this.connectMessage.hashCode());
    Assertions.assertNotEquals(this.connectMessage.hashCode(),
        new ConnectMessage("hello".getBytes(StandardCharsets.UTF_8)).hashCode());
  }

  @Test
  void testToString() {
    System.out.println(this.connectMessage.toString());
    Assertions.assertTrue(!this.connectMessage.toString().isEmpty());
    Assertions.assertTrue(this.connectMessage.toString().contains("Message"));
  }

  @Test
  void accept() {
//    MessageHandler handler = (MessageHandler) new ConnectMessage("abc".getBytes(StandardCharsets.UTF_8));
//    this.connectMessage.accept(handler);
  }
}