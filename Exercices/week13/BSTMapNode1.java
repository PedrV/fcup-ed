package week13;

// -----------------------------------------------------------
// Estruturas de Dados 2019/2020 (CC1007) - DCC/FCUP
// http://www.dcc.fc.up.pt/~pribeiro/aulas/edados1920/
// -----------------------------------------------------------
// No de uma arvore binaria de pesquisa - versao dicionario
// Ultima alteracao: 13/05/2018
// -----------------------------------------------------------

// K e o tipo da chave (key) e V o tipo do valor (value)
// O tipo K tem de implementar o interface Comparable
// (ou te-lo herdado de uma super classe).
public class BSTMapNode1<K extends Comparable<? super K>, V> {
    private K key;                 // chave
    private V value;               // valor
    private BSTMapNode1<K,V> left;  // Filho esquerdo
    private BSTMapNode1<K,V> right; // Filho direito
 
    // Construtor
    BSTMapNode1(K k, V v, BSTMapNode1<K,V> l, BSTMapNode1<K,V> r) {
       key = k;
       value = v;
       left = l;
       right = r;
    }
 
    // Getters e Setters
    public K getKey() {return key;}
    public V getValue() {return value;}
    public BSTMapNode1<K,V> getLeft() {return left;}
    public BSTMapNode1<K,V> getRight() {return right;}
    public void setKey(K k) {key = k;}
    public void setValue(V v) {value = v;}
    public void setLeft(BSTMapNode1<K,V> l) {left = l;}
    public void setRight(BSTMapNode1<K,V> r) {right = r;}   
 }