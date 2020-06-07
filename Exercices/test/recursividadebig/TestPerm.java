package test.recursividadebig;

class Perm<T> {
    private T[] v;
    private boolean[] used;
    private int perm[]; 

    Perm (T[] v) {
        this.v = v;
        used = new boolean[v.length];
        perm = new int[v.length];
    }

    public void perms () {
        goPerm (0);
    }

    private void goPerm (int cur) {

        if (cur == v.length) {

            for (int i = 0; i < v.length; i++) 
                System.out.print(v[perm[i]] + " ");

            System.out.println();

        } else {

            for (int i = 0; i < v.length; i++) {
                if (!used[i]) {
                    used[i] = true;
                    perm[i] = cur;
                    goPerm(cur+1);
                    used[i] = false;
                }
            }
        }

    }
}

public class TestPerm {


    // Num metodo static parametrizado se este pertencer a uma clase, esta pode não ser parametrizada que este metodo chega para aguentar parametros para si
    public static <T> void perm (T[] v) {
        boolean[] used = new boolean[v.length];
        int[] perm = new int[v.length];

        goPerm(v, perm, used, 0);
    }

    public static <T> void goPerm(T[] v, int[] perm, boolean[] used, int cur) {
        
        if (cur == v.length) {

            for (int i = 0; i < v.length; i++) 
                System.out.print(v[perm[i]] + " ");

            System.out.println();

        } else {

            for (int i = 0; i < v.length; i++) {
                if (!used[i]) {
                    used[i] = true;
                    perm[i] = cur;
                    goPerm(v, perm, used, cur+1);
                    used[i] = false;
                }
            }
        }
    }


    public static void main(String[] args) {

        Integer v[] = {1,2,3}; // Inicializacao de array

        Perm<Integer> p = new Perm<>(v);

        p.perms();
           
    }
}