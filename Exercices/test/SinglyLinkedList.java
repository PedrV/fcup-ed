package test;

// -----------------------------------------------------------
// Estruturas de Dados 2019/2020 (CC1007) - DCC/FCUP
// http://www.dcc.fc.up.pt/~pribeiro/aulas/edados1920/
// -----------------------------------------------------------
// Lista ligada simples
// Ultima alteracao: 03/04/2018
// -----------------------------------------------------------

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
      if (isEmpty()) return null;
      return first.getValue();
   }

   // Retorna o ultimo valor da lista (ou null se a lista for vazia)
   public T getLast() {
      if (isEmpty()) return null;
      Node<T> cur = first;
      while (cur.getNext() != null)
         cur = cur.getNext();
      return cur.getValue();      
   }

   // Remove o primeiro elemento da lista (se for vazia nao faz nada)
   public void removeFirst() {
      if (isEmpty()) return;
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

   // ---------------------------------------------------------------------------------------------------------------------

   public void add(int pos, T v) {
   if (pos < 0 || pos >= size) 
      return;
   
   if (pos == 0) 
      addFirst(v);
   else if (pos == size-1)
      addLast(v);
   else {
      Node<T> cur = first;
      Node<T> new_node = new Node<>(v, null);

      for (int i = 1; i < pos; i++) {
            cur = cur.getNext();
      }

      new_node.setNext(cur.getNext());
      cur.setNext(new_node);
      size++;
   }

   } 

   // ---------------------------------------------------------------------------------------------------------------------

   // ED188    
   public T get(int pos) {

      if (pos < 0 || pos >= size) 
         return null;

      if (pos == 0) 
         return getFirst();
      else if (pos == size-1)
         return getLast();
      else {
         Node<T> cur = first;

         for (int i = 1; i <= pos; i++) {
               cur = cur.getNext();
         }

         return cur.getValue();
      }
   }

   // ---------------------------------------------------------------------------------------------------------------------

   //  ED189
   public T remove(int pos) {

      if (pos < 0 || pos >= size) 
         return null;

      if (pos == 0) {
         T first = getFirst();
         removeFirst();
         return first;

      } else if (pos == size-1) {
         T last = getLast();
         removeLast();
         return last;

      } else {
         Node<T> cur = first;

         for (int i = 1; i < pos; i++) 
               cur = cur.getNext();

         T ipos = cur.getNext().getValue();
         cur.setNext(cur.getNext().getNext());
         size--;

         return ipos;
      }

   }

   // ---------------------------------------------------------------------------------------------------------------------

   // ED190
   public SinglyLinkedList<T> copy() {
      SinglyLinkedList<T> new_list = new SinglyLinkedList<>();
      new_list.first = first;
      return new_list;
   }

   // ---------------------------------------------------------------------------------------------------------------------

   // ED191
   public void duplicate() {
      Node<T> cur = first; 
      int size_c = size;

      for (int i = 0, j = 0; i < size_c; i++, j+=2) {
         add(j, cur.getValue());
         cur = cur.getNext();
      }
         
   }

   // ---------------------------------------------------------------------------------------------------------------------

   // ED192
   public int count(T value) {
      Node<T> cur = first;
      int cnt = 0;

      for (int i = 0; i < size; i++) {
         if (cur.getValue().equals(value)) 
            cnt++;

         cur = cur.getNext();
      }

      return cnt;
   }

   // ---------------------------------------------------------------------------------------------------------------------

   // ED193
   public void removeAll(T value) {
      Node<T> cur = first;

      for (int i = 0; i < size; i++) {
         if (cur.getValue().equals(value)) {
            remove(i);
            i--;
         }

         cur = cur.getNext();
      }
      
   }
    
   // ---------------------------------------------------------------------------------------------------------------------
   public SinglyLinkedList<T> reverse() {
      SinglyLinkedList<T> rev = new SinglyLinkedList<>();
      Node<T> cur = first;

      for (int i = 0; i < size; i++) {
         rev.addFirst(cur.getValue());
         cur = cur.getNext();
      }

      return rev;
   }


   public int[] occurrences(T elem) {
      int[] occ = new int[size];
      Node<T> cur = first;
      int index = 0;

      for (int i = 0; i < size; i++) {
         if (cur.getValue().equals(elem)) {
            occ[index] = i;
            index++;
         }
      }

      if (index == 0)
         return null;
      else 
         return occ;
   }


   public void remove(SinglyLinkedList<T> toRemove) {
      
      Node<T> curRm = toRemove.first;
      Node<T> curN = first;
      Node<T> previous = first;
      boolean removed = false;

      for (int i = 0; i < size; i++) {
         for (int j = 0; j < toRemove.size; j++) {

            if (curN.getValue().equals(curRm.getValue())) {

               if (i == 0) {
                  removeFirst();
                  i--;
                  removed = true;
               } else {

                  previous.setNext(previous.getNext().getNext());
                  size--;
                  i--;
                  removed = true;
               }

               break;
            }
            

            curRm = curRm.getNext();
         } 


         if (!removed)
            previous = curN;
            
         curN = curN.getNext();

         curRm = toRemove.first;
         removed = false;
      }

   }


   // Converte a lista para uma String
   public String toString() {
      String str = "{";      
      Node<T> cur = first;
      while (cur != null) {
         str += cur.getValue();
         cur = cur.getNext();
         if (cur != null) str += ",";                     
      }      
      str += "}";
      return str;
   }

    
 }