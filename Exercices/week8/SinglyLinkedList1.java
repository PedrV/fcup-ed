/* --------------------------------------------------------- */
//                         Recap                             //
/* --------------------------------------------------------- */

package week8;


// LinkedList without the "last node" //
/* public class SinglyLinkedList1<T> {
    private Node1<T> first;
    private int size;

    // start with empty list
    SinglyLinkedList1 () {
        first = null;
        size = 0;
    }

    public int getSize () {
        return size;
    }

    public boolean isEmpty () {
        return (size == 0);
    }


    public void addFirst (T value) {
        Node1<T> newNode = new Node1<> (first, value);
        first = newNode;
        size++;
    }

    public void addLast (T value) {
        
        if (isEmpty()) {
            addFirst(value);
        } else {
            Node1<T> newNode = new Node1<> (null, value);
            Node1<T> cur = first;

            // go to the last node of the list (could be a for loop using size)
            while (cur.getNext() != null) {
                cur = cur.getNext();
            }

            cur.setNext(newNode);
            size++;
        }
    }

    public void add (int index, T value) {

        if (index == 0) {
            addFirst(value);
        } else if (index == size) {
            addLast(value);
        } else if (index > 0 && index < size) {

            Node1<T> newNode = new Node1<> (null, value);
            Node1<T> cur = first;

            for(int i = 0; i != index-1; i++) {
                cur = cur.getNext();
            }

            newNode.setNext(cur.getNext());
            cur.setNext(newNode);
            
            size++;
        } else {
            throw new Error("Index out of range"); 
        }

    }



    public T getFirst () {
        return first.getValue();
    }

    public T getLast () {
        Node1<T> cur = first;

        while(cur.getNext() != null) {
            cur = cur.getNext();
        }

        return cur.getValue();
    }
  
    public T get (int index) {

        Node1<T> cur = first;

        if (index == 0) {
            return getFirst();
        } else if (index == size-1) {
            return getLast();
        } else if (index > 0 && index < size-1) {

            for (int i = 0 ; i != index; i++) {
                cur = cur.getNext();
            }

        } else {
            throw new Error("Index out of range");
        }

        return cur.getValue();
    }


    public String toString() {
        String s = "{";
        Node1<T> cur = first;

        for (int i = 0; i < size; i++) {
            if (i == size-1) {
                s += cur.getValue();
            } else  {
                s += cur.getValue() + ",";
            }

            cur = cur.getNext();
        }

        s += "}";
        return s;
    }
} */



// LinkedList with the "last node"

public class SinglyLinkedList1<T> {
    private Node1<T> first;
    private Node1<T> last;
    private int size;

    SinglyLinkedList1 () {
        first = last;
        last = null;
        size = 0;
    }


    public int getSize () {
        return size;
    }

    public boolean isEmpty () {
        return (size == 0);
    }




    public void addFirst (T value) {

        Node1<T> newNode = new Node1<> (first, value);

        if (isEmpty()) {
            first = newNode;
            last = newNode;
        } else {
            first = newNode;
        }
        size++;
    }

    public void addLast (T value) {

        if (isEmpty()) {
            addFirst(value);
        } else {
            Node1<T> newNode = new Node1<> (null, value);
            last.setNext(newNode);
            last = newNode;
            size++;
        }

    }

    public void add (int index, T value) {
        if (index == 0) {
            addFirst(value);
        } else if (index == size) {
            addLast(value);
        } else if ( index > 0 && index < size ) {
            Node1<T> cur = first;
            Node1<T> newNode = new Node1<> (null, value);

            for (int i = 0; i != index-1; i++) {
                cur = cur.getNext();
            }

            newNode.setNext(cur.getNext());
            cur.setNext(newNode);
            size++;
        } else {
            throw new Error ("Index out of range");
        }
    }



    public T getFirst () {
        return first.getValue();
    }

    public T getLast() {
        return last.getValue();
    }

    public T get (int index) {

        Node1<T> cur = first;

        if (index == 0) {
            return getFirst();
        } else if (index == size-1) {
            return getLast();
        } else if (index > 0 && index < size-1) {
            for(int i = 0; i != index; i++) {
                cur = cur.getNext();
            }
        }

        return cur.getValue();
    }



    public T removeFirst () {
        T temp = first.getValue();

        first = first.getNext();
        size--;

        return temp;
    }

    public T removeLast () {
        T temp = last.getValue();
        Node1<T> cur = first;
        
        while (cur.getNext().getNext() != null ) {
            cur = cur.getNext();
        }

        cur.setNext(null);
        size--;

        return temp;

    }

    public T remove (int index) {
        T temp;

        if (index == 0) {
            return removeFirst();
        } else if (index == size-1) {
            return removeLast();
        } else if (index > 0 && index < size-1) {
            Node1<T> cur = first;

            for (int i = 0; i != index-1; i++) {
                cur = cur.getNext();
            }

            temp = cur.getNext().getValue();
            cur.setNext(cur.getNext().getNext());
            size--;

        } else {
            throw new Error ("Index out of range");
        }

        return temp;

    }



    public SinglyLinkedList1<T> copy () {
        SinglyLinkedList1<T> copy = new SinglyLinkedList1<>();

        for(int i = 0; i < size; i++) {
            copy.add(i, get(i));
        }

        return copy;
    }

    public void duplicate () { 

        Node1<T> cur = first;
        int size_copy = size;

        for(int i = 0; i < size_copy*2; i +=2) {
            add(i,cur.getValue());
            cur = cur.getNext();
        }    
    }

    public int count (T value) {
        int tot = 0;
        Node1<T> cur = first;

        for( int i = 0; i < size; i++) {
            if (cur.getValue().equals(value)) {
                tot++;
            }
            cur = cur.getNext();
        }

        return tot;
    }

    public void removeAll (T value) {
        Node1<T> cur = first;

        for(int i = 0; i < size;) {
            if (cur.getValue().equals(value)) {
                remove(i);
            } else {
                i++;
            } 
            cur = cur.getNext();
            
        }
    }

    public void removeEvenPos () {
        int size_copy = size;

        for(int i = 0, j = 0; i < size_copy; i++, j++) {
            if (i % 2 == 0) {
                remove(j);
                j--;
            }
        }
        
    }

    public void removeOddPos () {
        int size_copy = size;

        for(int i = 0, j = 0; i < size_copy; i++, j++) {
            if (i % 2 != 0) {
                remove(j);
                j--;
            }
        }
    }

    public Integer firstOcc (T value) {
        Node1<T> cur = first;

        for(int i = 0; i < size; i++) {
            if (cur.getValue().equals(value)) {
                return i;
            }
            cur = cur.getNext();
        }

        return null;
    }

    public Integer lastOcc (T value) {
        Node1<T> cur = first;
        int how_many = count(value);

        for (int i = 0; i < size; i++) {
            if (cur.getValue().equals(value)) {
                how_many--;
            }

            if (how_many == 0) {
                return i;
            }

            cur = cur.getNext();
        }

        return null;
    }

    public void join (SinglyLinkedList1 <T> list) { 
        
        for (int i = 0; i < list.size; i++) {
            addLast(list.get(i));    
        }

    }



    public String toString() {
        String s = "{";
        Node1<T> cur = first;

        for (int i = 0; i < size; i++) {
            if (i == size-1) {
                s += cur.getValue();
            } else  {
                s += cur.getValue() + ",";
            }

            cur = cur.getNext();
        }

        s += "}";
        return s;
    }

}
