package assignment5.problem1.sequentialSolution;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FilesGeneratorFacadeTest {

  String[] args;
  FilesGeneratorFacade facade;

  @BeforeEach
  void setUp() {
    this.args = new String[]{"./src/test/resources/test_Files"};
    this.facade = new FilesGeneratorFacade();
  }

  @Test
  void generateFiles() {
    this.facade.generateFiles(this.args);
  }

  @Test
  void generateFiles_Negative() {
    this.facade.generateFiles(new String[]{"./src/test/resources/test_NotEnoughFiles"});
    this.facade.generateFiles(new String[]{"./src/test/resources/test_CoursesEmpty"});
    this.facade.generateFiles(new String[]{"./src/test/resources/test_StudentEmpty"});
//    Throwable exp_emptyFolder = Assertions.assertThrows(Exception.class,
//        () -> this.facade.generateFiles(new String[]{"test_NotEnoughFiles"}));
//    Assertions.assertEquals("Expected number of files in given folder is two.",
//        exp_emptyFolder.getMessage());

//    Throwable exp_emptyCourses = Assertions.assertThrows(Exception.class,
//        () -> this.facade.generateFiles(new String[]{"test_CoursesEmpty"}));
//    Assertions.assertEquals(
//        "Input CSV file /Users/gayatribirthare/Group_mahvash_gayatribirthare/a4/test_CoursesEmpty/courses.csv is empty"
//        , exp_emptyCourses.getMessage());

//    Throwable exp_emptyStudents = Assertions.assertThrows(Exception.class,
//        () -> this.facade.generateFiles(new String[]{"test_StudentEmpty"}));
//    Assertions.assertEquals(
//        "Input CSV file /Users/gayatribirthare/Group_mahvash_gayatribirthare/a4/test_StudentEmpty/studentVle_small.csv is empty"
//        , exp_emptyStudents.getMessage());
  }

  @Test
  void testEquals() {
    FilesGeneratorFacade equalFileGeneratorFacade = this.facade;
    Assertions.assertTrue(this.facade.equals(equalFileGeneratorFacade));
    FilesGeneratorFacade diffEqualTitle = new FilesGeneratorFacade();
    Assertions.assertFalse(this.facade.equals(diffEqualTitle));
    Assertions.assertTrue(this.facade.equals(this.facade));
    Assertions.assertFalse(this.facade.equals(null));
  }

  @Test
  void testHashCode() {
    Assertions.assertTrue(this.facade.hashCode() != new FilesGeneratorFacade().hashCode());
    Assertions.assertTrue(this.facade.hashCode() == this.facade.hashCode());
  }

  @Test
  void testToString() {
    Assertions.assertTrue(!this.facade.toString().isEmpty());
    Assertions.assertTrue(this.facade.toString().contains("FilesGeneratorFacade"));
  }
}