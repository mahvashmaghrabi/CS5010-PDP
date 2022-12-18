package assignment5.problem1.concurrentSolution;

import java.io.File;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ProducerTest {

  File file;
  List<String> filePaths;

  @BeforeEach
  void setUp() {

    this.filePaths = new ArrayList<>();
  }


  @Test
  void producerShouldFoundEmptyFiles() throws InterruptedException {
    ExecutorService pool = Executors.newCachedThreadPool();
    SharedFileData sharedFileData = new SharedFileData(10);
    this.file = new File("./src/test/resources/test_emptyFiles");
    this.filePaths.add(this.file.getAbsolutePath() + File.separator + "courses.csv");
    this.filePaths.add(this.file.getAbsolutePath() + File.separator + "student.csv");
    Producer producer = new Producer(sharedFileData, this.file.getAbsolutePath());
    pool.execute(producer);
    pool.shutdown();
    boolean taskCompleted = pool.awaitTermination(2, TimeUnit.SECONDS);
    Assertions.assertTrue(taskCompleted);
  }

  @Test
  void producerShouldThrowFileNotFoundExp() throws InterruptedException {
    ExecutorService pool = Executors.newCachedThreadPool();
    SharedFileData sharedFileData = new SharedFileData(10);
    this.file = new File("./src/test/resources/test_emptyFiles");
    this.filePaths.add(this.file.getAbsolutePath() + File.separator + "courses_NAN.csv");
    this.filePaths.add(this.file.getAbsolutePath() + File.separator + "student.csv");
    Producer producer = new Producer(sharedFileData, this.file.getAbsolutePath());
    pool.execute(producer);
    pool.shutdown();
    boolean taskCompleted = pool.awaitTermination(2, TimeUnit.SECONDS);
    Assertions.assertTrue(taskCompleted);
  }


  @Test
  void producerShouldFoundCorrectFiles() throws InterruptedException {
    ExecutorService pool = Executors.newCachedThreadPool();
    SharedFileData sharedFileData = new SharedFileData(10);
    this.file = new File(Paths.get("./src/test/resources/test_Files").toAbsolutePath().toString());

    this.filePaths.add(this.file.getAbsolutePath() + File.separator + "courses.csv");
    this.filePaths.add(this.file.getAbsolutePath() + File.separator + "studentVle_small.csv");
    Producer producer = new Producer(sharedFileData, this.file.getAbsolutePath());
    pool.execute(producer);
    pool.shutdown();
    boolean taskCompleted = pool.awaitTermination(2, TimeUnit.SECONDS);
    Assertions.assertTrue(taskCompleted);
  }

  @Test
  void testEquals() {
    SharedFileData sharedFileData = new SharedFileData(10);

    this.file = new File("./src/test/resources/test_Files");
    this.filePaths.add(this.file.getAbsolutePath() + File.separator + "courses.csv");
    this.filePaths.add(this.file.getAbsolutePath() + File.separator + "studentVle_small.csv");
    Producer source = new Producer(sharedFileData, this.file.getAbsolutePath());
    Producer equal = source;
    Assertions.assertTrue(source.equals(equal));
    Producer diffEqual = new Producer(sharedFileData, this.file.getAbsolutePath());
    Assertions.assertTrue(source.equals(diffEqual));
    Producer diffNotEqual = new Producer(new SharedFileData(2), this.file.getAbsolutePath());
    Assertions.assertFalse(source.equals(diffNotEqual));
    Assertions.assertTrue(source.equals(source));
    Assertions.assertFalse(source.equals(null));
  }

  @Test
  void testHashCode() {
    SharedFileData sharedFileData = new SharedFileData(10);

    this.file = new File("./src/test/resources/test_Files");
    this.filePaths.add(this.file.getAbsolutePath() + File.separator + "courses.csv");
    this.filePaths.add(this.file.getAbsolutePath() + File.separator + "studentVle_small.csv");
    Producer source = new Producer(sharedFileData, this.file.getAbsolutePath());
    Assertions.assertTrue(source.hashCode() != new Consumer(new SharedFileData(33)).hashCode());
    Assertions.assertTrue(source.hashCode() == source.hashCode());
  }

  @Test
  void testToString() {
    SharedFileData sharedFileData = new SharedFileData(10);

    this.file = new File("./src/test/resources/test_Files");
    this.filePaths.add(this.file.getAbsolutePath() + File.separator + "courses.csv");
    this.filePaths.add(this.file.getAbsolutePath() + File.separator + "studentVle_small.csv");
    Producer source = new Producer(sharedFileData, this.file.getAbsolutePath());
    Assertions.assertTrue(!source.toString().isEmpty());
    Assertions.assertTrue(source.toString().contains("Producer{"));
  }

}