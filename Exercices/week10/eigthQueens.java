package week10;

// TODO:
// Perguntar se existe alguma maneira de verificar se existem queens que podem ser atacadas sem ter de se representar a matrix e percorrer tudo

class PermutationsQueens {

    public void permutations (int[] v) {
        boolean[] used = new boolean[v.length];
        int[] perm = new int[v.length];
        startPerm(v, perm, used, 0);
    }

    public void startPerm (int[] v, int[] perm, boolean[] used, int cur) {

        if (cur == v.length) {

            for(int i = 0; i < v.length; i++) 
                System.out.print(v[perm[i]]);
            
            System.out.println();

        } else {

            for(int i = 0; i < v.length; i++) {
                if(!used[i]) {
                    used[i] = true;
                    perm[cur] = i;

                    startPerm(v, perm, used, cur+1);
                    used[i] = false;
                }
            }
        }
    }
}


public class eigthQueens {
    public static void main (String[] args) {
        int[] board = {1,2,3,4};
    }
}   