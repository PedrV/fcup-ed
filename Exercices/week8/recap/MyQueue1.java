/* --------------------------------------------------------- */
//                         Recap                             //
/* --------------------------------------------------------- */

package week8.recap;

// FIFO
public interface MyQueue1<T> {
    public int size ();

    public boolean isEmpty();

    public T first ();

    public T dequeue ();

    public void enqueue (T value);

}