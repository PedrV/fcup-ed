package week7;

public class DNode<T> {
    private DNode<T> next;
    private DNode<T> prev;
    private T value;

    DNode (T value, DNode<T> prev, DNode<T> next) {
        this.value = value;
        this.prev = prev;
        this.next = next;
    }

    public DNode<T> getPrev () {
        return prev;
    }

    public DNode<T> getNext () {
        return next;
    }
    
    public T getValue () {
        return value;
    }


    public void setPrev (DNode<T> nprev) {
        prev = nprev; 
    }


    public void setNext (DNode<T> nnext) {
        next = nnext;
    }

    public void setValue (T nvalue) {
        value = nvalue;
    }

}