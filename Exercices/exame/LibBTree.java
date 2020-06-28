package exame;

import java.util.Scanner;

public class LibBTree {
   public static BTree<Character> readIntTree(Scanner in) {
      BTree<Character> t = new BTree<Character>();
      t.setRoot(readIntNode(in));
      return t;
   }
   
   private static BTNode<Character> readIntNode(Scanner in) {
      String s = in.next();
      if (s.equals("N")) return null;
      Character value = s.toCharArray()[0];
      BTNode<Character> left = readIntNode(in);
      BTNode<Character> right = readIntNode(in);
      return new BTNode<Character>(left, right, value);
   }
}