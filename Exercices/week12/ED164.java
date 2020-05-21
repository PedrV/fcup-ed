package week12;

import java.util.Scanner;

public class ED164 {
    public static void main (String[] args) {
        Scanner scan = new Scanner (System.in);
        BSTree<String> tree = new BSTree<>();

        int number = scan.nextInt();
        scan.nextLine();

        for (int i = 0; i < number; i++) {
            tree.insert (scan.nextLine());
        }

        scan.close();

        System.out.println(tree.numberNodes());
    }
}