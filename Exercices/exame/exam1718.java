package exame;

import java.util.Arrays;
import java.util.LinkedList;

class Matriz {
    char[][] m;
    int size;

    Matriz (int k) {
        m = new char[k][k];
        size = k;
        for (int i = 0; i < k; i++) 
            for (int j = 0; j < k; j++) {
                m[i][j] = '.';
            }
    }

    public boolean verify (char c) {
        int cnt = 0;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (m[i][j] != c) {
                    cnt = 0;
                    break;
                } else { cnt++; }

                if (cnt == size) {return true;}
            }
        }

        cnt = 0;
        for (int j = 0; j < size; j++) {
            for (int i = 0; i < size; i++) {
                if (m[i][j] != c) {
                    cnt = 0;
                    break;
                } else { cnt++; }

                if (cnt == size) {return true;}
            }
        }

        return false;
    }

    @Override
    public char[][] clone() {
        char[][] newm = new char[size][size];
        for (int i = 0; i < size; i++) 
            for (int j = 0; j < size; j++) 
                newm[i][j] = m[i][j];

        return newm;
    }

    @Override
    public String toString () {
        String s  = "[";
        for (int i = 0; i < size; i++) {
            s += "[";
            for (int j = 0; j < size; j++) {
                s += m[i][j]; 
                if (j != size-1) s+=", ";
            }
            s+="]";
            if (i != size-1) s+=", ";
        }
        s+="]";
        return s;
    }
}


public class exam1718 {    

    public static BSTMap<Integer,String> compose (BSTMap<Integer,Double> f, BSTMap<Double,String> g) {
        LinkedList<Integer> l = f.keys();
        LinkedList<Double> ll = g.keys();
        BSTMap<Integer,String> r = new BSTMap<>();
        for (Integer key : l) {
            for (Double key1 : ll) {
                if (f.get(key).equals(key1))
                    r.put(key, g.get(key1));
            }
        }
        return r;
    }

    public static void main(String[] args) {
        Matriz x = new Matriz(3);
        SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
        for (int i=1; i<=6; i++)
            list.addLast(i);


        // Adicionando numeros de 6 a 10 ao inicio da lista
/*         for (int i=6; i<=10; i++)
            list.addFirst(i); */
/*         
        System.out.println("list: " + list.toString());
        SinglyLinkedList<Integer> l = list.rotate(7);
        System.out.println("l: " + l.toString()); */


        BSTMap<Integer,Double> m1 = new BSTMap<>();
        BSTMap<Double,String> m2 = new BSTMap<>();

        m1.put(1, 1.0);
        m1.put(42, 42.42);
        m1.put(69, 96.69);
        m1.put(123, 33.33);

        m2.put(1.0, "UM");
        m2.put(42.42, "quarenta e dois");
        m2.put(96.69, "sixtynine");
        m2.put(420.69, "no");

        BSTMap<Integer,String> r = compose(m1, m2);
        LinkedList<Integer> o = r.keys();
        for (Integer key : o) {
            System.out.println(key + " " + r.get(key));
        }

    }
}