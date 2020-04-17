/* --------------------------------------------------------- */
//                         Recap                             //
/* --------------------------------------------------------- */

package week8.recap;

public class DoublyLinkedList1<T> {
    private DNode1<T> first; // dummy nodes to avoid exceptional cases, prev is always null
    private DNode1<T> last; // dummy nodes to avoid exceptional cases, next is always null
    private int size;


    DoublyLinkedList1 () {
        first = new DNode1<>(null, null, last);
        last = new DNode1<>(null, first, null);
        size = 0;
    }

    public int getSize () {
        return size;
    }

    public boolean isEmpty () {
        return (size == 0);
    }



    public void addFirst (T value) {

        if (isEmpty()) {
            DNode1<T> newNode = new DNode1<T>(value, first, null);
            first.setNext(newNode);
            last.setPrev(newNode);

        } else {
            DNode1<T> newNode = new DNode1<T>(value, first, null);
            newNode.setNext(first.getNext());
            first.getNext().setPrev(newNode);
            first.setNext(newNode);
        }

        size++;
    }

    public void addLast (T value) {
        if(isEmpty()) {
            addFirst(value);
        } else {
            DNode1<T> newNode = new DNode1<T>(value, null, last);
            
            newNode.setPrev(last.getPrev());
            last.getPrev().setNext(newNode);
            last.setPrev(newNode);
            size++;
        }
    }

    public void add (int index, T value) {
        if (index == 0) {
            addFirst(value);
        } else if (index == size) {
            addLast(value);
        } else if (index > 0 && index < size) {
            
            DNode1<T> newNode = new DNode1<T>(value, null, null);
            DNode1<T> cur = first.getNext();

            for(int i = 0; i != index-1; i++) {
                cur = cur.getNext();
            }

            newNode.setPrev(cur);
            newNode.setNext(cur.getNext());
            cur.getNext().setPrev(newNode);
            cur.setNext(newNode);

            size++;
        } else {
            throw new Error ("Index out of range");
        }
    }



    public T removeFirst () {
        T temp = first.getNext().getValue();

        first.getNext().getNext().setPrev(first);
        first.setNext(first.getNext().getNext());

        size--;
        return temp;
    }

    public T removeLast () {
        T temp = last.getPrev().getValue();

        last.getPrev().getPrev().setNext(last);
        last.setPrev(last.getPrev().getPrev());

        size--;
        return temp;
    }

    public T remove (int index) {

        T temp = null; // initializing the variable, it wont ever be null
        DNode1<T> cur = first.getNext();

        if (index == 0) {
            return removeFirst();
        } else if (index == size-1) {
            return removeLast();
        } else if (index > 0 && index < size-1) {
            for (int i = 0; i != index-1 ; i++) {
                cur = cur.getNext();
            }

            temp = cur.getNext().getValue();
            cur.setNext(cur.getNext().getNext());
            cur.getNext().setPrev(cur);
            size--;
        
        } else {
            throw new Error ("Index out of range");
        }

        return temp;
    }



    public T getFirst() {
        return first.getNext().getValue();
    }

    public T getLast() {
        return last.getPrev().getValue();
    }

    public T get(int index) {
        DNode1<T> cur = first.getNext();

        if (index == 0) {
            return getFirst();
        } else if (index == size-1) {
            return getLast();
        } else if (index > 0 && index < size-1) {
            for(int i = 0; i != index; i++) {
                cur = cur.getNext();
            }

        } else {
            throw new Error ("Index out of range");
        } 

        
        return cur.getValue();
    }


    public String toString () {
        String s = "{";
        DNode1<T> cur = first.getNext();

        for(int i = 0; i < size; i++) {
            if (i == size-1) {
                s += cur.getValue();
            } else {
                s += cur.getValue() + ",";
            }

            cur = cur.getNext();
        }

        s+= "}";
        return s;
    }

    public String InvertToString () {
        String s = "{";
        DNode1<T> cur = last.getPrev();

        for(int i = 0; i < size; i++) {
            if (i == size-1) {
                s += cur.getValue();
            } else {
                s += cur.getValue() + ",";
            }

            cur = cur.getPrev();
        }

        s+= "}";
        return s;
    }
}