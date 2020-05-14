package week11.util;

public class LinkedListQueue<T> implements MyQueue<T> {
    private DoublyLinkedList<T> queue;


    public LinkedListQueue () {
        queue = new DoublyLinkedList<>();
    }

    public int size () {
        return queue.size();
    }

    public boolean isEmpty () {
        return queue.isEmpty();
    }

    public T first () {
        return queue.getFirst();
    }

    public T dequeue () {
        T removed = queue.getFirst();
        queue.removeFirst();
        return removed;
    }

    public void enqueue (T value) {
        queue.addLast(value);
    }

    public String toString () {
        return queue.toString();
    }

}