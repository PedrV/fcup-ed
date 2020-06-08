package test_pratico;

import java.util.ArrayList;

public class ED240 {
    static String path = "";

    public static String[] paths(BTree<Integer> t) {
        ArrayList<Integer> x = new ArrayList<>(t.numberNodes());
        
        maxV(t.getRoot(), x);
        
        int max = Integer.MIN_VALUE;
        int cnt = 0;
        for (Integer integer : x) {
            if (integer >= max) {
                max = integer;
                cnt++;
            }
        }

        String[] s = new String[cnt];
        int i = 0;
        if (t.getRoot().getValue().equals(max)) {
            s[0] = "R";
            t.getRoot().setValue(Integer.MIN_VALUE);
        }

        ArrayList<String> ss = new ArrayList<>();
        paths(t.getRoot(), max, "", ss);

        for (String string : ss) {
            s[i] = string;
            i++;
        }
        return s;
    }

    public static void paths(BTNode<Integer> n, int max, String temp_path, ArrayList<String> s) {
        if (n == null)
            return;

        if (n.getValue().equals(max)) {
            n.setValue(Integer.MIN_VALUE);
            s.add(temp_path);
            return;
        }

        paths(n.getLeft(), max, temp_path + "E", s);
        paths(n.getRight(), max, temp_path + "D", s);

    }

    public static void maxV (BTNode<Integer> n, ArrayList<Integer> x) {
        if (n == null) {
            return;
        }

        x.add(n.getValue());

        maxV(n.getLeft(), x);
        maxV(n.getRight(), x);
    }
}