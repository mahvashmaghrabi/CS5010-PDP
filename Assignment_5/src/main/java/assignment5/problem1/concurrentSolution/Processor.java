package assignment5.problem1.concurrentSolution;

import java.time.Instant;
import java.util.Objects;
import java.util.regex.Pattern;

/**
 * Represents a Processor
 */
public class Processor implements Runnable {

  private final SharedFileData sharedFileData;

  /**
   * Constructs a Processor using below information
   *
   * @param sharedFileData file data as object
   */
  public Processor(SharedFileData sharedFileData) {
    this.sharedFileData = sharedFileData;
  }

  /**
   * When an object implementing interface {@code Runnable} is used to create a thread, starting the
   * thread causes the object's {@code run} method to be called in that separately executing
   * thread.
   * <p>
   * The general contract of the method {@code run} is that it may take any action whatsoever.
   *
   * @see Thread#run()
   */
  @Override
  public void run() {
    System.out.println(Thread.currentThread() + ": Checking to start Processor course data size = "
        + this.sharedFileData.getCourseData().size());

    while (true) {
      boolean isReaderDone = this.sharedFileData.isReaderDone();

      while (!this.sharedFileData.getCourseData().isEmpty()) {
        try {
          String courseData = this.sharedFileData.getCourseData().take();

          if (!courseData.trim().isBlank() && courseData.length() > 0) {
            String[] lineArray = courseData.split(",");

            if (lineArray[2] != null && !lineArray[2].trim().isBlank() &&
                Pattern.compile("-?\\d+(\\.\\d+)?").matcher(lineArray[2].trim()).matches()) {
              int numberOfClicks = Integer.parseInt(lineArray[2]);
              if (numberOfClicks >= this.sharedFileData.getThresholdValue()) {
                this.sharedFileData.setResult(courseData);
              }
            }
          }
        } catch (InterruptedException e) {
          System.out.println(e.getMessage());
        }
      }

      if (isReaderDone) {
        this.sharedFileData.setProcessDone(true);
        System.out.println("Ending Processor as no student data to process .. ");
        System.out.println("Processor End Time = " + Instant.now() + "\n");
        return;
      }
    }
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
    if (!(o instanceof Processor processor)) {
      return false;
    }
    return sharedFileData.equals(processor.sharedFileData);
  }

  /**
   * Returns a hashcode
   *
   * @return integer
   */
  @Override
  public int hashCode() {
    return Objects.hash(sharedFileData);
  }

  /**
   * Represents a String representation of current class
   *
   * @return String
   */
  @Override
  public String toString() {
    return "Processor{" + "sharedFileData=" + sharedFileData +
        '}';
  }
}
