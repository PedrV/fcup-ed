package test;

import java.util.Scanner;

class SlidingWindow {

    public int numberSegments (final int[] seg, final int depth_req, final int seg_size) {
        int seg_av = 0;
        final int req = (int) Math.ceil((double) seg_size / 2);
        int total = 0;

        // i represents the right side of the window, j represents the lfet side of the
        // window
        for (int i = 0, j = 0; i < seg.length; i++) {

            // If the segment has the depth required to be usefull
            if (seg[i] >= depth_req)
                seg_av++;

            // When the size of the window is reached (size if)
            if (i >= seg_size - 1) {
                if (seg_av >= req) // If there are enough usefull segments
                    total++;

                if (seg[j] >= depth_req) // Shrink the left side of the window by 1
                    seg_av--; // (this shrink is illusory, because the window size is represented by "j" and
                              // "i" but since the first moment it hits the size, it will always trigger the
                              // "size if" and it constrols the size by the seq_av)

                j++;
            }

        }

        return total;
    }

}

public class ED222 {
    public static void main(final String[] args) {
        final Scanner scan = new Scanner(System.in);

        final int segments = scan.nextInt();
        final int seg_size = scan.nextInt();
        final int depth_req = scan.nextInt();
        scan.nextLine();

        final int[] seg = new int[segments];

        for (int i = 0; i < segments; i++)
            seg[i] = Integer.parseInt(scan.next());

        scan.close();

        final SlidingWindow river = new SlidingWindow();
        System.out.println(river.numberSegments(seg, depth_req, seg_size));

    }
}