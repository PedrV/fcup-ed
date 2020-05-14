package  week11.util;

public class DoublyLinkedList <T> {
    private DNode<T> first; // first em DoublyLinkedList não é um "titulo" como nas LinkedLists, aqui é um node verdadeiro, que
    private DNode<T> last; // tem valor null e que sinaliza o final da lista, o mesmo com o last. Podia ser feito com "titulos"
    private int size;      // mas assim evita-se alguns casos especiais e simplifica-se o codigo, em linkedlist ve-se first = "algo", last = "algo"
                            // aqui nunca se mexe no valor do first e last, são nodes sentinela

    public DoublyLinkedList () {
        size = 0;
        first = new DNode<T> (null, null, last);
        last = new DNode<T>(null, first, null);
    }

    public boolean isEmpty () {
        return ( size == 0);
    }

    public int size () {
        return size;
    } 



    public void addFirst (T value) {

        if (isEmpty()) {
            DNode<T> node = new DNode<T>(value, first, last);

            first.setNext(node);
            last.setPrev(node);

        } else { 

            DNode<T> oldF = first.getNext();
            DNode<T> node = new DNode<T>(value, first, oldF);

            first.setNext(node);
            oldF.setPrev(node);

        }
        size++;
    }

    public void addLast (T value) {

        if (isEmpty()) {
            addFirst(value);
        } else {
            DNode<T> oldL = last.getPrev();
            DNode<T> node = new DNode<T>(value, oldL, last);

            last.setPrev(node);
            oldL.setNext(node);
            size++;
        }
    }

    public void add (T value, int index) {
    
        if (index == 0) {
            addFirst(value);
            return;
        } else if (index == size-1) {
            addLast(value);
            return;
        }

        if(index > size-1 || index < 0) {
            throw new Error("Index out of range"); 
        }


        DNode<T> cur = first.getNext();

        for(int i = 0; i < size; i++) {
            if (i == index-1) {
                break;
            }
            cur = cur.getNext();
        } 

        DNode<T> newNode = new DNode<T>(value, cur, cur.getNext());

        cur.getNext().setPrev(newNode); // set the previous node of the node after the cur to be newNode
        cur.setNext(newNode);
        size++;

    }



    public T getFirst () {
        if ( isEmpty() ) {
            return null;
        } else {
            return first.getNext().getValue();
        }
    }

    public T getLast () {
        if ( isEmpty() ) {
            return null;
        } else {
            return last.getPrev().getValue();
        }
    }

    public T get (int index) {

        
        if (index == 0) {
            return getFirst();
        } else if (index == size) {
            return getLast();
        }


        if(index >= size || index < 0) {
            return null;
        }

        DNode<T> cur = first.getNext();

        for(int i = 0; i < size; i++) {
            if(i == index) {
                return cur.getValue();
            }
            cur = cur.getNext();
        }

        return null;
    }



    public T removeFirst () {

        if(isEmpty()) {
            return null;
        }

        T removed = first.getNext().getValue();

        first.getNext().getNext().setPrev(first);
        first.setNext(first.getNext().getNext());

        size--;
        return removed;
    }


    public T removeLast () {

        if(isEmpty()) {
            return null;
        }

        T removed = last.getPrev().getValue();

        last.getPrev().getPrev().setNext(last);
        last.setPrev(last.getPrev().getPrev());

        size--;
        return removed;
    }

    public T remove (int index) {
        
        if (index == 0) {
            return removeFirst();
        } else if (index == size) {
            return removeLast();
        }
        
        if(index > size-1 || index < 0) {
            return null;
        }

        DNode<T> cur = first.getNext();

        for(int i = 0; i < size; i++) {
            if(i == index-1) {
                break;
            }
            cur = cur.getNext();
        }

        T removed = cur.getNext().getValue();

        cur.getNext().getNext().setPrev(cur);
        cur.setNext(cur.getNext().getNext());

        size--;
        return removed;

    }

    public void clear () {
        size = 0;
    }


    public String toString () {
        String s = "{";
        DNode<T> cur = first.getNext();

        for(int i = 0; i < size; i++) {
            if ( i == size-1){
                s += cur.getValue();
            } else {
                s += cur.getValue() + ",";
            }
            cur = cur.getNext();
        }
        s += "}";

        return s;
    }

    public String reverseToString () {
        String s = "{";
        DNode<T> cur = last.getPrev();

        for(int i = 0; i < size; i++) {
            if ( i == size-1){
                s += cur.getValue();
            } else {
                s += cur.getValue() + ",";
            }
            cur = cur.getPrev();
        }
        s += "}";

        return s;
    }
}