package week7;

public class TestImple {
    public static void main (String[] args) {
        CircularLinkedList<String> list = new CircularLinkedList<>();
        
        list.addFirst("Vieira");
        list.addFirst("Campos");
        list.addFirst("Pedro");
/* 
        list.addLast("is");
        list.addLast("the");
        list.addLast("best"); */

        System.out.println(list.toString());

        System.out.println(list.toString());


    }
}