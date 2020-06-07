package test.adt_qsld;

import java.util.LinkedList;
import java.util.Scanner;

public class ED006 {

    static void game (LinkedList<String> pl, int words) {
        int to_remove = 0;

        while (pl.size() > 1) {
            
            to_remove = (words-1) % pl.size();

            pl.remove(to_remove);

        }
    }


    public static void main(String[] args) {
        Scanner scan = new Scanner (System.in);

        int cases = scan.nextInt();
        scan.nextLine();

        while (cases > 0) {
            String[] words = scan.nextLine().split(" ");

            Scanner temp = new Scanner(scan.nextLine());

            LinkedList<String> pl = new LinkedList<>();
            while (temp.hasNext())
                pl.addLast(temp.next());
            
            game(pl, words.length);

            if(pl.getFirst().equals("Carlos"))
                System.out.println("O Carlos nao se livrou");
            else 
                System.out.printf("O Carlos livrou-se (coitado do %s!)", pl.getFirst());

            pl.clear();
            cases--;
        }

        scan.close();
    }
}