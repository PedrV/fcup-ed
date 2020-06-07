package test.trees;

public class BTNode<T> {
    private BTNode<T> left;
    private BTNode<T> right;
    private T value;

    public BTNode (T value, BTNode<T> left, BTNode<T> right) {
        this.value = value;
        this.left = left; this.right = right;
    }

    public void setLeft(BTNode<T> left) {
        this.left = left;
    }

    public void setRight(BTNode<T> right) {
        this.right = right;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public BTNode<T> getLeft() {
        return left;
    }

    public BTNode<T> getRight() {
        return right;
    }

    public T getValue() {
        return value;
    }
}