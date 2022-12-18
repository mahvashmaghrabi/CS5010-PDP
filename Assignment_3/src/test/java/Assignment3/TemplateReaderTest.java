package Assignment3;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.io.*;
import java.io.Reader;


class TemplateReaderTest {
  private Customer CUSTOMER;
  private Address ADDRESS;
  private PersonalDetails PERSONAL_DETAILS;
  private int writeCalled = 0;
  private int newLineCalled = 0;
  private int readerNewLineCalled = 0;
  class MockBufferedReader extends BufferedReader {

    public MockBufferedReader(Reader in) {
      super(in);
    }

    public String readLine() throws IOException {
      readerNewLineCalled++;
      if (readerNewLineCalled < 5) {
        return "someString";
      }
      return null;
    }
  }
  class MockBufferedWriter extends BufferedWriter {
    public MockBufferedWriter(Writer out) {
      super(out);
    }

    @Override
    public void write(char[] cbuf, int off, int len) throws IOException {
      writeCalled++;
    }

    public void write(String str) throws IOException {
      writeCalled++;
    }

    @Override
    public void flush() throws IOException {

    }

    @Override
    public void close() throws IOException {

    }

    public void newLine() throws IOException {
      newLineCalled++;
    }
  }
  private BufferedWriter bufferedWriter;
  private BufferedReader bufferedReader;

  @BeforeEach
  void setUp() {
    ADDRESS = new Address("First Street", "Seattle", "King", "WA", 98109);
    PERSONAL_DETAILS = new PersonalDetails("235-123-1223", "", "johndoe@gmail.com", "someWeb");
    CUSTOMER = new Customer("John", "Doe", "First Company", ADDRESS, PERSONAL_DETAILS);

    writeCalled = 0;
    newLineCalled = 0;
    readerNewLineCalled = 0;

    try {
      bufferedWriter = new MockBufferedWriter(new FileWriter("D:\\Assignment3_NOJAR\\src\\main\\resources\\someFile.txt"));
      bufferedReader = new MockBufferedReader(new FileReader("D:\\Assignment3_NOJAR\\src\\main\\resources\\email-template.txt"));
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  @Test
  void readTemplate() {
    TemplateReader.readTemplate(bufferedReader, bufferedWriter, CUSTOMER);
    Assertions.assertEquals(5, readerNewLineCalled);
    Assertions.assertEquals(4, writeCalled);
    Assertions.assertEquals(4, newLineCalled);
  }

  @Test
  void writeTextToFile() {
    TemplateReader.writeTextToFile("someText", bufferedWriter, CUSTOMER);
    Assertions.assertEquals(1, writeCalled, "write called only once");
    Assertions.assertEquals(1, newLineCalled, "newLine called only once");
  }

  @Test
  void regex_StringMatches_ReturnsTrue() {
    Assertions.assertTrue(TemplateReader.regex("Some String with matching text [[first_name]]"));
    Assertions.assertTrue(TemplateReader.regex("Some String with matching text [[first_name]] and [[last_name]]"));
    Assertions.assertTrue(TemplateReader.regex("Some String with matching text ([[email]])"));
  }

  @Test
  void regex_StringNotMatches_ReturnsFalse() {
    Assertions.assertFalse(TemplateReader.regex("Some String with non matching text"));
    Assertions.assertFalse(TemplateReader.regex("Some String with non matching text [[first_name and [last_name]"));
    Assertions.assertFalse(TemplateReader.regex("Some String with non matching text (email)"));
  }

  @Test
  void replaceText_MatchingText_Replaced() {
    String textToReplace = "String with Matching text [[first_name]]";
    String replacedText = TemplateReader.replaceText(textToReplace, CUSTOMER);
    Assertions.assertEquals("String with Matching text John", replacedText);

    textToReplace = "String with Matching text [[first_name]] [[last_name]]";
    replacedText = TemplateReader.replaceText(textToReplace, CUSTOMER);
    Assertions.assertEquals("String with Matching text John Doe", replacedText);
  }

  @Test
  void replaceText_NonMatchingText_NotReplaced() {
    String textToReplace = "String with Matching text [[first_name";
    String replacedText = TemplateReader.replaceText(textToReplace, CUSTOMER);
    Assertions.assertEquals("String with Matching text [[first_name", replacedText);

    textToReplace = "String with Matching text first_name last_name";
    replacedText = TemplateReader.replaceText(textToReplace, CUSTOMER);
    Assertions.assertEquals("String with Matching text first_name last_name", replacedText);
  }
}