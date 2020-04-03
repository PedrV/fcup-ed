package week7;

public interface MyStack<T> {
    public T pop();

    public void push (T value);

    public boolean isEmpty ();

    public int size ();

    public T top();
}