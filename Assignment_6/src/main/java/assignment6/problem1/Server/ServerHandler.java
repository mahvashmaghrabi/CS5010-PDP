package assignment6.problem1.Server;

import assignment6.problem1.Messages.BroadcastMessage;
import assignment6.problem1.Messages.ComplimentMessage;
import assignment6.problem1.Messages.ConnectResponse;
import assignment6.problem1.Messages.DirectMessage;
import assignment6.problem1.Messages.DisconnectMessage;
import assignment6.problem1.Messages.FailedMessage;
import assignment6.problem1.Messages.Message;
import assignment6.problem1.Messages.QueryResponse;
import assignment6.problem1.Messages.QueryUsersMessage;
import assignment6.problem1.Messages.RandomComplimentGenerator;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.stream.Collectors;

/**
 * Represents a ServerHandler
 */
public class ServerHandler implements Runnable, MessageHandler {

  private static final int CLIENT_CAPACITY = 10;
  private final BlockingQueue<Message> messages = new LinkedBlockingQueue<>();
  private final ConcurrentMap<String, Client> clientMap = new ConcurrentHashMap<>();

  /**
   * Constructs empty ServerHandler object
   */
  public ServerHandler() {
  }

  /**
   * Returns client connected capacity
   *
   * @return int
   */
  public static int getClientCapacity() {
    return CLIENT_CAPACITY;
  }

  /**
   * Returns number of clients connected
   *
   * @return integer
   */
  public synchronized Integer getTotalClientsConnected() {
    return this.clientMap.size();
  }

  /**
   * Adds given client to the server's client list.
   *
   * @param client   client at server side
   * @param userName username as String
   */

  public void addClient(String userName, Client client) {
    if (this.clientMap.size() < CLIENT_CAPACITY) {
      clientMap.put(userName, client);
      client.sendMessage(new ConnectResponse(true, userName.getBytes(StandardCharsets.UTF_8)));
    } else {
      client.sendMessage(new ConnectResponse(
          false,
          ("Connection denied. Limit to total client connected at a same time is "
              + CLIENT_CAPACITY).getBytes(
              StandardCharsets.UTF_8)));
      client.disconnect();
    }
  }

  /**
   * adds message
   *
   * @param message Message object
   * @throws InterruptedException in case any error occurs
   */

  public void dispatchMessage(Message message) throws InterruptedException {
    messages.put(message);
  }

  /**
   * Continuously reads messages from the queue and send them to all clients connected
   */

  public void run() {
    try {
      while (true) {
        Message message = this.messages.take();
        message.accept(this);
      }
    } catch (InterruptedException ie) {
      System.out.println(ie.getMessage());
    }
  }

  /**
   * Send message to clients thread
   *
   * @param broadcastMessage BroadcastMessage
   */
  @Override
  public void handleMessage(BroadcastMessage broadcastMessage) {
    this.clientMap.values().forEach(client -> client.sendMessage(broadcastMessage));
  }

  /**
   * Send message to clients thread
   *
   * @param message DisconnectMessage
   */
  @Override
  public void handleMessage(DisconnectMessage message) {
    var client = this.clientMap.get(message.getUserNameAsString());
    if (client != null) {
      client.disconnect();
    }
    this.clientMap.remove(message.getUserNameAsString());
  }

  /**
   * Send message to clients thread
   *
   * @param message QueryUsersMessage
   */
  @Override
  public void handleMessage(QueryUsersMessage message) {
    var client = this.clientMap.get(message.getUserNameAsString());
    client.sendMessage(new QueryResponse(
        this.clientMap.keySet().stream()
            .map(String::getBytes)
            .collect(Collectors.toList())));
  }

  /**
   * Send message to clients thread
   *
   * @param directMessage DirectMessage
   */
  @Override
  public void handleMessage(DirectMessage directMessage) {
    var recepeint = this.clientMap.get(directMessage.getRecipientAsString());
    System.out.println("checking recepint = " + (recepeint == null));
    if (recepeint != null) {
      recepeint.sendMessage(directMessage);
    } else {
      var sender = this.clientMap.get(directMessage.getUserNameAsString());
      sender.sendMessage(new FailedMessage(directMessage.getUserName()
          , "Given recepeint not connected".getBytes(StandardCharsets.UTF_8)));
    }
  }

  /**
   * Send message to clients thread
   *
   * @param complimentMessage ComplimentMessage
   */
  @Override
  public void handleMessage(ComplimentMessage complimentMessage) {
    RandomComplimentGenerator complimentGenerator = new RandomComplimentGenerator();
    String compliment = complimentGenerator.generateRandomCompliment();
    handleMessage(new BroadcastMessage(
        complimentMessage.getUserName(),
        (complimentMessage.getRecipientAsString()
            + ": "
            + compliment).getBytes(StandardCharsets.UTF_8)));
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