
package week2;

import java.util.Scanner;

// stats

public class ED183 {

  public static void main(String[] args) {
	
    Scanner scan = new Scanner(System.in);

    int[] v = new int[1000];
    int total = 0, max = 0, min = 0;

    int n = scan.nextInt();

    for(int i = 0; i < n; i++){
      v[i] = scan.nextInt();
      max = v[i];
      min = v[i];
    }

    for(int i = 0; i < n; i++){

      if(max < v[i]){
        max = v[i];
      }
      if (min > v[i]){
        min = v[i];
      }
      
      total += v[i];
    }

    System.out.printf("%.2f\n", (double)total / n);
    System.out.println(max-min);

    scan.close();
 }
}