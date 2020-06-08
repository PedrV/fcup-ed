package test.recursividadebig;

class QueensSolution {
    private boolean[][] board;
    private int bd;

/*     public static boolean possible(int[] x, int n) {
        for (int i = 0; i < n; i++) {
            if (x[i] == x[n])             
                return false;   // same column
            if ((x[i] - x[n]) == (n - i)) 
                return false;   // same major diagonal
            if ((x[n] - x[i]) == (n - i)) 
                return false;   // same minor diagonal
        }
        return true;
    } */

    QueensSolution(int board_dim) {
        board = new boolean[board_dim][board_dim];
        for (int i = 0; i < board_dim; i++) 
            for (int j = 0; j < board_dim; j++) 
                board[i][j] = true;
    }

    private boolean possible(int n) {
        for (int i = n; i < board.length; i++) {
            if (board[i][n])   
                return true;
        }
        return false;
    }

    private void resetBoard () {
        for (int i = 0; i < board.length; i++) 
            for (int j = 0; j < board.length; j++) 
                board[i][j] = true;
    }

    private void markPositions (int ii, int jj) {
        board[ii][jj] = false;

        // Update row and col
        for (int i = 0; i < board.length; i++) {
            board[i][jj] = false;
            board[ii][i] = false;
        }

        // Update upper right diagonal
        for(int i = ii, j = jj; i < board.length && j < board.length; i++, j++)
            board[i][j] = false;
            
        // Update upper left diagonal
        for(int i = ii, j = jj; i < board.length && j >= 0 ; i++, j--)
            board[i][j] = false;
            
        // Update lower left diagonal
        for(int i = ii, j = jj; i >= 0 && j >= 0 ; i--, j--)
            board[i][j] = false;
            
        // Update lower right diagonal
        for(int i = ii, j = jj; i >= 0 && j < board.length ; i--, j++)
            board[i][j] = false;
    }

    public void printQueens(int[] x) {
        int n = x.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

            if (x[i] == j)
                System.out.print("Q ");
            else           
                System.out.print("* ");
            }

            System.out.println();
        }  

        System.out.println();
    }
 
    public void nextPiece(int n) {
        int[] a = new int[n];
        nextPiece(a, 0);
    }
 
    public void nextPiece(int[] x, int k) {
        int n = x.length;
        if (k == n) 
            printQueens(x);
        else {
            for (int i = 0; i < n; i++) {
                x[k] = i;
                if (possible(i)) {
                    markPositions(i, k);
                    nextPiece(x, k+1);
                }
            }
            resetBoard();
        }
    }   
}

public class Queens {
    public static void main(String[] args) {
        QueensSolution q = new QueensSolution(8);
        q.nextPiece(8);
    }
}