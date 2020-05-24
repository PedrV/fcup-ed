package week13;

// -----------------------------------------------------------
// Estruturas de Dados 2019/2020 (CC1007) - DCC/FCUP
// http://www.dcc.fc.up.pt/~pribeiro/aulas/edados1920/
// -----------------------------------------------------------
// Arvore binaria "normal"
// Ultima alteracao: 26/04/2018
// -----------------------------------------------------------

public class BTree<T> {   
   private BTNode<T> root; // raiz da arvore

   // Construtor
   BTree() {
      root = null;
   }

   // Getter e Setter para a raiz
   public BTNode<T> getRoot() {return root;}
   public void setRoot(BTNode<T> r) {root = r;}

   // Verificar se arvore esta vazia
   public boolean isEmpty() {
      return root == null;
   }

   // --------------------------------------------------------

   // Numero de nos da arvore   
   public int numberNodes() {
      return numberNodes(root);
   }

   private int numberNodes(BTNode<T> n) {
      if (n == null) return 0;
      return 1 + numberNodes(n.getLeft()) + numberNodes(n.getRight());
   }

   // --------------------------------------------------------

   // Altura da arvore
   public int depth() {
      return depth(root);
   }

   private int depth(BTNode<T> n) {
      if (n == null) return -1;
      return 1 + Math.max(depth(n.getLeft()), depth(n.getRight()));
   }

   // --------------------------------------------------------
   
   // O elemento value esta contido na arvore?
   public boolean contains(T value) {
      return contains(root, value);
   }

   private boolean contains(BTNode<T> n, T value) {
      if (n==null) return false;
      if (n.getValue().equals(value)) return true;
      return contains(n.getLeft(), value) || contains(n.getRight(), value);
   }

   // --------------------------------------------------------

   // Imprimir arvore em PreOrder
   public void printPreOrder() {
      System.out.print("PreOrder:");
      printPreOrder(root);
      System.out.println();
   }

   private void printPreOrder(BTNode<T> n) {
      if (n==null) return;
      System.out.print(" " + n.getValue() );
      printPreOrder(n.getLeft());
      printPreOrder(n.getRight());
   }

   // --------------------------------------------------------
   
   // Imprimir arvore em InOrder
   public void printInOrder() {
      System.out.print("InOrder:");
      printInOrder(root);
      System.out.println();
   }

   private void printInOrder(BTNode<T> n) {
      if (n==null) return;
      printInOrder(n.getLeft());
      System.out.print(" " + n.getValue());
      printInOrder(n.getRight());
   }

   // --------------------------------------------------------

   // Imprimir arvore em PostOrder
   public void printPostOrder() {
      System.out.print("PostOrder:");
      printPostOrder(root);
      System.out.println();
   }

   private void printPostOrder(BTNode<T> n) {
      if (n==null) return;
      printPostOrder(n.getLeft());
      printPostOrder(n.getRight());
      System.out.print(" " + n.getValue());
   }

   // --------------------------------------------------------

   // Imprimir arvore numa visita em largura (usando TAD Fila)
   public void printBFS() {
      System.out.print("BFS:");
      
      MyQueue<BTNode<T>> q = new LinkedListQueue<BTNode<T>>();
      q.enqueue(root);
      while (!q.isEmpty()) {
         BTNode<T> cur = q.dequeue();
         if (cur != null) {
            System.out.print(" " + cur.getValue());
            q.enqueue(cur.getLeft());
            q.enqueue(cur.getRight());
         }
      }
      System.out.println();
   }

   // --------------------------------------------------------
   
   // Imprimir arvore numa visita em profundidade (usando TAD Pilha)
   public void printDFS() {
      System.out.print("DFS:");
      
      MyStack<BTNode<T>> q = new LinkedListStack<BTNode<T>>();
      q.push(root);
      while (!q.isEmpty()) {
         BTNode<T> cur = q.pop();
         if (cur != null) {
            System.out.print(" " + cur.getValue());
            q.push(cur.getLeft());
            q.push(cur.getRight());
         }
      }
      System.out.println();
   }


   // --------------------------------------------------------
   // Metodos adicionados para ED233

   /////////////////////////////////////////////////////////////////
   public int internal() {
      return internal(root);     // Chamar contagem para a raiz
   }

   private int internal (BTNode<T> n) {

      if (n == null)    // Se proprio no for vazio, retornar 0, pois nao existem nos internos
         return 0;

      // Se no tiver pelo menos um filho, à esquerda ou direita é considerado no interno  
      if (n.getLeft() != null || n.getRight() != null)
         return 1 + internal(n.getLeft()) + internal(n.getRight()); // Se houver filhos, mais 1 nó interno, e passo recursivo para o resto da árvore   
      else 
         return internal(n.getLeft()) + internal(n.getRight()); // Se não houver filhos, nao acrescentar nada e continuar passo recursivo
   }
   //////////////////////////////////////////////////////////////////


   //////////////////////////////////////////////////////////////////
   public void cut(int d) {
      if (d <= 0) {  // Caso a altura para fazer o corte seja 0 (raiz) ou algo menor, toda a árvore é apagada 
         setRoot(null);
         return;
      } else if (d > depth(root)) { // Caso a altura para fazer o corte seja maior que a altura maxima da árvore então nenhum corte será feito
         return;
      }

      cut(root, d);  // Fazer corte em altura d, onde 0 < d <= h e h representa a altura da árvore 
   }

   private BTNode<T> cut (BTNode<T> n, int d) {
      // Assim que chegarmos ao nivel desejado para cortar, parar a recursao retornando null
      if (d == 0)
         return null;

      n.setLeft(cut(n.getLeft(), d-1));      // Ir reconstruindo a árvore à esquerda em cada nivel
      n.setRight(cut(n.getRight(), d-1));    // Ir reconstruindo a árovre à direita em cada nivel

      return n; // Retornar a nova árvore
   }

   //////////////////////////////////////////////////////////////////


   //////////////////////////////////////////////////////////////////
   public int[] maxLevel() {
      int[] level = {1,1}; // No pior dos casos a árvore tem apenas a raiz (já que é dada a garantia que a árvore nunca é nula) e por isso tem no maximo 1 nó que aparece uma vez

      for (int i = 1; i <= depth(root); i++) {
         int number_nodes = numberNodesLVL(root, i);

         if (number_nodes > level[0]) {
            level[0] = number_nodes;
            level[1] = 1;
         } else if (number_nodes == level[0]) {
            level[1]++;
         }

      }


      return level;
   }

   private int numberNodesLVL (BTNode<T> n, int d) {
      if (d == 1) {

         if (n == null)
            return 0;
         
         if (n.getLeft() == null && n.getRight() == null)
            return 0;

         else if (n.getLeft() != null && n.getRight() != null)
            return 2;

         else
            return 1;

      } else {
         if (n == null)
            return 0;

         return numberNodesLVL(n.getLeft(), d-1) + numberNodesLVL(n.getRight(), d-1);
      }
   }

   //////////////////////////////////////////////////////////////////


   // --------------------------------------------------------

}
