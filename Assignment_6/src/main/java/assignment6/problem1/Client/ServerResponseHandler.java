package assignment6.problem1.Client;

import assignment6.problem1.Messages.BroadcastMessage;
import assignment6.problem1.Messages.ConnectMessage;
import assignment6.problem1.Messages.ConnectResponse;
import assignment6.problem1.Messages.DirectMessage;
import assignment6.problem1.Messages.FailedMessage;
import assignment6.problem1.Messages.Message;
import assignment6.problem1.Messages.MessageDeserializer;
import assignment6.problem1.Messages.QueryResponse;
import assignment6.problem1.Server.MessageHandler;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * Represents ServerResponseHandler
 */
public class ServerResponseHandler extends Thread implements MessageHandler {

  private final DataInputStream inputStream;
  private final DataOutputStream outputStream;
  private final byte[] username;
  private boolean loggedIn = false;

  /**
   * Constructs a ServerResponseHandler
   *
   * @param inputStream  inputStream
   * @param outputStream outputStream
   * @param username     username
   * @throws IOException throws in case any error occurs
   */
  public ServerResponseHandler(
      DataInputStream inputStream,
      DataOutputStream outputStream,
      byte[] username) throws IOException {
    this.inputStream = inputStream;
    this.outputStream = outputStream;
    this.username = username;
    login();
  }

  private void login() throws IOException {
    new ConnectMessage(username).serialize(outputStream);

  }

  /**
   * Continuously reads and deserialize message
   */
  @Override
  public void run() {
    try {
      while (!this.isInterrupted()) {
        Message message = MessageDeserializer.read(this.inputStream);
        message.accept(this);
      }

    } catch (IOException ex) {
      System.out.println("Connection broken.");
    }
  }

  /**
   * Returns a string representation of this thread, including the thread's name, priority, and
   * thread group.
   *
   * @return a string representation of this thread.
   */
  @Override
  public String toString() {
    return super.toString();
  }

  /**
   * Returns a hash code value for the object.
   *
   * @return a hash code value for this object.
   */
  @Override
  public int hashCode() {
    return super.hashCode();
  }

  /**
   * Indicates whether some other object is "equal to" this one.
   *
   * @param obj the reference object with which to compare.
   */
  @Override
  public boolean equals(Object obj) {
    return super.equals(obj);
  }

  /**
   * Handler for Broadcast Message
   *
   * @param broadcastMessage Broadcast Message
   */
  @Override
  public void handleMessage(BroadcastMessage broadcastMessage) {
    System.out.println(broadcastMessage.getUserNameAsString() + " -> " + new String(
        broadcastMessage.getMessageContent(), StandardCharsets.UTF_8));
  }

  /**
   * Handler for Direct message
   *
   * @param directMessage Direct Message
   */
  @Override
  public void handleMessage(DirectMessage directMessage) {
    System.out.println(
        directMessage.getUserNameAsString() + " -> " + new String(directMessage.getMessageContent(),
            StandardCharsets.UTF_8));
  }

  /**
   * Handler for Query Response message
   *
   * @param message Query Response message
   */
  @Override
  public void handleMessage(QueryResponse message) {
    System.out.println("Connected users::");
    message.getUserDetails()
        .forEach(bytes -> System.out.println(new String(bytes, StandardCharsets.UTF_8)));
  }

  /**
   * handler for Failed Message
   *
   * @param message Failed Message
   */
  @Override
  public void handleMessage(FailedMessage message) {
    System.out.printf("failure:: %s%n",
        new String(message.getMessageContent(), StandardCharsets.UTF_8));

  }

  /**
   * Handler for Connect Response
   *
   * @param message Connect Response
   */
  @Override
  public void handleMessage(ConnectResponse message) {
    if (!loggedIn && message.isSuccess()) {
      loggedIn = true;
      System.out.println("You are connected!");
      var userInputHandler = new UserInputHandler(outputStream, username);
      userInputHandler.setDaemon(true);
      userInputHandler.start();

    } else {
      System.out.println(
          "Server message:: " + new String(message.getMessage(), StandardCharsets.UTF_8));
      this.interrupt();
    }
  }

}
