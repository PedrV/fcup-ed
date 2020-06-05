package test;

import java.util.Scanner;
import java.util.TreeSet;

public class ED165 {
    public static void main(final String[] args) {
        final TreeSet<Integer> t = new TreeSet<>();
        final Scanner scan = new Scanner(System.in);

        final int n = scan.nextInt();
        final int[] num = new int[n];

        for (int i = 0; i < n; i++)
            num[i] = scan.nextInt();

        for (int i = 0; i < n; i++)
            for (int j = i; j < n; j++)
                t.add(num[i] + num[j]);

        final int q = scan.nextInt();

        for (int i = 0; i < q; i++) {
            final int temp = scan.nextInt();
            if (t.contains(temp))
                System.out.println(temp + ": " + "sim");
            else 
                System.out.println(temp + ": " + "nao");
        }
        
        scan.close();
    }
}