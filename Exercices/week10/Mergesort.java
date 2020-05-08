package week10;

import java.util.Arrays;

public class Mergesort {

    static void mergesort(int[] v, int start, int end) {

        if (start == end)
            return;

        int middle = start + (end-start)/2;
        mergesort(v, start, middle);
        mergesort(v, middle+1, end);
        merge(v, start, end);
    }

    static void merge(int[] v, int start, int end) {
        int middle = start + (end-start)/2;
        int[] aux = new int[v.length];

        int lp = start;
        int rp = middle+1;
        int cur = 0;

        while (lp <= middle && rp <= end) {

            if (v[lp] < v[rp])
                aux[cur++] = v[lp++];
            else
                aux[cur++] = v[rp++];
        }

        while (lp <= middle)
            aux[cur++] = v[lp++];
        
        while (rp <= end)
            aux[cur++] = v[rp++];


        for (int i = 0; i < cur; i++)
            v[start+i] = aux[i];
    }

    public static void main (String[] args) {
        int[] v = {1,3,4,2,42,9};

        System.out.println(Arrays.toString(v));
        
        mergesort(v, 0, v.length-1);
        
        System.out.println(Arrays.toString(v));
    }
}