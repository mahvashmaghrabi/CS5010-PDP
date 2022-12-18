package assignment5.problem1.concurrentSolution;

import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ConsumerTest {

  @Test
  void consumerShouldWriteFile() throws InterruptedException {
    ExecutorService pool = Executors.newCachedThreadPool();
    SharedFileData sharedFileData = new SharedFileData(10);
    sharedFileData.setProcessDone(true);
    Consumer consumer = new Consumer(sharedFileData);
    pool.execute(consumer);
    pool.shutdown();
    boolean taskCompleted = pool.awaitTermination(2, TimeUnit.SECONDS);
    Assertions.assertTrue(taskCompleted);
  }

  @Test
  void consumerShouldWait() throws InterruptedException {
    ExecutorService pool = Executors.newCachedThreadPool();
    SharedFileData sharedFileData = new SharedFileData(10);
    Consumer consumer = new Consumer(sharedFileData);
    pool.execute(consumer);
    sharedFileData.setResult("abc");
    pool.shutdown();
    boolean taskCompleted = pool.awaitTermination(1, TimeUnit.SECONDS);
    assertFalse(taskCompleted);
  }

  @Test
  void testEquals() {
    Consumer source = new Consumer(new SharedFileData(2));
    Consumer equal = source;
    Assertions.assertTrue(source.equals(equal));
    Consumer diffEqual = new Consumer(new SharedFileData(1));
    assertFalse(source.equals(diffEqual));
    Assertions.assertTrue(source.equals(source));
    assertFalse(source.equals(null));
  }

  @Test
  void testHashCode() {
    Consumer source = new Consumer(new SharedFileData(1));
    Assertions.assertTrue(source.hashCode() != new Consumer(new SharedFileData(33)).hashCode());
    Assertions.assertTrue(source.hashCode() == source.hashCode());
  }

  @Test
  void testToString() {
    Consumer source = new Consumer(new SharedFileData(2));
    Assertions.assertTrue(!source.toString().isEmpty());
    Assertions.assertTrue(source.toString().contains("Consumer{"));
  }
}