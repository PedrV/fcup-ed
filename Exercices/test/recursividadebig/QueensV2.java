package test.recursividadebig;

public class QueensV2 {

    public static boolean possible(final int[] b, final int n) {
        for (int i = 0; i < n; i++) {
            if (b[i] == b[n])
                return false; // se for mesma coluna
            if ((b[i] - b[n]) == (n - i))
                return false; // se for na diagonal principal, esq ou dir
            if ((b[n] - b[i]) == (n - i))
                return false; // se for na diagonal secundária, esq ou dir
        }
        return true;
    }

    public static void printQueens(final int[] b) {
        final int n = b.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                if (b[i] == j)
                    System.out.print("b ");
                else
                    System.out.print("* ");
            }

            System.out.println();
        }
        System.out.println();
    }

    public static void nextPos(final int n) {
        final int[] a = new int[n];
        nextPos(a, 0);
    }

    // b[] é o array que tem em cada posiçao a posiçao que a peça vai ficar no tabuleiro, se b[0] = 3, entao a peça da linha 8 vai ficar na posiçao 4
    public static void nextPos(final int[] b, final int k) {
        final int n = b.length;
        if (k == n)
            printQueens(b);
        else {
            for (int i = 0; i < n; i++) {
                b[k] = i;
                if (possible(b, k))
                    nextPos(b, k + 1);
            }
        }
    }

    public static void main(final String[] args) {
        nextPos(8);
    }

}