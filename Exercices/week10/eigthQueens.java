package week10;

// TODO:
// Perguntar se existe alguma maneira de verificar se existem queens que podem ser atacadas sem ter de se representar a matrix e percorrer tudo

class PermutationsQueens {
    private boolean[][] available;
    private int col;

    PermutationsQueens (boolean[][] available) {
        this.available = available;
        col = 0;
    }

    private void updateBoard (int row) {
        available[row][col] = false;

        // Update row and col
        for (int i = 0; i < available.length; i++) {
            available[i][col] = false;
            available[row][i] = false;
        }

        // Update upper right diagonal
        for(int i = row, j = col; i < available.length && j < available.length; i++, j++)
            available[i][j] = false;
            
        // Update upper left diagonal
        for(int i = row, j = col; i < available.length && j >= 0 ; i++, j--)
            available[i][j] = false;
            
        // Update lower left diagonal
        for(int i = row, j = col; i >= 0 && j >= 0 ; i--, j--)
            available[i][j] = false;
            
        // Update lower right diagonal
        for(int i = row, j = col; i >= 0 && j < available.length ; i--, j++)
            available[i][j] = false;


        // Next number will represent the next col
        col++;
    }


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

                    if (!available[i][col])
                        return;

                    updateBoard(i);

                    startPerm(v, perm, used, cur+1);
                    used[i] = false;
                }
            }
        }
    }
}


public class eigthQueens {
    public static void main (String[] args) {
        int[] board = {1,2,3,4,5,6,7,8};

        boolean[][] available = new boolean[8][8];

        for(int i = 0; i < 8; i++)
            for(int j = 0; j < 8; j++ )
                available[i][j] = true;
            
        PermutationsQueens start = new PermutationsQueens(available);
        start.permutations(board);
        
    }
}   