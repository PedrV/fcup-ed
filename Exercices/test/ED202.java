package test;

// Find the shortest path. The aggressive way! - Theta(n!)

import java.util.Scanner;

class Permutations {
    static double min_distance = Integer.MAX_VALUE;

    static void permutations(int v[], double[][] map) {

        boolean used[] = new boolean[v.length]; // i esta na permutacao?
        int perm[] = new int[v.length];         // permutacao actual

        goPerm(0, v, used, perm, map);          // chamar funcao recursiva
    }

    // Gera todos os subconjuntos a partir da posicao 'cur'
    static void goPerm(int cur, int v[], boolean used[], int perm[], double[][] map) {
        double cur_distance = 0;

        if (cur == v.length) {  // Caso base: terminamos a permutacao

            for (int i=0, j = 0; i < v.length; i++) {
                cur_distance += map[j][v[perm[i]]]; // Buscar a distancia do proximo local
                
                // Ir até ao ponto na matriz das distancias que representa estar num local (um ponto de distancia 0) na diagonal da matriz
                if (i < perm.length)
                    j = v[perm[i]]; 
                
                // Adicionar a distancia de volta do ponto final ao inicial
                if (i == perm.length-1)
                    cur_distance += map[0][v[perm[i]]];
            }    
            
            min_distance = Math.min(min_distance, cur_distance);

        } else {                              // Se nao terminamos, continuar a gerar

            for (int i=0; i<v.length; i++) {  // Tentar todos os elementos
                if (!used[i]) { 
                    used[i] = true; 
                    perm[cur] = i;

                    goPerm(cur+1, v, used, perm, map);
                    used[i] = false;
                }
            }
        }

    } 
}


public class ED202 {
    public static void main (String[] args) {
        Scanner scan = new Scanner (System.in);

        int number_locations = scan.nextInt();
        double[][] map = new double[number_locations][number_locations];
        
        scan.nextLine(); // Discartar newline
        scan.nextLine(); // Discartar nomes dos locais uma vez que nao interessa para resultado

        int[] locations = new int[number_locations-1]; 
        
        // Cada local é marcado com um numero. O local inicial é o numero 0
        // O local inicial nao entra no "locations" porque nao tem de ser permutado
        for (int i = 0; i < number_locations-1; i++)
            locations[i] = i+1;
            
        for(int i = 0; i < number_locations; i++)
            for (int j = 0; j < number_locations; j++) 
                map[i][j] = Double.parseDouble(scan.next());
             
            
        Permutations.permutations(locations, map);
        System.out.println(Permutations.min_distance);

        scan.close();
    }    
}
