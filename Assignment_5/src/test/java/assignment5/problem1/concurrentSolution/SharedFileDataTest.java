package assignment5.problem1.concurrentSolution;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SharedFileDataTest {

  SharedFileData sharedFileData;
  int THRESHOLD_VALUE = 2;

  @BeforeEach
  void setUp() {
    this.sharedFileData = new SharedFileData(THRESHOLD_VALUE);
  }

  @Test
  void isCourseDone() {
    assertFalse(this.sharedFileData.isCourseDone());
  }

  @Test
  void getResult() {
    //System.out.println(this.sharedFileData.getResult().toString());
    assertTrue(this.sharedFileData.getResult().toString().
        equals("[module_presentation, date, total_clicks]"));
  }

  @Test
  void setResult() {
    assertTrue(this.sharedFileData.getResult().toString().
        equals("[module_presentation, date, total_clicks]"));
    this.sharedFileData.setResult("testing");
    // System.out.println(this.sharedFileData.getResult().toString());
    assertTrue(this.sharedFileData.getResult().toString()
        .equals("[module_presentation, date, total_clicks, testing]"));
    assertTrue(this.sharedFileData.getResult().size() > 0);
  }

  @Test
  void getThresholdValue() {
    assertEquals(THRESHOLD_VALUE, this.sharedFileData.getThresholdValue());
  }

  @Test
  void testEquals() {
    SharedFileData data = new SharedFileData(2);
    Assertions.assertFalse(this.sharedFileData.equals(data));
    SharedFileData notEqual = this.sharedFileData;
    Assertions.assertTrue(this.sharedFileData.equals(notEqual));
    SharedFileData diffEqual = new SharedFileData(2);
    Assertions.assertFalse(this.sharedFileData.equals(diffEqual));
    Assertions.assertTrue(this.sharedFileData.equals(this.sharedFileData));
    Assertions.assertFalse(this.sharedFileData.equals(null));
    SharedFileData data1 = new SharedFileData(3);
    Assertions.assertFalse(this.sharedFileData.equals(data1));
    SharedFileData dataCourse = new SharedFileData(2);
    dataCourse.addCourseData("Hello");
    Assertions.assertFalse(this.sharedFileData.equals(dataCourse));
    dataCourse.setIsReaderDone(true);
    Assertions.assertFalse(this.sharedFileData.equals(dataCourse));
    dataCourse.setResult("hello");
    Assertions.assertFalse(this.sharedFileData.equals(dataCourse));
    dataCourse.setIsReaderDone(false);
    Assertions.assertFalse(this.sharedFileData.equals(dataCourse));
    dataCourse.setProcessDone(true);
    Assertions.assertFalse(this.sharedFileData.equals(dataCourse));
  }

  @Test
  void testHashCode() {
    SharedFileData source = new SharedFileData(2);
    Assertions.assertTrue(this.sharedFileData.hashCode() != source.hashCode());
    Assertions.assertTrue(this.sharedFileData.hashCode() == this.sharedFileData.hashCode());
  }

  @Test
  void testToString() {
    Assertions.assertTrue(!this.sharedFileData.toString().isEmpty());
    Assertions.assertTrue(this.sharedFileData.toString().contains("SharedFileData{"));
  }
}