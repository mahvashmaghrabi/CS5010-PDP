package assignment6.problem1.Messages;

import java.io.FileNotFoundException;
import java.nio.charset.StandardCharsets;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BroadcastMessageTest {

  BroadcastMessage broadCastMessage;

  @BeforeEach
  void setUp() {
    byte[] username = "abc".getBytes(StandardCharsets.UTF_8);
    byte[] messageContent = "hello".getBytes(StandardCharsets.UTF_8);
    this.broadCastMessage = new BroadcastMessage(username, messageContent);
  }

  @Test
  void getMessageContent() {
    byte[] msg = this.broadCastMessage.getMessageContent();
    Assertions.assertEquals("hello", new String(msg, StandardCharsets.UTF_8));
  }

  @Test
  void serialize() throws FileNotFoundException {
//    this.broadCastMessage.serialize(new DataOutputStream(new PrintWriter("README.md")));
  }

  @Test
  void testEquals() {
    BroadcastMessage EqualBCM = new BroadcastMessage(this.broadCastMessage.getUserName(),
        this.broadCastMessage.getMessageContent());
    Assertions.assertTrue(this.broadCastMessage.equals(EqualBCM));
    BroadcastMessage notEqualDiffBCM = new BroadcastMessage("s".getBytes(StandardCharsets.UTF_8),
        "fr".getBytes(StandardCharsets.UTF_8));
    Assertions.assertFalse(this.broadCastMessage.equals(notEqualDiffBCM));

    BroadcastMessage notEqualDiffBCM1 = new BroadcastMessage(this.broadCastMessage.getUserName(),
        "d".getBytes(StandardCharsets.UTF_8));
    Assertions.assertFalse(this.broadCastMessage.equals(notEqualDiffBCM));

    BroadcastMessage notEqualDiffBCM2 = new BroadcastMessage("e".getBytes(StandardCharsets.UTF_8),
        this.broadCastMessage.getMessageContent());
    Assertions.assertFalse(this.broadCastMessage.equals(notEqualDiffBCM));

    BroadcastMessage equalBCM = this.broadCastMessage;
    Assertions.assertTrue(this.broadCastMessage.equals(equalBCM));
//    BroadcastMessage diffEqualBCM = new BroadcastMessage(this.broadCastMessage.getSenderDetails(),
//        this.broadCastMessage.getMessageDetails());
//    Assertions.assertTrue(this.broadCastMessage.equals(diffEqualBCM));
    Assertions.assertTrue(this.broadCastMessage.equals(this.broadCastMessage));
    Assertions.assertFalse(this.broadCastMessage.equals(null));
  }

  @Test
  void testHashCode() {
    Assertions.assertEquals(this.broadCastMessage.hashCode(), this.broadCastMessage.hashCode());
    Assertions.assertNotEquals(this.broadCastMessage.hashCode(),
        new BroadcastMessage("s".getBytes(StandardCharsets.UTF_8),
            "fr".getBytes(StandardCharsets.UTF_8)).hashCode());
  }

  @Test
  void testToString() {
    Assertions.assertTrue(!this.broadCastMessage.toString().isEmpty());
    Assertions.assertTrue(this.broadCastMessage.toString().contains("BroadcastMessage{"));
  }
}