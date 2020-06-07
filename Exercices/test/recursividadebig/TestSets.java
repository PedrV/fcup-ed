package test.recursividadebig;

class Sets<T> {
    private T[] v;
    private boolean[] used;

    Sets (T[] v) {
        this.v = v;
        used = new boolean[v.length];
    }

    public void sets () {
        goSets(0);
    }

    private void goSets (int cur) {

        if (cur == v.length) {

            for (int i = 0; i < v.length; i++)
                if (used[i])
                    System.out.print(v[i] + " ");
            System.out.println();

        } else {
            used[cur] = true;
            goSets(cur+1);
            used[cur] = true;
            goSets(cur+1);
        }
    }
}



public class TestSets {

    static <T> void sets (T[] v) {
        boolean[] used = new boolean[v.length];
        goSets(v, used, 0);
    }

    static <T> void goSets (T[] v, boolean[] used, int cur) {
        if (cur == v.length) {

            for (int i = 0; i < v.length; i++)
                if (used[i])
                    System.out.print(v[i] + " ");
            System.out.println();

        } else {
            used[cur] = true;
            goSets(v, used, cur+1);
            used[cur] = false;
            goSets(v, used, cur+1);
        }
    }


    public static void main(String[] args) {
        Integer[] v = {1,2,3,4};

        TestSets.sets(v);
    }
}