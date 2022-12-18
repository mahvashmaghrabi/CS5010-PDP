package assignment5.problem1.concurrentSolution;

import java.util.Objects;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Represents a Shared data for file read and write purpose
 */
public class SharedFileData {

  private final int thresholdValue;
  private final BlockingQueue<String> fileData;
  private final BlockingQueue<String> result;
  private boolean isReaderDone;
  private boolean isProcessDone;

  /**
   * Constructs a Shared file data object using below information
   *
   * @param thresholdValue threshold value
   */
  public SharedFileData(int thresholdValue) {
    this.fileData = new LinkedBlockingQueue<>();
    this.isReaderDone = false;
    this.isProcessDone = false;
    this.result = new LinkedBlockingQueue<>();
    this.thresholdValue = thresholdValue;

    this.result.add("module_presentation, date, total_clicks");
  }

  /**
   * Returns process done
   *
   * @return boolean
   */
  public boolean isProcessDone() {
    return this.isProcessDone;
  }

  /**
   * Sets a process true or false
   *
   * @param processDone boolean
   */
  public void setProcessDone(boolean processDone) {
    isProcessDone = processDone;
  }

  /**
   * Adds course data to blocking queue
   *
   * @param courseData String
   */
  public void addCourseData(String courseData) {
    this.fileData.add(courseData);
  }

  /**
   * Returns a file data
   *
   * @return blocking queue
   */
  public BlockingQueue<String> getCourseData() {
    return this.fileData;
  }

  /**
   * Sets to a boolean value if reading file task is done
   *
   * @param doneOrNot boolean
   */
  public synchronized void setIsReaderDone(boolean doneOrNot) {
    this.isReaderDone = doneOrNot;
  }

  /**
   * Returns a boolean if reading course file task is done
   *
   * @return boolean
   */
  public synchronized boolean isCourseDone() {
    return this.isReaderDone;
  }

  /**
   * Returns a boolean if reading file task is done
   *
   * @return boolean
   */
  public boolean isReaderDone() {
    return this.isReaderDone;
  }

  /**
   * Returns final file contents
   *
   * @return string builder
   */
  public synchronized BlockingQueue<String> getResult() {
    return this.result;
  }

  /**
   * Appends a string to a result
   *
   * @param result as StringBuilder
   */
  public void setResult(String result) {
    this.result.add(result);
  }

  /**
   * Returns a threshold value
   *
   * @return int
   */
  public synchronized int getThresholdValue() {
    return this.thresholdValue;
  }

  /**
   * Checks equality of same type of different objects
   *
   * @param o current class object
   * @return true if matches, else false
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof SharedFileData that)) {
      return false;
    }
    return getThresholdValue() == that.getThresholdValue()
        && isReaderDone() == that.isReaderDone()
        && isProcessDone() == that.isProcessDone()
        && fileData.equals(that.fileData)
        && getResult().equals(that.getResult());
  }

  /**
   * Generates hashcode of class object
   *
   * @return integer
   */
  @Override
  public int hashCode() {
    return Objects.hash(getThresholdValue(), fileData, getResult(), isReaderDone(),
        isProcessDone());
  }

  /**
   * String representation of the class
   *
   * @return String
   */
  @Override
  public String toString() {
    return "SharedFileData{" +
        "thresholdValue=" + thresholdValue +
        ", fileData=" + fileData +
        ", result=" + result +
        ", isReaderDone=" + isReaderDone +
        ", isProcessDone=" + isProcessDone +
        '}';
  }
}
