package week10;

import java.util.Scanner;

class Capicuas {
    public boolean reverse (char[] arr, int start, int end) {

        if (start >= end)
            return true;
        
        if (arr[start] != arr[end])
            return false;

        return reverse(arr, start+1, end-1);
    }

}

public class testCapicuas {
    public static void main (String[] args) {
/*         Capicuas<Integer> t = new Capicuas<>();
        Capicuas<Character> t1 = new Capicuas<>();

        Integer[] arr = {1,2,3,4,5,6};
        Character[] arrchar = {'a','b','c','d','e'};

        System.out.println(Arrays.toString(arr));
        t.reverse(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));

        System.out.println(Arrays.toString(arrchar));
        t1.reverse(arrchar, 0, arrchar.length-1);
        System.out.println(Arrays.toString(arrchar)); */

        Scanner scan = new Scanner (System.in);
        Capicuas test = new Capicuas();
        
        System.out.println("Introduzir possive capicua:");
        String line = scan.nextLine();
        scan.close();


        System.out.println(test.reverse(line.toCharArray(), 0, line.length()-1));


    }
}   