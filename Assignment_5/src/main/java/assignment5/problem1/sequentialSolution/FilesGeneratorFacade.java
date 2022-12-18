package assignment5.problem1.sequentialSolution;

import java.util.List;

/**
 * Represents a File Generator facade which connects all componenets of the application
 */
public class FilesGeneratorFacade {

  /**
   * Constructs File generator facade object
   */
  public FilesGeneratorFacade() {
  }

  /**
   * Reads input file
   *
   * @param fileName name of the input file to be read
   * @return List of string arrays
   */
  private List<String> readInputFile(String fileName) {
    InputFileReader inputCsvReader = new InputCSVReader();
    return inputCsvReader.readFile(fileName);
  }

  /**
   * Generates files from main method
   *
   * @param args arguments passed in command line
   */
  public void generateFiles(String[] args) {
    try {
      var fileList = CommandLineParser.parseCommand(args);
      if (fileList.size() != 2) {
        throw new RuntimeException("Expected number of files in given folder is two.");
      }
      //Helper.sendSystemOutToFile();

      List<String> csvStudentData = readInputFile(fileList.get(0));
      List<String> csvCourseData = readInputFile(fileList.get(1));
      if (csvStudentData.size() == 0) {
        throw new RuntimeException("Input CSV file " + fileList.get(0) + " is empty");
      }
      if (csvCourseData.size() == 0) {
        throw new RuntimeException("Input CSV file " + fileList.get(1) + " is empty");
      }
      FileExecutor executor = new FileExecutor();
      executor.executeFiles(csvCourseData, csvStudentData);
    } catch (Exception ex) {
      System.out.println(ex.getMessage());
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
