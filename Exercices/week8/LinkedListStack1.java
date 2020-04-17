/* --------------------------------------------------------- */
//                         Recap                             //
/* --------------------------------------------------------- */


package week8;

public class LinkedListStack1<T> implements MyStack1<T> {
    private DoublyLinkedList1<T> stack;
    private int size;

    LinkedListStack1 () {
        stack = new DoublyLinkedList1<>();
        size = 0;
    }

    public int size () {
        return size;
    }

    public boolean isEmpty () {
        return (size == 0);
    } 

    public T peek () {
        return stack.getFirst();
    }

    public T pop () {
        return stack.removeFirst();
    }

    public void push (T value) {
        stack.addFirst(value);
    }

    public String toString () {
        return stack.toString();
    }
}