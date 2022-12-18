package assignment6.problem1.Messages;

import java.io.DataInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Represents a MessageDeserializer class
 */
public class MessageDeserializer {

  static Map<Integer, MessageIdentifier> intToMessageId =
      Arrays.stream(MessageIdentifier.values())
          .collect(Collectors.toMap(MessageIdentifier::getMsgId, Function.identity()));

  /**
   * Reads data from socket input stream
   *
   * @param in DataInputStream
   * @return object
   * @throws IOException throws in case any error
   */
  public static Message read(DataInputStream in) throws IOException {
    int messageId = in.readInt();
    in.readChar();

    MessageIdentifier messageIdentifier = intToMessageId.get(messageId);
    return switch (messageIdentifier) {
      case CONNECT_MESSAGE -> readConnectMessage(in);
      case DISCONNECT_MESSAGE -> readDisconnectMessage(in);
      case DISCONNECT_RESPONSE -> readDisconnectResponseMessage(in);
      case QUERY_CONNECTED_USERS -> readQueryUsersMessage(in);
      case QUERY_USER_RESPONSE -> readQueryUsersResponse(in);
      case BROADCAST_MESSAGE -> readBroadcastMessage(in);
      case DIRECT_MESSAGE -> readDirectMessage(in);
      case FAILED_MESSAGE -> readFailedMessage(in);
      default -> readComplimentMessage(in);
    };
  }

  private static Message readFailedMessage(DataInputStream in) throws IOException {
    byte[] username = readArray(in);
    String str = new String(username, StandardCharsets.UTF_8);
    System.out.println("username = " + str);
    in.readChar();
    return new FailedMessage(username, readArray(in));
  }

  private static Message readComplimentMessage(DataInputStream in) throws IOException {
    byte[] username = readArray(in);
    in.readChar();
    byte[] recepient = readArray(in);
    //in.readChar();
    return new ComplimentMessage(username, recepient);//,readArray(in));
  }

  private static Message readDirectMessage(DataInputStream in) throws IOException {
    byte[] username = readArray(in);
    in.readChar();
    byte[] recepient = readArray(in);
    in.readChar();
    return new DirectMessage(username, recepient, readArray(in));
  }

  private static byte[] readArray(DataInputStream in) throws IOException {
    int size = in.readInt();
    in.readChar();
    byte[] username = new byte[size];
    in.readFully(username);
    return username;
  }

  private static ConnectMessage readConnectMessage(DataInputStream in) throws IOException {
    return new ConnectMessage(readArray(in));
  }

  private static DisconnectMessage readDisconnectMessage(DataInputStream in) throws IOException {
    return new DisconnectMessage(readArray(in));
  }

  private static ConnectResponse readDisconnectResponseMessage(DataInputStream in)
      throws IOException {
    boolean isSuccess = in.readBoolean();
    in.readChar();
    int size = in.readInt();
    in.readChar();
    byte[] messageContent = new byte[size];
    in.readFully(messageContent);
    return new ConnectResponse(isSuccess, messageContent);
  }

  private static QueryUsersMessage readQueryUsersMessage(DataInputStream in) throws IOException {
    return new QueryUsersMessage(readArray(in));
  }

  private static Message readQueryUsersResponse(DataInputStream in) throws IOException {
    int numOfUsers = in.readInt();
    List<byte[]> users = new ArrayList<>();
    for (int i = 0; i < numOfUsers; i++) {
      in.readChar();
      users.add(readArray(in));
    }

    return new QueryResponse(users);
  }

  private static BroadcastMessage readBroadcastMessage(DataInputStream in) throws IOException {
    byte[] username = readArray(in);
    in.readChar();
    return new BroadcastMessage(username, readArray(in));
  }
}
