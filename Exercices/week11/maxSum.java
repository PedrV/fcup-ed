package week11;

/*
(Maximum Sum of tree: biggest sum of the values of the nodes of a tree that form a path)
This is a ED213 possibility. 
---------------------------------------------------------------------------------------------------------------------------------

- This bottom-up algorithm finds the maximum sum of the tree and gives the path from root to end node to obtain it.

The way this algorithm works is that it finds the maximum sum of the subtrees of the main binary tree
and puts them in a array, starting from the bottom, the element in the last position of the array is the max sum of the subtree
that starts in the root, the original binary tree. 

At the same time, the node values of the tree are modified to recieve the max sum of the subtree at the current depth.
e.g the node at depth 2 that originates the biggest subtree of depth n-2, where n is depth of the original tree, will have is
value replaced with the max sum of his subtree.

(If the values of the original tree cannot be changed, on adjacent tree must be created).
---------------------------------------------------------------------------------------------------------------------------------
*/

import java.util.Scanner;
import javafx.util.Pair;

public class maxSum {

    public static String maxiSum (BTree<Integer> t) {
        String path = "";               // Directions starting from root to the last node
        int[] max_path = maxPath(t);    // Each max sum of a subtree


        // Start always from the root so there is no need to check it, start at position n-2 from the array
        for (int i = max_path.length-2; i >= 0; i--) {

            if (t.getRoot().getLeft() != null)
                if (t.getRoot().getLeft().getValue() == max_path[i]) {          // If the alteration is to the left of the current node  
                    path += "E";                                                // Write "E" for left
                    t.setRoot(t.getRoot().getLeft());                           // Set the node to the left as the root to start searching from there
            } 
            
            if (t.getRoot().getRight() != null) {
                if (t.getRoot().getRight().getValue() == max_path[i]) {         // If the alteration is to the right of the current node  
                    path += "D";                                                // Write "E" for right
                    t.setRoot(t.getRoot().getRight());                          // Set the node to the right as the root to start searching from there
                }
            }
                
        }

        return path;
    }


    // Get one array with the path to get the maxSum.
    // Each array element has the max sum at a given subtree, the last element is the max sum of the original tree
    public static int[] maxPath(BTree<Integer> t) {

        int depth = t.depth();                  // Get the depth of the original tree
        int[] path = new int[(depth+1)];        // Array for the max sum of the subtrees
        
        for (int i = 0; i < path.length; i ++ ) {

            // Key of Pair: the child originating the best sum. Value of Pair: the best sum
            Pair<Integer, Integer> p = maxNodeLevel (t.getRoot(), depth, depth-1, t);

            // Find the parent of the child at Key with proper depth
            int parent = findParent(t.getRoot(), p.getKey(), depth-1);

            // Update the path with the wanted node (child)
            path[i] = p.getKey();
            // path[i+1] = parent;
           
            depth--;
            // Replace the old parent with the new value of the child+parent at Value
            replaceParent(t.getRoot(), parent, p.getValue());
        } 

        return path;
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
            if (n.getRight().getValue() == x) {      // Found the parent on the right
                n.getRight().setValue(new_parent);
                return;
            }
        } 

        // If not found, search left and right of the current node
        replaceParent(n.getLeft(), x, new_parent);
        replaceParent(n.getRight(), x, new_parent);
    }


    // Find the parent of a node with a given value x, at a given depth (the depth garantes that this search tool works with trees with duplicates)
    // (Behaviour: If there is a duplicate value in the same depth, this alghoritm will find the on most to the left) 
    private static int findParent (BTNode<Integer> n, int x, int depth) {

        if (n == null)
            return 0;
        
        if (n.getLeft() != null && n.getRight() != null) {

            if ( (n.getLeft().getValue() == x && depth == 0) || (n.getRight().getValue() == x && depth == 0) )
                return n.getValue();

        } else if (n.getLeft() != null) {

            if (n.getLeft().getValue() == x && depth == 0) 
                return n.getValue();

        } else if (n.getRight() != null) {

            if (n.getRight().getValue() == x && depth == 0) 
                return n.getValue();

        } else {
            return 0;
        }
    
        return findParent(n.getLeft(), x, depth-1) + findParent(n.getRight(), x, depth-1);
    }

    
    // Get the combination of max node at a given depth and the sum of with his parent at proper depth
    // (Suggestion: Instead of returning the sum, returning the parent instead would avoid getting it again in maxPath)
    private static Pair<Integer,Integer> maxNodeLevel (BTNode<Integer> n, int depth, int pdepth, BTree<Integer> t) {
        Pair<Integer,Integer> p, l, r;
        
        if (n == null)
            return p = new Pair <Integer, Integer> (Integer.MIN_VALUE, Integer.MIN_VALUE);
        
        if (depth == 0) 
            return p = new Pair<Integer,Integer>(n.getValue(), n.getValue() + findParent(t.getRoot(), n.getValue(), pdepth));
        
        
        l = maxNodeLevel(n.getLeft(), depth - 1, pdepth, t);
        r = maxNodeLevel(n.getRight(), depth - 1, pdepth, t);
        
        int v1 = (int) l.getValue();
        int v2 = (int) r.getValue();
        
        // Return Pair with the greatest sum
        if (v1 > v2)
            return l;
        else
            return r;
    }
    


    // Find the max Node on each level independet from the others
/*     private static int maxNodeLevel (BTNode<Integer> n, int depth) {

        if (n == null)
            return Integer.MIN_VALUE;

        if (depth == 0) 
            return n.getValue();
        
        return Math.max(maxNodeLevel(n.getLeft(), depth-1), maxNodeLevel(n.getRight(), depth-1));
    } */



    public static void main (String[] args) {
        // Ler arvore de inteiros em preorder
        String treeString1 = "12 9 5 3 N N 7 N N 10 N N 16 N N"; 

        Scanner in1 = new Scanner(treeString1);
        BTree<Integer> t1 = LibBTree.readIntTree(in1);
        
        System.out.println(maxiSum(t1));
    }
}