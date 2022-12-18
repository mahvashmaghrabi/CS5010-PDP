package assignment6.problem1.Messages;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MessageDeserializerTest {

  private DataOutputStream dout;
  private ByteArrayOutputStream bos;


  @BeforeEach
  void setUp() {
    bos = new ByteArrayOutputStream(2000);
    dout = new DataOutputStream(bos);
  }

  @Test
  void read_ConnectMessage() throws IOException {
    ConnectMessage message = new ConnectMessage("Bar".getBytes(StandardCharsets.UTF_8));
    message.serialize(dout);
    DataInputStream din = new DataInputStream(new ByteArrayInputStream(bos.toByteArray()));
    Assertions.assertEquals(MessageDeserializer.read(din), message);
  }

  @Test
  void read_DisconnectMessage() throws IOException {
    DisconnectMessage message = new DisconnectMessage("Bar".getBytes(StandardCharsets.UTF_8));
    message.serialize(dout);
    DataInputStream din = new DataInputStream(new ByteArrayInputStream(bos.toByteArray()));
    Assertions.assertEquals(MessageDeserializer.read(din), message);
  }

  @Test
  void read_DisconnectResponse() throws IOException {
    ConnectResponse message = new ConnectResponse(true, "Bar".getBytes(StandardCharsets.UTF_8));
    message.serialize(dout);
    DataInputStream din = new DataInputStream(new ByteArrayInputStream(bos.toByteArray()));
    Assertions.assertEquals(MessageDeserializer.read(din), message);
  }

  @Test
  void read_QueryUsersMessage() throws IOException {
    QueryUsersMessage message = new QueryUsersMessage("Bar".getBytes(StandardCharsets.UTF_8));
    message.serialize(dout);
    DataInputStream din = new DataInputStream(new ByteArrayInputStream(bos.toByteArray()));
    Assertions.assertEquals(MessageDeserializer.read(din), message);
  }

  @Test
  void read_QueryResponse() throws IOException {
    QueryResponse message = new QueryResponse(
        Stream.of("bar", "baz")
            .map(s -> s.getBytes(StandardCharsets.UTF_8))
            .collect(Collectors.toList()));

    message.serialize(dout);
    DataInputStream din = new DataInputStream(new ByteArrayInputStream(bos.toByteArray()));
    Assertions.assertEquals(MessageDeserializer.read(din), message);
  }

  @Test
  void read_BroadcastMessage() throws IOException {
    BroadcastMessage message = new BroadcastMessage("bar".getBytes(StandardCharsets.UTF_8),
        "baz".getBytes(StandardCharsets.UTF_8));

    message.serialize(dout);
    DataInputStream din = new DataInputStream(new ByteArrayInputStream(bos.toByteArray()));
    Assertions.assertEquals(MessageDeserializer.read(din), message);
  }

  @Test
  void read_DirectMessage() throws IOException {
    DirectMessage message = new DirectMessage("bar".getBytes(StandardCharsets.UTF_8),
        "baz".getBytes(StandardCharsets.UTF_8), "foo".getBytes(StandardCharsets.UTF_8));

    message.serialize(dout);
    DataInputStream din = new DataInputStream(new ByteArrayInputStream(bos.toByteArray()));
    Assertions.assertEquals(MessageDeserializer.read(din), message);
  }

  @Test
  void read_FailedMessage() throws IOException {
    FailedMessage message = new FailedMessage("bar".getBytes(StandardCharsets.UTF_8),
        "baz".getBytes(StandardCharsets.UTF_8));

    message.serialize(dout);
    DataInputStream din = new DataInputStream(new ByteArrayInputStream(bos.toByteArray()));
    Assertions.assertEquals(MessageDeserializer.read(din), message);
  }

  @Test
  void read_ComplimentMessage() throws IOException {
    ComplimentMessage message = new ComplimentMessage("bar".getBytes(StandardCharsets.UTF_8),
        "baz".getBytes(StandardCharsets.UTF_8));

    message.serialize(dout);
    DataInputStream din = new DataInputStream(new ByteArrayInputStream(bos.toByteArray()));
    Assertions.assertEquals(MessageDeserializer.read(din), message);
  }
}