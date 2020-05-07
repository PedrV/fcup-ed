package week10;

import java.util.Random;

public class Quicksort {

    static int partition (int[] array, int low, int high) {
        Random random = new Random();
        int pivot_index = random.nextInt(high-low) + low;

        int temp = array[pivot_index];
        array[pivot_index] = array[high];
        array[high] = temp;

        int pivot = array[high];
        int i = low - 1;

        for(int j = low; j < high; j++) {
            if (pivot > array[j]) {
                i++;

                int temp1 = array[j];
                array[j] = array[i];
                array[i] = temp1;
            }
        }

        int temp1 = array[i+1];
        array[i+1] = array[high];
        array[high] = temp1;

        return (i+1);
    }

    static void quicksort (int[] array, int low, int high) {
        if (low < high) {
            int m = partition(array, low, high);
            quicksort(array, low, m-1);
            quicksort(array, m+1, high);
        }   
    }




    public static void main(String[] args) {
        int[] array = {1,4,2,42,5,22};
        
        for (int i = 0; i < array.length; i++)
            System.out.print(" " + array[i]);
            
        System.out.println();
        
        Quicksort.quicksort(array, 0, array.length-1);
            
        for (int i = 0; i < array.length; i++)
            System.out.print(" " + array[i]);
    }
}