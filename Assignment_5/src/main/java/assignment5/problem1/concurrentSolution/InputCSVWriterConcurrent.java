package assignment5.problem1.concurrentSolution;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Objects;

/**
 * Represents an CSV file writer class
 */
public class InputCSVWriterConcurrent implements InputFileWriterConcurrent {

  private final String filePath;

  /**
   * Constructs an InputCSVWriterConcurrent using below ionformation
   *
   * @param filePath file path
   */
  public InputCSVWriterConcurrent(String filePath) {
    this.filePath = filePath;
  }

  /**
   * Creates new file with given file name and file contenty
   *
   * @param fileContent content of the file
   */
  @Override
  public synchronized void writeFile(String fileContent) {
    //   synchronized (this) {
    try (var bw = Files.newBufferedWriter(Paths.get(this.filePath))) {
      bw.write(fileContent);
    } catch (Exception ex) {
      System.out.println("Error occurred while writing file " + this.filePath);
      //ex.printStackTrace();
    }
    // }
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
    if (!(o instanceof InputCSVWriterConcurrent that)) {
      return false;
    }
    return filePath.equals(that.filePath);
  }

  /**
   * Returns a hashcode
   *
   * @return integer
   */
  @Override
  public int hashCode() {
    return Objects.hash(filePath);
  }

  /**
   * Represents a String representation of current class
   *
   * @return String
   */
  @Override
  public String toString() {
    return "InputCSVWriterConcurrent{" +
        "filePath='" + filePath + '\'' +
        '}';
  }
}
