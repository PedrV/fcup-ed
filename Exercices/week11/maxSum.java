package week11;

//FIXME: see fixme from TestImple
/*
(Maximum Sum of tree: biggest sum of the values of the nodes of a tree that form a path)
This is a ED123 variation. This bottom-up algorithm finds the maximum sum of the subtrees of a binary tree.
---------------------------------------------------------------------------------------------------------------------------------

The way this algorithm works is that it finds the maximum sum of the subtrees of the main binary tree
and puts them in a array, starting from the bottom, the element in the last position of the array is the max sum of the subtree
that starts in the root, the original binary tree. 

- The first element of array is the max sum of the leafs (trees witout descendents)
- The second value of the array is the max sum of the subtrees whose nodes depth is (n-1)
- The third value of the array is the max sum of the subtrees whose nodes depth is (n-2)
- ...

---------------------------------------------------------------------------------------------------------------------------------



*/

import java.util.Scanner;
import java.util.Arrays;


public class maxSum {
    // Get max sum of subtrees
    public static int[] maxiSum(BTree<Integer> t) {

        int depth = t.depth();              // Get the depth of the original tree
        int[] maxNodes = new int[depth+1];  // Array for the max sum of the subtrees
        BTree<Integer> t1 = t;              // Tree to recieve the alterations of node values
        
        
        // Go to all depths, getting every subtree
        for (int i = 0; i < maxNodes.length; i++) {
            maxNodes[i] = maxNodeLevel (t1.getRoot(), depth);           // Get the max node of a level
            depth--;

            int parent = findParent(t.getRoot(), maxNodes[i]);          // Get the parent of the node with the highest value

            replaceParent(t1.getRoot(), parent, parent+maxNodes[i]);    // Substitute the parent of the node with the highest value for the mx sum of the previous subtree
        } 

        return maxNodes;
    }


    // Replace Parent of a given value x of a node by a new parent 
    // (Bonus: remove the last 3 return statements to see all the occurrences of the nodes with same value as the parent replaced)
    private static void replaceParent (BTNode<Integer> n, int x, int new_parent) {

        if (n == null)
            return;
        
        // This cases is only for the root substitution
        if (n.getValue() == x) {
            n.setValue(new_parent);
            return;
        }

        if (n.getLeft() != null) {
            if (n.getLeft().getValue() == x) {       // Found the parent on the left
                n.getLeft().setValue(new_parent);
                return;
            }
        }
        
        if (n.getRight() != null) {
            if (n.getRight().getValue() == x) {       // Found the parent on the right
                n.getRight().setValue(new_parent);
                return;
            }
        } 

        // If not found, search left and right of the current node
        replaceParent(n.getLeft(), x, new_parent);
        replaceParent(n.getRight(), x, new_parent);
    }


    // Find the parent of a node with a given value x, addmiting no duplicates
    // If a tree has duplicated values, this method will only find the first occurence of parent-child relation
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

    public static void main (String[] args) {
        // Ler arvore de inteiros em preorder
        String treeString1 = "12 9 5 3 N N 7 N N 10 N N 16 N N"; 

        Scanner in1 = new Scanner(treeString1);
        BTree<Integer> t1 = LibBTree.readIntTree(in1);
        
        System.out.println(Arrays.toString(maxiSum(t1)));
    }
}