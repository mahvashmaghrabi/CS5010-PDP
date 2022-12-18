package assignment5.problem1.concurrentSolution;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ProcessorTest {


  @Test
  void processorShouldWaitForTheResult() throws InterruptedException {
    ExecutorService pool = Executors.newCachedThreadPool();
    SharedFileData sharedFileData = new SharedFileData(10);
    Processor processor = new Processor(sharedFileData);
    pool.execute(processor);
    pool.shutdown();
    boolean taskCompleted = pool.awaitTermination(2, TimeUnit.SECONDS);
    Assertions.assertFalse(taskCompleted);
  }

  @Test
  void processorShouldProcessCourseData() throws InterruptedException {
    ExecutorService pool = Executors.newCachedThreadPool();
    SharedFileData sharedFileData = new SharedFileData(10);
    Processor processor = new Processor(sharedFileData);
    pool.execute(processor);
    pool.shutdown();
    boolean taskCompleted = pool.awaitTermination(2, TimeUnit.SECONDS);
    assertFalse(taskCompleted);
  }

  @Test
  void processorShouldProcessCourseWhenProcessDoneTrue() throws InterruptedException {
    ExecutorService pool = Executors.newCachedThreadPool();
    SharedFileData sharedFileData = new SharedFileData(10);
    Processor processor = new Processor(sharedFileData);
    sharedFileData.setIsReaderDone(true);
    pool.execute(processor);
    pool.shutdown();
    boolean taskCompleted = pool.awaitTermination(2, TimeUnit.SECONDS);
    assertTrue(taskCompleted);
  }

  @Test
  void processorShouldProcessCourseWthNumber() throws InterruptedException {
    ExecutorService pool = Executors.newCachedThreadPool();
    SharedFileData sharedFileData = new SharedFileData(10);
    sharedFileData.addCourseData("abc,1,1");
    Processor processor = new Processor(sharedFileData);
    pool.execute(processor);
    pool.shutdown();
    boolean taskCompleted = pool.awaitTermination(2, TimeUnit.SECONDS);
    assertFalse(taskCompleted);
  }

  @Test
  void processorShouldProcessCourseWithBlank() throws InterruptedException {
    ExecutorService pool = Executors.newCachedThreadPool();
    SharedFileData sharedFileData = new SharedFileData(10);
    sharedFileData.addCourseData("");
    Processor processor = new Processor(sharedFileData);
    pool.execute(processor);
    pool.shutdown();
    boolean taskCompleted = pool.awaitTermination(2, TimeUnit.SECONDS);
    assertFalse(taskCompleted);
  }

  @Test
  void processorShouldProcessCourseWthNumberMatchingThreshold() throws InterruptedException {
    ExecutorService pool = Executors.newCachedThreadPool();
    SharedFileData sharedFileData = new SharedFileData(1);
    sharedFileData.addCourseData("abc,1,10,\n");
    Processor processor = new Processor(sharedFileData);
    pool.execute(processor);
    pool.shutdown();
    boolean taskCompleted = pool.awaitTermination(2, TimeUnit.SECONDS);
    assertFalse(taskCompleted);
  }

  @Test
  void processorShouldCourseDataWhenProcessNotDone() throws InterruptedException {
    ExecutorService pool = Executors.newCachedThreadPool();
    SharedFileData sharedFileData = new SharedFileData(10);
    Processor processor = new Processor(sharedFileData);
    pool.execute(processor);
    pool.shutdown();
    boolean taskCompleted = pool.awaitTermination(2, TimeUnit.SECONDS);
    assertFalse(taskCompleted);
  }

//  @Test
//  void processorShouldProcessCourseWhenStudentDoneTrue_NotANumber() throws InterruptedException {
//    ExecutorService pool = Executors.newCachedThreadPool();
//    SharedFileData sharedFileData = new SharedFileData(10);
//    Processor processor = new Processor(sharedFileData);
//    pool.execute(processor);
//    pool.shutdown();
//    boolean taskCompleted = pool.awaitTermination(2, TimeUnit.SECONDS);
//    assert(taskCompleted);
//  }

  @Test
  void testEquals() {
    Processor source = new Processor(new SharedFileData(2));
    Processor equal = source;
    Assertions.assertTrue(source.equals(equal));
    Processor notequal = new Processor(new SharedFileData(2));
    Assertions.assertFalse(source.equals(notequal));
    Processor diffEqual = new Processor(new SharedFileData(1));
    Assertions.assertFalse(source.equals(diffEqual));
    Assertions.assertTrue(source.equals(source));
    Assertions.assertFalse(source.equals(null));
  }

  @Test
  void testHashCode() {
    Processor source = new Processor(new SharedFileData(1));
    Assertions.assertTrue(source.hashCode() != new Consumer(new SharedFileData(33)).hashCode());
    Assertions.assertTrue(source.hashCode() == source.hashCode());
  }

  @Test
  void testToString() {
    Processor source = new Processor(new SharedFileData(2));
    Assertions.assertTrue(!source.toString().isEmpty());
    Assertions.assertTrue(source.toString().contains("Processor{"));
  }
}