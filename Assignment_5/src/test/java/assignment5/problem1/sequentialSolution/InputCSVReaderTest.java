package assignment5.problem1.sequentialSolution;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class InputCSVReaderTest {

  InputCSVReader reader;

  @BeforeEach
  void setUp() {
    this.reader = new InputCSVReader();
  }


  @Test
  void readFile() {
    List<String> list = this.reader.readFile(
        "./src/test/resources/test_Files" + File.separator + "courses.csv");
    assertTrue(list.size() > 0);
  }

  @Test
  void readFile_FileNotFound() {
    //   "./test_Files/throwFileNotFound.txt"
    List<String> res = this.reader.readFile(
        "./src/test/resources/test_Files" + File.separator + "throwFileNotFound.txt");
    Assertions.assertEquals(0, res.size());
  }

  @Test
  void writeFile_Positive() {
    this.reader.writeFile(
        "./src/test/resources/test_Files" + File.separator + "test_WriteFile.csv",
        "Hello");
  }

  @Test
  void testEquals() {
    InputCSVReader equalInputCSVReader = this.reader;
    Assertions.assertTrue(this.reader.equals(equalInputCSVReader));
    InputCSVReader diffEqualTitle = new InputCSVReader();
    Assertions.assertFalse(this.reader.equals(diffEqualTitle));
    Assertions.assertTrue(this.reader.equals(this.reader));
    Assertions.assertFalse(this.reader.equals(null));
  }

  @Test
  void testHashCode() {
    Assertions.assertTrue(this.reader.hashCode() != new InputCSVReader().hashCode());
    Assertions.assertTrue(this.reader.hashCode() == this.reader.hashCode());
  }

  @Test
  void testToString() {
    Assertions.assertTrue(!this.reader.toString().isEmpty());
    Assertions.assertTrue(this.reader.toString().contains("InputCSVReader"));
  }
}