package assignment6.problem1.Server;

import assignment6.problem1.Messages.ConnectResponse;
import assignment6.problem1.Messages.Message;
import assignment6.problem1.Messages.MessageIdentifier;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Represents a Client at server side
 */
public class Client {

  private final ServerHandler serverHandler;
  private final Sender sender;
  private final Reciever reciever;

  /**
   * Constructs a Client message
   *
   * @param serverHandler      server handler as object
   * @param clientInputStream  input stream of client
   * @param clientOutputStream output stream of client
   * @throws IOException throws exception in case error occurs
   */
  public Client(ServerHandler serverHandler, InputStream clientInputStream,
      OutputStream clientOutputStream) throws IOException {
    this.serverHandler = serverHandler;
    this.sender = new Sender(clientOutputStream);
    this.reciever = new Reciever(clientInputStream, this);
    this.sender.start();
    this.reciever.start();
  }

  /**
   * Disconnects client by sending Connect response
   */
  public void disconnect() {
    this.sender.sendMessage(new ConnectResponse(true, new byte[0]));
    this.sender.interrupt();
    this.reciever.interrupt();
  }

  /**
   * Sends message to client
   *
   * @param message as object
   */
  public void sendMessage(Message message) {
    this.sender.sendMessage(message);
  }

  /**
   * Sends client message to server handler
   *
   * @param message as object
   * @throws InterruptedException throws exception in case fails
   */
  public void dispatchMessage(Message message) throws InterruptedException {
    if (message.getMsgIdentifier() == MessageIdentifier.CONNECT_MESSAGE) {
      serverHandler.addClient(message.getUserNameAsString(), this);
    } else {
      this.serverHandler.dispatchMessage(message);
    }
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
   * Returns a string representation of the object.
   */
  @Override
  public String toString() {
    return super.toString();
  }
}
