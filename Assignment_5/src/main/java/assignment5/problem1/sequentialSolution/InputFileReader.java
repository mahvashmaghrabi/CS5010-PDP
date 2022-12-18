package assignment5.problem1.sequentialSolution;

import java.util.List;

/**
 * Represents common File reader
 */
public abstract class InputFileReader {

  /**
   * Constructs default Input file reader
   */
  public InputFileReader() {
  }

  /**
   * Returns the contents of the file
   *
   * @param csvFilePath file path of CSV expressed as a Path
   * @return all data in List of String arrays
   */
  public abstract List<String> readFile(String csvFilePath);

  /**
   * Writes the contents to the given file name
   *
   * @param csvFilePath file path of CSV expressed as a Path
   * @param contents    file contents to be written
   */
  public abstract void writeFile(String csvFilePath, String contents);

  /**
   * Generates hashcode of class object
   *
   * @return integer
   */

  @Override
  public int hashCode() {
    return super.hashCode();
  }

  /**
   * Checks equality of same type of different objects
   *
   * @param obj current class object
   * @return true if matches, else false
   */

  @Override
  public boolean equals(Object obj) {
    return super.equals(obj);
  }

  /**
   * String representation of the class
   *
   * @return String
   */

  @Override
  public String toString() {
    return super.toString();
  }
}
