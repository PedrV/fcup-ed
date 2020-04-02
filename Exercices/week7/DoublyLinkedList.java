package week7;

public class DoublyLinkedList <T> {
        private DNode<T> first;
        private DNode<T> last;
        private int size;

        DoublyLinkedList () {
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


/* public class DoublyLinkedList <T> {
    private DNode<T> first; // guard, always empty node to avoid limit cases
    private DNode<T> last;  // guard, always empty node to avoid limit cases
    private int size;

    DoublyLinkedList () {
        first = new DNode<T>(null, null, null);
        last = new DNode<T>(null, first, null);
        first.setNext(last);
        size = 0;
    }
    
    public boolean isEmpty () {
        return (size == 0);
    }

    public int size () {
        return size;
    }

    public void addFirst (T value) {
        if (isEmpty()) {
            DNode<T> newNode = new DNode<T> (value, first ,last);
            first.setNext(newNode);
            last.setPrev(newNode);
        } else {
            DNode<T> newNode = new DNode<T> (value, first ,first.getNext());
            first.setNext(newNode);
            last.setPrev(newNode);
        }
        size++;
    }

    public void addLast (T value) {
        if (isEmpty()) { 
            addFirst(value);
        } else {
            DNode<T> newNode = new DNode<T>(value, last.getPrev(), last);
            last.getPrev().setNext(newNode);
            last.setPrev(newNode);
            size++;    
        }
    }

    public void addBetween (int index, T value) {
        DNode<T> cur = first.getNext();
        DNode<T> newNode = new DNode<T>(value, first, last); // initializing node

        for(int i = 0; i < size; i++) {
            if (i == index-1) { // stop 1 before the wanted postion

                 // set the prev node of the node in the position after index to be the new node
                cur.getNext().setPrev(newNode);
                 // set the next node newNode to be the one we defined before to point with prevo to newNode
                newNode.setNext(cur.getNext());

                 // next of the node before the newNode should be newNode 
                cur.setNext(newNode);
                 // set prev node of newNode to be the node cur, line above tells to cur that is next node is newNode;
                newNode.setPrev(cur);
                
            }
            cur = cur.getNext();
        }
        size++;
    }


    public String toString() {
        String s = "{";
        DNode<T> cur = first.getNext(); // do not count the void node

        for(int i = 0; i < size; i++) {
            if (i == size-1) {
                s += cur.getValue(); 
            } else {
                s += cur.getValue() + ",";
            }
            cur = cur.getNext();
        }
        s += "}";

        return s;
    }

    public String invertPrint() {
        String s = "{";
        DNode<T> cur = last.getPrev(); // void node is out

        for(int i = 0; i < size; i++) {
            if (i == size-1) {
                s += cur.getValue();
            } else {
                s += cur.getValue() + ",";
            }
            cur = cur.getPrev();
        }
        s += "}";

        return s;
    } 
} */