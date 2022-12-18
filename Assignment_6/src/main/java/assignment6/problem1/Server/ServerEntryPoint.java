package assignment6.problem1.Server;

/**
 * Represents a Server entry point
 */
public class ServerEntryPoint {

  private static final int LISTENING_ON_PORT = 2050;

  /**
   * Boots the server process by blocking rest process to listen for new connection at first, then
   * runs in continuous loop for more connections
   *
   * @param args args
   */
  public static void main(String[] args) {
    ChatServer server = new ChatServer();
    server.openPortForConnection(LISTENING_ON_PORT);
  }
}
