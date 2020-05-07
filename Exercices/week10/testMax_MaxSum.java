package week10;

class MaxImple {

    // Maximo usando tail recursion
    public static int maxRec1 (int[] arr, int start, int end) {
        int max_so_far = arr[start];

        if (start == end)
            return arr[end];
        
        return Math.max(max_so_far, maxRec1(arr, start+1, end));
    }

    // Maximo usando dividir para conquistar
    public static int maxRec2 (int[] arr, int start, int end) {

        if (start == end)
            return arr[end];

        int middle = (start + end) / 2;

        int max_esq = maxRec2(arr, start, middle);
        int max_dir = maxRec2(arr, middle+1, end);

        return (Math.max(max_esq, max_dir));
    }

    // Sum array usando tail recursion
    public static int sumArray1(int[] arr, int start, int end) {

        if (start == end) 
            return arr[end];

        return (arr[start] + sumArray1(arr, start+1, end));
    }


    // Sum array usando dividir para conquistar
    public static int sumArray2(int[] arr, int start, int end) { 

        if (start == end)
            return arr[end];

        int middle = (start + end) / 2;
            
        return (sumArray2(arr, start, middle) + sumArray2(arr, middle+1, end));

    }
    
}
    
public class testMax_MaxSum {
    public static void main (String [] args) {
        int[] array = {1,-2,34,4,12,42};

        System.out.println(MaxImple.sumArray1(array, 0, array.length-1));
        System.out.println(MaxImple.sumArray2(array, 0, array.length-1));
    }
}