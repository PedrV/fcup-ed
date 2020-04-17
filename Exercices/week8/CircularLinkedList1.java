/* --------------------------------------------------------- */
//                         Recap                             //
/* --------------------------------------------------------- */

package week8;

public class CircularLinkedList1<T> {
    private Node1<T> last;
    private int size;

    CircularLinkedList1 () {
        last = null;
        size = 0;
    }

    public int getSize () {
        return size;
    }

    public boolean isEmpty () {
        return (size == 0);
    }

    public void rotate() {
        if (!isEmpty()) {
            last = last.getNext();
        }
    }

    public void rotateB() {
        if (!isEmpty()) {

            Node1<T> cur = last.getNext();

            for(int i = 0; i != size-2; i++) {
                cur= cur.getNext();
            }

            last = cur;
        }
    }



    public void addFirst (T value) {

        Node1<T> newNode = new Node1<> (null, value);

        if (isEmpty()) {
            last = newNode;
            last.setNext(last);
        } else {
            newNode.setNext(last.getNext());
            last.setNext(newNode);
        }

        size++;
    }

    public void addLast (T value) {

        if (isEmpty()) {
            addFirst(value);
        } else {

            Node1<T> newNode = new Node1<> (last.getNext(), value);

            last.setNext(newNode);
            last = newNode;

            size++;
        }
        /* ou adicionar no 1º e dizer que afinal era o ulitmo o que adicionamos
        addFirst(value);
        last = last.getNext(); */
    }

    public void add (int index, T value) {

        Node1<T> cur = last.getNext();

        if (index == 0) {
            addFirst(value);
        } else if (index == size) {
            addLast(value);
        } else if (index > 0 && index < size) {

            Node1<T> newNode = new Node1<>(null, value);

            for(int i = 0; i != index-1; i++) {
                cur = cur.getNext();
            }

            newNode.setNext(cur.getNext());
            cur.setNext(newNode);
            size++;
        }
    }



    public T removeFirst () {

        if (isEmpty()) {
            throw new Error ("List is already empty");
        }

        T temp = last.getNext().getValue();

        last.setNext(last.getNext().getNext());

        size--;
        return temp;
    }

    public T removeLast () {

        if (isEmpty()) {
            throw new Error ("List is already empty");
        }

        T temp = last.getValue();

        Node1<T> cur = last.getNext();

        for(int i = 0; i != size-2; i++) {
            cur = cur.getNext();
        }

        cur.setNext(last.getNext());
        last = cur;
        size--;
        return temp;

    }

    public T remove (int index) {
        
        T temp = null; // initializing the variable, it wont ever be null
        Node1<T> cur = last.getNext();

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

            size--;
        
        } else {
            throw new Error ("Index out of range");
        }

        return temp;
    }



    public T getFirst () {
        if (!isEmpty()) {
            return last.getNext().getValue();
        } else {
            return null;
        }
    }

    public T getLast () {
        if (!isEmpty()) {
            return last.getValue();
        } else {
            return null;
        }
    }

    public T get (int index) {
        if (index == 0) {
            return getFirst();
        } else if (index == size-1) {
            return getLast();
        } else if (index > 0 && index < size-1) {

            T temp = null;
            Node1<T> cur = last.getNext();

            for (int i = 0; i != index; i++) {
                cur = cur.getNext();
            }

            return temp;
        } else {
            throw new Error ("Index out of range");
        }
    }


    public String toString() {
        String s = "{";
        Node1<T> cur = last.getNext();

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