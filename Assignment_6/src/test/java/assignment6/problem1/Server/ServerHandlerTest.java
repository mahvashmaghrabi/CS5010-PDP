package assignment6.problem1.Server;

import assignment6.problem1.Messages.BroadcastMessage;
import assignment6.problem1.Messages.ComplimentMessage;
import assignment6.problem1.Messages.ConnectResponse;
import assignment6.problem1.Messages.DirectMessage;
import assignment6.problem1.Messages.DisconnectMessage;
import assignment6.problem1.Messages.FailedMessage;
import assignment6.problem1.Messages.MessageDeserializer;
import assignment6.problem1.Messages.MessageIdentifier;
import assignment6.problem1.Messages.QueryUsersMessage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ServerHandlerTest {

  private final String testUser = "test_user";
  private final String testUser2 = "test_user2";

  private ByteArrayOutputStream bos;
  private ByteArrayInputStream bin;
  private ServerHandler serverHandler;


  @BeforeEach
  void setup() {
    serverHandler = new ServerHandler();
    new Thread(serverHandler).start();
    bos = new ByteArrayOutputStream(2000);
    bin = new ByteArrayInputStream(new byte[2000]);
  }


  @Test
  void getTotalClientsConnected() throws IOException, InterruptedException {
    serverHandler.addClient(testUser, new Client(serverHandler, bin, bos));
    Assertions.assertEquals(1, serverHandler.getTotalClientsConnected());
  }

  @Test
  void getClientCapacity() {
    Assertions.assertEquals(10, ServerHandler.getClientCapacity());
  }

  @Test
  void addClient() throws IOException, InterruptedException {
    serverHandler.addClient(testUser, new Client(serverHandler, bin, bos));
    Assertions.assertEquals(1, serverHandler.getTotalClientsConnected());

    for (int i = 1; i <= ServerHandler.getClientCapacity(); i++) {
      serverHandler.addClient(testUser + "_" + i, new Client(serverHandler, bin, bos));
    }

    Thread.sleep(100);

    var inputStream = new DataInputStream(new ByteArrayInputStream(bos.toByteArray()));
    for (int i = 0; i < ServerHandler.getClientCapacity(); i++) {
      var connectMessage = MessageDeserializer.read(inputStream);
    }

    var tooManyClientMessage = MessageDeserializer.read(inputStream);
    Assertions.assertEquals(
        new ConnectResponse(
            false,
            ("Connection denied. Limit to total client connected at a same time is "
                + ServerHandler.getClientCapacity()).getBytes(
                StandardCharsets.UTF_8)), tooManyClientMessage);
  }

  @Test
  void dispatchMessage() throws IOException, InterruptedException {
    serverHandler.addClient(testUser, new Client(serverHandler, bin, bos));

    var broadcastMessage = new BroadcastMessage(
        testUser.getBytes(StandardCharsets.UTF_8),
        "hello".getBytes(StandardCharsets.UTF_8));

    serverHandler.dispatchMessage(broadcastMessage);

    Thread.sleep(100);

    var inputStream = new DataInputStream(new ByteArrayInputStream(bos.toByteArray()));
    var connectMessage = MessageDeserializer.read(inputStream);
    var message = MessageDeserializer.read(inputStream);
    Assertions.assertEquals(broadcastMessage, message);
  }

  @Test
  void handleBroadcastMessage() throws IOException, InterruptedException {
    serverHandler.addClient(testUser, new Client(serverHandler, bin, bos));

    var broadcastMessage = new BroadcastMessage(
        testUser.getBytes(StandardCharsets.UTF_8),
        "hello".getBytes(StandardCharsets.UTF_8));

    serverHandler.dispatchMessage(broadcastMessage);

    Thread.sleep(100);
    var inputStream = new DataInputStream(new ByteArrayInputStream(bos.toByteArray()));
    var connectMessage = MessageDeserializer.read(inputStream);
    var message = MessageDeserializer.read(inputStream);
    Assertions.assertEquals(broadcastMessage, message);
  }

  @Test
  void testHandleDisconnectMessage() throws IOException, InterruptedException {
    serverHandler.addClient(testUser, new Client(serverHandler, bin, bos));

    var disconnectMessage = new DisconnectMessage(testUser.getBytes(StandardCharsets.UTF_8));

    serverHandler.dispatchMessage(disconnectMessage);

    Thread.sleep(100);
    var message = MessageDeserializer.read(
        new DataInputStream(new ByteArrayInputStream(bos.toByteArray())));
    Assertions.assertEquals(new ConnectResponse(true, testUser.getBytes(StandardCharsets.UTF_8)),
        message);

    var disconnectMessageWrong = new DisconnectMessage(
        "randomuser".getBytes(StandardCharsets.UTF_8));
    serverHandler.dispatchMessage(disconnectMessageWrong);

  }

  @Test
  void testHandleDirectMessage() throws IOException, InterruptedException {
    serverHandler.addClient(testUser, new Client(serverHandler, bin, bos));
    serverHandler.addClient(testUser2, new Client(serverHandler, bin, bos));

    var directMessage = new DirectMessage(
        testUser.getBytes(StandardCharsets.UTF_8),
        testUser2.getBytes(StandardCharsets.UTF_8),
        "hello".getBytes(StandardCharsets.UTF_8));

    serverHandler.dispatchMessage(directMessage);

    Thread.sleep(100);
    var inputStream = new DataInputStream(new ByteArrayInputStream(bos.toByteArray()));
    var connectMessage1 = MessageDeserializer.read(inputStream);
    var connectMessage2 = MessageDeserializer.read(inputStream);
    var message = MessageDeserializer.read(inputStream);
    Assertions.assertEquals(directMessage, message);
  }

  @Test
  void testHandleFailedDirectMessage() throws IOException, InterruptedException {
    serverHandler.addClient(testUser, new Client(serverHandler, bin, bos));

    var directMessage = new DirectMessage(
        testUser.getBytes(StandardCharsets.UTF_8),
        testUser2.getBytes(StandardCharsets.UTF_8),
        "hello".getBytes(StandardCharsets.UTF_8));

    serverHandler.dispatchMessage(directMessage);

    Thread.sleep(100);
    var inputStream = new DataInputStream(new ByteArrayInputStream(bos.toByteArray()));
    var connectMessage = MessageDeserializer.read(inputStream);
    var message = MessageDeserializer.read(inputStream);
    Assertions.assertEquals(new FailedMessage(
        testUser.getBytes(StandardCharsets.UTF_8),
        "Given recepeint not connected".getBytes(StandardCharsets.UTF_8)), message);
  }


  @Test
  void testQueryUsersMessage() throws IOException, InterruptedException {
    serverHandler.addClient(testUser, new Client(serverHandler, bin, bos));
    serverHandler.addClient(testUser2, new Client(serverHandler, bin, bos));

    var queryUsersMessage = new QueryUsersMessage(testUser.getBytes(StandardCharsets.UTF_8));

    serverHandler.dispatchMessage(queryUsersMessage);

    Thread.sleep(100);
    var inputStream = new DataInputStream(new ByteArrayInputStream(bos.toByteArray()));
    var connectMessage1 = MessageDeserializer.read(inputStream);
    var connectMessage2 = MessageDeserializer.read(inputStream);
    var message = MessageDeserializer.read(inputStream);
    Assertions.assertEquals(MessageIdentifier.QUERY_USER_RESPONSE, message.getMsgIdentifier());
  }


  @Test
  void testHandleComplimentMessage() throws IOException, InterruptedException {
    serverHandler.addClient(testUser, new Client(serverHandler, bin, bos));

    var queryUsersMessage = new ComplimentMessage(
        testUser.getBytes(StandardCharsets.UTF_8),
        testUser2.getBytes(StandardCharsets.UTF_8));

    serverHandler.dispatchMessage(queryUsersMessage);

    Thread.sleep(100);
    var inputStream = new DataInputStream(new ByteArrayInputStream(bos.toByteArray()));
    var connectMessage = MessageDeserializer.read(inputStream);
    var message = MessageDeserializer.read(inputStream);
    Assertions.assertEquals(MessageIdentifier.BROADCAST_MESSAGE, message.getMsgIdentifier());
  }

  @Test
  void testEquals() {
    ServerHandler EqualCM = new ServerHandler();
    Assertions.assertFalse(this.serverHandler.equals(EqualCM));

    ServerHandler equalCM = this.serverHandler;
    Assertions.assertTrue(this.serverHandler.equals(equalCM));

    Assertions.assertTrue(this.serverHandler.equals(this.serverHandler));
    Assertions.assertFalse(this.serverHandler.equals(null));
  }

  @Test
  void testHashCode() {
    Assertions.assertEquals(this.serverHandler.hashCode(), this.serverHandler.hashCode());
    Assertions.assertNotEquals(this.serverHandler.hashCode(),
        new ServerHandler().hashCode());
  }

  @Test
  void testToString() {
    System.out.println(this.serverHandler.toString());
    Assertions.assertTrue(!this.serverHandler.toString().isEmpty());
    Assertions.assertTrue(this.serverHandler.toString().contains("ServerHandler"));
  }

  @Test
  void main() {
    Thread.currentThread().interrupt();
    serverHandler.run();
  }

}