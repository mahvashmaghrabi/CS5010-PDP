package lab4;

import java.util.ArrayList;
import java.util.List;

public class NewPriorityQueue2<Integer extends Comparable<Integer>> implements MyPriorityQueue<Integer>{
  List<Integer> queueElements;
  int size;

  public NewPriorityQueue2() {
    queueElements = new ArrayList<>();
    size = 0;
  }

  public void insert(Integer e) {
    int index = 0;
    for(int i = size; i > 0; i--) {
      Integer current = queueElements.get(i - 1);
      if (current.compareTo(e) <= 0) {
        index = i;
        break;
      }
    }
    queueElements.add(index, e);
    size++;
  }


  public Integer remove() throws QueueEmptyException {
    if (isEmpty()) {
      throw new QueueEmptyException();
    }

    Integer removedElement = queueElements.get(size-1);
    queueElements.remove(size-1);
    size--;
    return removedElement;
  }


  public Integer front() throws QueueEmptyException {
    if (isEmpty()) {
      throw new QueueEmptyException();
    }
    return queueElements.get(size-1);
  }

  public boolean isEmpty() {
    return queueElements.isEmpty();
  }

  public int size() {
    return size;
  }
}