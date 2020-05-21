package week12;

import week11.util.*;

public class BSTree<T extends Comparable <? super T>> {
    private BSTNode<T> root;

    BSTree () {
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

    private boolean contains (BSTNode<T> n, T value) {
        if (n == null) 
            return false;
        
        if (value.compareTo(n.getValue()) < 0)      // Procurar à esquerda, o valor é menor
            return contains(n.getLeft(), value);    
        if (value.compareTo(n.getValue()) > 0)      // Procurar à direita, o valor é maior
            return contains(n.getRight(), value);
        
        return true;
    }

    //-------------------------------------------------------------------

    public boolean insert (T value) {
        if (contains(root, value)) 
            return false;
        
        root = insert(root, value);
        return true;
    }

    private BSTNode<T> insert (BSTNode<T> n, T value) {
        
        if (n == null)
            return new BSTNode<T>(value, null, null);

        if (value.compareTo(n.getValue()) < 0) {
            n.setLeft(insert(n.getLeft(), value));          // Ir "reconstruindo" a árvore há medida que vamos indo para esquerda
        } else if (value.compareTo(n.getValue()) > 0) {
            n.setRight(insert(n.getRight(), value));        // Ir "reconstruindo" a árvore há medida que vamos indo para esquerda
        } 

        return n;   
    }

    //-------------------------------------------------------------------

    public boolean remove (T value) {
        if (!contains(root, value))
            return false;

        root = remove(root, value);
        return true;
    }

    private BSTNode<T> remove (BSTNode<T> n, T value) {

        if (value.compareTo(n.getValue()) < 0) {        // Continuamos a procura à esquerda
            n.setLeft(remove(n.getLeft(), value));      // Conforme vamos procurando vamos nos preparar para quando remover-mos o elemento a árvore ser "reconstruida"
            
        } else if (value.compareTo(n.getValue()) > 0) { // Continuamos a procura à direita
            n.setRight(remove(n.getRight(), value));    // Conforme vamos procurando vamos nos preparar para quando remover-mos o elemento a árvore ser "reconstruida"
            
        } else if (n.getLeft() == null) {   // Se encontramos e o alvo so tem um filho (à esquerda), pomos o filho no lugar dele     
            n = n.getRight();
        } else if (n.getRight() == null) {  // Se encontramos e o alvo so tem um filho (à direita), pomos o filho no lugar dele
            n = n.getLeft();

        } else { // Se tem 2 filhos

            BSTNode<T> max = n.getLeft();

            while (max.getRight() != null)          // Procurar maior valor lado esquerdo
                max = max.getRight();
            
            n.setValue(max.getValue());             // Node passa a ter o maior valor do lado esquerdo (ou seja o valor pretendido é removido)
            remove(n.getLeft(), max.getValue());    // O Node com o valor que usamos para substituir anteriormente é removido     
        }

        return n;
    }

    //-------------------------------------------------------------------


    public void printPreOrder () {
        System.out.print("PreOrder: ");
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
        System.out.print("InOrder: ");
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
        System.out.print("PostOrder: ");
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
        System.out.print("BFS: ");
        MyQueue<BSTNode<T>> q = new LinkedListQueue<>();

        q.enqueue(root);

        while (!q.isEmpty()) {
            BSTNode<T> cur = q.dequeue();

            if (cur != null) {
                System.out.print(" " + cur.getValue());
            }
            
            if (cur.getLeft() != null)
                q.enqueue(cur.getLeft());
            if (cur.getRight() != null)
                q.enqueue(cur.getRight());
            
        }
        System.out.println();
    }

    //-------------------------------------------------------------------

    public void printDFS () {
        System.out.print("DFS: ");
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


    // ED208 - Max, Min

    public T maxValue () { // É garantido árvore tem pelo menos um valor
        return (maxValue(root));    
    }

    private T maxValue (BSTNode<T> n) {
        
        if (n.getRight() == null)
            return n.getValue();
            
        return maxValue(n.getRight());

    }


    public T minValue () {  // É garantido árvore tem pelo menos um valor
        return minValue (root);
    }

    private T minValue (BSTNode<T> n) {

        if (n.getLeft() == null)
            return n.getValue();
        
        return minValue(n.getLeft());
    }

    //-------------------------------------------------------------------

    // ED209 - Numeros entre

    public int countBetween(T a, T b) {
        return countBetween(root, a, b);
    } 

    private int countBetween(BSTNode<T> n,  T a, T b) {
        if (n == null)
            return 0;

        if (n.getValue().compareTo(a) >= 0 && n.getValue().compareTo(b) <= 0)
            return 1 + countBetween(n.getLeft(), a, b) + countBetween(n.getRight(), a, b);

        else if (n.getValue().compareTo(b) > 0)         // Se no atual tiver maior valor que o maior valor do limite (b), entao toda a subarvore da direita esta excluida
            return countBetween(n.getLeft(), a, b);

        else if (n.getValue().compareTo(a) < 0)        // Se no atual tiver menor valor que o menor valor do limite (a), entao toda a subarvore da esquerda esta excluida
            return countBetween(n.getRight(), a, b);
        else 
            return countBetween(n.getLeft(), a, b) + countBetween(n.getRight(), a, b);
    }

    //-------------------------------------------------------------------

}