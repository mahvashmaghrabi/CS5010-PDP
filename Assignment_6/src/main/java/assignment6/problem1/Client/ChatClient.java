package assignment6.problem1.Client;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

/**
 * Represents a ChatClient
 */
public class ChatClient {

  /**
   * Starts connection
   *
   * @param hostname   hostname
   * @param portNumber port
   */
  public void startConnection(String hostname, String portNumber) {
    try {
      var clientSocket = new Socket(hostname, Integer.parseInt(portNumber));
      BufferedReader stdinReader = new BufferedReader(new InputStreamReader(System.in));
      System.out.println("Enter the Username : ");
      var username = stdinReader.readLine();
      var outputStream = new DataOutputStream(clientSocket.getOutputStream());
      var inputStream = new DataInputStream(clientSocket.getInputStream());
      var serverResponseHandler = new ServerResponseHandler(
          inputStream,
          outputStream,
          username.getBytes(StandardCharsets.UTF_8));

      serverResponseHandler.start();

      serverResponseHandler.join();
    } catch (IOException | InterruptedException ex) {
      System.out.println("Connection broken. Following is the cause");
      System.out.println(ex.getMessage());
    }
  }
}
