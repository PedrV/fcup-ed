// ----------------------------------------------------------------------------------------------------------------- //

// Solving the max sub array problem; 
// Given one dimensional array find the longest contiguous sub array using Kadane's algorithm
// https://en.wikipedia.org/wiki/Maximum_subarray_problem#Kadane%27s_algorithm_%28Algorithm_3:_Dynamic_Programming%29

// ----------------------------------------------------------------------------------------------------------------- //

package week9;

import java.util.Scanner;

public class ED198 {

    public static int maxSubArray (int [] array) {
        int longest_so_far = 0;
        int current_longest = 0;

        // Complexity O(n); Even better Theta(n)
        for(int i = 0; i < array.length; i++) {

            if (0 > current_longest + array[i])
                current_longest = 0;
            else 
                current_longest += array[i];

            if (longest_so_far < current_longest) 
                longest_so_far = current_longest;

        }

        return longest_so_far;
    }

    public static void main (String[] args) {
        Scanner scan = new Scanner(System.in);

        int size = scan.nextInt();
        int[] array = new int[size];

        scan.nextLine();

        for(int i = 0; i < size; i++) {
            array[i] = scan.nextInt();
        } 

        System.out.println(maxSubArray(array));
    }
}