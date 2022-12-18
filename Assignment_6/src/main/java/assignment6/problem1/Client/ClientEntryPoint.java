package assignment6.problem1.Client;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Represents a ClientEntryPoint
 */
public class ClientEntryPoint {

  /**
   * Boots the client process by taking host, port and username from keyboard
   *
   * @param args args
   */
  public static void main(String[] args) {
    ChatClient chatClient = new ChatClient();
    try (BufferedReader stdinReader = new BufferedReader(new InputStreamReader(System.in))) {
      System.out.println("Enter the Host Name : ");
      String hostName = stdinReader.readLine();

      System.out.println("Enter the Port Number : ");
      String portStr = stdinReader.readLine();

      chatClient.startConnection(hostName, portStr);
    } catch (Exception ex) {
      System.out.println("Error occurred while attempting to make a connection." + ex.getMessage());
    }
  }
}
