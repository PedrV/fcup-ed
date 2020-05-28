package week12;

import java.util.Random;

// Classe para gerar várias árvores de pesquisa com elementos aleatórios
class TestRandom {
    final static int NUM_TREES = 20;         // Número de árvores de pesquisa
    final static int NUM_VALUES = 100000;    // Quantidade de valores por árvore
    final static int MAX_VALUE = 1000000000; // Máximo valor num nó

    public static void main(String[] args) {
        // variáveis para guardar altura total, mínima e máxima
        int total = 0, min = 0, max = 0;

        // Objecto para gerar números aleatórios
        Random r = new Random();

        // Ciclo para iterar sobre cada uma das árvores binárias de pesquisa
        for (int i = 1; i <= NUM_TREES; i++) {
            // Criar uma árvore (inicialmente vazia)
            BSTree<Integer> t = new BSTree<Integer>();

            // Ciclo para iterar sobre cada um dos valores a inserir
            for (int j=0; j<NUM_VALUES; j++) {

                int x;

                // Se valor já existe na árvore, gerar novamente
                do {
                    // Gerar um valor aleatório entre 0 e MAX_VALUE-1
                    x = r.nextInt(MAX_VALUE); 
                } while (t.contains(x));

                // Inserir valor na árvore
                t.insert(x); 
            }

            // Actualizar variáveis com dados sobre altura
            int h = t.depth();
            total += h;

            if (i==1 || h<min) min = h;
            if (i==1 || h>max) max = h; 

            System.out.printf("Arvore #%2d: altura = %d | num. nos = %d%n",
                            i, h, t.numberNodes());
        }

        // Escrever estatísticas gerais
        System.out.printf("Altura média: %.2f%n", (double)total/NUM_TREES);
        System.out.println("Altura mínima: " + min);
        System.out.println("Altura máxima: " + max);                     
    }
}