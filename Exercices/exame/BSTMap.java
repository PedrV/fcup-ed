package exame;

import java.util.LinkedList;

public class BSTMap<K extends Comparable<? super K>, V> {
    private BSTMapNode<K, V> root;

    BSTMap () {root=null;}

    public BSTMapNode<K, V> getRoot() {
        return root;
    }

    public void setRoot(BSTMapNode<K, V> root) {
        this.root = root;
    }

    public void clear () {root = null;}



    public V get (K key) {
        return contains(root, key);
    }

    private V contains (BSTMapNode<K, V> n, K key) {
        if (n == null)
            return null;
        
        if (n.getKey().compareTo(key) > 0) 
            return contains(n.getLeft(), key);
        if (n.getKey().compareTo(key) < 0)
            return contains(n.getRight(), key);

        return n.getValue();
    }


    public void put (K key, V value) {
        root = put (root, key, value);
    }

    private BSTMapNode<K,V> put (BSTMapNode<K,V> n, K key, V value) {
        if (n == null)
            return new BSTMapNode<>(key, value, null, null);
        else if (n.getKey().compareTo(key) > 0)
            n.setLeft(put(n.getLeft(),key,value));
        else if (n.getKey().compareTo(key) < 0)
            n.setRight(put(n.getRight(),key,value));
        else
            n.setValue(value);
        return n;
    }


    public void remove (K key) {
        root = remove (root, key);
    }

    private BSTMapNode<K,V> remove (BSTMapNode<K,V> n, K key) {
        if (n == null)
            return null;
        else if (n.getKey().compareTo(key) > 0)
            n.setLeft(remove(n.getLeft(),key));
        else if (n.getKey().compareTo(key) < 0)
            n.setRight(remove(n.getRight(),key));
        else if (n.getLeft() == null)
            n = n.getRight();
        else if (n.getRight() == null)
            n = n.getLeft();
        else {
            BSTMapNode<K,V> max = n.getLeft();
            
            while (max.getRight() != null)
                max = max.getRight();

            n.setKey(max.getKey());
            n.setValue(max.getValue());
            n.setLeft(remove(n.getLeft(), max.getKey()));
        }

        return n;
    }

    public LinkedList<K> keys() {
        LinkedList<K> keychain = new LinkedList<>();
        keys(root, keychain);
        return keychain;
    }

    private void keys (BSTMapNode<K,V> n, LinkedList<K> keychain) {
        if (n == null)
            return;

        keys(n.getLeft(), keychain);
        keychain.addLast(n.getKey());
        keys(n.getRight(), keychain);
    }
    
}