package test.trees;

import week11.util.*;

public class BSTree<T extends Comparable <? super T>> {
    private BSTNode<T> root;

    public BSTree () {
        root = null;
    }

    public boolean isEmpty () {
        return root == null;
    }

    public void setRoot (BSTNode<T> node) {
        root = node;
    }

    public BSTNode<T> getRoot () {
        return root;
    }

    public void clear () {
        root = null;
    }

    //-------------------------------------------------------------------

    public int numberNodes () {
        return numberNodes(root);
    }

    private int numberNodes (BSTNode<T> n) {
        if (n == null) 
            return 0; 
        return 1 + numberNodes(n.getLeft()) + numberNodes(n.getRight());
    } 

    //-------------------------------------------------------------------
    
    public int depth () {
        return depth(root);
    }
    
    private int depth (BSTNode<T> n) {
        if (n == null)
            return -1;

        return 1 + Math.max(depth(n.getLeft()), depth(n.getRight()));
    }

    //-------------------------------------------------------------------

    public boolean contains (T value) {
        return contains(root, value);
    }   

    private boolean contains (BSTNode<T> n, T v) {
        if (n == null)
            return false;

        if (n.getValue().compareTo(v) < 0)
            return contains(n.getLeft(), v);
        else if (n.getValue().compareTo(v) > 0)
            return contains(n.getRight(), v);
        else 
            return true;
    }

    public boolean insert (T value) {
        if (contains(root, value))
            return false;

        root = insert(root, value);

        return true;
    }

    private BSTNode<T> insert (BSTNode<T> n, T value) {
        if (n == null)
            return new BSTNode<T>(value, null, null);
        
        if (value.compareTo(n.getValue()) < 0)
            n.setLeft(insert(n.getLeft(), value));
        else if (value.compareTo(n.getValue()) > 0)
            n.setRight(insert(n.getRight(), value));

        return n;
    }

    public boolean remove (T value) {
        if (!contains(root, value))
            return false;

        remove (root, value);

        return true;
    }

    private BSTNode<T> remove (BSTNode<T> n, T v) {

        if (v.compareTo(n.getValue()) < 0)
            n.setLeft(remove(n.getLeft(), v));
        else if (v.compareTo(n.getValue()) > 0)
            n.setRight(remove(n.getRight(), v));
        else if (n.getLeft() == null)
            n = n.getRight();
        else if (n.getRight() == null)
            n = n.getLeft();
        else {
            BSTNode<T> max = n.getLeft();

            while (max.getRight() != null)          // Procurar maior valor lado esquerdo
                max = max.getRight();
            
            n.setValue(max.getValue());             // Node passa a ter o maior valor do lado esquerdo (ou seja o valor pretendido é removido)
            remove(n.getLeft(), max.getValue());
        }

        return n;
    }
   
    //-------------------------------------------------------------------


    public void printPreOrder () {
        System.out.print("PreOrder:");
        printPreOrder(root);
        System.out.println();
    }

    private void printPreOrder (BSTNode<T> n) {
        if (n == null)
            return;

        System.out.print(" " + n.getValue());
        printPreOrder(n.getLeft());
        printPreOrder(n.getRight());
    }

    //-------------------------------------------------------------------

    public void printInOrder () {
        System.out.print("InOrder:");
        printInOrder(root);
        System.out.println();
    }

    private void printInOrder (BSTNode<T> n) {
        if (n == null)
            return;

        printInOrder(n.getLeft());
        System.out.print(" " + n.getValue());
        printInOrder(n.getRight());
    }

    //-------------------------------------------------------------------

    public void printPostOrder () {
        System.out.print("PostOrder:");
        printPostOrder (root);
        System.out.println();
    }

    private void printPostOrder (BSTNode<T> n) {
        if (n == null)
            return;
        
        printPostOrder (n.getLeft());
        printPostOrder (n.getRight());
        System.out.print(" " + n.getValue());
    }

    //-------------------------------------------------------------------

    public void printBFS () {
        System.out.print("BFS:");
        MyQueue<BSTNode<T>> q = new LinkedListQueue<>();

        q.enqueue(root);


        while (!q.isEmpty()) {
            BSTNode<T> cur = q.dequeue();

            if (cur != null) {
                System.out.print(" " + cur.getValue());
                
                q.enqueue(cur.getLeft());
                q.enqueue(cur.getRight());
            }
        }
        
        
        System.out.println();
    }

    //-------------------------------------------------------------------

    public void printDFS () {
        System.out.print("DFS:");
        MyStack<BSTNode<T>> s = new LinkedListStack<>();

        s.push(root);

        while (!s.isEmpty()) {

            BSTNode<T> cur = s.pop();

            if (cur != null) {
                System.out.print(" " + cur.getValue());
            }

            if (cur.getLeft() != null)
                s.push(cur.getLeft());
            if (cur.getRight() != null)
                s.push(cur.getRight());

        }

        System.out.println();
    }

    //-------------------------------------------------------------------
    // ED209 - Contar entre nós entre 2 valores
    // ------------------------------------------------------------------------ \\

    public int countBetween(T a, T b) {
       return countBetween(root, a, b);
    }

    private int countBetween(BSTNode<T> n, T a, T b) {
        if (n == null)
            return 0;

        if (n.getValue().compareTo(a) >= 0 && n.getValue().compareTo(b) <= 0) {

            return 1 + countBetween(n.getLeft(), a, b) + countBetween(n.getRight(), a, b);

        } else {
            if (n.getValue().compareTo(b) >= 0)
                return countBetween(n.getLeft(), a, b);
            else if (n.getValue().compareTo(a) <= 0)
                return countBetween(n.getRight(), a, b);
            else 
                return countBetween(n.getLeft(), a, b) + countBetween(n.getRight(), a, b);
        }
             
    }
    
    // ------------------------------------------------------------------------ \\
    // ED210 - Arvore binaria válida
    // ------------------------------------------------------------------------ \\
    public boolean valid() {
        return valid(root, root);
    }

    private boolean valid (BSTNode<T> n, BSTNode<T> root) {
        if (n == null)
            return true;
        
        if (n.getLeft() != null) {
            if (n.getValue().compareTo(n.getLeft().getValue()) <= 0)
                return false;

            if (n.getLeft().getRight() != null) {
                if (n.getValue().compareTo(n.getLeft().getRight().getValue()) <= 0)
                    return false;
            }
        }

        if (n.getRight() != null) {
            if (n.getValue().compareTo(n.getRight().getValue()) >= 0)
                return false;
            
            if (n.getRight().getLeft() != null) {
                if (n.getValue().compareTo(n.getRight().getLeft().getValue()) >= 0)
                    return false;
            }
        }
        
        return valid(n.getLeft(), root) && valid(n.getRight(), root);
    }


    //-------------------------------------------------------------------
    // ED208 - max e min
    // ------------------------------------------------------------------------ \\

    public T minValue() {
        BSTNode<T> n = root;
        while (n.getLeft() != null)
            n = n.getLeft();

        return n.getValue();
    }

    public T maxValue() {
        BSTNode<T> n = root;
        while (n.getRight() != null)
            n = n.getRight();

        return n.getValue();
    }

}