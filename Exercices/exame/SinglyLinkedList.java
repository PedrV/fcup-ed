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

    //Exam1718
    // ****************************************************************************** //
    public boolean contains (T value) {
        Node<T> cur = first;
        while(cur != null) {
            if (cur.getValue().equals(value) ) return true;
            cur = cur.getNext();
        }
        return false;
    }

    public boolean removed(int x) {
        if (x < 0 || x >= size) return false;
        Node<T> cur = first;
        if (x == 0) {
            first = first.getNext();
            size--;
            return true;
        }

        for (int i = 0; i != x-1; i++) cur = cur.getNext();
        cur.setNext(cur.getNext().getNext());
        size--;
        return true;
    }

    public SinglyLinkedList<T> noDuplicates () {
        T cur;
        int sizec = size;
        SinglyLinkedList<T> n = new SinglyLinkedList<>();
        for (int i = 0; i < sizec; i++) {
            cur = getLast();
            removeLast();
            if (!contains(cur)) n.addFirst(cur);
        }
        return n;
    }

    // ****************************************************************************** //


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

    public SinglyLinkedList<T> rotate (int k) {
        SinglyLinkedList<T> l = new SinglyLinkedList<>();

        l.first = new Node<>(null,null);
        l.size = size;
        Node<T> cur = first;
        Node<T> cur2 = first;
        int rots = k % size;
        for (; rots != 0; rots--) {
            for (int i = 0; i < size-2; i++) { 
                cur = cur.getNext(); 
            }
            cur2 = cur.getNext();
            cur.setNext(null);
            cur2.setNext(first);
            first = cur2;
            cur = first;
        }

        l.first = first;
        return l;
    }

}