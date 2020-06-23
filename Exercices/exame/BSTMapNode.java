package exame;

// Quando se usa genericos a keyword que se usa é extends, mesmo que seja uma interface: 
// -- public class Map<T extends Comparable<T>> {} (T tem de implementar o metodo diretamente, nos garantimos ao Java que ele vai la estar)
// -- public class Map<K extends Comparable<? super K>> {} (K neste ou está lá diretamente ou está presente numa superclass de K)
// No caso de nao ser um generico a implementar
// -- public class Scoreboard implements Comparable<Integer> (vai comparar Integer)
// -- public class Person implements Comparable<Person>  (Vai comparar class Person em si)
/* https://courses.cs.vt.edu/~cs3114/Summer14/Notes/JavaGenerics.pdf */


public class BSTMapNode<K extends Comparable<? super K>, V> {
    private BSTMapNode<K, V> left;
    private BSTMapNode<K, V> right;
    private K key;
    private V value;

    BSTMapNode (K key, V value, BSTMapNode<K, V> left, BSTMapNode<K, V> right) {
        this.key = key;
        this.value = value;
        this.right= right;
        this.left = left;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }

    public BSTMapNode<K, V> getLeft() {
        return left;
    }
    
    public BSTMapNode<K, V> getRight() {
        return right;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public void setValue(V value) {
        this.value = value;
    }

    public void setLeft(BSTMapNode<K, V> left) {
        this.left = left;
    }

    public void setRight(BSTMapNode<K, V> right) {
        this.right = right;
    }
}