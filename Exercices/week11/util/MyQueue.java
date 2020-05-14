package  week11.util;

public interface MyQueue<T> {
    public int size ();

    public boolean isEmpty();

    public T first ();

    public void enqueue (T value);

    public T dequeue ();
}