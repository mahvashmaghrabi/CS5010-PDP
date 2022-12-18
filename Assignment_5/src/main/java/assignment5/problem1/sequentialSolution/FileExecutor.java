package assignment5.problem1.sequentialSolution;

import static java.util.stream.Collectors.groupingBy;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


/**
 * Represents a Command Executor to execute the command options.
 */
public class FileExecutor {

  private static final String OUTPUT_DIR = "out_SequentialSolution";

  /**
   * Constructs a default FileExecutor
   */
  public FileExecutor() {
  }

  /**
   * Transforms csv data for further processing
   *
   * @param csvCourseData  input csv course file data
   * @param csvStudentData input csv student file data
   */
  public void executeFiles(List<String> csvCourseData, List<String> csvStudentData) {

    var courseDataMap = transformCourseData(csvCourseData);
    var studentDataMap = transformStudentData(csvStudentData, courseDataMap);

    writeFile(studentDataMap);
  }

  /**
   * Writes file contents in give file name
   *
   * @param studentDataMap student csv data
   */
  private void writeFile(Map<String, StringBuilder> studentDataMap) {

    for (String key : studentDataMap.keySet()) {
      InputFileReader reader = new InputCSVReader();
      reader.writeFile(key, studentDataMap.get(key).toString());
    }
  }

  /**
   * Transforms student csv data based on course csv data and grouping on days
   *
   * @param csvStudentData student data in list
   * @param courseDataMap  course data in map
   * @return fileDetails in Map
   */
  private Map<String, StringBuilder> transformStudentData(List<String> csvStudentData,
      Map<String, Boolean> courseDataMap) {
    var groupedStudentCourseData = csvStudentData.stream()
        .skip(1)
        .map(s -> s.replaceAll("[\"]", "").split(","))
        .collect(groupingBy(parts -> parts[0] + "_" + parts[1] + "_" + parts[4],
            Collectors.summingInt(parts -> Integer.parseInt(parts[5]))
        ));

    Map<String, StringBuilder> fileDetails = new HashMap<>();

    String folderPath = Paths.get(OUTPUT_DIR).toAbsolutePath().toString();

    for (String key : groupedStudentCourseData.keySet()) {
      updateCourseMap(key, courseDataMap);

      StringBuilder fileNameWithPath = new StringBuilder();
      fileNameWithPath.append(folderPath).append(File.separator)
          .append(key, 0, key.lastIndexOf('_')).append(".csv");

      createFileNameAsPerData(folderPath, fileNameWithPath);

      StringBuilder sb = new StringBuilder();

      createFileAndContentMap(fileDetails, fileNameWithPath, groupedStudentCourseData, key, sb);
    }

    for (String key : courseDataMap.keySet()) {
      StringBuilder fileName = new StringBuilder();
      fileName.append(folderPath).append(File.separator).append(key).append(".csv");
      if (!courseDataMap.get(key)) {
        fileDetails.put(fileName.toString(), new StringBuilder("Date,TotalClicks\n"));
      }
    }

    return fileDetails;
  }

  private void createFileAndContentMap(Map<String, StringBuilder> fileDetails,
      StringBuilder fileNameWithPath, Map<String, Integer> groupedCourseData,
      String key, StringBuilder sb) {
    if (fileDetails.containsKey(fileNameWithPath.toString())) {
      sb.append(key.split("_")[2])
          .append(",").append(groupedCourseData.get(key)).append("\n");
      fileDetails.put(fileNameWithPath.toString(),
          fileDetails.get(fileNameWithPath.toString()).append(sb));
    } else {
      sb.append("Date,TotalClicks\n").append(key.split("_")[2])
          .append(",").append(groupedCourseData.get(key)).append("\n");
      fileDetails.put(fileNameWithPath.toString(), sb);
    }
  }

  private void createFileNameAsPerData(String folderPath, StringBuilder fileNameWithPath) {
    try {
      if (!Files.exists(Path.of(folderPath))) {
        new File(folderPath).mkdirs();
      }
      if (!Files.exists(Paths.get(String.valueOf(fileNameWithPath)))) {
        File file = new File(fileNameWithPath.toString());
        file.getParentFile().mkdirs();
        file.createNewFile();
      }
    } catch (IOException e) {
      System.out.println(e.getMessage());
    }
  }

  private void updateCourseMap(String groupedCourseData,
      Map<String, Boolean> courseDataMap) {
    String setKey = groupedCourseData.substring(0, groupedCourseData.lastIndexOf('_'));
    if (!courseDataMap.containsKey(setKey)) {
    } else {
      courseDataMap.put(setKey, true);
    }
  }

  /**
   * Transforms course data
   *
   * @param csvCourseData course data in list
   * @return course data in Map
   */
  private Map<String, Boolean> transformCourseData(List<String> csvCourseData) {
    Map<String, Boolean> map = new HashMap<>();
    for (int i = 1; i < csvCourseData.size(); i++) {
      if (csvCourseData.get(i) == null || csvCourseData.get(i).isBlank()) {
        continue; // skip empty rows
      }
      String[] cellValues = csvCourseData.get(i).replaceAll("[\"]", "").split(",");
      map.put(cellValues[0] + "_" + cellValues[1], false);
      // key = code_module & code_presentation and value = module_presentation_length
    }
    return map;
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
