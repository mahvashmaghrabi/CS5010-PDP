package assignment6.problem1.Messages;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class QueryResponseTest {

  QueryResponse response;
  List<byte[]> userDetails;

  @BeforeEach
  void setUp() {
    this.userDetails = new ArrayList<>();
    this.userDetails.add("abc".getBytes(StandardCharsets.UTF_8));
    this.response = new QueryResponse(this.userDetails);
  }

  @Test
  void getUserDetails() {
    Assertions.assertNotNull(this.response.getUserDetails());
  }

  @Test
  void serialize() {
  }

  @Test
  void accept() {
  }

  @Test
  void testEquals() {
    QueryResponse EqualDM = new QueryResponse(this.userDetails);
    Assertions.assertTrue(this.response.equals(EqualDM));
    List<byte[]> str = new ArrayList<>();
    QueryResponse equalDiffDM = new QueryResponse(str);
    Assertions.assertTrue(this.response.equals(equalDiffDM));
    str.add("a".getBytes(StandardCharsets.UTF_8));
    Assertions.assertTrue(this.response.equals(equalDiffDM));
    QueryResponse equalDM = this.response;
    Assertions.assertTrue(this.response.equals(equalDM));
    Assertions.assertTrue(this.response.equals(this.response));
    Assertions.assertFalse(this.response.equals(null));
  }

  @Test
  void testHashCode() {
    Assertions.assertEquals(this.response.hashCode(), this.response.hashCode());
    Assertions.assertEquals(this.response.hashCode(),
        new QueryResponse(this.userDetails).hashCode());
    List<byte[]> str = new ArrayList<>();
    Assertions.assertEquals(this.response.hashCode(),
        new QueryResponse(str).hashCode());
  }

  @Test
  void testToString() {
    System.out.println(this.response.toString());
    Assertions.assertTrue(!this.response.toString().isEmpty());
    Assertions.assertTrue(this.response.toString().contains("Message{"));
  }
}