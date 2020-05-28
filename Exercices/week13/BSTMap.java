package week13;

import java.util.LinkedList;

public class BSTMap <K extends Comparable <? super K>, V> {
    private BSTMapNode<K,V> root;

    BSTMap () {
        root = null;
    }

    public void setRoot (BSTMapNode<K,V> n) {
        root = n;
    }

    public BSTMapNode<K,V> getRoot () {
        return root;
    }

    public boolean isEmpty () {
        return root == null;
    }


    // ----------------------------------------------------------------------
    public int size () {
        return size(root);
    }

    private int size (BSTMapNode<K,V> n) {
        if (n == null)
            return 0;
        
        return 1 + size(n.getLeft()) + size(n.getRight());
    }


    // ----------------------------------------------------------------------
    public V get (K k) {
        return get(root, k);
    }

    private V get (BSTMapNode<K,V> n, K k) {
        if (n == null)
            return null;
        
        if (k.compareTo(n.getKey()) < 0)
            return get(n.getLeft(), k);
        if (k.compareTo(n.getKey()) > 0)
            return get(n.getRight(), k);
        
        return n.getValue();

    }


    // ----------------------------------------------------------------------
    public void put (K k, V v) {
        root = put (root, k, v);
    }

    private BSTMapNode<K,V> put (BSTMapNode<K,V> n, K k, V v) {
        if (n == null) return new BSTMapNode<K,V>(k, v, null, null);

        if (k.compareTo(n.getKey()) < 0)            // Se key for menor que o key atual ir para a subarvore da esquerda
            n.setLeft(put(n.getLeft(), k, v));
        else if (k.compareTo(n.getKey()) > 0)       // Se key for maior que o key atual ir para a subarvore da direita 
            n.setRight(put(n.getRight(), k, v));
        else    
            n.setValue(v);  // Se não é menor ou maior é igual nesse caso atualizar o valor
            
        return n;
    }    


    // ----------------------------------------------------------------------
    public boolean remove(K k) {
        if (get(k) == null)
            return false;
        
        root = remove(root, k);
        return true;

    }

    private BSTMapNode<K,V> remove (BSTMapNode<K,V> n, K k) {
        
        if (k.compareTo(n.getKey()) < 0)            // Se key for menor que o key atual ir para a subarvore da esquerda
            n.setLeft(remove(n.getLeft(), k));      // Ir "reconstruindo" a árvore à medida que vamos avançando
        else if (k.compareTo(n.getKey()) > 0)       // Se key for maio que o key atual ir para a subarvore da direita
            n.setRight(remove(n.getRight(), k));    // Ir "reconstruindo" a árvore à medida que vamos avançando
        else if (n.getLeft() == null)               // Neste caso a key é a que queremos, e no caso de esta nao tiver filho à esquerda
            n = n.getRight();                       // Se nete caso podemos substituir o nó que queremos remover pelo seu conteudo à direita pos nao vai haver conflitos com as coisas à esquerda
        else if (n.getRight() == null)              // Key encontrada, nao tem filho à direita 
            n = n.getLeft();                        // Substituir pelo conteudo à esquerda sem medo de conflitos com o conteudo à direita
        else {                                      // Neste caso tem filhos à direita e esquerda

            BSTMapNode<K,V> max = n.getLeft();      

            while (max.getRight() != null)          // Encontrar o maior filho da árvore da esquerda para ir para o lugar do que vai ser removido
                max = max.getRight();

            n.setKey(max.getKey());                 // Substituir key de n
            n.setValue(max.getValue());             // Substituir value de n

            n.setLeft(remove(n.getLeft(), max.getKey()));   // Eliminar o nó que usamos anteriormente

        }

        return n;
    }


    // ----------------------------------------------------------------------
    public LinkedList<K> keys () {
        LinkedList<K> list = new LinkedList<>();

        keys(root, list);

        return list;
    }

    private void keys (BSTMapNode<K,V> n, LinkedList<K> l) {
        if (n == null)
            return;
        
        keys(n.getLeft(), l);
        l.addLast(n.getKey());      // Colocar todas as keys na linked list (este tipo de colocaçao "inOrder" permite ter a lista por ordem)
        keys(n.getRight(), l);

    }

}