package exame;

public class DNode<T> {
    private DNode<T> next;
    private DNode<T> prev;
    private T value;

    public DNode (T value, DNode<T> prev, DNode<T> next) {
        this.value = value;
        this.next = next;
        this.prev = prev;
    }

    /**
     * @return the next
     */
    public DNode<T> getNext() {
        return next;
    }
    /**
     * @return the prev
     */
    public DNode<T> getPrev() {
        return prev;
    }
    /**
     * @return the value
     */
    public T getValue() {
        return value;
    }
    /**
     * @param next the next to set
     */
    public void setNext(DNode<T> next) {
        this.next = next;
    }
    /**
     * @param prev the prev to set
     */
    public void setPrev(DNode<T> prev) {
        this.prev = prev;
    }
    /**
     * @param value the value to set
     */
    public void setValue(T value) {
        this.value = value;
    }
}