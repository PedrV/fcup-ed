package week6;


public class TestImpl {
    public static void main(String[] args) {
        Pair <String,Integer> pair = new Pair<>("pedro",18);
        Pair <String,Integer> pair2 = new Pair<>("pedro",18);
        Pair <String,Integer> pair1 = new Pair<>("vieira",18);
       // SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
        SinglyLinkedList<String> list1 = new SinglyLinkedList<>();
        SinglyLinkedList<Pair> list3 = new SinglyLinkedList<>();


        list1.addLast("krone");
        list1.addLast("top");
        list1.addLast("pedro");
        list1.addLast("vieira");
        list1.addLast("GG's boys");
        list1.addLast("pppppppppp");
        list1.addLast("GG's boys");
        list1.addLast("GG's boys");
        list1.addLast("GG's boys");

        
        list3.addFirst(pair);
        list3.addFirst(pair1);
        list3.addFirst(pair2);

        System.out.println(list3.toString());


/*        list1.addLast("campos");
        list1.addLast("vieira");
        list1.addLast("Estruturas");

        list1.addFirst("Dados");
        list1.addFirst("value");
        
        list1.addElement("position", 5); */


/*         System.out.println(list1.getLast());
        System.out.println(list1.toString()); */


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