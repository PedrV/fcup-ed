package week6;


public class SinglyLinkedList <T> {
    private Node <T> first;
    private int size;

    // creates empty linked list, the first Node points to de final node first->null, size 0
    public SinglyLinkedList () {
        first = null;
        size = 0;
    }


    public int size () {
        return size;
    }


    public boolean isEmpty () {
        return (size == 0);
    }

    // creates new node pointing to first (null no caso de ser a lista vazia)
    public void addFirst (T value) {
        Node <T> newNode = new Node <>(value, first);
        first = newNode;
        size++;
    }


    public void addElement (T value, int position) {
        Node <T> cur = first;
        Node <T> newNode = new Node <>(value, null);

        if (position == 0) {
            addFirst(value);
            return;
        } else if (position == size) {
            addLast(value);
            return;
        } else if (position > size || position < 0) {
            return;
        }

        for(int i = 0; i < position-1; i++) { // loop until the position before the one wanted
            cur = cur.getNext();
        }

        newNode.setNext(cur.getNext());
        cur.setNext(newNode);
        size++;
    }

    public void addLast (T value) {
        Node <T> newNode = new Node <> (value, null);
        if (isEmpty()) {
            first = newNode;
        } else {
            Node <T> cur = first;

            while (cur.getNext() != null) {
                cur = cur.getNext();
            }

            cur.setNext(newNode);
        }
        size++;
    }

    public T getFirst () {

        if (!isEmpty()) {
            return first.getValue();
        } else {
            return null;
        }
    }


    public T getLast () {

        if (!isEmpty()) {

            Node <T> cur = first;
            while (cur.getNext() != null) {
                cur = cur.getNext();
            }
            return cur.getValue();

        } else {
            return null;
        }

    }

    public T getElemet (int index) {
        if (isEmpty()) {
            return null;
        } else {
            Node <T> cur = first;

            for (int i = 0; i < size; i++) {
                if (i == index) {
                    return cur.getValue();
                }
                cur = cur.getNext();
            }
            return null;
        }
    }


    public void removeFirst () {
        if (isEmpty()) {
            return;
        } else {
            first = first.getNext();
            size--;
        }
    }

    public void removeLast () {
        if (isEmpty()) {
            return;
        } else {
            Node <T> cur = first;
            while (cur.getNext() != null) {
                cur = cur.getNext(); 
            }
            cur.setNext(null);
            size--;
        }
    }

    public T removeElement (int index) {
        if (isEmpty()) {
            return null;
        } else {
            T removed;
            Node <T> cur = first;

            if(index == 0) {    // remove first element is already defined
                removed = cur.getValue();
                removeFirst();
                size--;
                return removed;
            }

            for(int i = 0; i < size; i++) {

                if (i == (index-1) && (i + 1) < size ) {
                    removed = (cur.getNext().getValue());   // store the element to be deleted
                    cur.setNext(cur.getNext().getNext());
                    size--;
                    return (removed);
                }

                cur = cur.getNext();
            }
            return null;
        }
    }

    public SinglyLinkedList<T> copy () {
        SinglyLinkedList<T> copy = new SinglyLinkedList<>();

        Node <T> cur = first;


        for(int i = 0; i < size; i++) {
            copy.addLast(cur.getValue());
            cur = cur.getNext();
        }

        return copy;
    }

    public void duplicate () {
        Node <T> cur = first;
        int sizecopy = size;

        if (size == 0) {return;}

        for(int i = 0, j = 0; i < sizecopy; i++, j += 2) {
            addElement(cur.getValue(), j);
            cur = cur.getNext();
        }
    }

    public int count (T value) {
        Node <T> cur = first;
        int count = 0;

        for(int i = 0; i < size; i++) {
            if (cur.getValue().equals(value)) {
                count++;
            }
            cur = cur.getNext();
        }

        return count;
    }

    public void removeAll (T value) {
        SinglyLinkedList<T> copy = copy(); // copy list so the index do not get affected when elements are removed
        Node <T> cur = copy.first;

        int rep = count(value), i = 0; // count how many elements are supposed to get deleted

        while (rep >= 0) {
            if (cur.getValue().equals(value)) {
                removeElement(i); // each time a element is deleted the size gets smaller by one so the index should aswell
                i--;
            }
            cur = cur.getNext();
            i++;
            rep--;
        }
    }

    /* using Integer so I can return null, since null is an object pointing to nothing
    using a primitive type like int that does not point to anithing would be an error
    java performs autoboxing on the values returning an int like when a position is found and i is returned*/

    public Integer firstOcc (T value) { 
        Node<T> cur = first;

        for(int i = 0; i < size; i++) {
            if (cur.getValue().equals(value)) {
                return i;
            }
            cur = cur.getNext();
        }
        return null;
    }

    public String toString () {
        String s = "[";

        Node <T> cur = first;

        for (int i = 0; i < size; i++) {
            if ( i == size-1 ) {
                s += cur.getValue();
            } else {
                s += cur.getValue() + ",";
            }
            cur = cur.getNext(); 
        }

        s += "]";
        return s;
    }
}