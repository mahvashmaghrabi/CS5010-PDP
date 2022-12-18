package assignment5.problem1.sequentialSolution;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * Represents a Command line parser
 */
public class CommandLineParser {

  private static final String STUDENT_FILE_NAME = "studentVle.csv";
  private static final String COURSES_FILE_NAME = "courses.csv";

  /**
   * Parses commands from command line
   *
   * @param args args passed in command line
   * @return list
   */
  public static List<String> parseCommand(String[] args) {
    if (args == null || args.length == 0) {
      throw new RuntimeException("Arguments can not be null");
    }
    String folderPath;
    if (!Files.isDirectory(Paths.get(args[0]))) {
      throw new RuntimeException("Please enter valid directory name.");
    } else {
      folderPath = Paths.get(args[0]).toAbsolutePath().toString();
    }

    return getFileNames(folderPath);
  }

  /**
   * Gets the file names from the given directory
   *
   * @param directoryPath where the grammar files are stored
   * @return filenames
   */
  private static List<String> getFileNames(String directoryPath) {
    File f = new File(directoryPath);

    var pathNames = f.list();
    List<String> files = new ArrayList<>();
    if (pathNames == null || pathNames.length == 0) {
      throw new RuntimeException(
          "The given directory name does not have any file. Please start over");
    } else {
      for (String pathName : pathNames) {
        StringBuilder sb = new StringBuilder();
        sb.append(f.getAbsolutePath()).append(File.separator).append(pathName);
        var filePath = Paths.get(sb.toString());
        if (!Files.isRegularFile(filePath) || (!pathName.equals(STUDENT_FILE_NAME)
            && !pathName.equals(COURSES_FILE_NAME))) {
          continue;
        }
        files.add(filePath.toString());
      }
    }
    return files;
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
