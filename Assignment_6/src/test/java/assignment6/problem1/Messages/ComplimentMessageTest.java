package assignment6.problem1.Messages;

import java.nio.charset.StandardCharsets;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ComplimentMessageTest {

  ComplimentMessage complimentMessage;
  byte[] receiver;
  byte[] sender;
  byte[] msg;

  @BeforeEach
  void setUp() {
    receiver = "abc".getBytes(StandardCharsets.UTF_8);
    sender = "sss".getBytes(StandardCharsets.UTF_8);
    msg = "hello".getBytes(StandardCharsets.UTF_8);
    this.complimentMessage = new ComplimentMessage(sender, this.receiver);//, msg);
  }

  @Test
  void getSender() {
    Assertions.assertNotNull(this.complimentMessage.getSender());
  }

  @Test
  void getRecipient() {
    Assertions.assertNotNull(this.complimentMessage.getRecipient());
  }

  @Test
  void testEquals() {
    ComplimentMessage EqualDM = new ComplimentMessage(this.sender, this.receiver);//,msg);
    Assertions.assertTrue(this.complimentMessage.equals(EqualDM));
    ComplimentMessage equalDiffDM = new ComplimentMessage
        ("bc".getBytes(StandardCharsets.UTF_8), receiver);//,msg);
    Assertions.assertFalse(this.complimentMessage.equals(equalDiffDM));

    ComplimentMessage notEqualDiffDM = new ComplimentMessage(sender,
        "s".getBytes(StandardCharsets.UTF_8));//,msg);
    Assertions.assertFalse(this.complimentMessage.equals(notEqualDiffDM));

    ComplimentMessage notEqualDiffDM2 = new ComplimentMessage(sender,
        "s".getBytes(StandardCharsets.UTF_8));
    //   ,"msg".getBytes(StandardCharsets.UTF_8));

    Assertions.assertFalse(this.complimentMessage.equals(notEqualDiffDM2));

    ComplimentMessage equalDM = this.complimentMessage;
    Assertions.assertTrue(this.complimentMessage.equals(equalDM));
    Assertions.assertTrue(this.complimentMessage.equals(this.complimentMessage));
    Assertions.assertFalse(this.complimentMessage.equals(null));
  }

  @Test
  void testHashCode() {
    Assertions.assertEquals(this.complimentMessage.hashCode(), this.complimentMessage.hashCode());
    Assertions.assertEquals(this.complimentMessage.hashCode(),
        new ComplimentMessage(sender, receiver).hashCode());
    Assertions.assertNotEquals(this.complimentMessage.hashCode(),
        new ComplimentMessage("fff".getBytes(StandardCharsets.UTF_8),
            "a".getBytes(StandardCharsets.UTF_8)).hashCode());
  }

  @Test
  void testToString() {
    Assertions.assertTrue(!this.complimentMessage.toString().isEmpty());
    Assertions.assertTrue(this.complimentMessage.toString().contains("ComplimentMessage{"));
  }
}