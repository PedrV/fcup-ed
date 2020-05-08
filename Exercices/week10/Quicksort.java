package week10;

import java.util.Random;

public class Quicksort {

    static int partition (int[] v, int start, int end) {
        Random random = new Random();

        int rand = random.nextInt(end-start) + start; 
        
        int temp = v[rand];
        v[rand] = v[end];
        v[end] = temp;

        int pivot = v[end];
        int i = start - 1;

        for(int j = start; j < end; j++) {
            if (pivot > v[j]) {
                i++;

                int temp1 = v[j];
                v[j] = v[i];
                v[i] = temp1;
            }
        }

        int temp1 = v[i+1];
        v[i+1] = v[end];
        v[end] = temp1;

        return (i+1);
    }

    static void quicksort (int[] v, int start, int end) {
        if (start >= end)
            return;

        int m = partition(v, start, end);
        quicksort(v, start, m-1);
        quicksort(v, m+1, end);
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