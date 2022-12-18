package assignment5.problem1.concurrentSolution;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Objects;
import java.util.Scanner;

/**
 * Represents CSV reader class with default lines to skip
 */
public class InputCSVReaderConcurrent implements InputFileReaderConcurrent {

  private final Scanner fileScanner;

  /**
   * Constructs a default CSV reader
   *
   * @param filePath path
   * @throws FileNotFoundException if file is not found in given file path
   */
  public InputCSVReaderConcurrent(String filePath) throws FileNotFoundException {
    this.fileScanner = new Scanner(
        new InputStreamReader(
            new FileInputStream(filePath),
            StandardCharsets.UTF_8));
  }

  /**
   * Returns the contents of the file
   *
   * @return all data in List of String
   */
  @Override
  public String readLine() {
    synchronized (this) {
      return fileScanner.nextLine();
    }
  }

  /**
   * Returns if it has line to read
   *
   * @return true if it has line
   */
  @Override
  public boolean hasLine() {
    return fileScanner.hasNextLine();
  }

  /**
   * Compares current and parameter object
   *
   * @param o Object
   * @return true if equal else false
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof InputCSVReaderConcurrent that)) {
      return false;
    }
    return fileScanner.equals(that.fileScanner);
  }

  /**
   * Returns a hashcode
   *
   * @return integer
   */
  @Override
  public int hashCode() {
    return Objects.hash(fileScanner);
  }

  /**
   * Represents a String representation of current class
   *
   * @return String
   */
  @Override
  public String toString() {
    return "InputCSVReaderConcurrent{" +
        "fileScanner=" + fileScanner +
        '}';
  }
}
