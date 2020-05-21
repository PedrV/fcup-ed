package week12;

import java.util.Arrays;


class Team implements Comparable<Team> {
    String name;
    Integer points; 

    // Construtor
    Team(String n, int p) {
        name = n;
        points = p;
    }

    // Método para dar representação em String de um objecto da classe
    public String toString() {
        return "(" + name + "," + points + ")";
    }

    public int compareTo (Team t) {
        int comp = -points.compareTo(t.points);

        if (comp == 0) 
            return name.compareTo(t.name);  // Para usar este metodo (compareTo) é usado um wrapper Integer. 
                                            //Se fosse usado o tipo primitivo int entao era o usado o comparador binario "<", ">"
        
        return comp;

    }
 }

public class Test {
    public static void main (String[] args) {
        Team[] v = new Team[7];

        v[0] = new Team("Leicester", 20);
        v[1] = new Team("Chelsea", 31);
        v[2] = new Team("Arsenal", 20);
        v[3] = new Team("Liverpool", 42);
        v[4] = new Team("Man United", 37);
        v[5] = new Team("Man City", 20);
        v[6] = new Team("Tottenham", 39);
        
        // Ordenar e escrever array v
        Arrays.sort(v);
        System.out.println(Arrays.toString(v));

    }
}