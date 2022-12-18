package assignment6.problem1.Messages;

import java.nio.charset.StandardCharsets;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DisconnectMessageTest {

  DisconnectMessage disconnectMessage;

  @BeforeEach
  void setUp() {
    this.disconnectMessage = new DisconnectMessage("abc".getBytes(StandardCharsets.UTF_8));
  }

  @Test
  void accept() {
//    MessageHandler handler = (MessageHandler) new DisconnectMessage("abc".getBytes(StandardCharsets.UTF_8));
//    this.disconnectMessage.accept(handler);
  }

  @Test
  void testToString() {
    Assertions.assertTrue(!this.disconnectMessage.toString().isEmpty());
    Assertions.assertTrue(this.disconnectMessage.toString().contains("DisconnectMessage"));
  }

  @Test
  void testEquals() {
    DisconnectMessage EqualDM = new DisconnectMessage("abc".getBytes(StandardCharsets.UTF_8));
    Assertions.assertTrue(this.disconnectMessage.equals(EqualDM));
    DisconnectMessage notEqualDiffCM = new DisconnectMessage(
        "test".getBytes(StandardCharsets.UTF_8));
    Assertions.assertFalse(this.disconnectMessage.equals(notEqualDiffCM));

    DisconnectMessage equalCM = this.disconnectMessage;
    Assertions.assertTrue(this.disconnectMessage.equals(equalCM));
    DisconnectMessage diffEqualCM = new DisconnectMessage(this.disconnectMessage.getUserName());
    Assertions.assertTrue(this.disconnectMessage.equals(diffEqualCM));
    Assertions.assertTrue(this.disconnectMessage.equals(this.disconnectMessage));
    Assertions.assertFalse(this.disconnectMessage.equals(null));
  }

  @Test
  void testHashCode() {
    Assertions.assertEquals(this.disconnectMessage.hashCode(), this.disconnectMessage.hashCode());
    Assertions.assertNotEquals(this.disconnectMessage.hashCode(),
        new DisconnectMessage("dfd".getBytes(StandardCharsets.UTF_8)).hashCode());
  }
}