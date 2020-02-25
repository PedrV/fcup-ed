
package week1;

import java.util.Scanner;

final class ext2 {

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        
        System.out.print("Number: ");
        int input =  scan.nextInt();
    
        int i = 2;
        System.out.print(input + " = ");
        while(input != 1){
            while(input % i == 0 && input != 1){
                System.out.print(i);
                input /= i;
                if(input != 1){
                    System.out.print(" * ");
                }
            }
            i++;
        }
        scan.close();
    }
}