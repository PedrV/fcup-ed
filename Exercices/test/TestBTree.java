package test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

// -----------------------------------------------------------
// Estruturas de Dados 2019/2020 (CC1007) - DCC/FCUP
// http://www.dcc.fc.up.pt/~pribeiro/aulas/edados1920/
// -----------------------------------------------------------
// Exemplo de utilizacao da uma arvore binaria
// Ultima alteracao: 26/04/2018
// -----------------------------------------------------------

public class TestBTree {

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

    public static int[] sumLevels(BTree<Integer> t) {
        int[] levels = new int[t.depth()+1];

        for (int i = 0; i < levels.length; i++) {
            levels[i] = sum(t.getRoot(), i);
        }

        return levels;
    }

    public static int sum(BTNode<Integer> n, int depth) {

        if (n == null)
            return 0;

        if (depth == 0)
            return n.getValue();
        else
            return sum(n.getLeft(), depth-1) + sum(n.getRight(), depth-1);

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

        // Inserindo 11 elementos na arvore binaria de pesquisa
        int[] data = {14, 4, 18, 3, 9, 16, 20, 7, 15, 17, 5};
        int[] data1 = {5,3,1,4, 10, 7, 42};
        int[] data2 = {7, 5, 6, 9, 8, 10};
        int[] data3 = {5,4,2,7,8};
/*         for (int i=0; i<data3.length; i++) {
            t.insert(data3[i]);
        } */

        t.printInOrder();

        System.out.println(t.valid());



    }
}
