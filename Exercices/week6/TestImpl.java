package week6;


public class TestImpl {
    public static void main(String[] args) {
        SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
        
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);

        System.out.println(list.toString());
        System.out.println(list.firstOcc(2));


/* 
        System.out.println(list.size()); // 3
        System.out.println(list.getFirst()); // 69
        System.out.println(list.getLast());  // 777

        list.removeFirst();                 // remove 69 42 is new first
        System.out.println(list.getFirst()); // 42
        list.removeLast();                   // remove 777 now only 42 remains   
        System.out.println(list.getLast()); // equals to get first, should return 42
        System.out.println(list.size()); // 1        

        System.out.println(list.toString());

        list.addLast(1);
        list.addLast(2);
        list.addLast(3);

        System.out.println(list.toString());
        System.out.println(list.size()); // 4

        System.out.println(list.removeElement(5));
        System.out.println(list.toString()); */


        /*
        Node <Integer> n1 = new Node <> (42, null);
        Node <Integer> n2 = new Node <> (13, null);


        // shows value of the Node n1
        System.out.println(n1.getValue());

        // shows next value of n1 -- null
        System.out.println(n1.getNext());

        // puts n2 as the next node after n1   n1->n2->null
        n1.setNext(n2);
        System.out.println(n1.getNext());

        // change value of n1 from 42 to 77
        n1.setValue(77);
        System.out.println(n1.getValue());

        // gets the node which n1 is point to and the unveils it.
        System.out.println(n1.getNext().getValue()); // ==
        // does the same thing as the last command but it access the value of n2 directly
        System.out.println(n2.getValue());           // ==  */
    }
}