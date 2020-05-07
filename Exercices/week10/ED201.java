package week10;

import java.util.Scanner;

class Subset {
    static int max_so_far = 0;      // Variavel global contendo o maximo subset somado que obedece às condiçoes impostas


    // Escrever todos os subconjuntos do array v[], inicializa o gerador
    static void sets(int v[], int duration) {

        // array de booleanos para representar o conjunto
        boolean used[] = new boolean[v.length];

        goSets(0, v, used, 0, duration); // chamar funcao recursiva
    }


    // Gera todos os subconjuntos a partir da posicao 'cur'
    static void goSets(int cur, int v[], boolean used[], int max, int duration) {
        int dur = duration;

        if (cur == v.length) {  // Caso base: terminamos o conjunto

            // Escrever conjunto
            for (int i=0; i<v.length; i++) {
                if (used[i]) {
                    max += v[i];
                }
            }

            // Redefinir tamanho maximo
            if ((max > max_so_far && max <= dur)) {
                max_so_far = max;
            }


        } else {                                // Se nao terminamos, continuar a gerar
            used[cur] = true;                   // Subconjuntos que incluem o elemento actual
            goSets(cur+1, v, used, 0, dur);     // Chamada recursiva

            used[cur] = false;                  // Subconjuntos que nao incluem o el. actual
            goSets(cur+1, v, used, 0, dur);     // Chamada recursiva
        }
    }
      
}

public class ED201 {
    public static void main (String[] args) {
        Scanner scan = new Scanner (System.in);

        int duration = scan.nextInt();
        int tracks = scan.nextInt();
        int[] track_list = new int[tracks];

        scan.nextLine(); // Desgate the newline

        for(int i = 0; i < tracks; i++)
            track_list[i] = scan.nextInt();


        Subset.sets(track_list, duration);
        System.out.println(Subset.max_so_far);

        scan.close();
    }
}