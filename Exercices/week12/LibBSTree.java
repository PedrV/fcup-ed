package week12;

import java.util.Scanner;

public class LibBSTree {
    public static BSTree<Integer> readIntTree (Scanner scan) {
        BSTree<Integer> t = new BSTree<>();
        
        t.setRoot(readIntNode(scan));

        return t;
    }

    public static BSTNode<Integer> readIntNode (Scanner scan) {
        
        String s = scan.next();

        if (s.equals("N"))
            return null;
        
        int value = Integer.parseInt(s);
        BSTNode<Integer> left = readIntNode(scan);
        BSTNode<Integer> right = readIntNode(scan);
        return new BSTNode<Integer>(value, left, right);
    }
}