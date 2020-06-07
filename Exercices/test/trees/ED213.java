package test.trees;

import java.util.Scanner;

public class ED213 {
    static int max_final = Integer.MIN_VALUE;
    static String path_final = "";

    // Maximo até um certo nivel k
   /*  public static String maxSum(BTree<Integer> t, int k) {
        maxSum(t.getRoot(), 0, "", k);
        return path_final;
    }

    private static void maxSum (BTNode<Integer> n, int sum, String path, int level) {
        if(n == null)
            return;
        
        sum += n.getValue();  

        // if (n.getLeft() == null && n.geRight() == null)
        if (level == 0)
            return;

        if (sum > max_final) {
            max_final = sum;
            path_final = path;
        }

        maxSum(n.getLeft(), sum, path + "E", level-1);
        maxSum(n.getRight(), sum, path + "D", level-1);

    } */

    public static String maxSum(BTree<Integer> t) {
        maxSum(t.getRoot(), 0, "");
        return path_final;
    }

    private static void maxSum (BTNode<Integer> n, int sum, String path) {
        if(n == null)
            return;
        
        sum += n.getValue();  

        // if (n.getLeft() == null && n.geRight() == null)
        if (sum > max_final) {
            max_final = sum;
            path_final = path;
        }

        maxSum(n.getLeft(), sum, path + "E");
        maxSum(n.getRight(), sum, path + "D");

    }

    public static void main(String[] args) {
        Scanner scan = new Scanner (System.in);
        BTree<Integer> t = LibBTree.readIntTree(scan);
        System.out.println(maxSum(t));
    }
}