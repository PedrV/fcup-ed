package week5;

import java.util.Scanner;

class UNIQUE {
    private int[] array;
    private int size;

    public UNIQUE (Scanner scan) {
        size = 0;
        while (scan.hasNextLine()) {
            array[size] = scan.nextInt();
            size++;
        }
    }
   

    public String toString () {
        String s = "";
        s = "[";
        for(int i = 0; i < size; i++ ) {
            if ( i == size-1) {
                s += array[i];
            } else {
                s += array[i] + ",";
            }
        }
        s += "]";
        return s;
    }
}


public class ED184_UNIQUE {
    public static void main (String[] args) {
        Scanner scan = new Scanner(System.in);

        UNIQUE test = new UNIQUE(scan);

        System.out.println(test.toString());
    }
}