
package week2;

import java.util.Scanner;

public class los {

    static void losangulo(final int n) {

        int left_bound = n/2 + 1, right_bound = n/2 + 1;

        // 1º parte do losangulo
        for (int i = 1; i <= n/2 + 1; i++) {
            for(int j = 1; j <= n; j++){
                if(j >= left_bound && j <= right_bound){
                    System.out.print("#");
                }  else {
                    System.out.print(".");
                }
            }
            System.out.println();
            left_bound--;
            right_bound++;
        }

        // 2º parte do losangulo
        left_bound += 2;
        right_bound -= 2;

        for (int i = n/2; i >= 1; i--) {
            for(int j = 1; j <= n; j++){
                if(j >= left_bound && j <= right_bound){
                    System.out.print("#");
                }  else {
                    System.out.print(".");
                }
            }
            System.out.println();
            left_bound++;
            right_bound--; 
        }
    }

    public static void main(final String[] args) {

        Scanner scanner = new Scanner(System.in);

        losangulo(scanner.nextInt());

        scanner.close();
    }
}