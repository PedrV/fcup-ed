package week7;

public class LinkedListQueue<T> implements MyQueue<T> {
    private DoublyLinkedList<T> queue;


    LinkedListQueue () {
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