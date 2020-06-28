package exame;

public class CircularLinkedList<T> {
    private Node<T> last;
    private int size;

    CircularLinkedList () {
        last = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public T getFirst () {
        return last.getNext().getValue();
    }

    public T getLast () {
        return last.getValue();
    }

    public void rotate() {
        last = last.getNext();
    }

    public void rotateBack() {
        Node<T> cur = last;
        while (cur.getNext() != last) 
            cur = cur.getNext();
        
        last = cur;
    }

    public void addFirst (T value) {
        if (isEmpty()) 
            last = new Node<>(value, last);
        else {
            Node<T> newNode = new Node<>(value,last.getNext());
            last.setNext(newNode);
        }

        size++;
    }

    public void addLast (T value) {
        addFirst(value);
        last = last.getNext();
    }

    public void removeFirst () {
        if (isEmpty())
            return;

        if (size == 1) 
            last = null;

        last.setNext(last.getNext().getNext());
        size--;
    }

    public void removeLast () {
        if (isEmpty() || size == 1) {
            removeFirst();
            return;
        }

        Node<T> cur = last;
        for (int i = 0; i < size-1; i++) 
            cur = cur.getNext();
        
        cur.setNext(cur.getNext().getNext());
        last = cur;
        size--;
    }

    public void add (T value, int index) {
        if (index < 0 || index > size)
            return;
        
        if (index == 0) {
            addFirst(value);
            return;
        } else if (index == size) {
            addLast(value);
            return;
        }

        Node<T> cur = last.getNext();
        Node<T> newNode = new Node<>(value, null);
        for (int i = 0; i != index-1; i++)
            cur = cur.getNext();
        
        newNode.setNext(cur.getNext());
        cur.setNext(newNode);
        size++;
    }

    public void remove (int index) {
        if (index < 0 || index >= size || isEmpty()) 
            return;

        if (index == size-1) {
            removeFirst();
            return;
        }

        if (index == 0) {
            removeLast();
            return;
        }

        Node<T> cur = last.getNext();
        for (int i = 0; i != index-1; i++)
            cur = cur.getNext();
        
        cur.setNext(cur.getNext().getNext());
        size--;
    }
    

    public String toString () {
        String s = "{";
        Node<T> cur  = last.getNext();

        for (int i = 0; i < size; i++) {
            if (i == size-1) {
                s+=cur.getValue();
            } else {
                s+= cur.getValue() + ",";
            }
            cur = cur.getNext();
        }
        return s+="}";
    }
}
