package assignment6.problem1.Client;

import assignment6.problem1.Messages.BroadcastMessage;
import assignment6.problem1.Messages.ConnectResponse;
import assignment6.problem1.Messages.DirectMessage;
import assignment6.problem1.Messages.FailedMessage;
import assignment6.problem1.Messages.QueryResponse;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ServerResponseHandlerTest {

  private static byte[] testUser = "test_user".getBytes(StandardCharsets.UTF_8);
  private static byte[] testUser2 = "test_user2".getBytes(StandardCharsets.UTF_8);
  private final PrintStream originalOut = System.out;
  private ServerResponseHandler handler;
  private DataInputStream dis;
  private ByteArrayOutputStream bout;

  @BeforeEach
  void setUp() throws IOException {
    this.dis = new DataInputStream(new ByteArrayInputStream(new byte[0]));
    this.bout = new ByteArrayOutputStream();
    this.handler = new ServerResponseHandler(
        dis,
        new DataOutputStream(new ByteArrayOutputStream()),
        testUser);

    System.setOut(new PrintStream(bout));
  }

  @AfterEach
  void tearDown() {
    System.setOut(originalOut);
  }

  @Test
  void testToString() {
    System.out.println(this.handler.toString());
    Assertions.assertTrue(!this.handler.toString().isEmpty());
    Assertions.assertTrue(this.handler.toString().contains("Thread"));
  }

  @Test
  void testHashCode() throws IOException {
    Assertions.assertEquals(this.handler.hashCode(), this.handler.hashCode());
    Assertions.assertNotEquals(this.handler.hashCode(),
        new ServerResponseHandler(
            dis,
            new DataOutputStream(new ByteArrayOutputStream()),
            testUser).hashCode());
  }

  @Test
  void testEquals() throws IOException {
    ServerResponseHandler EqualCM = new ServerResponseHandler(
        dis,
        new DataOutputStream(new ByteArrayOutputStream()),
        testUser);
    Assertions.assertFalse(this.handler.equals(EqualCM));

    ServerResponseHandler equalCM = this.handler;
    Assertions.assertTrue(this.handler.equals(equalCM));

    Assertions.assertTrue(this.handler.equals(this.handler));
    Assertions.assertFalse(this.handler.equals(null));
  }

  @Test
  void handleBroadcastMessage() {
    this.handler.handleMessage(new BroadcastMessage(
        testUser,
        "hello!".getBytes(StandardCharsets.UTF_8)));

    Assertions.assertEquals("test_user -> hello!\n", bout.toString());
  }

  @Test
  void testHandleDirectMessage() {
    this.handler.handleMessage(new DirectMessage(
        testUser,
        testUser2,
        "hi!".getBytes(StandardCharsets.UTF_8)));

    Assertions.assertEquals("test_user -> hi!\n", bout.toString());
  }

  @Test
  void testHandleQueryResponseMessage() {
    this.handler.handleMessage(new QueryResponse(
        List.of(
            testUser,
            testUser2)));

    Assertions.assertEquals(
        "Connected users::\n"
            + "test_user\n"
            + "test_user2\n",
        bout.toString());
  }

  @Test
  void testHandleFailedMessageMessage() {
    this.handler.handleMessage(
        new FailedMessage(testUser, "bad response".getBytes(StandardCharsets.UTF_8)));

    Assertions.assertEquals(
        "failure:: bad response\n",
        bout.toString());
  }

  @Test
  void testHandleDisconnectResponseMessage() throws InterruptedException {
    this.handler.start();
    handler.handleMessage(new ConnectResponse(
        true,
        "".getBytes(StandardCharsets.UTF_8)));
    handler.handleMessage(new ConnectResponse(
        true,
        "".getBytes(StandardCharsets.UTF_8)));
    Assertions.assertTrue(this.handler.isInterrupted());
  }

  @Test
  void testRun() throws IOException, InterruptedException {
    this.handler.start();
    this.dis.reset();
    Thread.sleep(100);
    Assertions.assertFalse(this.handler.isAlive());
  }

  @Test
  void testRunMessage() throws IOException, InterruptedException {
    var input = new ByteArrayOutputStream();
    new BroadcastMessage(
        testUser,
        "hi".getBytes(StandardCharsets.UTF_8))
        .serialize(new DataOutputStream(input));

    var handler = new ServerResponseHandler(
        new DataInputStream(new ByteArrayInputStream(input.toByteArray())),
        new DataOutputStream(new ByteArrayOutputStream()),
        testUser);

    handler.start();
    Thread.sleep(100);
    Assertions.assertTrue(bout.toString().contains("test_user -> hi"));
  }

}