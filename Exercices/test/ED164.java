package test;

import java.util.Scanner;
import java.util.TreeSet;

public class ED164 {
    public static void main (String[] args) {
        Scanner scan = new Scanner(System.in);
        TreeSet<String> t = new TreeSet<>();

        int n = scan.nextInt();
        scan.nextLine();

        for (int i = 0; i < n; i++) {
            t.add(scan.nextLine());
        }

        scan.close();
        System.out.println(t.size());

    }
}