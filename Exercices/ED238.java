import java.util.Scanner;

class SlidingWindow {
    public static void slidingWindow (int n, char[] seqN, int[] K) {
  
        
        for (int k : K) {
            // Sliding window lower bound
            int max_seq_size = 0;
            int ub_sliding_window = 0;
            int lb_sliding_window = 0;
            int zero_count = 0;
            
            // O(N)
            // i functions as sliding window upper bound
            for (; ub_sliding_window < n; ub_sliding_window++) {
                if (seqN[ub_sliding_window] == '0')
                    zero_count += 1;  


                while(zero_count > k) {
                    // Increase lower bound until satisfying zero count
                    if (seqN[lb_sliding_window] == '0')
                    zero_count -= 1;

                    lb_sliding_window += 1;
                }
            }

            // Maximum between stored maximum and sliding window current size
            max_seq_size = Math.max(max_seq_size, ub_sliding_window - lb_sliding_window + 1);
            System.out.println(max_seq_size);

        }
            
    }
}


public class ED238 {
    public static void main(String[] args) {
        Scanner scan = new Scanner (System.in);
        
        int n = scan.nextInt();
        scan.nextLine();
        char[] seqN = scan.nextLine().toCharArray();
        
        int q = scan.nextInt();

        int[] k = new int[q];
        for (int i = 0; i < q; i++) {
            k[i] = scan.nextInt();
        }

        SlidingWindow.slidingWindow(n, seqN, k);

        scan.close();
    }
}
