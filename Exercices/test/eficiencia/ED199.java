package test.eficiencia;

import java.util.Scanner;

public class ED199 {
    public static void main (String[] args) {
        Scanner scan = new Scanner(System.in);

        int chests = scan.nextInt();
        int pos = scan.nextInt() - 1;
        int iter = scan.nextInt();
        scan.nextLine();

        String line = scan.nextLine();

        int pos_min = pos;
        int pos_max = pos;
        int treasures = 0;

        for (int i = 0; i < iter; i++) {

            String[] s = scan.nextLine().split(" ");

            if (s[0].equals("D")) {
                pos += Integer.parseInt(s[1]);

            } else if (s[0].equals("E")) {
                pos -= Integer.parseInt(s[1]);

            }

            pos_min = Math.min(pos, pos_min);
            pos_max = Math.max(pos, pos_max);

        }

        for (int i = 0; i < chests; i++) {
            if (i >= pos_min && i <= pos_max) {
                if (line.charAt(i) == 'T')
                    treasures++;
            }   
        }


        System.out.println(treasures);
        scan.close();
    }  

}