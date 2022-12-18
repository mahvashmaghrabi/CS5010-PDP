package assignment6.problem1.Messages;

import java.nio.charset.StandardCharsets;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ConnectResponseTest {

  ConnectResponse connectResponse;

  @BeforeEach
  void setUp() {
    this.connectResponse = new ConnectResponse(true,
        "hello".getBytes(StandardCharsets.UTF_8));
  }

  @Test
  void accept() {
  }

  @Test
  void testToString() {
    Assertions.assertTrue(!this.connectResponse.toString().isEmpty());
    Assertions.assertTrue(this.connectResponse.toString().contains("ConnectResponse{"));
  }

  @Test
  void testHashCode() {
    Assertions.assertEquals(this.connectResponse.hashCode(), this.connectResponse.hashCode());
    Assertions.assertNotEquals(this.connectResponse.hashCode(),
        new BroadcastMessage("s".getBytes(StandardCharsets.UTF_8),
            "fr".getBytes(StandardCharsets.UTF_8)).hashCode());
  }

  @Test
  void testEquals() {
    ConnectResponse EqualBCM = new ConnectResponse(true,
        "hello".getBytes(StandardCharsets.UTF_8));
    Assertions.assertTrue(this.connectResponse.equals(EqualBCM));
    ConnectResponse notEqualDiffBCM = new ConnectResponse(false,
        "s".getBytes(StandardCharsets.UTF_8));
    Assertions.assertTrue(this.connectResponse.equals(notEqualDiffBCM));

    Assertions.assertTrue(this.connectResponse.equals(this.connectResponse));
    Assertions.assertFalse(this.connectResponse.equals(null));
  }
}