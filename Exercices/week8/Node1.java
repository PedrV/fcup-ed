/* --------------------------------------------------------- */
//                         Recap                             //
/* --------------------------------------------------------- */

package week8;

public class Node1<T> {
    private Node1<T> next;
    private T value;

    Node1 (Node1<T> next, T value) {
        this.next = next;
        this.value = value;
    }

    public void setValue (T new_value) {
        value = new_value;
    }

    public void setNext (Node1<T> new_next) {
        next = new_next;
    }

    public T getValue () {
        return value;
    }

    public Node1<T> getNext() {
        return next;
    }
}