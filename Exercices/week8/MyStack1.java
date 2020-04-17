/* --------------------------------------------------------- */
//                         Recap                             //
/* --------------------------------------------------------- */

package week8;

// LIFO
public interface MyStack1<T> {
    public int size();

    public boolean isEmpty();

    public T peek ();

    public T pop ();

    public void push (T value);
}