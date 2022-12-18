package lab4;

public interface MyPriorityQueue<E> {
  void insert(E e);

  E remove() throws QueueEmptyException;

  E front() throws QueueEmptyException;

  boolean isEmpty();
}