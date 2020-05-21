package week12;


/* ----------- ----------- ----------- ----------- ----------- ----------- ----------- ----------- ----------- ----------- ----------- -----------
    Nome: Pedro Campos Vieira
    Número mecanográfico: 201905272
    Comentário: Ao longo do codigo existem comentarios pretinentemente localizados de forma a tentar explicar o que faz cada parte, no entanto aqui ficam raciocionios mais gerais:

    - l: lista fornecida
    - l1: lista com elementos para serem removidos (apenas metodo remove)

    -- reverse: Este metodo é bastante simples, começando pelo elemento inicial de l, e continuando por aí, sempre que econtramos
    um elemento colocamo-lo em primeiro, assim sabemos que o primeiro elemento de l vai estar em ultimo na nova lista e assim sucessivamente.
    
    -- occurrences: Neste metodo começamos por criar um array como o tamanho de l, pois nao sabemos se toda a lista não é constituida por o elemnto que procuramos,
    no entanto sabemos que um elemnto nao pode ocorrer mais vezes que o numero de elementos da propria lista.
    Fazendo um simples loop pela lista, comparando o elemento na posiçao "i" com o elemento que queremos, podemos saber se existe, e em caso de existir,
    basta acrescentar a posiçao em que ocorre "i" ao array de ocorrencias.
    No final basta "cortar" o array pelo tamanho desejado, que é o "index" e está pronto para ser retornado. (A estrutura mais adequada talvez fosse um ArrayList neste caso, mas array é ok)

    -- remove: Este metodo, que recebe l1, tem que por cada elemento da lista, l, que vai ver os seus elementos possivelmente removidos, este compara-o com todos os elementos da lista, l1, que contem os 
    elementos que devem ser removidos. Ou seja por cada elemento, x de l, a lista l1 é iterada há procura de correspondencia entre x e um dos seus elementos.
    Cada vez que x recebe correspondecia, este é removido (mais detalhes junto do codigo). 
    (Nota: Quando um elemento é removido, o size diminui e o index de l tem de ser ajustado, ou seja temos de diminuir o index em 1 visto que um elemento foi removido).

    Complexidade:
    -- reverse: Simples loop por todos os elementos da lista, linear conforme os elementos da lista. O(n).
    -- occurences: Loop por todos os elementos da lista, mais o possivel reajuste do array. Em geral linear sobre os elementos da lista. O(n).
    -- remove: O metodo remove(SinglyLinkedList<T> toRemove), embora passe apenas uma vez por cada elemento de l, em cada um deles tem de ver se este coincide com um elemento de l1.
    Admitindo que l tem "n" elementos e l1 tem "r" elementos, então a complexiade seria r*n, que corresponderia a O(n).
   ----------- ----------- ----------- ----------- ----------- ----------- ----------- ----------- ----------- ----------- ----------- ----------- */


import java.util.Arrays;

public class SinglyLinkedList<T> {
    private Node<T> first;    // Primeiro no da lista
    private int size;         // Tamanho da lista
 
    // Construtor (cria lista vazia)
    SinglyLinkedList() {
       first = null;
       size = 0;
    }
 
    // Retorna o tamanho da lista
    public int size() {
       return size;
    }
 
    // Devolve true se a lista estiver vazia ou falso caso contrario
    public boolean isEmpty() {
       return (size == 0);
    }
    
    // Adiciona v ao inicio da lista
    public void addFirst(T v) {
       Node<T> newNode = new Node<T>(v, first); 
       first = newNode;
       size++;
    }
 
    // Adiciona v ao final da lista
    public void addLast(T v) {
       Node<T> newNode = new Node<T>(v, null); 
       if (isEmpty()) {
          first = newNode;
       } else {
          Node<T> cur = first;

          while (cur.getNext() != null)
            cur = cur.getNext();

          cur.setNext(newNode);         
       }
       size++;
    }
 
    // Retorna o primeiro valor da lista (ou null se a lista for vazia)
    public T getFirst() {
        if (isEmpty())
            return null;
        return first.getValue();
    }
 
    // Retorna o ultimo valor da lista (ou null se a lista for vazia)
    public T getLast() {
        if (isEmpty()) 
            return null;

        Node<T> cur = first;

        while (cur.getNext() != null)
            cur = cur.getNext();

        return cur.getValue();      
    }
 
    // Remove o primeiro elemento da lista (se for vazia nao faz nada)
    public void removeFirst() {
        if (isEmpty()) 
            return;
        
        first = first.getNext();
        size--;
    }
 
