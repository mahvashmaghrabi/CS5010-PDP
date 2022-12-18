package assignment6.problem1.Client;

import assignment6.problem1.Messages.MessageIdentifier;
import assignment6.problem1.Server.Sender;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.nio.charset.StandardCharsets;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class UserInputHandlerTest {

  private final String testUser = "test_user";
  UserInputHandler handler;
  Sender sender;
  private ByteArrayOutputStream bos;

  @BeforeEach
  void setUp() {
    bos = new ByteArrayOutputStream(2000);
    sender = new Sender(bos);
    new Thread(sender).start();
    handler = new UserInputHandler(
        new DataOutputStream(bos),
        testUser.getBytes(StandardCharsets.UTF_8));
  }

  @Test
  void run_helpCommand() {
    ByteArrayInputStream testIn = new ByteArrayInputStream("?".getBytes());
    System.setIn(testIn);
    Thread handlerThread = new Thread(handler);
    handlerThread.start();
    Thread.currentThread().interrupt();
  }

  @Test
  void run_NULL() {
    ByteArrayInputStream testIn = new ByteArrayInputStream("".getBytes(StandardCharsets.UTF_8));
    System.setIn(testIn);
    Thread handlerThread = new Thread(handler);
    handlerThread.start();
    Thread.currentThread().interrupt();
  }

  @Test
  void run_wrongCommand() {
    ByteArrayInputStream testIn = new ByteArrayInputStream("*".getBytes(StandardCharsets.UTF_8));
    System.setIn(testIn);
    Thread handlerThread = new Thread(handler);
    handlerThread.start();
    Thread.currentThread().interrupt();
  }

  @Test
  void run_Message() {
    ByteArrayInputStream testIn = new ByteArrayInputStream(
        "logoff".getBytes(StandardCharsets.UTF_8));
    System.setIn(testIn);
    Thread handlerThread = new Thread(handler);
    handlerThread.start();
    Thread.currentThread().interrupt();
  }

  @Test
  void parseUserInput() {
    var logoff = handler.parseUserInput("logoff");
    Assertions.assertEquals(MessageIdentifier.DISCONNECT_MESSAGE,
        logoff.getMsgIdentifier());
    var logoffFail = handler.parseUserInput("logoff hello");
    Assertions.assertNull(logoffFail);
    var who = handler.parseUserInput("who");
    Assertions.assertEquals(MessageIdentifier.QUERY_CONNECTED_USERS, who.getMsgIdentifier());

    var whoFail = handler.parseUserInput("who hello");
    Assertions.assertNull(whoFail);
    var all = handler.parseUserInput("@all hello");
    Assertions.assertEquals(MessageIdentifier.BROADCAST_MESSAGE,
        all.getMsgIdentifier());
    var allFail = handler.parseUserInput("@all");
    Assertions.assertNull(allFail);
    var user = handler.parseUserInput("@user hello");
    Assertions.assertEquals(MessageIdentifier.DIRECT_MESSAGE,
        user.getMsgIdentifier());
    var userFail = handler.parseUserInput("@a");
    Assertions.assertNull(userFail);

    var abc = handler.parseUserInput("!abc");
    Assertions.assertEquals(MessageIdentifier.SEND_COMPLIMENT,
        abc.getMsgIdentifier());
    var abcFail = handler.parseUserInput("!abc hello");
    Assertions.assertNull(abcFail);

    var unSupportedOption = handler.parseUserInput("*");
    Assertions.assertNull(unSupportedOption);
  }

  @Test
  void testToString() {
    System.out.println(this.handler.toString());
    Assertions.assertTrue(!this.handler.toString().isEmpty());
    Assertions.assertTrue(this.handler.toString().contains("Thread"));
  }

  @Test
  void testHashCode() {
    Assertions.assertEquals(this.handler.hashCode(), this.handler.hashCode());
    Assertions.assertNotEquals(this.handler.hashCode(),
        new UserInputHandler(
            new DataOutputStream(bos),
            testUser.getBytes(StandardCharsets.UTF_8)).hashCode());
  }

  @Test
  void testEquals() {
    UserInputHandler EqualCM = new UserInputHandler(
        new DataOutputStream(bos),
        testUser.getBytes(StandardCharsets.UTF_8));
    Assertions.assertFalse(this.handler.equals(EqualCM));

    UserInputHandler equalCM = this.handler;
    Assertions.assertTrue(this.handler.equals(equalCM));

    Assertions.assertTrue(this.handler.equals(this.handler));
    Assertions.assertFalse(this.handler.equals(null));
  }
}