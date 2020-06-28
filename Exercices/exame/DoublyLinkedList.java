package exame;

public class DoublyLinkedList<T> {
    private DNode<T> first;
    private DNode<T> last;
    private int size;

    DoublyLinkedList () {
        first = new DNode<>(null, null, last);
        last = new DNode<>(null, first, null);
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public T getFirst () {
        return first.getNext().getValue();
    }

    public T getLast () {
        return last.getPrev().getValue();
    }

    public T get (int index) {
        if (index < 0 || index >= size)
            return null;

        DNode<T> cur = first.getNext();
        for (int i = 0; i != index; i++)
            cur = cur.getNext();
        
        return cur.getValue();
    }

    public void addFirst (T value) {
        DNode<T> newnode = new DNode<>(value, first, first.getNext());
        first.getNext().setPrev(newnode);
        first.setNext(newnode);
        size++;
    }

    public void addLast (T value) {
        DNode<T> newnode = new DNode<>(value, last.getPrev(), last);
        last.getPrev().setNext(newnode);
        last.setPrev(newnode);
        size++;
    }

    public void add (T value, int index) {
        if (index < 0 || index > size) 
            return;
        
        if (index == 0) {
            addFirst(value);
            return;
        }

        if (index == size) {
            addLast(value);
            return;
        }

        DNode<T> cur = first.getNext();
        for (int i = 0; i != index-1; i++) 
            cur = cur.getNext();
        
        DNode<T> newNode = new DNode<T>(value, cur, cur.getNext());
        cur.getNext().setPrev(newNode);
        cur.setNext(newNode);
    }

    public void removeFirst () {
        if (!isEmpty()) {
            first.setNext(first.getNext().getNext());
            size--;
        }
    }

    public void removeLast () {
        if (!isEmpty()) {
            last.setPrev(last.getPrev().getPrev());
            size--;
        }
    }
    

    public void remove (int index) {
        if (index < 0 || index >= size || isEmpty())
            return;

        if (index == 0) {
            removeFirst();
            return;
        }

        if (index == size-1) {
            removeLast();
            return;
        }

        DNode<T> cur = first.getNext();
        for (int i = 0; i != index-1; i++) 
            cur = cur.getNext();
        
        cur.getNext().getNext().setPrev(cur);
        cur.setNext(cur.getNext().getNext());
    
    }

    public String toString () {
        String s = "{";
        DNode<T> cur = first.getNext();

        for (int i = 0; i < size; i++) {
            if (i == size-1)
                s += cur.getValue();
            else 
                s += cur.getValue() + ",";
            
            cur = cur.getNext();
        }

        return s+="}";
    }

    public String toStringRev () {
        String s = "{";
        DNode<T> cur = last.getPrev();

        for (int i = 0; i < size; i++) {
            if (i == size-1)
                s += cur.getValue();
            else 
                s += cur.getValue() + ",";

            cur = cur.getPrev();
        }

        return s+="}";
    }
}