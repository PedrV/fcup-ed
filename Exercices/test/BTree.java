package test;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BTree<T> {
    private BTNode<T> root;

    BTree() {
        root = null;
    }

    public BTNode<T> getRoot() {
        return root;
    }

    public void setRoot(BTNode<T> root) {
        this.root = root;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public int numberNodes() {
        return numberNodes(root);
    }

    private int numberNodes(BTNode<T> n) {
        if (n == null)
            return 0;

        return 1 + numberNodes(n.getLeft()) + numberNodes(n.getRight());
    }

    public int depth() {
        return depth(root);
    }

    private int depth(BTNode<T> n) {
        if (n == null)
            return -1;

        return 1 + Math.max(depth(n.getLeft()), depth(n.getRight()));
    }

    public boolean contains(T elem) {
        return contains(root, elem);
    }

    private boolean contains(BTNode<T> n, T elem) {
        if (n == null)
            return false;

        if (n.getValue().equals(elem))
            return true;

        return contains(n.getLeft(), elem) || contains(n.getRight(), elem);
    }

    public void printPreOrder() {
        System.out.print("PreOrder:");
        printPreOrder(root);
        System.out.println();
    }

    private void printPreOrder(BTNode<T> n) {
        if (n == null)
            return;

        System.out.print(" " + n.getValue());
        printPreOrder(n.getLeft());
        printPreOrder(n.getRight());
    }

    public void printInOrder () {
        System.out.print("InOrder:");
        printInOrder(root);
        System.out.println();
    }

    private void printInOrder (BTNode<T> n) {
        if (n == null)
            return;
        
        printInOrder(n.getLeft());
        System.out.print(" " + n.getValue());
        printInOrder(n.getRight());
    }  

    public void printPostOrder() {
        System.out.print("PostOrder:");
        printPostOrder(root);
        System.out.println();
    }

    public void printPostOrder(BTNode<T> n) {
        if (n == null)
            return;

        printPostOrder(n.getLeft());
        printPostOrder(n.getRight());
        System.out.print(" " + n.getValue());
    }

    public void printBFS () {
        System.out.print("BFS:");
        Stack<BTNode<T>> s = new Stack<>();

        BTNode<T> n = root;

        s.add(n);

        while (!s.isEmpty()) {
            n = s.pop(); 

            if (n != null) {
                System.out.print(" " + n.getValue());
                s.add(n.getLeft());
                s.add(n.getRight());
            }
        }
        System.out.println();
    }

    public void printDFS () {
        System.out.print("DFS:");
        Queue<BTNode<T>> q = new LinkedList<>();
        BTNode<T> n = root;

        q.add(n);

        while (!q.isEmpty()) {
            n = q.remove();

            if (n != null) {
                System.out.print(" " + n.getValue());
                q.add(n.getLeft());
                q.add(n.getRight());
            }
        }
        System.out.println();
    }


    // ED204 - Number of leafs
    // ------------------------------------------------------------------------ \\
    public int numberLeafs() {
        return numberLeafs(root);
    }

    private int numberLeafs(BTNode<T> n) {
        if (n == null)
            return 0;
        
        if (n.getLeft() == null && n.getRight() == null)
            return 1;

        return numberLeafs(n.getLeft()) + numberLeafs(n.getRight());
    }

    // ED205 - Return if a tree is strictly binary
    // ------------------------------------------------------------------------ \\
    public boolean strict() {
        return strict(root);
    }

    private boolean strict (BTNode<T> n) {
        if (n == null)
            return true;
        
        if ((n.getLeft() != null && n.getRight() == null) || (n.getLeft() == null && n.getRight() != null)) 
            return false;
        
        return strict(n.getLeft()) && strict(n.getRight());
    }

    // ED206 - Return the value at the end of path
    // ------------------------------------------------------------------------ \\
    public T path(String s) {
        return path(root, s, 0);
    }

    private T path(BTNode<T> n, String s, int i) {

        if (i == s.length())
            return n.getValue();
        
        if (s.charAt(i) == 'E') 
            return path(n.getLeft(), s, i+1);
        else if (s.charAt(i) == 'D')
            return path(n.getRight(), s, i+1);
        else 
            return n.getValue();
    }

    // ED207 - Number of nodes at a given depth
    // ------------------------------------------------------------------------ \\
    public int nodesLevel(int k)  {
        return nodesLevel(root, k);
    }

    private int nodesLevel (BTNode<T> n, int k) {
            
        if (n == null)
            return 0;
        
        if (k == 0)
            return 1;

        return nodesLevel(n.getLeft(), k-1) + nodesLevel(n.getRight(), k-1);
    }


    // ED233
    // ------------------------------------------------------------------------ \\
    public int internal() {
        return internal(root);
    }

    private int internal(BTNode<T> n) {

        if (n == null)
            return 0;

        if (n.getLeft() != null || n.getRight() != null)
            return 1 + internal(n.getLeft()) + internal(n.getRight());
        else
            return internal(n.getLeft()) + internal(n.getRight());
    }

    public void cut(int d) {
        if (d < 0) {
            setRoot(null);
            return;
        } else if (d > depth()) {
            return;
        }

        setRoot(cut(root, d));
    }

    private BTNode<T> cut (BTNode<T> n, int d) {
        if (d == 0)
            return null;
        
        n.setLeft(cut(n.getLeft(), d-1));
        n.setRight(cut(n.getRight(), d-1));
        return n;
    }

    public int[] maxLevel() {

        Queue<BTNode<T>> q = new LinkedList<>();
        int[] max = {0,0}; // Max level count, how many levels with that level count
        BTNode<T> n = root;

        int nodes = 0;          // Number of nodes at a level
        int change_level = 0;   // Flag to see when is a change of level is needed
        int level = 0;          // Current level with nodes being counted
        int[] level_nodes = new int[depth()+2]; // +2 because depth counts root at 0, and the other +1 is because the queue takes 1 more cycle to get empty because of the leafs

        // Add the root node to the list
        q.add(n);
        level_nodes[level++] += 1;

        while (!q.isEmpty()) {

            n = q.poll();

            // Check if has left child
            if (n.getLeft() != null) {
                q.add(n.getLeft());
                nodes++;
            }

            // Check if has right child
            if (n.getRight() != null) {
                q.add(n.getRight());
                nodes++;
            }


            if (change_level == 0) {    // When hits 0, all the nodes of the current level had already exited the queue
                level_nodes[level++] += nodes;  // Update number of nodes at level
                change_level = nodes;   // Get ou many nodes it needs to exit the queue to change level again
                nodes = 0;  // Reset number of nodes to count next level
            }

            change_level--;

        }

        // See level with biggest node count and in how many the count is max
        for (int i = 0; i < level_nodes.length-1; i++) {
            if (level_nodes[i] > max[0]) {
                max[0] = level_nodes[i];
                max[1] = 1;
            } else if (level_nodes[i] == max[0]) 
                max[1]++;
        }

        return max;
    }

}