/* --------------------------------------------------------- */
//                         Recap                             //
/* --------------------------------------------------------- */

package week8;

public class TestImplementations {
    public static void main (String[] args) {
        DoublyLinkedList1<Integer> dlist = new DoublyLinkedList1<>();

        dlist.addLast(1);
        dlist.addLast(2);
        dlist.addLast(3);
        dlist.addLast(4);
        dlist.addLast(5);

        dlist.add(5, 42);

        /*
        dlist1.addLast(6);
        dlist1.addLast(7);
        dlist1.addLast(8);
        dlist1.addLast(9);
        dlist1.addLast(10);
        dlist1.addLast(42); */


       // System.out.println(list.get(-1));
/*         System.out.println(list.get(0));
        System.out.println(list.get(1));
        System.out.println(list.get(2));
        System.out.println(list.get(3)); */
        //System.out.println(list.get(4));


        System.out.println(dlist);
        System.out.println(dlist.InvertToString());

        System.out.println(dlist.remove(3));

        System.out.println(dlist);
        System.out.println(dlist.InvertToString());
    }
}