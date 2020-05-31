package week14.util;

// -----------------------------------------------------------
// Estruturas de Dados 2019/2020 (CC1007) - DCC/FCUP
// http://www.dcc.fc.up.pt/~pribeiro/aulas/edados1920/
// -----------------------------------------------------------
// Exemplo de utilizacao do TAD Pilha
// Ultima alteracao: 06/04/2018
// -----------------------------------------------------------

public class TestMyStack {
   public static void main(String[] args) {

      // Criacao da pilha
      MyStack<Integer> s = new LinkedListStack<Integer>();
      //MyStack<Integer> s = new ArrayStack<Integer>();

      // Exemplo de insercao de elementos na pilha
      for (int i=1; i<=8; i++)
         s.push(i); // insere i no topo da pilha
      System.out.println(s);

      // Exemplo de remocao de elementos na pilha
      for (int i=0; i<4; i++) {
         int aux = s.pop(); // retira o elemento no topo da pilha
         System.out.println("s.pop() = " + aux);
      }
      System.out.println(s);

      // Exemplo de utilizacao dos outros metodos
      System.out.println("s.size() = " + s.size());
      System.out.println("s.isEmpty() = " + s.isEmpty());
      System.out.println("s.top() = " + s.top());
   }
}
