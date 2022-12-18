package assignment6.problem1.Server;

import assignment6.problem1.Messages.BroadcastMessage;
import assignment6.problem1.Messages.ComplimentMessage;
import assignment6.problem1.Messages.ConnectMessage;
import assignment6.problem1.Messages.ConnectResponse;
import assignment6.problem1.Messages.DirectMessage;
import assignment6.problem1.Messages.DisconnectMessage;
import assignment6.problem1.Messages.FailedMessage;
import assignment6.problem1.Messages.QueryResponse;
import assignment6.problem1.Messages.QueryUsersMessage;

/**
 * Represents interface of different message handlers methods
 */
public interface MessageHandler {

  /**
   * Handler for connect message
   *
   * @param connectMessage object
   */
  default void handleMessage(ConnectMessage connectMessage) {
    throw new UnsupportedOperationException();
  }

  /**
   * Handler for disconnect message
   *
   * @param message disconnect message
   */
  default void handleMessage(DisconnectMessage message) {
    throw new UnsupportedOperationException();
  }

  /**
   * Handler for Connect Response
   *
   * @param message Connect Response
   */
  default void handleMessage(ConnectResponse message) {
    throw new UnsupportedOperationException();
  }

  /**
   * Handler for Query Users Response message
   *
   * @param message Query Users Response message
   */
  default void handleMessage(QueryUsersMessage message) {
    throw new UnsupportedOperationException();
  }

  /**
   * Handler for Query Response message
   *
   * @param message Query Response message
   */
  default void handleMessage(QueryResponse message) {
    throw new UnsupportedOperationException();
  }

  /**
   * Handler for Broadcast Message
   *
   * @param broadcastMessage Broadcast Message
   */
  default void handleMessage(BroadcastMessage broadcastMessage) {
    throw new UnsupportedOperationException();
  }

  /**
   * Handler for Direct message
   *
   * @param directMessage Direct Message
   */
  default void handleMessage(DirectMessage directMessage) {
    throw new UnsupportedOperationException();
  }

  /**
   * Handler for Compliment Message
   *
   * @param complimentMessage Compliment Message
   */
  default void handleMessage(ComplimentMessage complimentMessage) {
    throw new UnsupportedOperationException();
  }

  /**
   * handler for Failed Message
   *
   * @param failedMessage Failed Message
   */
  default void handleMessage(FailedMessage failedMessage) {
    throw new UnsupportedOperationException();
  }
}
