package assignment5.problem1.concurrentSolution;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Instant;
import java.util.Objects;

/**
 * Represents a Consumer class
 */
public class Consumer implements Runnable {

  private static final String OUTPUT_DIR = "out_ConcurrentSolution";
  private static final String OUT_FILENAME = "activity-";
  private final SharedFileData sharedFileData;
  private final StringBuilder result;

  /**
   * Constructs a Consumer object using below information
   *
   * @param sharedFileData share file data as Object
   */
  public Consumer(SharedFileData sharedFileData) {
    this.sharedFileData = sharedFileData;
    this.result = new StringBuilder();
  }

  /**
   * Writes file contents in give file name
   */
  private void writeFile() {
    String absolutePath = Paths.get(OUTPUT_DIR).toAbsolutePath().toString();

    String fileNameWithPath =
        absolutePath + File.separator + OUT_FILENAME + this.sharedFileData.getThresholdValue()
            + ".csv";
    try {
      if (!Files.exists(Path.of(absolutePath))) {
        new File(absolutePath).mkdirs();
      }
      if (!Files.exists(Path.of(fileNameWithPath))) {
//        new File(absolutePath).mkdirs();
        File file = new File(fileNameWithPath);
        file.getParentFile().mkdirs();
        file.createNewFile();
      }
    } catch (IOException e) {
      System.out.println(e.getMessage());
    }
    //System.out.println(">>>> output file path = " + fileName);
    InputFileWriterConcurrent writer = new InputCSVWriterConcurrent(fileNameWithPath);
    writer.writeFile(result.toString());
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
    System.out.println(Thread.currentThread() +
        ": Checking to start Consumer student data map size = " + this.sharedFileData.getResult());
    while (true) {
      //System.out.println("this.sharedFileData.isProcessDone()");
      boolean isProcessDone = this.sharedFileData.isProcessDone();
      while (!this.sharedFileData.getResult().isEmpty()) {
        System.out.println("Consumer starting appending Start Time = " + Instant.now() + "\n");
        System.out.println("Consumer started as size of result = "
            + this.sharedFileData.getResult().size());

        try {
          result.append(this.sharedFileData.getResult().take())
              .append("\n");
        } catch (InterruptedException e) {
          System.out.println(e.getMessage());
          //e.printStackTrace();
        }
        System.out.println("Consumer done appending End Time = " + Instant.now() + "\n");
      }

      if (isProcessDone) {
        writeFile();
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
    if (!(o instanceof Consumer consumer)) {
      return false;
    }
    return sharedFileData.equals(consumer.sharedFileData);
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
    return "Consumer{" +
        "sharedFileData=" + sharedFileData +
        '}';
  }
}
