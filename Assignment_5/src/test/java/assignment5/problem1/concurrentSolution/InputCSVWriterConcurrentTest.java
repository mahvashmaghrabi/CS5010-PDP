package assignment5.problem1.concurrentSolution;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class InputCSVWriterConcurrentTest {

  InputCSVWriterConcurrent writer;
  String filePath;

  @BeforeEach
  void setUp() {
    this.filePath = "./src/test/resources/test_Files";
    this.writer = new InputCSVWriterConcurrent(filePath + File.separator + "test_WriteFile.csv");
  }

  @Test
  void writeFile() {
    this.writer.writeFile("hello");
  }


  @Test
  void testEquals() {
    InputCSVWriterConcurrent source = new InputCSVWriterConcurrent(
        filePath + File.separator + "test_WriteFile.csv");
    InputCSVWriterConcurrent equal = source;
    assertTrue(source.equals(equal));
    InputCSVWriterConcurrent diffEqual = new InputCSVWriterConcurrent(
        filePath + File.separator + "test_WriteFile.csv");
    assertTrue(source.equals(diffEqual));
    InputCSVWriterConcurrent diffNotEqual = new InputCSVWriterConcurrent(
        filePath + File.separator + "test_Files.csv");
    assertFalse(source.equals(diffNotEqual));
    assertTrue(source.equals(source));
    assertFalse(source.equals(null));
  }

  @Test
  void testHashCode() {
    InputCSVWriterConcurrent source = new InputCSVWriterConcurrent(
        filePath + File.separator + "test_WriteFile.csv");
    assertTrue(source.hashCode() == new InputCSVWriterConcurrent(
        filePath + File.separator + "test_WriteFile.csv").hashCode());
    assertTrue(source.hashCode() != new InputCSVWriterConcurrent(
        filePath + File.separator + "test_Files.csv").hashCode());
    assertTrue(source.hashCode() == source.hashCode());
  }

  @Test
  void testToString() {
    InputCSVWriterConcurrent source = new InputCSVWriterConcurrent(
        filePath + File.separator + "test_WriteFile.csv");
    assertTrue(!source.toString().isEmpty());
    assertTrue(source.toString().contains("InputCSVWriterConcurrent{"));
  }
}