package exame;

public class SinglyLinkedList <T>{
    private Node<T> first;
    private int size;

    SinglyLinkedList () {
        first = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty () {
        return (size == 0);
    }


    public T getFirst() {
        return first.getValue();
    }

    public void addFirst (T value) {
        Node<T> newNode = new Node<>(value, null);
        
        if (isEmpty())
            first = newNode;
        else {
            newNode.setNext(first);
            first = newNode;
        }
        size++;    
    }

    public T getLast () {
        Node<T> cur = first;
        while (cur.getNext() != null) 
            cur = cur.getNext();
        return cur.getValue();
    }

    public void addLast (T value) {
        if (isEmpty()) {
            addFirst(value);
            return;
        }

        Node<T> cur = first;
        for (int i = 0; i < size-1; i++)
            cur = cur.getNext();
        
        Node<T> newNode = new Node<>(value, null);
        cur.setNext(newNode);   
        size++;
    }


    public void removeFirst () {
        first = first.getNext();
        size--;
    }

    public void removeLast() {
        if (size == 1) {
            removeFirst();
            return;
        }

        Node<T> cur = first;
        for (int i = 0; i < size-2; i++)
            cur = cur.getNext();
        
        cur.setNext(null);
        size--;
    }

    public T get (int index) {
        T value = null;

        if (index < 0 || index >= size || isEmpty())
            return null;

        Node<T> cur = first;
        for (int i = 0; i < size; i++) {
            if (i == index) {
                value = cur.getValue();
                break;
            }
            cur = cur.getNext();
        }

        return value;
    }

    public void add (T value, int index) {
        if (isEmpty() || index == 0) {
            addFirst(value);
            return;
        }
        
        if (index == size) {
            addLast(value);
            return;
        }

        Node<T> cur = first;
        Node<T> newNode = new Node<>(value, null);
        for (int i = 1; i < size; i++) {
            if (index == i-1) {
                newNode.setNext(cur.getNext());
                cur.setNext(newNode);
                break;
            }
            cur = cur.getNext();
        }
        size++;
    }

    public void remove (int index) {
        if (index < 0 || index >= size || isEmpty())
            return;
        
        Node<T> cur = first;
        if (index == 0)
            first = first.getNext();

        for(int i = 1; i < size; i++) {
            if (i == index-1) {
                cur.setNext(cur.getNext().getNext());
                break;
            }
            cur = cur.getNext();
        }
        size--;
    }

    public String toString () {
        String s = "{";
        Node<T> cur  = first;

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