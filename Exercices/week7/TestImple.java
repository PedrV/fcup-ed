package week7;

public class TestImple {
    public static void main (String[] args) {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<> ();

        list.addFirst(1);
        
        list.addFirst(134);
        
        list.addFirst(13);

        list.addFirst(31);
        
        list.addFirst(13124);
        
        list.addFirst(11241113);


        System.out.println(list.toString());
        
        list.clear();

        System.out.println(list.toString());

        list.add(42, 0);
        list.addLast(777);

        
        System.out.println(list.toString());

    }
}