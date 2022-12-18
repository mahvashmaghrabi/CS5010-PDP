package Assignment3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonalDetailsTest {
  private PersonalDetails personal;

  @BeforeEach
  void setUp() {
    this.personal = new PersonalDetails("12345","678910","abc@gmail.com","www.java.com");
  }

  @Test
  void getPhone1() {
    Assertions.assertEquals("12345", this.personal.getPhone1());

  }

  @Test
  void setPhone1() {
    this.personal.setPhone1("45678");
    Assertions.assertEquals("45678", this.personal.getPhone1());
  }

  @Test
  void getPhone2() {
    Assertions.assertEquals("678910", this.personal.getPhone2());
  }

  @Test
  void setPhone2() {
    this.personal.setPhone2("34567");
    Assertions.assertEquals("34567", this.personal.getPhone2());
  }

  @Test
  void getEmail() {
    Assertions.assertEquals("abc@gmail.com", this.personal.getEmail());

  }

  @Test
  void setEmail() {
    this.personal.setEmail("xyz@gmail.com");
    Assertions.assertEquals("xyz@gmail.com", this.personal.getEmail());
  }

  @Test
  void getWeb() {
    Assertions.assertEquals("www.java.com", this.personal.getWeb());

  }

  @Test
  void setWeb() {
    this.personal.setWeb("www.javatutorial.com");
    Assertions.assertEquals("www.javatutorial.com", this.personal.getWeb());
  }
}