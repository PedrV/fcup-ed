package test;

/* ----------------------------------------------------------------- 
Utility class used to construct a tree (in this case of Integers) 
from the stdin. Works on tree representations on PreOrder.   

Ex: 5 1 8 N N 6 N N 7 2 N N N

- "N" represents the end of a ancestry.                                                       
------------------------------------------------------------------ */

import java.util.Scanner;

public class LibBTree {
    public static BTree<Integer> readIntTree (Scanner scan) {

        BTree<Integer> tree = new BTree<>();
        tree.setRoot(readIntNode(scan));

        return tree;
    }

    public static BTNode<Integer> readIntNode (Scanner scan) {

        String s = scan.next();

        if (s.equals("N"))
            return null;
        
        int value = Integer.parseInt(s);
        BTNode<Integer> left = readIntNode(scan);
        BTNode<Integer> right = readIntNode(scan);
        return new BTNode<Integer>(value, left, right);
    }
}