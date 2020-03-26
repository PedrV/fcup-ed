package week6;

public class Node<T> {

    private Node<T> next;
    private T value;

    public Node (T value, Node<T> next) {
        this.next = next;
        this.value = value;
    }

    public T getValue () {
        return value;
    }

    public Node<T> getNext () {
        return next;
    }

    public void setValue (T nvalue) {
        value = nvalue;
    }

    public void setNext (Node <T> nnext) {
        next = nnext;
    }
}