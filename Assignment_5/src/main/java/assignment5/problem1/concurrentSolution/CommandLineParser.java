package assignment5.problem1.concurrentSolution;


import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Represents a Command line parser
 */
public class CommandLineParser {

  /**
   * Parses commands from command line
   *
   * @param args args passed in command line
   * @return list
   */
  public static String parseCommand(String[] args) {
    if (args == null || args.length == 0) {
      throw new RuntimeException("Arguments can not be null");
    }
    String folderPath;
    if (!Files.isDirectory(Paths.get(args[0]))) {
      throw new RuntimeException("Please enter valid directory name.");
    } else {
      folderPath = Paths.get(args[0]).toAbsolutePath().toString();
    }

    try {
      if (isEmpty(Path.of(folderPath))) {
        throw new RuntimeException(
            "The given directory name does not have any file. Please start over");
      }
    } catch (IOException e) {
      return e.getMessage();
    }
    if (!args[1].matches("-?\\d+(\\.\\d+)?")) {
      throw new RuntimeException("Threshold Value should be a number");
    }
    return folderPath;
  }

  /**
   * Checks if a Directory Is Empty
   *
   * @param path folder path
   * @return true if it has files
   * @throws IOException throws in case any error occurs
   */
  private static boolean isEmpty(Path path) throws IOException {
    if (Files.isDirectory(path)) {
      try (DirectoryStream<Path> directory = Files.newDirectoryStream(path)) {
        return !directory.iterator().hasNext();
      }
    }

    return false;
  }


  /**
   * String representation of the class
   *
   * @return String
   */
  @Override
  public String toString() {
    return "CommandLineParser{}";
  }

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
   * Indicates whether some other object is "equal to" this one.
   *
   * @param obj the reference object with which to compare.
   */
  @Override
  public boolean equals(Object obj) {
    return super.equals(obj);
  }
}
