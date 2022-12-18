package lab4;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.Arrays;
import java.util.List;
//import java.util.Queue;


import static org.junit.jupiter.api.Assertions.*;
@TestInstance(TestInstance.Lifecycle.PER_CLASS)

public class QueueTest {

  Queue<Integer> queue;
//Queue<Integer> queue;
  @BeforeEach
  public void setUp() {
    queue = new Queue<Integer>(){
      public Integer[] queueElements = new Integer[10];
      int front = 0;
      int rear = -1;
      public int size = 0;

      @Override
      public Queue enqueue(Integer element) {
        rear++;
        queueElements[rear] = element;
        size ++;
        return null;
      }

      @Override
      public Queue dequeue() {
        int frontElement = queueElements[front];
        front++;
        size--;
        return null;
      }

      @Override
      public Integer front() {
        return queueElements[front];
      }

      @Override
      public int size() {
        return size;
      }

      @Override
      public Integer[] getQueueElements() {
        return queueElements;
      }

    };
    //queue = new LinkedList<Integer>();
    queue.enqueue(7);
    queue.enqueue(4);
    queue.enqueue(5);
  }

  @Test
  public void enqueue() {
    queue.enqueue(6);
    assertEquals(4, queue.size());
    Integer[] qElements = queue.getQueueElements();
    assertTrue(Arrays.stream(qElements).toList().containsAll(List.of(6, 7, 4, 5)));
  }

  @Test
  public void dequeue() {
    queue.dequeue();
    assertEquals(2, queue.size());
    Integer[] qElements = queue.getQueueElements();
    assertTrue(Arrays.stream(qElements).toList().containsAll(List.of(4,5)));
    assertEquals(4, queue.front());
  }

  @Test
  public void front() {
    queue.front();
    assertEquals(3, queue.size());
    Integer[] qElements = queue.getQueueElements();
    assertEquals(7, queue.front());
    assertTrue(Arrays.stream(qElements).toList().containsAll(List.of(7,4,5)));
  }
}

