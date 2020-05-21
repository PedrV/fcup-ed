package week12;

public class BSTNode<T extends Comparable <? super T>> {
    private BSTNode<T> left;
    private BSTNode<T> right;
    private T value;

    BSTNode (T value, BSTNode<T> left, BSTNode<T> right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }

    // Getters
    public T getValue () {
        return value;
    }

    public BSTNode<T> getLeft () {
        return left;
    }

    public BSTNode<T> getRight () {
        return right;
    }


    // Setters
    public void setValue (T value) {
        this.value = value;
    }

    public void setLeft (BSTNode<T> left) {
        this.left = left;
    }

    public void setRight (BSTNode<T> right) {
        this.right = right;
    }
}