package assignment5.problem1.concurrentSolution;

/**
 * Represents an Interface of file reader
 */
public interface InputFileReaderConcurrent {

  /**
   * Returns the contents of the file
   *
   * @return all data in List of String
   */
  String readLine();

  /**
   * Returns if it has line to read
   *
   * @return true if it has line
   */
  boolean hasLine();
}
