package week7;

import java.util.Scanner;


class WhoLoses {
    int size = 0;
    CircularLinkedList<String> list_names = new CircularLinkedList<>();
    String[] namesAray; 

    public void getInput (Scanner scan) {

        int how_many = scan.nextInt();

        scan.nextLine(); // consumir new line deixada pelo enter em nextInt

        String words, names;

        while (how_many > 0) {
            words = scan.nextLine();
            size = words.split(" ").length;

            names = scan.nextLine();

            namesAray = names.split(" ");
            fillList();

            String loser = play();

            if (loser.equals("Carlos")) {
                System.out.println("O Carlos nao se livrou");
            } else {
                System.out.println("O Carlos livrou-se (coitado do " + loser + ")!");
            }

            how_many--;
        }
    }

    public void fillList () {
        for(int i = 1; i < namesAray.length; i++) {
            list_names.addLast(namesAray[i]);
        }
    }

    public String play () {
        String loser;

        while (list_names.size() > 1) {
            for(int i = 0; i < size; i++) {
                list_names.rotate();
            }
            list_names.removeLast();
        }

        loser = list_names.getFirst();
        list_names.removeLast(); // clear list  

        return loser;
    }

}


public class E006 {
    public static void main(String args []) {
        Scanner scan = new Scanner(System.in);
        WhoLoses game = new WhoLoses();

        game.getInput(scan);

    }
}