package exame;

/* ALtura da árvore: log(n+1) - 1 (de 0 a h,onde n é o numero total de nos
   Numero total de nos: 2^(h+1)-1 - onde h é a altura de da àrvore 
*/

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BSTree<T extends Comparable<? super T>> {
    private BSTNode<T> root;

    BSTree () {root = null;}

    public BSTNode<T> getRoot() {
        return root;
    }

    public void setRoot(BSTNode<T> root) {
        this.root = root;
    }

    public boolean isEmpty () {return root == null;}

    public int numberNodes () {
        return numberNodes(root);
    }

    private int numberNodes(BSTNode<T> n) {
        if (n == null)
            return 0;
        
        return 1 + numberNodes(n.getLeft()) + numberNodes(n.getRight());
    }

    // --------------------------------------------------------------------------------

    public int depth () {
        return depth(root);
    }

    private int depth(BSTNode<T> n) {
        if (n == null)
            return -1;
        
        return 1 + Math.max(depth(n.getLeft()),depth(n.getRight()));
    }

    // --------------------------------------------------------------------------------

    public boolean contains (T value) {
        return contains(root, value);
    }

    private boolean contains (BSTNode<T> n, T value) {
        if (n == null)
            return false;
        
        if (n.getValue().compareTo(value) > 0) 
            return contains(n.getLeft(), value);
        if (n.getValue().compareTo(value) < 0)
            return contains(n.getRight(), value);

        return true;
    }

    // --------------------------------------------------------------------------------

    public boolean insert (T value) {
        if (contains(value))
            return false;
        
        root = insert(root,value);
        return true;
    }

    private BSTNode<T> insert (BSTNode<T> n, T value) {

        if (n == null)
            return new BSTNode<T>(value, null, null);
        else if (n.getValue().compareTo(value) > 0) 
            n.setLeft(insert(n.getLeft(), value));
        else if (n.getValue().compareTo(value) < 0)
            n.setRight(insert(n.getRight(), value));
        
        return n;
    }


    // --------------------------------------------------------------------------------

    public boolean remove (T value) {
        if (!contains(value))
            return false;
        root = remove(root, value);
        return true;
    }

    private BSTNode<T> remove (BSTNode<T> n, T value) {

        if (n.getValue().compareTo(value) > 0)
            n.setLeft(remove(n.getLeft(), value));
        else if (n.getValue().compareTo(value) < 0)
            n.setRight(remove(n.getRight(), value));
        else if (n.getLeft() == null)
            return n = n.getRight();
        else if (n.getRight() == null)
            return n = n.getLeft();
        else {
            BSTNode<T> max = n.getLeft();

            while (max.getRight() != null)
                max = max.getRight();

            n.setValue(max.getValue());
            n.setLeft(remove(max, max.getValue()));
        }

        return n;
    }


    // --------------------------------------------------------------------------------


    public void printPreOrder () {
        printPreOrder(root);
        System.out.println();
    }

    private void printPreOrder (BSTNode<T> n) {
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

    private void printInOrder (BSTNode<T> n) {
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

    private void printPostOrder(BSTNode<T> n) {
        if (n == null)
        return;

        printPostOrder(n.getLeft());
        printPostOrder(n.getRight());
        System.out.print(n.getValue() + " ");
    }

    // --------------------------------------------------------------------------------

    public void printBFS () {
        Queue<BSTNode<T>> q = new LinkedList<>();

        q.add(root);

        while (!q.isEmpty()) {
            BSTNode<T> cur = q.poll();
            
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
        Stack<BSTNode<T>> s = new Stack<>();

        s.add(root);

        while (!s.isEmpty()) {
            BSTNode<T> cur = s.pop();
            
            if (cur != null) {
                System.out.print(cur.getValue() + " ");
                s.add(cur.getLeft());
                s.add(cur.getRight());
            }
        }
        System.out.println();
    }
}