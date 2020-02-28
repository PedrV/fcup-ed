package week2;

import java.util.Scanner;

// paliandros

public class _121 {

    public static void normalizer(String input){

        int spaces = 0;

        /* Strings immutable; instead of rewriting every time a chars has to
           modified create new instance of the class StringBuilder to create a
           new mutable sequece of chars aka String */
        
        input = input.toLowerCase();

        StringBuilder newInput = new StringBuilder(input);;

        for(int i = 0; i < input.length(); i++){
            if(Character.isLetterOrDigit(newInput.charAt(i))){
                newInput.setCharAt(spaces, input.charAt(i));
                spaces++;
            }
        }

        pali(newInput.substring(0, spaces));
    }

    public static void pali(String input){
        int size = input.length();

        for(int i = 0, j = size-1; i < size/2; i++, j--){
            if(input.charAt(i) != input.charAt(j)){
                System.out.println("nao");
                return;
            }
        }
        System.out.println("sim");
    }

    public static void main (String[] args){

        Scanner scan = new Scanner(System.in);

        String[] input = new String[99];

        int n = scan.nextInt();

        // consume line left by the enter in next int
        scan.nextLine();

        for(int i = 0; i < n; i++){
            input[i] = scan.nextLine();
        }

        System.out.println(n);
        for(int i = 0; i < n; i++){
            normalizer(input[i]);   
        }

    }
}