package week11.util;

public class DNode<T> {
    private DNode<T> next;
    private DNode<T> prev;
    private T value;

    protected DNode (T value, DNode<T> prev, DNode<T> next) {
        this.value = value;
        this.prev = prev;
        this.next = next;
    }

    // Setters
    public void setValue (T value) {
        this.value = value;
    }

    public void setNext (DNode<T> next) {
        this.next = next;
    }

    public void setPrev (DNode<T> prev) {
        this.prev = prev;
    }
    
    
    // Getters
    
    public T getValue () {
        return value;
    }

    public DNode<T> getNext () {
        return next;
    }

    public DNode<T> getPrev () {
        return prev;
    }

}