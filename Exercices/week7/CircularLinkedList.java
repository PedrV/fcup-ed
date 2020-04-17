package week7;


public class CircularLinkedList <T> {
    private Node<T> last; // em CircularLinkedLists last volta a ser um titulo, não é um node "fisico" como em doublyLinkedLists, aqui
    private int size;     // é algo como nas linkedlists, pode ser atribuido a outro node. Só que neste caso nao aponta para o null, aponta para o 1º  


    CircularLinkedList () {
        size = 0;
        last = new Node<T>(null, null);
    }

    public int size () {
        return size;
    }

    public boolean isEmpty () {
        return (size == 0);
    }


    public void addFirst (T value) {
        if (isEmpty()) {
            last = new Node<T> (value, null);
            last.setNext(last);
        } else {
            Node<T> newNode = new Node<T> (value, last.getNext());
            last.setNext(newNode);
        }
        size++;
    }

    public void addLast (T value) {
        addFirst(value);
        last = last.getNext();
    }


    public T getFirst () {
        return last.getNext().getValue();
    }

    public T getLast () {
        return last.getValue();
    }


    public T removeFirst () {

        if( size == 0) {
            return null;
        } else if (size == 1) {
            size = 0;
        }
        T removed = last.getNext().getValue();

        last.setNext(last.getNext().getNext());

        return  removed;
    }

    public T removeLast () {

        if(isEmpty()) {
            return null;
        } else if (size == 1) {
            return removeFirst();
        }

        Node<T> cur = last.getNext();

        T removed = last.getValue();


        for(int i = 0; i < size-2; i++) { // in a linked list the node "null" "exists", so it counts as node although it is not really there
            cur = cur.getNext();
        }

        cur.setNext(last.getNext());
        last = cur; 

        size--;

        return removed;
    }
    
    public void rotate () {
        if(!isEmpty()) {
            last = last.getNext();
        }
    }

    public void rotateB () {
        if(!isEmpty()) {
            Node<T> cur = last.getNext();
            for(int i = 0; i < size-2; i++) {
                cur = cur.getNext();
            }
            last = cur;
        }
    }


    public String toString () {
        String s = "{";

        Node<T> cur = last.getNext();

        for(int i = 0; i < size; i++) {
            if( i == size-1 ) {
                s += cur.getValue();
            } else {
                s += cur.getValue() + ",";
            }
            cur = cur.getNext();
        }

        s += "}";
        return s;
    }
}