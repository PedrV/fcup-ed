package exame;

public class BTNode<T> {
    private BTNode<T> left;
    private BTNode<T> right;
    private T value;

    BTNode (BTNode<T> left, BTNode<T> right, T value) {
        this.value = value;
        this.left = left;
        this.right = right;
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

    public void setLeft(BTNode<T> left) {
        this.left = left;
    }

    public void setRight(BTNode<T> right) {
        this.right = right;
    }

    public void setValue(T value) {
        this.value = value;
    }
}