    // Remove o ultimo elemento da lista (se for vazia nao faz nada)
    public void removeLast() {
       if (isEmpty()) return;
       if (size == 1) {
          first = null;
       } else {
          // Ciclo com for e uso de de size para mostrar alternativa ao while
          Node<T> cur = first;
        
          for (int i=0; i<size-2; i++)
             cur = cur.getNext();

          cur.setNext(cur.getNext().getNext());
       }
       size--;
    }


// Metodos Implementados para a ED232
// -------------------------------------------------------------------------------------------------------------------- \\

    ////////////////////////////////////////////////////////////////////////
    // Inverter a lista original numa nova lista
    public SinglyLinkedList<T> reverse() {
        SinglyLinkedList<T> n_list = new SinglyLinkedList<>();
        Node<T> cur = first; 

        for (int i = 0; i < size; i++) {
            n_list.addFirst(cur.getValue());    // Cada elemento que recebemos colocamo-lo em 1º, assim os primeiros ficam em ultimo e os ultimos em 1º
            cur = cur.getNext();
        }
        return n_list;
    }
    ////////////////////////////////////////////////////////////////////////



    ////////////////////////////////////////////////////////////////////////
    // Encontrar todas as ocorrecias de um elemento na lista
    public int[] occurrences(T elem) {
        int[] occ = new int [size];     // Pior casos todos os elementos são occurencias
        Node<T> cur = first;            // Apontador par ao primeiro elemento da lista
        int index = 0;                  // Index para o array com occurencias

        // Loop pelo size da lista
        for (int i = 0; i < size; i++ ) {
            if (cur.getValue().equals(elem)) {
                occ[index] = i;
                index++;
            }
            cur = cur.getNext();
        }   

        // Se index 0, não há elementos, retornar null, senão
        // Retornar um novo array desta vez com apenas os elementos que indicam occorrencias de elementos
        if (index == 0)
            return null;
        else
            return Arrays.copyOf(occ, index);   // Melhor opçao, talvez usar ArrayList em vez de array
    }
    ////////////////////////////////////////////////////////////////////////



    ////////////////////////////////////////////////////////////////////////
    // Remover todos os elementos da lista que aparecem na lista de elementos para remover
    public void remove(SinglyLinkedList<T> toRemove) {
        Node<T> cur = first;                    // Apontador para ao primeiro elemento da lista
        Node<T> curRemove = toRemove.first;     // Apontador para ao primeiro elemento da lista de elementos a remover
        Node<T> previous = cur;                 // Apontador para o node anterior ao atual para facilitar a remoçao de elementos
        boolean removed = false;                // Flag para saber se foram removidos elementos, para saber quando atualizar ou nao o previous

        for (int i = 0; i < size; i++) {    // Loop por todos os elementos da lista original
            for (int j = 0; j < toRemove.size; j++) {   // Em cada elemento da lista ver se este está na lista de elementos a remover

                if (cur.getValue().equals(curRemove.getValue())) {  // Se proximo elemento for o desejado, prepar para remove lo
                    
                    if(i == 0) {
                        removeFirst();
                        removed = true;
                    } else {
                        previous.setNext(previous.getNext().getNext()); // Proximo elemento do elemento antes daquele que vai ser removido vai ser o proximo daquele que vai ser removido
                        size--;                                         // assim saltamos o elemento que vai ser removido e nao tendo nada a apontar para ele o garbage collector do java apaga-o; Ajustar size
                        removed = true;
                    }
                    
                    i--;            // Ao remover um elemento da lista o seu tamanho diminui, logo temos de ajustar o index do loop
                    break;        
                }
                curRemove = curRemove.getNext();  
            }  

            curRemove = toRemove.first; // Colocar denovo o apontador da lista de elementos a remover no 1º elemento

            // Se não removemos nenhum elemento entao temos de atualizar o no anterior porque vamos atualizar a posiçao do nó atual, cur.
            // Caso elemento tenha sido removido então nao precisamos de atualizar o previous porque o atual muda mas a posiçao na lista nao
            if (!removed)
                previous = cur;
    
            cur = cur.getNext();
            removed = false;
        }
    }
    ////////////////////////////////////////////////////////////////////////

// -------------------------------------------------------------------------------------------------------------------- \\

    
    // Converte a lista para uma String
    public String toString() {
       String str = "{";      
       Node<T> cur = first;

       while (cur != null) {

          str += cur.getValue();
          cur = cur.getNext();

          if (cur != null) 
            str += ",";                     
       }   

       str += "}";
       return str;
    }
 }