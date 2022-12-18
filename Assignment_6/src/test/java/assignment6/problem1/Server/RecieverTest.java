package assignment6.problem1.Server;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RecieverTest {

  Reciever reciever;
  private ByteArrayOutputStream bos;
  private ByteArrayInputStream bin;
  private ServerHandler serverHandler;

  @BeforeEach
  void setUp() throws IOException {
    ServerHandler serverHandler = new ServerHandler();
    new Thread(serverHandler).start();
    bos = new ByteArrayOutputStream(2000);
    bin = new ByteArrayInputStream(new byte[2000]);
    reciever = new Reciever(bin, new Client(serverHandler, bin, bos));
  }

  @Test
  void run() {
    Thread.currentThread().interrupt();
    // reciever.interrupt();
    reciever.run();
  }

  @Test
  void testToString() {
    System.out.println(this.reciever.toString());
    Assertions.assertTrue(!this.reciever.toString().isEmpty());
    Assertions.assertTrue(this.reciever.toString().contains("Thread"));
  }

  @Test
  void testHashCode() throws IOException {
    Assertions.assertEquals(this.reciever.hashCode(), this.reciever.hashCode());
    Assertions.assertNotEquals(this.reciever.hashCode(),
        new Reciever(bin, new Client(serverHandler, bin, bos)).hashCode());
  }

  @Test
  void testEquals() throws IOException {
    Reciever EqualCM = new Reciever(bin, new Client(serverHandler, bin, bos));
    Assertions.assertFalse(this.reciever.equals(EqualCM));
    Reciever notEqualDiffCM = new Reciever(bin, new Client(serverHandler, bin, bos));
    Assertions.assertFalse(this.reciever.equals(notEqualDiffCM));

    Reciever equalCM = this.reciever;
    Assertions.assertTrue(this.reciever.equals(equalCM));

    Assertions.assertTrue(this.reciever.equals(this.reciever));
    Assertions.assertFalse(this.reciever.equals(null));
  }
}