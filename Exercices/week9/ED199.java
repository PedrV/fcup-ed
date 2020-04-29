package week9;

import java.util.Scanner;

public class ED199 {
    public static void main (String[] args ) {
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();     // Number of treasure chests
        int s = scan.nextInt();     // Starting Position
        int ins = scan.nextInt();   // Number of Instructions
        scan.nextLine();            // Consume the new line left by the nextInt()'s
        
        s -= 1;                     // Subtract one from starting position beacause arrays start at 0

        boolean[] arcas = new boolean[n];

        int min_pos = Integer.MAX_VALUE;
        int max_pos = Integer.MIN_VALUE;
        int tesouros = 0;
        
        String line = scan.nextLine();
        
        // Treasure chests marked with "T" have a treasure
        for (int i = 0; i < n; i++) {

            if (line.charAt(i) == 'T')
                arcas[i] = true;
            else
                arcas[i] = false;

        }

        // Read Instructions;
        for (int i = 0; i < ins; i++) {

            if (scan.next().equals("D")) {
                s += Integer.parseInt(scan.next());         // Each right step is one element to the right in the array
                max_pos = Math.max(max_pos, s);             // See the max position reached so far in the array

            } else {
                s -= Integer.parseInt(scan.next());         // Each left step is one element to the left in the array
                min_pos = Math.min(min_pos, s);             // See the min position reached so far in the array
            }

        }   
        
        scan.close();

        for (; min_pos <= max_pos; min_pos++) {             // Between the min and max bounds of the arrays check for treasures
            if (arcas[min_pos]) 
                tesouros++;
        }

        System.out.println(tesouros);

    } 
}