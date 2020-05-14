package week11;

import week11.util.*;

public class BTree<T> {
    private BTNode<T> root;

    // Constructor
    BTree () {
        root = null;
    }


    public boolean isEmpty () {
        return root == null;
    }

    // Setters and Getters for root
    public void setRoot (BTNode<T> root) {
        this.root = root; 
    }

    public BTNode<T> getRoot () {
        return root;
    }

    // Return the total number of Nodes
    // ------------------------------------------------------------------------ \\
    public int numberNodes () {
        return numberNodes(root);
    }

    private int numberNodes (BTNode<T> n) {
        if (n == null)
            return 0;
        
        return 1 + numberNodes(n.getLeft()) + numberNodes(n.getRight());
    }
    // ------------------------------------------------------------------------ \\


    // Return the max depth (max size of the path from root to leaf)   
    // ------------------------------------------------------------------------ \\
    public int depth () {
        return depth(root);
    }

    private int depth (BTNode<T> n) {
        if (n == null)
            return -1;
        
        return 1 + Math.max(depth(n.getLeft()), depth(n.getRight()));
    }
    // ------------------------------------------------------------------------ \\


    // Search Tree for element
    // ------------------------------------------------------------------------ \\
    public boolean contains (T element) {
        return contains(root, element);
    }

    private boolean contains (BTNode<T> n, T element) {
        if (n == null)
            return false;

        if (n.getValue().equals(element))
            return true;
        
        return (contains(n.getLeft(), element) || contains(n.getRight(), element));
    }
    // ------------------------------------------------------------------------ \\


    // Print Tree in PreOrder
    // ------------------------------------------------------------------------ \\
    public void printPreOrder () {
        System.out.print("PreOrder:"); // Mooshak requests
        printPreOrder(root);
        System.out.println();
    }

    private void printPreOrder (BTNode<T> n) {
        if (n == null) 
            return;

        System.out.print(" " + n.getValue());
        printPreOrder(n.getLeft());
        printPreOrder(n.getRight());
    }
    // ------------------------------------------------------------------------ \\


    // Print Tree InOrder
    // ------------------------------------------------------------------------ \\
    public void printInOrder () {
        System.out.print("InOrder:"); // Mooshak requests
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
    // ------------------------------------------------------------------------ \\


    // Print Tree PostOrder
    // ------------------------------------------------------------------------ \\
    public void printPostOrder () {
        System.out.print("PostOrder:"); // Mooshak requests
        printPostOrder(root);
        System.out.println();
    }

    public void printPostOrder (BTNode<T> n) {
        if (n == null)
            return;
        
        printPostOrder(n.getLeft());
        printPostOrder(n.getRight());
        System.out.print(" " + n.getValue());
    }
    // ------------------------------------------------------------------------ \\


    // Print Tree in BFS
    // ------------------------------------------------------------------------ \\
    public void printBFS () {
        System.out.print("BFS:"); // Mooshak requests
        printBFS(root);
        System.out.println();
    }

    private void printBFS (BTNode<T> n) {
        MyQueue<BTNode<T>> q = new LinkedListQueue<> ();

        q.enqueue(n);
        
        while (!q.isEmpty()) {
            BTNode<T> cur = q.dequeue();

            if (cur != null) {
                System.out.print(" " + cur.getValue());
                q.enqueue(cur.getLeft());
                q.enqueue(cur.getRight());
            }
        }
    }
    // ------------------------------------------------------------------------ \\


    // Print Tree DFS
    // ------------------------------------------------------------------------ \\
    public void printDFS () {
        System.out.print("DFS:"); // Mooshak requests
        printDFS (root);
        System.out.println();
    }

    private void printDFS (BTNode<T> n) {
        MyStack<BTNode<T>> s = new LinkedListStack <> ();

        s.push(n);

        while (!s.isEmpty()) {
            BTNode<T> cur = s.pop();

            if (cur != null) {
                System.out.print(" " + cur.getValue());
                s.push(cur.getLeft());
                s.push(cur.getRight());
            }
        }
    }
    // ------------------------------------------------------------------------ \\


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
    // ------------------------------------------------------------------------ \\


    // ED205 - Return if a tree is strictly binary
    // ------------------------------------------------------------------------ \\
    public boolean strict() {
        return strict(root);
    }

    private boolean strict(BTNode<T> n) {
        if (n == null) 
            return true;
        
        if (n.getLeft() == null && n.getRight() != null)
            return false;
        else if (n.getLeft() != null && n.getRight() == null)
            return false;

        return strict(n.getLeft()) && strict(n.getRight());
    } 
    // ------------------------------------------------------------------------ \\


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
    // ------------------------------------------------------------------------ \\


    // ED207 - Number of nodes at a given depth
    // ------------------------------------------------------------------------ \\
    public int nodesLevel(int k)  {
        return nodesLevel(root, k);
    }

    private int nodesLevel(BTNode<T> n, int k) {

        if (n == null)
            return 0;

        if (k == 0)
            return 1;
        
        return nodesLevel(n.getLeft(), k-1) + nodesLevel(n.getRight(), k-1);
        
    }
    // ------------------------------------------------------------------------ \\

}