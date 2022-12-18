package assignment5.problem1.concurrentSolution;

/**
 * Represents an CSV file writer class
 */
public interface InputFileWriterConcurrent {

  /**
   * Creates new file with given file name and file contenty
   *
   * @param contents content of the file
   */
  void writeFile(String contents);
}
