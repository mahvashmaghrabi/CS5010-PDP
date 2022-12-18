package assignment5.problem1.sequentialSolution;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FileExecutorTest {

  FileExecutor executor;
  List<String> courseList;
  List<String> studentList;

  @BeforeEach
  void setUp() {
    this.executor = new FileExecutor();
    courseList = new ArrayList<>();
    studentList = new ArrayList<>();
    createCourseList();
    createStudentList();
  }

  private void createStudentList() {
    this.studentList.add("code_module,code_presentation,id_student,id_site,date,sum_click");
    this.studentList.add("AAA,2013J,28408,546658,2,2");
    this.studentList.add("AAA,2013J,28409,546659,-5,6");
    this.studentList.add("AAA,2013J,28410,546661,-9,9");
    this.studentList.add("AAA,2014J,28410,546656,-8,10");
    this.studentList.add("AAA,2014J,28401,546658,-6,5");
    this.studentList.add("AAA,2014J,28410,546653,-8,7");
    this.studentList.add("BBB,2013B,28409,546654,-2,3");
    this.studentList.add("BBB,2014B,28400,546659,-2,4");
    this.studentList.add("CCC,2014J,28410,546656,-10,7");
    this.studentList.add("CCC,2014J,28407,546662,7,9");
    this.studentList.add("CCC,2014B,28408,546653,-9,5");
    this.studentList.add("CCC,2014B,28410,546658,-10,1");
    this.studentList.add("DDD,2013B,28407,546655,-4,4");
    this.studentList.add("DDD,2013B,28406,546656,1,2");
  }

  private void createCourseList() {
    this.courseList.add("\"code_module\",\"code_presentation\",\"module_presentation_length\"");
    this.courseList.add("\"AAA\",\"2013J\",\"268\"");
    this.courseList.add("\"AAA\",\"2014J\",\"269\"");
    this.courseList.add("\"BBB\",\"2013J\",\"268\"");
    this.courseList.add("\"BBB\",\"2014J\",\"262\"");
    this.courseList.add("\"BBB\",\"2013B\",\"240\"");
    this.courseList.add("\"BBB\",\"2014B\",\"234\"");
    this.courseList.add("\"CCC\",\"2014J\",\"269\"");
    this.courseList.add("\"CCC\",\"2014B\",\"241\"");
    this.courseList.add("\"DDD\",\"2014J\",\"262\"");
    this.courseList.add("\"DDD\",\"2013J\",\"240\"");
    this.courseList.add("\"DDD\",\"2013J\",\"241\"");
    this.courseList.add("\"EEE\",\"2013J\",\"268\"");
    this.courseList.add("\"EEE\",\"2014J\",\"269\"");

  }

  @Test
  void executeFiles() {
    this.executor.executeFiles(this.courseList, this.studentList);
  }

  @Test
  void testEquals() {
    FileExecutor equalFileExecutor = this.executor;
    Assertions.assertTrue(this.executor.equals(equalFileExecutor));
    FileExecutor diffEqualTitle = new FileExecutor();
    Assertions.assertFalse(this.executor.equals(diffEqualTitle));
    Assertions.assertTrue(this.executor.equals(this.executor));
    Assertions.assertFalse(this.executor.equals(null));
  }

  @Test
  void testHashCode() {
    Assertions.assertTrue(this.executor.hashCode() != new FileExecutor().hashCode());
    Assertions.assertTrue(this.executor.hashCode() == this.executor.hashCode());
  }

  @Test
  void testToString() {
    Assertions.assertTrue(!this.executor.toString().isEmpty());
    Assertions.assertTrue(this.executor.toString().contains("FileExecutor"));
  }
}
