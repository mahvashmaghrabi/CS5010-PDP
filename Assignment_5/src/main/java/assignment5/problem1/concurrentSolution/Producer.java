package assignment5.problem1.concurrentSolution;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Instant;
import java.util.Objects;

/**
 * Represents a Producer class
 */
public class Producer implements Runnable {

  private final SharedFileData sharedFileData;
  private final String inputFolderPath;

  /**
   * Constructs a Producer object using below information
   *
   * @param sharedFileData  Shared file data object
   * @param inputFolderPath input folder path
   */
  public Producer(SharedFileData sharedFileData, String inputFolderPath) {
    this.sharedFileData = sharedFileData;
    this.inputFolderPath = inputFolderPath;
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
//    System.out.println("Producer thread : "+Thread.currentThread());
    try {
      System.out.println("Producer Start Time = " + Instant.now() + "\n");
      File file = new File(this.inputFolderPath);

      for (var path : Objects.requireNonNull(file.list())) {
        var filePath = Paths.get(file.getAbsolutePath() + File.separator + path);

        if (Files.isRegularFile(filePath)) {
          InputFileReaderConcurrent fileReader = new InputCSVReaderConcurrent(filePath.toString());
          fileReader.readLine();
          while (fileReader.hasLine()) {
            String str = fileReader.readLine();
            if (str != null && !str.trim().isBlank()) {
              String fileContentWithFilename = path.replaceAll(".csv", "") + "," + str.trim();
              this.sharedFileData.addCourseData(fileContentWithFilename);
            }
          }
        }
      }

      this.sharedFileData.setIsReaderDone(true);
//        System.out.println("Exiting Producer .. Reading done for both files ..");
      System.out.println("Producer End Time = " + Instant.now() + "\n");
    } catch (FileNotFoundException e) {
      System.out.println(e.getMessage());
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
    if (!(o instanceof Producer producer)) {
      return false;
    }
    return sharedFileData.equals(producer.sharedFileData);
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
    return "Producer{" +
        "sharedFileData=" + sharedFileData +
        '}';
  }
}
