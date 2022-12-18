package assignment5.problem1.sequentialSolution;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * Represents CSV reader class with default lines to skip
 */
public class InputCSVReader extends InputFileReader {

  private static final int LINES_TO_SKIP = 0;

  /**
   * Constructs a default CSV reader
   */
  public InputCSVReader() {
  }

  /**
   * Returns the contents of the file
   *
   * @param csvFilePath file path of CSV expressed as a Path
   * @return all data in List of String arrays
   */
  @Override
  public List<String> readFile(String csvFilePath) {
    List<String> list = new ArrayList<>();

    try (var in = new BufferedReader(
        new InputStreamReader(new FileInputStream(csvFilePath), StandardCharsets.UTF_8))) {
      String line;
      while ((line = in.readLine()) != null) {
        list.add(line);
      }
    } catch (Exception e) {
      System.out.println("Error occurred while reading file " + csvFilePath);
      // e.printStackTrace();
    }
    return list;
  }

  /**
   * Writes the contents to the given file name
   *
   * @param csvFilePath file path of CSV expressed as a Path
   * @param contents    file contents to be written
   */
  @Override
  public void writeFile(String csvFilePath, String contents) {
    try (var bw = Files.newBufferedWriter(Paths.get(csvFilePath))) {
      bw.write(contents);
    } catch (Exception ex) {
      System.out.println("Error occurred while writing to file " + csvFilePath);
      // ex.printStackTrace();
    }
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
