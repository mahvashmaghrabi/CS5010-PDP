package lab4;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class NewPriorityQueueTest {
  NewPriorityQueue2<Integer> queue = new NewPriorityQueue2<>();

  @BeforeEach
  public void setup() {
    queue.insert(5);
    queue.insert(3);
    queue.insert(7);
    queue.insert(4);
  }

  @Test
  public void insert() throws QueueEmptyException {
    queue.insert(6);
    assertEquals(5, queue.size());
    List<Integer> qElements = queue.queueElements;
    assertEquals(7, queue.front());
    assertTrue(qElements.containsAll(List.of(5, 3, 4, 7, 6)));
  }

  @Test
  public void remove() throws QueueEmptyException {
    queue.remove();
    assertEquals(3, queue.size());
    List<Integer> qElements = queue.queueElements;
    assertEquals(5, queue.front());
    assertTrue(qElements.containsAll(List.of(5, 3, 4)));
  }

  @Test
  public void front() throws QueueEmptyException {
    assertEquals(4, queue.size());
    List<Integer> qElements = queue.queueElements;
    assertEquals(7, queue.front());
    assertTrue(qElements.containsAll(List.of(5, 3, 4, 7)));
  }

    @Test
    public void isEmpty() throws QueueEmptyException {
      queue.insert(5);
      queue.remove();
      assertFalse(queue.isEmpty());
  }
}