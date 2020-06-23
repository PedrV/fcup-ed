package exame;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BTree<T> {
    private BTNode<T> root;

    BTree () {root = null;}

    public void setRoot(BTNode<T> root) {
        this.root = root;
    }

    public BTNode<T> getRoot() {
        return root;
    }

    public boolean isEmpty () {return root == null;}

    // --------------------------------------------------------------------------------

    public int numberNodes () {
        return numberNodes(root);   
    }
    
    private int numberNodes (BTNode<T> n) {
        if (n == null) 
            return 0;

        return 1 + numberNodes(n.getLeft()) + numberNodes(n.getRight());
    }

    // --------------------------------------------------------------------------------

    public int depth () {
        return depth(root);
    }

    private int depth (BTNode<T> n) {
        if (n == null)
            return -1;

        return 1 + Math.max(depth(n.getLeft()), depth(n.getRight()));
    }

    // --------------------------------------------------------------------------------

    public boolean contains (T value) {
        return contains(root, value);
    }

    public boolean contains (BTNode<T> n, T value) {
        if (n == null)
            return false;
        
        return n.getValue().equals(value) || contains(n.getLeft(), value) || contains(n.getRight(), value);
    }

    // --------------------------------------------------------------------------------

    public void printPreOrder () {
        printPreOrder(root);
        System.out.println();
    }

    private void printPreOrder (BTNode<T> n) {
        if (n == null)
            return;

        System.out.print(n.getValue() + " ");
        printPreOrder(n.getLeft());
        printPreOrder(n.getRight());
    }

    // --------------------------------------------------------------------------------

    public void printInOrder () {
        printInOrder(root);
        System.out.println();
    }

    private void printInOrder (BTNode<T> n) {
        if (n == null)
            return;

        printInOrder(n.getLeft());
        System.out.print(n.getValue() + " ");
        printInOrder(n.getRight());
    }

    // --------------------------------------------------------------------------------

    public void printPostOrder () {
        printPostOrder(root);
        System.out.println();
    }

    private void printPostOrder(BTNode<T> n) {
        if (n == null)
        return;

        printPostOrder(n.getLeft());
        printPostOrder(n.getRight());
        System.out.print(n.getValue() + " ");
    }

    // --------------------------------------------------------------------------------

    public void printBFS () {
        Queue<BTNode<T>> q = new LinkedList<>();

        q.add(root);

        while (!q.isEmpty()) {
            BTNode<T> cur = q.poll();
            
            if (cur != null) {
                System.out.print(cur.getValue() + " ");
                q.add(cur.getLeft());
                q.add(cur.getRight());
            }
        }
        System.out.println();
    }

    // --------------------------------------------------------------------------------

    public void printDFS () {
        Stack<BTNode<T>> s = new Stack<>();

        s.add(root);

        while (!s.isEmpty()) {
            BTNode<T> cur = s.pop();
            
            if (cur != null) {
                System.out.print(cur.getValue() + " ");
                s.add(cur.getLeft());
                s.add(cur.getRight());
            }
        }
        System.out.println();
    }  

}