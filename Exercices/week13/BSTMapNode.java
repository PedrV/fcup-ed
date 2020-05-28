package week13;

public class BSTMapNode <K extends Comparable <? super K>, V> {
    private K key;
    private V value;
    private BSTMapNode<K, V> right;
    private BSTMapNode<K, V> left;


    BSTMapNode (K key, V value, BSTMapNode<K, V> right, BSTMapNode<K, V> left) {
        this.key = key;
        this.value = value;
        this.right = right;
        this.left = left;
    }


    // Getters & Setters
    public K getKey() {return key;}
    public V getValue() {return value;}
    public BSTMapNode<K,V> getRight() {return right;}
    public BSTMapNode<K,V> getLeft() {return left;}

    public void setKey(K key) {this.key = key;}
    public void setValue(V value) {this.value = value;}
    public void setLeft(BSTMapNode<K,V> left) {this.left = left;}
    public void setRight(BSTMapNode<K,V> right) {this.right = right;}

}