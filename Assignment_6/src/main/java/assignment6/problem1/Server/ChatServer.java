package assignment6.problem1.Server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Represents a ChatClient
 */
public class ChatServer {

  /**
   * Starts a server for connection to client
   *
   * @param portNumber as integer
   */
  public void openPortForConnection(int portNumber) {
    ServerSocket serverSocket = null;
    try {
      serverSocket = new ServerSocket(portNumber);
    } catch (IOException e) {
      System.out.println("Error occurred while opening socket for connection");
    }
    System.out.printf("ChatServer running at port: %s.%n", portNumber);

    ServerHandler serverHandler = new ServerHandler();
    Thread serverHandlerThread = new Thread(serverHandler);
    serverHandlerThread.start();
    keepListeningNewConnections(serverSocket, serverHandler);
  }

  private void keepListeningNewConnections(ServerSocket serverSocket, ServerHandler serverHandler) {

    while (true) {
      try {
        if (serverSocket == null) {
          throw new RuntimeException("Socket not provided");
        }

        Socket clientSocket = serverSocket.accept();
        new Client(serverHandler, clientSocket.getInputStream(), clientSocket.getOutputStream());

      } catch (IOException e) {
        System.out.println(e.getMessage());
      }
    }
  }
}