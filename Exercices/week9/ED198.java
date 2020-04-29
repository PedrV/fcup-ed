// ------------------------------------------------------------------------------------------------------------------------ //
//
// Solving the max sub array problem; 
// Given one dimensional array find the longest contiguous sub array using Kadane's algorithm
// https://en.wikipedia.org/wiki/Maximum_subarray_problem#Kadane%27s_algorithm_%28Algorithm_3:_Dynamic_Programming%29
//
// Modifications to the Alghoritm:
// 1. Added support to all negative numbers array
//  1.1 When the array is all negative numbers the max sub array will be an array of one element, the element closer to 0
//      1.1.1 To implement this, a variable containing the max number of the array is added
//
// **** The complexity stays O(n) [Theta(n)] ****
//
// ------------------------------------------------------------------------------------------------------------------------ //


package week9;

import java.util.Scanner;

public class ED198 {

    public static int maxSubArray (int [] array) {
        int longest_so_far = 0;
        int current_longest = 0;
        int single_max = array[0]; 

        // Complexity O(n); Even better Theta(n)
        for(int i = 0; i < array.length; i++) {

            if (array[i] > single_max)
                single_max = array[i];

            if (0 > current_longest + array[i])
                current_longest = 0;
            else 
                current_longest += array[i];

            if (longest_so_far < current_longest) 
                longest_so_far = current_longest;

        }

        if (longest_so_far == 0 && single_max < 0)
            return single_max;
        else
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
        scan.close();
    }
}