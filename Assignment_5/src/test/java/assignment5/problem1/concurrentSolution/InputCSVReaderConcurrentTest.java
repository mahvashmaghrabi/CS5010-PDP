package assignment5.problem1.concurrentSolution;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;
import java.io.FileNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class InputCSVReaderConcurrentTest {

  InputCSVReaderConcurrent reader;
  String filePath;

  @BeforeEach
  void setUp() throws FileNotFoundException {
    this.filePath = "./src/test/resources/test_Files";
    this.reader = new InputCSVReaderConcurrent(filePath + File.separator + "test_WriteFile.csv");
  }

  @Test
  void readLine() {
    this.reader.readLine();
  }

  @Test
  void hasLine() {
    assertTrue(this.reader.hasLine());
  }

  @Test
  void testEquals() throws FileNotFoundException {
    InputCSVReaderConcurrent source = new InputCSVReaderConcurrent(
        filePath + File.separator + "test_WriteFile.csv");
    InputCSVReaderConcurrent equal = source;
    assertTrue(source.equals(equal));
    InputCSVReaderConcurrent diffEqual = new InputCSVReaderConcurrent(
        filePath + File.separator + "test_WriteFile.csv");
    assertFalse(source.equals(diffEqual));
    assertTrue(source.equals(source));
    assertFalse(source.equals(null));
  }

  @Test
  void testHashCode() throws FileNotFoundException {
    InputCSVReaderConcurrent source = new InputCSVReaderConcurrent(
        filePath + File.separator + "test_WriteFile.csv");
    assertTrue(source.hashCode() != new InputCSVReaderConcurrent(
        filePath + File.separator + "test_WriteFile.csv").hashCode());
    assertTrue(source.hashCode() == source.hashCode());
  }

  @Test
  void testToString() throws FileNotFoundException {
    InputCSVReaderConcurrent source = new InputCSVReaderConcurrent(
        filePath + File.separator + "test_WriteFile.csv");
    assertTrue(!source.toString().isEmpty());
    assertTrue(source.toString().contains("InputCSVReaderConcurrent{"));
  }
}