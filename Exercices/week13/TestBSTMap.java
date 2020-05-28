package week13;


import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.TreeMap;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;


public class TestBSTMap {
   
   public static void main(String[] args) {
      
      // Criacao de um dicionario     
      BSTMap<String,Integer> map = new BSTMap<String,Integer>();  // Criaçao de algo semelhante ao TreeMap, usando BST

      TreeSet<Integer> tree = new TreeSet<>();  // tree é uma "árvore a serio", tem todos os metodos disponiveis do TreeSet. Por baixo do TreeSet temos um TreeMap que tem como base Red-Black tree baseadas em NavigableMap.
      TreeMap<Integer, String> map1 = new TreeMap<>();   // TreeMap que implementa a interface Map mas desta ves é uma "àrvore a sério", tem todos os metodos desbloqueados é baseado num Red-Black Tree

      Set<Integer> t = new TreeSet<>();     // t tem apenas os metodos da interface Set disponiveis, no entanto é usado com um TreeSet (que usam um TreeMap) por baixo para fazer tudo funcionar
      Set<Integer> t1 = new LinkedHashSet<>();  // t1 tem apenas os metodos da interface Set disponiveis, tal como t, mas desta vez é usado um LinkedHashSet por baixo para fazer tudo funcionar

      Map<String, Double> m = new TreeMap<>();  // m tem apenas os metodos da interface Map disponiveis, usa um TreeMao para fazer tudo funcionar
      Map<Double, Character> m1 = new HashMap<>(); //m1 tem também apenas os metodos da interface Map, mas usa agora um HashMap para eles



      map1.put(5, "cinco");
      map1.put(6, "seis");
      map1.put(42, "quarenta e dois");
      map1.put(20, "vinte");

      Set<Integer> set = map1.keySet();
      Iterator<Integer> iter;

      System.out.println(map1.remove(5));
      map1.put(999, "Infinity");

      iter = set.iterator();

      while (iter.hasNext()) 
         System.out.println(iter.next());

      
      // Inserindo alguns pares (chave,valor)
      map.put("Life", 42);
      map.put("Zero", 0);
      map.put("Infinity", 999);
      map.put("Test", 20);
      map.put("Test1", 145);
      map.put("numero", 77);

/* 
      LinkedList<String> keys = map.keys();

      System.out.println(map.get("Test"));

      for (String k : map.keys())
         System.out.println("- (" + k + "," + map.get(k) + ")");
      

        System.out.println(map.remove("Life"));
        System.out.println(map.remove("Zero"));
        System.out.println(map.remove("Test"));


      for (String k : map.keys())
         System.out.println("- (" + k + "," + map.get(k) + ")"); */


   }
}