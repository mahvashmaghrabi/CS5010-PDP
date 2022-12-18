package assignment6.problem1.Server;

import assignment6.problem1.Messages.BroadcastMessage;
import assignment6.problem1.Messages.ConnectMessage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ClientTest {

  private final String testUser = "test_user";
  private ByteArrayOutputStream bos;
  private ByteArrayInputStream bin;
  private ServerHandler serverHandler;
  private Client client;

  @BeforeEach
  void setUp() throws IOException {
    serverHandler = new ServerHandler();
    new Thread(serverHandler).start();
    bos = new ByteArrayOutputStream(2000);
    bin = new ByteArrayInputStream(new byte[2000]);
    client = new Client(serverHandler, bin, bos);
  }


  @Test
  void dispatchMessage() throws InterruptedException {
    var broadcastMessage = new BroadcastMessage(
        testUser.getBytes(StandardCharsets.UTF_8),
        "hello".getBytes(StandardCharsets.UTF_8));

    client.dispatchMessage(broadcastMessage);

    var connectMessage = new ConnectMessage(
        testUser.getBytes(StandardCharsets.UTF_8));
    client.dispatchMessage(connectMessage);
  }

  @Test
  void testHashCode() throws IOException {
    Assertions.assertEquals(this.client.hashCode(), this.client.hashCode());
    Assertions.assertNotEquals(this.client.hashCode(),
        new Client(serverHandler, bin, bos).hashCode());
  }

  @Test
  void testEquals() throws IOException {
    Client EqualCM = new Client(serverHandler, bin, bos);
    Assertions.assertFalse(this.client.equals(EqualCM));

    Client equalCM = this.client;
    Assertions.assertTrue(this.client.equals(equalCM));

    Assertions.assertTrue(this.client.equals(this.client));
    Assertions.assertFalse(this.client.equals(null));
  }

  @Test
  void testToString() {
    System.out.println(this.client.toString());
    Assertions.assertTrue(!this.client.toString().isEmpty());
    Assertions.assertTrue(this.client.toString().contains("Client"));
  }
}