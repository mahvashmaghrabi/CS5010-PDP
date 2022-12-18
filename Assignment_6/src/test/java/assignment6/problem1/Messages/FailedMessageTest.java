package assignment6.problem1.Messages;

import java.nio.charset.StandardCharsets;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FailedMessageTest {

  FailedMessage failedMessage;
  byte[] str;
  byte[] testUser = "test_user".getBytes(StandardCharsets.UTF_8);

  @BeforeEach
  void setUp() {
    str = "abc".getBytes(StandardCharsets.UTF_8);
    this.failedMessage = new FailedMessage(testUser, str);
  }

  @Test
  void getMessageContent() {
    Assertions.assertNotNull(this.failedMessage.getMessageContent());
  }

  @Test
  void testEquals() {
    FailedMessage EqualDM = new FailedMessage(testUser, this.str);
    Assertions.assertTrue(this.failedMessage.equals(EqualDM));
    FailedMessage equalDiffDM = new FailedMessage(testUser, "abc".getBytes(StandardCharsets.UTF_8));
    Assertions.assertTrue(this.failedMessage.equals(equalDiffDM));

    FailedMessage notEqualDiffDM = new FailedMessage(testUser,
        "ppp".getBytes(StandardCharsets.UTF_8));
    Assertions.assertFalse(this.failedMessage.equals(notEqualDiffDM));

    FailedMessage equalDM = this.failedMessage;
    Assertions.assertTrue(this.failedMessage.equals(equalDM));
    Assertions.assertTrue(this.failedMessage.equals(this.failedMessage));
    Assertions.assertFalse(this.failedMessage.equals(null));
  }

  @Test
  void testHashCode() {
    Assertions.assertEquals(this.failedMessage.hashCode(), this.failedMessage.hashCode());
    Assertions.assertEquals(this.failedMessage.hashCode(),
        new FailedMessage(testUser, "abc".getBytes(StandardCharsets.UTF_8)).hashCode());
    Assertions.assertNotEquals(this.failedMessage.hashCode(),
        new FailedMessage(testUser, "fff".getBytes(StandardCharsets.UTF_8)).hashCode());
  }

  @Test
  void testToString() {
    Assertions.assertTrue(!this.failedMessage.toString().isEmpty());
    Assertions.assertTrue(this.failedMessage.toString().contains("FailedMessage{"));
  }
}