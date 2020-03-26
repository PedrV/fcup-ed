package week5;

import java.util.Arrays;

class BigNumber {
    private int[] number;
    private int size;

    private BigNumber(int x) {
        number = new int[1000];
        size = 1000;
    }

    public BigNumber(String number) {
        size = number.length();

        this.number = new int[size];

        for(int i = size-1, j = 0; i >= 0; i-- ,j++) {
            this.number[j] = number.charAt(i) - '0';
        }
    }

    public BigNumber add (BigNumber n1) {
        BigNumber result = new BigNumber(1);
        int biggestSize, carry = 0;
        int[] new_n1;
        int[] new_number;


        // get the biggest size of number to command the operations

        if (size >= n1.size) {                              // I need to resize the arrays so they have the same size
            biggestSize = size;                             // If I have to resize arrays then probably Im not using the best
            new_n1 = Arrays.copyOf(n1.number, biggestSize); // data structure, but I dont want to use something that was not talked
            new_number = Arrays.copyOf(number, size);       // in class, at the moment I'm doing this (best option: maybe ArrayList)
        } else {
            biggestSize = n1.size;
            new_n1 = Arrays.copyOf(n1.number, n1.size);
            new_number = Arrays.copyOf(number, biggestSize);
        }


        result.size = biggestSize;

        //add function
        for(int i = 0; i < biggestSize; i++) {
            if ((new_number[i] + new_n1[i]) >= 10) {
                result.number[i] = (new_number[i] + new_n1[i]) % 10 + carry;
                carry = 1;
            } else {
                result.number[i] = new_number[i] + new_n1[i] + carry;
                carry = 0;
            }

            if (carry != 0 && i == biggestSize-1) {
                result.number[i+1] = carry;
                result.size = biggestSize+1;
            }
        } 

        return result;
    }

    public String toString () {
        String s = "";
        s = "[";
        for(int i = 0; i < size; i++ ) {
            if ( i == size-1) {
                s += number[i];
            } else {
                s += number[i] + ",";
            }
        }
        s += "]";
        return s;
    }

}


public class ED185 {
    public static void main (String[] args){
        BigNumber n1 = new BigNumber("421221");
        BigNumber n2 = new BigNumber("88777");

        BigNumber n3 = n1.add(n2);

        System.out.println(n3.toString());
        
    }
}