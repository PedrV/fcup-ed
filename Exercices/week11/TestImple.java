package week11;

import java.util.Scanner;
import java.util.Arrays;

public class TestImple {
    // ED211
    public static int countEven(BTree<Integer> t) {
        BTNode<Integer> cur = t.getRoot();
        
        if (cur == null)
            return 0;
            
        BTree<Integer> left = new BTree<>();
        left.setRoot(cur.getLeft());
        
        BTree<Integer> right = new BTree<>();
        right.setRoot(cur.getRight());
        
        if ((cur.getValue() & 1) == 0)
            return 1 + countEven(left) + countEven(right);
        else
            return countEven(left) + countEven(right);
    }

    // ED212
    public static int[] sumLevels(BTree<Integer> t) {
        int[] sum = new int[t.depth()+1];

        for (int i = 0; i <= t.depth(); i++) {
            sum[i] = sumLevels(t.getRoot(), i);
        }
    
        return sum;
    }   

    private static int sumLevels(BTNode<Integer> t, int index) {

        // If a child is nonexistent them there is no need to search anymore on that lineage
        // If this happens the pointer to the child is going to be null
        if (t == null && index != 0)
            return 0;

        // Go until the depth wanted is reached
        if (index == 0)
            if (t != null)
                return t.getValue();
            else
                return 0;
        
        return sumLevels(t.getLeft(), index-1) + sumLevels(t.getRight(), index-1);
    }


    // ED213
    public static String maxSum(BTree<Integer> t) {
        
    }

    public static void main(String[] args) {
        // Ler arvore de inteiros em preorder
        String treeString1 = "6 3 2 N 1 N N 5 N 7 N N 10 8 N 9 N N 25 N N"; 
        String treeString2 = "1 2 3 4 5 6 N N N N N N N"; 
        String treeString3 = "14 4 3 N N 9 7 5 N N N N 18 16 15 N N 17 N N 20 N N"; 
        /*        String treeString2 = "6 3 2 N N 5 N N 10 N N"; 
        String treeString3 = "6 3 N N 10 N N"; 
        String treeString4 = "6 3 2 N N N 10 8 N N 25 N N"; 
        String treeString5 = "6 3 2 N N 5 N N N"; 
        String treeString6 = "6 3 N 5 N N 10 N 25 N N"; 
        
        String treeString7 = "6 N N"; 
        String treeString8 = "5 1 8 N N 6 N N 7 2 N N N"; 
 */
        Scanner in1 = new Scanner(treeString1);
        Scanner in2 = new Scanner(treeString2);
        Scanner in3 = new Scanner(treeString3);
        BTree<Integer> t1 = LibBTree.readIntTree(in1);
        BTree<Integer> t2 = LibBTree.readIntTree(in2);
        BTree<Integer> t3 = LibBTree.readIntTree(in3);
        
        System.out.println(Arrays.toString(sumLevels(t1)));
        System.out.println(Arrays.toString(sumLevels(t2)));
        System.out.println(Arrays.toString(sumLevels(t3)));
        
        /*System.out.println(t2.strict());
        System.out.println(t3.strict());
        System.out.println(t4.strict());
        System.out.println(t5.strict());
        System.out.println(t6.strict());
        System.out.println(t7.strict());
        System.out.println(t8.strict()); */
       
/*        // Escrever resultado de chamada a alguns metodos
        System.out.println("numberNodes = " + t.numberNodes());
        System.out.println("depth = " + t.depth());
        System.out.println("contains(2) = " + t.contains(2));
        System.out.println("contains(3) = " + t.contains(3));

        // Escrever nos da arvore seguindo varias ordens possiveis
        t.printPreOrder();      
        t.printInOrder();
        t.printPostOrder();
        t.printBFS();
        t.printDFS(); */
    }
}
