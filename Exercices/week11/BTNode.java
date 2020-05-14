package week11;


public class BTNode<T> {
    private T value;
    private BTNode<T> left;
    private BTNode<T> right;

    BTNode (T value, BTNode<T> left, BTNode<T> right) {
        this.value = value;
        this.left = left; this.right = right;
    }



    // Setters
    public void setValue (T newValue) {
        value = newValue;
    }

    public void setLeft (BTNode<T> newLeft) {
        left = newLeft;
    }

    public void setRight (BTNode<T> newRight) {
        right = newRight;
    }

    
    // Getters
    public T getValue () {
        return value;
    }

    public BTNode<T> getLeft () {
        return left;
    }

    public BTNode<T> getRight () {
        return right;
    }
}