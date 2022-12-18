package assignment6.problem1.Server;

import assignment6.problem1.Messages.Message;
import assignment6.problem1.Messages.MessageDeserializer;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Represents a Reciever
 */
public class Reciever extends Thread {

  private final Client client;
  private DataInputStream clientInput;

  /**
   * Constructs a Reciever object using below params
   *
   * @param inputStream userDetails
   * @param client      client
   */
  public Reciever(
      InputStream inputStream,
      Client client) {
    this.client = client;
    this.clientInput = new DataInputStream(inputStream);
  }


  /**
   * When an object implementing interface {@code Runnable} is used to create a thread, starting the
   * thread causes the object's {@code run} method to be called in that separately executing
   * thread.
   * <p>
   * The general contract of the method {@code run} is that it may take any action whatsoever.
   *
   * @see Thread#run()
   */
  @Override
  public void run() {
    try {
      while (!Thread.currentThread().isInterrupted()) {
        Message message = MessageDeserializer.read(this.clientInput);
        client.dispatchMessage(message);
      }
    } catch (IOException | InterruptedException ex) {
      System.out.println("Thread interrupted " + ex.getMessage());
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
}
