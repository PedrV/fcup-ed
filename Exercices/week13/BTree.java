package week13;


/* ----------- ----------- ----------- ----------- ----------- ----------- ----------- ----------- ----------- ----------- ----------- -----------
   Nome: Pedro Campos Vieira
   Número mecanográfico: 201905272
   Comentário: Ao longo do codigo existem comentarios pretinentemente localizados de forma a tentar explicar o que faz cada parte, no entanto aqui ficam raciocionios mais gerais:

   -- internal(): este método é bastante simples, apenas vai recursivamente ver se um determinado nó tem pelo menos um filho e caso afirmativo acrescenta-o há lista
   -- cut(): este método vai "reconstruindo" a árvore até encontrar a altura que deve ser cortada, ou seja quando a variavel "d" chega a 0. Quando isto acontece
   é a recursão para, retornando null.
   -- maxLevel(): para resolver este problema, existem 2 metodos, um que calcula a quantidade de nos em cada nivel da árvore, numberNodesLVL() e o maxLevel() que descobre qual
   o maior numero de nos em cada nivel e em quantos niveis esse numero aparece.

   Complexidade:
   -- internal(): este metodo passa uma vez por cada filho da árvore. Logo tem complexidade O(n), onde n são o numero de nos da árvore
   -- cut(): este metodo percorre todos os nós até a altura de corte "x". Admitindo que "x" pode ser maior que a altura da árvore, este metodo tem 
   complexidade O(n), onde n é a altura da árvore.
   -- maxLevel(): dividindo este metodo em todos os metodos que nele participam, temos uma complexidade linear do metodo depth(), mais uma complexiade linear de numberNodesLVL(), em qua apenas numa passagem
   sobre a altura da árvore descobre a quantidade de nós em cada nivel, mais a complexidade do proprio maxLevel, que tem um ciclo pela altura da árvore (length do array number_nodes).
   Tudo isto resulta em algo parecido a n + n + n, ou seja 3n, ou seja O(n), onde n é a altura da árvore.
   ----------- ----------- ----------- ----------- ----------- ----------- ----------- ----------- ----------- ----------- ----------- ----------- */


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


   // Metodos adicionados para ED233
   // --------------------------------------------------------

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
      return;
   }

   private BTNode<T> cut (BTNode<T> n, int d) {
      // Assim que chegarmos ao nivel desejado para cortar, parar a recursao retornando null
      if (d == 0)
         return null;

      if (n == null)
         return null;

      n.setLeft(cut(n.getLeft(), d-1));      // Ir reconstruindo a árvore à esquerda em cada nivel
      n.setRight(cut(n.getRight(), d-1));    // Ir reconstruindo a árovre à direita em cada nivel

      return n; // Retornar a nova árvore
   }

   //////////////////////////////////////////////////////////////////


   //////////////////////////////////////////////////////////////////
   public int[] maxLevel() {
      int[] level = {1,1};                   // No pior dos casos a árvore tem apenas a raiz (já que é dada a garantia que a árvore nunca é nula) e por isso tem no maximo 1 nó que aparece uma vez
      int depth = depth(root);               // Altura da árvore
      int[] number_nodes = new int[depth];   // Array que irá conter o numero nos em cada nivel da árovre (raiz nao incluida)

      // Caso em que é apenas a raiz da árvore não é preciso testar nada
      if (depth == 0) {
         return level;
      }

      // Calcular o numero de nós em cada nível
      numberNodesLVL(root, 0, depth-1, number_nodes);

      // Começar no nivel 1, pois a raiz está automaticamente classificada na inicialização do array level com {1,1}
      for (int i = 0; i < depth; i++) {

         // Ver se determinado numero de nos na altura i+1 é maior que numero de nós atual (no incio o maior ja visto é a raiz)
         if (number_nodes[i] > level[0]) {
            level[0] = number_nodes[i];   // Atualizar maior quantidade de nós
            level[1] = 1;                 // Atualizar quantidade de niveis com maior quantidade de nós

         // Ver se determinado numero de nos na altura i+1 é igual ao numero de nos atual (no incio o maior ja visto é a raiz)
         } else if (number_nodes[i] == level[0]) {
            level[1]++;  // Atualizar quantidade de niveis com maior quantidade de nós
         }

      }

      return level;
   }

   // Calcular o numero total de nós num nivel d da árvore
   private void numberNodesLVL (BTNode<T> n, int d, int stop, int[] nodes) {

      // Se o nó em questão for null, então nao tem filhos
      if (n == null)
         nodes[d] += 0;
      
      // Ver filho esquerdo e direito do atual, se forem os 2 null, então nao existem filhos
      if (n.getLeft() == null && n.getRight() == null) {
         nodes[d] += 0;

      // Se ambos os filhos de não forem null então ele tem 2 filhos  
      } else if (n.getLeft() != null && n.getRight() != null) {
         nodes[d] += 2;

      // Caso contrario então ele vai ter um filho à esquerda ou direita, mas não os 2. De qualquer maneira terá apenas 1 
      } else {
         nodes[d] += 1;
      }
      
      // Calcular a quantidade de nos em todos os niveis até à altura da árvode (stop)
      if (d < stop) {
         if(n.getLeft() != null) {  // Verificar se nó da esquerda é possivel visitar ou se é null
            numberNodesLVL(n.getLeft(), d+1, stop, nodes);
         }
         if (n.getRight() != null) { // Verificar se nó da direita é possivel visitar ou se é null
            numberNodesLVL(n.getRight(), d+1, stop, nodes);
         }
      }
   }

   //////////////////////////////////////////////////////////////////


   // --------------------------------------------------------

}
