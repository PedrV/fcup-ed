package week12;

import java.util.Arrays;

public class testImple {
    public static void main (String[] args) {
        SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
        SinglyLinkedList<Character> list1 = new SinglyLinkedList<>();
        SinglyLinkedList<String> list2 = new SinglyLinkedList<>();
        SinglyLinkedList<Integer> list3 = new SinglyLinkedList<>();


        SinglyLinkedList<Integer> remove = new SinglyLinkedList<>();
        remove.addFirst(3);

        list1.addFirst('c');
        list1.addFirst('a');
        list1.addFirst('d');
        list1.addFirst('b');
        list1.addFirst('a');
        
        list.addFirst(42);
        list.addFirst(22);
        list.addFirst(42);
        list.addFirst(42);
        list.addFirst(22);
        list.addFirst(42);
        
        list2.addFirst("ola");
        list2.addFirst("mundo");
        list2.addFirst("ola");
        list2.addFirst("ola");
        
        list3.addFirst(1);
        list3.addFirst(2);
        list3.addFirst(3);
        list3.addFirst(3);
        list3.addFirst(2);
        list3.addFirst(1);

        System.out.println(list3.toString());
        list3.remove(remove);
        System.out.println(list3.toString());
        
    }
}