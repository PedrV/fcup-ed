package week14.util;

// -----------------------------------------------------------
// Estruturas de Dados 2019/2020 (CC1007) - DCC/FCUP
// http://www.dcc.fc.up.pt/~pribeiro/aulas/edados1920/
// -----------------------------------------------------------
// Exemplo de utilizacao do TAD Fila
// Ultima alteracao: 06/04/2018
// -----------------------------------------------------------

public class TestMyQueue {
   public static void main(String[] args) {

      // Criacao da fila
      MyQueue<Integer> q = new LinkedListQueue<Integer>();

      // Exemplo de insercao de elementos na fila
      for (int i=1; i<=8; i++)
         q.enqueue(i); // insere i no final da fila
      System.out.println(q);

      // Exemplo de remocao de elementos da fila
      for (int i=0; i<4; i++) {
         int aux = q.dequeue(); // retira o elemento no inicio da fila
         System.out.println("q.dequeue() = " + aux);
      }
      System.out.println(q);

      // Exemplo de utilizacao dos outros metodos
      System.out.println("q.size() = " + q.size());
      System.out.println("q.isEmpty() = " + q.isEmpty());
      System.out.println("q.first() = " + q.first());
   }
}
