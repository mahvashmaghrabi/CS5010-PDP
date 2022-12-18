package assignment6.problem1.Server;

import assignment6.problem1.Messages.BroadcastMessage;
import assignment6.problem1.Messages.ConnectMessage;
import assignment6.problem1.Messages.MessageDeserializer;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SenderTest {

  private final String testUser = "test_user";
  Sender sender;
  private ByteArrayOutputStream bos;

  @BeforeEach
  void setUp() {
    bos = new ByteArrayOutputStream(2000);
    sender = new Sender(bos);
    new Thread(sender).start();

  }

  @Test
  void sendMessage() throws IOException, InterruptedException {
    var broadcastMessage = new BroadcastMessage(
        testUser.getBytes(StandardCharsets.UTF_8),
        "hello".getBytes(StandardCharsets.UTF_8));
    this.sender.sendMessage(broadcastMessage);
    Thread.sleep(100);
    var message = MessageDeserializer.read(
        new DataInputStream(new ByteArrayInputStream(bos.toByteArray())));
    Assertions.assertEquals(broadcastMessage, message);
  }

  @Test
  void run_interrupt() {
    Thread.currentThread().interrupt();
    sender.run();
  }

  @Test
  void run() {
    Thread.currentThread().interrupt();
    var broadcastMessage = new BroadcastMessage(
        testUser.getBytes(StandardCharsets.UTF_8),
        "hello".getBytes(StandardCharsets.UTF_8));
    sender.sendMessage(broadcastMessage);
    //Thread.currentThread().interrupt();
    sender.run();
  }

  @Test
  void testToString() {
    Sender EqualCM = new Sender(bos);
    Assertions.assertFalse(this.sender.equals(EqualCM));
    String notEqualDiffCM = new String("test".getBytes(StandardCharsets.UTF_8));
    Assertions.assertFalse(this.sender.equals(notEqualDiffCM));

    Sender equalCM = this.sender;
    Assertions.assertTrue(this.sender.equals(equalCM));

    Assertions.assertTrue(this.sender.equals(this.sender));
    Assertions.assertFalse(this.sender.equals(null));
  }

  @Test
  void testHashCode() {
    Assertions.assertEquals(this.sender.hashCode(), this.sender.hashCode());
    Assertions.assertNotEquals(this.sender.hashCode(),
        new ConnectMessage("hello".getBytes(StandardCharsets.UTF_8)).hashCode());
  }

  @Test
  void testEquals() {

    System.out.println(this.sender.toString());
    Assertions.assertTrue(!this.sender.toString().isEmpty());
    Assertions.assertTrue(this.sender.toString().contains("Thread"));
  }
}