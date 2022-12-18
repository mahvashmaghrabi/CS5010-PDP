package assignment6.problem1.Messages;

import java.nio.charset.StandardCharsets;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DirectMessageTest {

  DirectMessage dm;
  byte[] re;
  byte[] messageContent;

  @BeforeEach
  void setUp() {
    byte[] username = "abc".getBytes(StandardCharsets.UTF_8);
    re = "a".getBytes(StandardCharsets.UTF_8);
    messageContent = "hello".getBytes(StandardCharsets.UTF_8);
    this.dm = new DirectMessage(username, re, messageContent);
  }

  @Test
  void getMessageContent() {
    byte[] msg = this.dm.getMessageContent();
    Assertions.assertEquals("hello", new String(msg, StandardCharsets.UTF_8));
  }

  @Test
  void testToString() {
    Assertions.assertTrue(!this.dm.toString().isEmpty());
    Assertions.assertTrue(this.dm.toString().contains("DirectMessage"));
  }

  @Test
  void testEquals() {
    DirectMessage EqualDM = new DirectMessage(this.dm.getUserName(), re,
        this.dm.getMessageContent());
    Assertions.assertTrue(this.dm.equals(EqualDM));
    DirectMessage equalDiffDM = new DirectMessage("abc".getBytes(StandardCharsets.UTF_8),
        "re".getBytes(StandardCharsets.UTF_8), "hello".getBytes(StandardCharsets.UTF_8));
    Assertions.assertFalse(this.dm.equals(equalDiffDM));

    DirectMessage notEqualDiffDM = new DirectMessage("fff".getBytes(StandardCharsets.UTF_8),
        "ppp".getBytes(StandardCharsets.UTF_8), messageContent);
    Assertions.assertFalse(this.dm.equals(notEqualDiffDM));

    DirectMessage notEqualDiffDM1 = new DirectMessage("abc".getBytes(StandardCharsets.UTF_8),
        "re".getBytes(StandardCharsets.UTF_8), "testing".getBytes(StandardCharsets.UTF_8));
    Assertions.assertFalse(this.dm.equals(notEqualDiffDM1));

    DirectMessage equalDM = this.dm;
    Assertions.assertTrue(this.dm.equals(equalDM));
    Assertions.assertTrue(this.dm.equals(this.dm));
    Assertions.assertFalse(this.dm.equals(null));
  }

  @Test
  void testHashCode() {
    Assertions.assertEquals(this.dm.hashCode(), this.dm.hashCode());
    Assertions.assertEquals(this.dm.hashCode(),
        new DirectMessage("abc".getBytes(StandardCharsets.UTF_8), re,
            "hello".getBytes(StandardCharsets.UTF_8)).hashCode());
    Assertions.assertNotEquals(this.dm.hashCode(),
        new DirectMessage("fff".getBytes(StandardCharsets.UTF_8),
            "r".getBytes(StandardCharsets.UTF_8),
            "ppp".getBytes(StandardCharsets.UTF_8)).hashCode());
  }
}