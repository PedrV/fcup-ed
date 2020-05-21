package week12;

import java.util.Arrays;


class Teams implements Comparable<Teams> {
    String name;
    Integer points; 

    // Construtor
    Teams(String n, int p) {
        name = n;
        points = p;
    }

    // Método para dar representação em String de um objecto da classe
    public String toString() {
        return "(" + name + "," + points + ")";
    }

    public int compareTo (Teams t) {
        int comp = -points.compareTo(t.points);

        if (comp == 0) 
            return name.compareTo(t.name);  // Para usar este metodo (compareTo) é usado um wrapper Integer. 
                                            //Se fosse usado o tipo primitivo int entao era o usado o comparador binario "<", ">"
        
        return comp;

    }
 }

public class Test {
    public static void main (String[] args) {
        Teams[] v = new Teams[7];

        v[0] = new Teams("Leicester", 20);
        v[1] = new Teams("Chelsea", 31);
        v[2] = new Teams("Arsenal", 20);
        v[3] = new Teams("Liverpool", 42);
        v[4] = new Teams("Man United", 37);
        v[5] = new Teams("Man City", 20);
        v[6] = new Teams("Tottenham", 39);
        
        // Ordenar e escrever array v
        Arrays.sort(v);
        System.out.println(Arrays.toString(v));

    }
}