package week12;

import java.util.Arrays;
import java.util.Random;;

public class testImple {
    public static void main (String[] args) {
        SinglyLinkedList<Integer> list = new SinglyLinkedList<>();

        Random gen = new Random();

        int upperbound = 5001;

        for (int i = 0; i < 50000; i++) {
            list.addFirst(gen.nextInt(upperbound));
        }

        SinglyLinkedList<Integer> remove = new SinglyLinkedList<>();


        for (int i = 0; i < 100; i++) {
            remove.addFirst(gen.nextInt(upperbound));
        } 

        System.out.println("List before remove: ");
        System.out.println(list);
 
        System.out.println();
        System.out.println();
        System.out.println();

        System.out.println("List after remove: ");
        list.remove(remove);
        System.out.println(list);
        
    }
}