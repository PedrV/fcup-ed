package test;

import java.util.Scanner;

class Sets1 {
    static int biggestS = 0;
    static int sum = 0;
    static int duration;

    static void sets (int[] v) {
        boolean[] used = new boolean[v.length];

        goSets (v, used, 0);
    }

    static void goSets (int[] v, boolean[] used, int cur) {
        if (cur == v.length) {
            for (int i = 0; i < used.length; i++) 
                if (used[i]) sum += v[i];
            
            if (sum <= duration && sum > biggestS)
                biggestS = sum;
            
            sum = 0;

        } else {
            used[cur] = true;
            goSets(v, used, cur+1);
            used[cur] = false;
            goSets(v, used, cur+1);
        }
    }

}

public class ED201 {
    public static void main(String[] args) {
        Scanner scan = new Scanner (System.in);

        Sets1.duration = scan.nextInt();
        int musics = scan.nextInt();
        int[] v = new int[musics];

        for (int i = 0; i < musics; i++) 
            v[i] = scan.nextInt();
        
        scan.close();

        Sets1.sets(v);
        System.out.println(Sets1.biggestS);

    }
}