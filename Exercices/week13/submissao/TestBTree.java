package week13.submissao;

import java.util.Arrays;
import java.util.Random;

// -----------------------------------------------------------
// Estruturas de Dados 2019/2020 (CC1007) - DCC/FCUP
// http://www.dcc.fc.up.pt/~pribeiro/aulas/edados1920/
// -----------------------------------------------------------
// Exemplo de utilizacao da uma arvore binaria
// Ultima alteracao: 26/04/2018
// -----------------------------------------------------------

import java.util.Scanner;

public class TestBTree {
   public static void main(String[] args) {
      // Ler arvore de inteiros em preorder
      Scanner in = new Scanner(System.in);
      BTree<Integer> t = LibBTree.readIntTree(in);
     // BTree<Integer> t2 = LibBTree.readIntTree(in);


      // Escrever nos da arvore seguindo varias ordens possiveis
      System.out.println(Arrays.toString(t.maxLevel()));

/*       System.out.print("Resultado obtido: ");
      t.printPreOrder();

      System.out.print("Resultado certo: ");
      t2.printPreOrder(); */

/*      t.printInOrder();
      t.printPostOrder();
      t.printBFS();
      t.printDFS(); */
   }
}
