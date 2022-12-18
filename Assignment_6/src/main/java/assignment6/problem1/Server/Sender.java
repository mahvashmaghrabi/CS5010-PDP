package assignment6.problem1.Server;

import assignment6.problem1.Messages.Message;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Vector;

/**
 * Represents a Sender thread
 */
public class Sender extends Thread {

  private final DataOutputStream clientOutput;
  private Vector<Message> queue;

  /**
   * Constructs a Sender object using below params
   *
   * @param outputStream outputStream of client
   */
  public Sender(OutputStream outputStream) {
    this.queue = new Vector<>();
    this.clientOutput = new DataOutputStream(outputStream);
  }

  /**
   * adds message to the message queue
   *
   * @param message message object
   */

  public synchronized void sendMessage(Message message) {
    queue.add(message);
    notify();
  }

  private synchronized Message getNextMessage() throws InterruptedException {
    while (queue.size() == 0) {
      wait();
    }

    var message = queue.get(0);
    queue.removeElementAt(0);
    return message;
  }


  private void sendMessageToClient(Message message) throws IOException {
    message.serialize(clientOutput);
    clientOutput.flush();
  }


  /**
   * Reads messages from the message queue
   */

  public void run() {
    try {

      while (!isInterrupted()) {
        var message = getNextMessage();
        if (message != null) {
          sendMessageToClient(message);
        }
      }

      if (isInterrupted()) {
        System.out.println("Sender thread interrupted.");
      }

    } catch (Exception e) {
      System.out.println("Error occurred during message sending. Following is the cause");
      System.out.println(e.getMessage());
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
