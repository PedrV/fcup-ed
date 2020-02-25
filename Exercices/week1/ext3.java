
package week1;

public class ext3{
    public static void main(String[] args){
        int[] arr = {1,23,2,3,4,12,3,123,20,20,20};

        // set wanted for the number to search in the array
        int wanted = 20, cnt = 0;
        for(int i = 0; i < arr.length; i++){
            if(arr[i] == wanted){
                cnt++;
            }
        }
        System.out.println("There were " + cnt + " " + wanted + "s" + " in the array");
    }
}