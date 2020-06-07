package test.trees;

import java.util.Arrays;
import java.util.Scanner;

public class TestBTree {

    // ED211
    public static int countEven(BTree<Integer> t) {
        return countEven(t.getRoot());
    }

    private static int countEven (BTNode<Integer> n) {
        if (n == null)
            return 0;

        if (n.getValue() % 2 == 0)
            return 1 + countEven(n.getLeft()) + countEven(n.getRight());
        else
            return countEven(n.getLeft()) + countEven(n.getRight());
    }
    
    // ------------------------------------------------------------------------ \\

    // ED212
    public static int[] sumLevels(BTree<Integer> t) {
        int depth = t.depth()+1;
        int[] sum = new int[depth];
        for (int i = 0; i < depth; i++) {
            sum[i] = sumLevels(t.getRoot(), i);
        }

        return sum;
    }   

    private static int sumLevels(BTNode<Integer> n, int level) {
        if (n == null)
            return 0;

        if (level == 0)
            return n.getValue();

        return sumLevels(n.getLeft(), level-1) + sumLevels(n.getRight(), level-1);
    }

    public static void main(String[] args) {

/*         String line = "6 3 2 1 N N N 5 N 7 N N 10 8 N 9 N N 25 N N";
        String line1 = "6 3 2 N N 5 N N 10 N N";
        String line2 = "6 3 N 5 N 7 N N 10 8 N 9 N N 25 N N";
        String line3 = "6 3 2 1 N N N N N";
        String line4 = "42 N N";
        
        // Ler arvore de inteiros em preorder
        Scanner in = new Scanner(line);
        Scanner in1 = new Scanner(line1);
        Scanner in2 = new Scanner(line2);
        Scanner in3 = new Scanner(line3);
        Scanner in4 = new Scanner(line4);

        BTree<Integer> t = LibBTree.readIntTree(in);
        BTree<Integer> t1 = LibBTree.readIntTree(in1);
        BTree<Integer> t2 = LibBTree.readIntTree(in2);
        BTree<Integer> t3 = LibBTree.readIntTree(in3);
        BTree<Integer> t4 = LibBTree.readIntTree(in4);
 */
        // Escrever resultado de chamada a alguns metodos
/*         System.out.println("numberNodes = " + t.numberNodes());
        System.out.println("depth = " + t.depth());
        System.out.println("contains(2) = " + t.contains(2));
        System.out.println("contains(3) = " + t.contains(3));
 */
/*         System.out.println(Arrays.toString(t.maxLevel()));
        System.out.println(Arrays.toString(t1.maxLevel()));
        System.out.println(Arrays.toString(t2.maxLevel()));
        System.out.println(Arrays.toString(t3.maxLevel()));
        System.out.println(Arrays.toString(t4.maxLevel())); */

/*         System.out.println(t1.internal());
        System.out.println(t2.internal());
        System.out.println(t3.internal());
        System.out.println(t4.internal()); */
        

        BSTree<Integer> t = new BSTree<Integer>();
        BSTree<Integer> t1 = new BSTree<Integer>();
        BSTree<Integer> t2 = new BSTree<Integer>();
        BSTree<Integer> t3 = new BSTree<Integer>();

        // Inserindo 11 elementos na arvore binaria de pesquisa
        int[] data = {14, 4, 18, 3, 9, 16, 20, 7, 15, 17, 5};
        int[] data1 = {5,3,1,4, 10, 7, 42};
        int[] data2 = {7, 5, 6, 9, 8, 10};
        int[] data3 = {5,4,2,7,8};
        int[] data4 = {6,3,10,1,4,8,42,2,7,23,54};
/*         for (int i=0; i<data4.length; i++) {
            t.insert(data4[i]);
        } */
        

        String s = "5 3 1 N N 4 N N 10 7 N N 42 N N";
        String s1 = "7 5 N 6 N N 9 8 N N 10 N N";
        String s2 = "5 4 2 N N 7 N N 8 N N";
        String s3 = "5 3 1 N N 2 N N 7 6 N N 8 N N";

        Scanner scan = new Scanner (s);
        Scanner scan1 = new Scanner (s1);
        Scanner scan2 = new Scanner (s2);
        Scanner scan3 = new Scanner (s3);

        t = LibBSTree.readIntTree(scan);
        t1 = LibBSTree.readIntTree(scan1);
        t2 = LibBSTree.readIntTree(scan2);
        t3 = LibBSTree.readIntTree(scan3);

        System.out.println(t.valid());
        System.out.println(t1.valid());
        System.out.println(t2.valid());
        System.out.println(t3.valid());
    }
}
