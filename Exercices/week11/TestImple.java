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
    public static int[] maxSum(BTree<Integer> t) {
        int depth = t.depth();
        int[] maxNodes = new int[depth+1];
        BTree<Integer> t1 = t;
        
    
        for (int i = 0; i < maxNodes.length; i++) {
            maxNodes[i] = maxNodeLevel (t1.getRoot(), depth);
            depth--;

            int parent = findParent(t.getRoot(), maxNodes[i]);

            replaceParent(t1.getRoot(), parent, parent+maxNodes[i]);
        } 

        return maxNodes;
    }

    private static void replaceParent (BTNode<Integer> n, int x, int new_parent) {

        if (n == null)
            return;
        
        // This cases is only for the root substitution
        if (n.getValue() == x) {
            n.setValue(new_parent);
            return;
        }

        if (n.getLeft() != null) {
            if (n.getLeft().getValue() == x) 
                n.getLeft().setValue(new_parent);
        }
        
        if (n.getRight() != null) {
            if (n.getRight().getValue() == x) 
                n.getRight().setValue(new_parent);
        } 

        replaceParent(n.getLeft(), x, new_parent);
        replaceParent(n.getRight(), x, new_parent);
    }

    private static int findParent (BTNode<Integer> n, int x) {

        if (n == null)
            return 0;
        
        if (n.getLeft() != null && n.getRight() != null) {

            if (n.getLeft().getValue() == x || n.getRight().getValue() == x) 
                return n.getValue();

        } else if (n.getLeft() != null) {

            if (n.getLeft().getValue() == x) 
                return n.getValue();

        } else if (n.getRight() != null) {

            if (n.getRight().getValue() == x) 
                return n.getValue();

        } else {
            return 0;
        }
    
        return findParent(n.getLeft(), x) + findParent(n.getRight(), x);
    }

    private static int maxNodeLevel (BTNode<Integer> n, int depth) {

        if (n == null)
            return Integer.MIN_VALUE;

        if (depth == 0) 
            return n.getValue();
        
        return Math.max(maxNodeLevel(n.getLeft(), depth-1), maxNodeLevel(n.getRight(), depth-1));
    }

    public static void main(String[] args) {
        // Ler arvore de inteiros em preorder
        String treeString1 = "12 9 5 3 N N 7 N N 10 N N 16 N N"; 
        /*        String treeString2 = "6 3 2 N N 5 N N 10 N N"; 
        String treeString3 = "6 3 N N 10 N N"; 
        String treeString4 = "6 3 2 N N N 10 8 N N 25 N N"; 
        String treeString5 = "6 3 2 N N 5 N N N"; 
        String treeString6 = "6 3 N 5 N N 10 N 25 N N"; 
        
        String treeString7 = "6 N N"; 
        String treeString8 = "5 1 8 N N 6 N N 7 2 N N N"; 
 */
        Scanner in1 = new Scanner(treeString1);

        BTree<Integer> t1 = LibBTree.readIntTree(in1);
        
        System.out.println(Arrays.toString(maxSum(t1)));

        
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
