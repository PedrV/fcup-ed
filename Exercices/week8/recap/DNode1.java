/* --------------------------------------------------------- */
//                         Recap                             //
/* --------------------------------------------------------- */

package week8.recap;

public class DNode1<T> {
    private DNode1<T> next;
    private DNode1<T> prev;
    private T value;

    DNode1 (T value, DNode1<T> prev, DNode1<T> next) {
        this.value = value;
        this.prev = prev;
        this.next = next;
    }

    public DNode1<T> getPrev() {
        return prev;
    }

    public DNode1<T> getNext() {
        return next;
    }

    public T getValue () {
        return value;
    }


    public void setPrev (DNode1<T> prev) {
        this.prev = prev;
    }

    public void setNext (DNode1<T> next) {
        this.next = next;
    }

    public void setValue (T value) {
        this.value = value;
    }


}