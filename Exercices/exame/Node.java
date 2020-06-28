package exame;

public class Node<T> {
    private Node<T> next;
    private T value;

    Node (T value, Node<T> next) {
        this.value = value;
        this.next = next;
    }
    

    /**
     * @return the value
     */
    public T getValue() {
        return value;
    }

    /**
     * @return the next
     */
    public Node<T> getNext() {
        return next;
    }

    /**
     * @param next the next to set
     */
    public void setNext(Node<T> next) {
        this.next = next;
    }

    /**
     * @param value the value to set
     */
    public void setValue(T value) {
        this.value = value;
    }
}