package assignment6.problem1.Client;

import java.io.IOException;
import java.net.ServerSocket;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ChatClientTest {

  String hostname = "localhost";
  String port = "2050";
  String username = "test";
  ChatClient client;

  @BeforeEach
  void setUp() {
    this.client = new ChatClient();

  }

  @Test
  void startConnection() throws IOException {
//    Thread thread = new Thread(this::startConnection);
//    thread.start();
//    Thread.currentThread().interrupt();
    ServerSocket socket = new ServerSocket(2050);
    socket.close();
    this.client.startConnection(hostname, port);
    // socket.close();
  }

}