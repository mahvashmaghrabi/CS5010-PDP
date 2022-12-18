package lab4;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class StackTest {
  Stack<Integer> stack;

  @BeforeEach
  void setUp() {
    stack = new Stack<Integer>() {
      Integer stackElements[] = new Integer[10];
      int top = -1;
      int size = 0;
      @Override
      public Stack push(Integer element) {
        top++;
        stackElements[top] = element;
        size++;
        return null;
      }

      @Override
      public Stack remove() {
        top--;
        size--;
        return null;
      }

      @Override
      public Integer top() {
        return stackElements[top];
      }

      @Override
      public int size() {
        return size;
      }

      @Override
      public Integer[] getStackElements() {
        return stackElements;
      }
    };
    stack.push(7);
    stack.push(4);
    stack.push(5);
  }

  @Test
  void push() {
    stack.push(6);

    assertEquals(4, stack.size());
    Integer[] elements = stack.getStackElements();
    assertEquals(6, stack.top());
    assertTrue(Arrays.stream(elements).toList().containsAll(List.of(6, 7, 4, 5)));
  }

  @Test
  void remove() {
    stack.remove();
    assertEquals(2, stack.size());
    Integer[] qElements = stack.getStackElements();
    assertTrue(Arrays.stream(qElements).toList().containsAll(List.of(4,5)));
    assertEquals(4, stack.top());
  }

  @Test
  void top() {
    stack.top();
    assertEquals(3, stack.size());
    Integer[] qElements = stack.getStackElements();
    assertEquals(5, stack.top());
    assertTrue(Arrays.stream(qElements).toList().containsAll(List.of(7,4,5)));
  }
}