// ----------------------------------------------------------------------- //
// Implementation of fixed size Sliding Window Algorithm 
// ----------------------------------------------------------------------- //

package week9;

import java.util.Scanner;

class Segmentacao {

    public int segmentacao (int n, int k, int t, int[] segmentos) {
        int sequencias = 0;
        int profundidade_aceitavel = 0;
        
        double k1 = k;
        k1 = Math.round(k1/2);


        for (int i = 0; i < n; i++) {         

            if (segmentos[i] >= t)    
                profundidade_aceitavel++;

            if (i >= k-1) {                             // Once the size of the window is reached, see if the requirements are meet

                if (profundidade_aceitavel >= k1 )
                    sequencias++;

                if (segmentos[i - (k-1)] >= t)          // Remove the last element of the "window"
                    profundidade_aceitavel--;

            }

        }

        return sequencias;
    }

}

public class ED222 {
    public static void main (String[] args) {
        Scanner scan = new Scanner (System.in);
        Segmentacao start = new Segmentacao();

        int n = scan.nextInt();     // Number of segments
        int k = scan.nextInt();     // Length of the segments to consider
        int t = scan.nextInt();     // Depth wanted


        int [] segmentos = new int[n];

        for(int i = 0; i < n; i++) 
            segmentos[i] = scan.nextInt();
        

        System.out.println(start.segmentacao(n, k, t, segmentos));

        scan.close();
    } 
}