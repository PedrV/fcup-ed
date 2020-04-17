/* --------------------------------------------------------- */
//                         Recap                             //
/* --------------------------------------------------------- */

package week8.recap;

public class LinkedListQueue1<T> implements MyQueue1<T> {
    private DoublyLinkedList1<T> queue;
    private int size;

    LinkedListQueue1 () {
        queue = new DoublyLinkedList1<>();
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return (size == 0);
    }

    public T first() {
        return queue.getFirst();
    }

    public T dequeue() {
        return queue.removeFirst();
    }

    public void enqueue(T value) {
        queue.addLast(value);
    }

    public String toString() {
        return queue.toString();
    }

}