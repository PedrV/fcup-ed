package week14;

import week14.util.BSTMap;
import week14.util.BSTree;

/* ----------- ----------- ----------- ----------- ----------- ----------- ----------- ----------- ----------- ----------- ----------- -----------
   Nome: Pedro Campos Vieira
   Número mecanográfico: 201905272
   Comentário: Ao longo do codigo existem comentarios pretinentemente localizados de forma a tentar explicar o que faz cada parte, no entanto aqui ficam raciocionios mais gerais:

   flag 1: Usando o facto de BST não permitirem duplicados, ao inserir o nome do filme na árvore, no final podemos saber quantidade de filmes contando o numero de nós;
   flag 2: Mapeando o nome do filme à sua quantidade de reviews, temos um dicionário em que a cada filme (key), corresponde o numero de reviews (value),
   para conseguir descobrir o maior numero de reviews, em vez de manter um maximo no dicionário, no final de ler todos os filmes do stdin, lista-se os nomes dos filmes e
   descobre-se o máximo associado.
   flag 3: Construi-se mais um dicionáro, conteundo key: filme, value: total rating. Depois, tirando vantagem do dicionário construido na flag anterior, lista-se os nomes
   dos filmes e vemos o numero de reviews associado aquele filme no dicionário da flag 2, e o numero total de ratings no dicionário da flag 3, depois basta dividir e ver se >= 5.0.
   Retira-se vantagem do facto de a construçao da lista ser feita InOrder, e assim as keys (nomes dos filmes) já virem ordenados por ordem alfabetica.
   
   (Podia se evitar a construção de 2 dicionários usando apenas um dicionário do tipo <String, Pair<Integer,Integer>>, onde String seria o nome do filme e os Integer a quantidade de reviews e total ratings)


   Complexidade: (ignorando a parte que temos de ler o input, sendo esta O(n), n é o numero de reviews)

   flag 1: Percorremos cada nó uma vez, logo O(n), onde n é o numero de nós da árvore (ou numero de filmes unicos)

   flag 2: Dicionário construido "usando" o principio de BST. Para listar as keys passamos uma vez por cada nó, logo O(n), onde n é o numero de nós da árvore (ou numero de filmes unicos),
   depois fazemos uma pesquisa sobre o value de cada key do dicionário, onde a cada passo temos de ir buscar novamente o value, ou seja (n^2+n)/2 sobre o numero de nós da árvore. 
   Temos de descobrir ainda o size do map, mais um ciclo sobre o numero de nós, e ainda para ir buscar os elementos da LinkedList na posição "i" durante o ciclo, precisamos de fazer um loop pelo numero de elementos da lista até à posiçao "i", mais (n^2+n)/2.
   No final, temos O(n^2) sobre o numero de nós do dicionário.

   flag 3: Listar keys: n; Buscar size: n; A cada passo ir buscar aos 2 dicionários os 2 values: (n^2 + n) e ainda ir buscar o conteudo da LinkedList, (n^2+n)/2
   No final O(n^2) sobre o numero de nós do dicionário, ou seja numero de filmes unicos.

   ----------- ----------- ----------- ----------- ----------- ----------- ----------- ----------- ----------- ----------- ----------- ----------- */

import java.util.LinkedList;
import java.util.Scanner;


public class ED234 {
  public static void main (final String[] args) {
    final Scanner scan = new Scanner(System.in);
        final BSTree<String> tree_movies = new BSTree<>(); // Manter o numero de filmes unicos
        final BSTMap<String, Integer> map_movies = new BSTMap<>(); // Manter nome e quantidade de reviews de cada filme
        final BSTMap<String, Integer> movies_rates = new BSTMap<>(); // Manter nome e reviews de cada filme
        LinkedList<String> movie_names = new LinkedList<>(); // Levar nome dos filmes quando necessário

        final int flag = scan.nextInt(); // Flag para decidir output
        scan.nextLine();
        final int movies = scan.nextInt(); // Quantidade de reviews
        scan.nextLine();

        for (int i = 0; i < movies; i++) {
            String[] temp = new String[2]; // Array de string: temp[0] - nome do filme; temp[1] - review
            temp = scan.nextLine().split(" "); // Dividir input no espaço

            if (flag == 1) {
                tree_movies.insert(temp[0]); // Inserir apenas o nome do filme, como é árovre de pesquisa nao permite
                                             // duplicados

            } else if (flag == 2 || flag == 3) { // Quer a flag seja 2 ou 3, inserir no dicionario a quantidade de reviews do filme
                if (map_movies.get(temp[0]) == null) // Senao houver correspondecia no dicionário ao nome do filme
                    map_movies.put(temp[0], 1); // Introduzir o nome do filme e "1", pois eta é a 1º review
                else
                    map_movies.put(temp[0], map_movies.get(temp[0]) + 1); // Caso contrário, inserir mais uma review às
                                                                          // que já lá estão
            }

            if (flag == 3) {
                if (movies_rates.get(temp[0]) == null) // Senao houver correspondecia no dicionário ao nome do filme
                    movies_rates.put(temp[0], Integer.parseInt(temp[1])); // Acrescentar o nome do filme a sua review
                                                                          // inicial
                else
                    movies_rates.put(temp[0], movies_rates.get(temp[0]) + Integer.parseInt(temp[1])); // Se já existe correspondencia, adicionar a review à que já lá está
            }
        }

        if (flag == 1) {
            System.out.println(tree_movies.numberNodes()); // Imprimir a quantidade de filmes

        } else if (flag == 2) {
            movie_names = map_movies.keys(); // Buscar linkedlist com os nomes dos filmes

            int max = map_movies.get(movie_names.getFirst()); // Começar por definir o numero maximo de reviews como o numero de reviews do 1ºfilme
            String name = movie_names.getFirst(); // Definir nome do 1º filme como filme com mais reviews

            // Encontrar o máximo de reviews dos filmes
            for (int i = 1; i < map_movies.size(); i++) {

                final int cur = map_movies.get(movie_names.get(i)); // Buscar numero de reviews do filme na posiçao "i"
                                                                    // da lista

                if (cur > max) { // Se for maior que o numero maior atual, atualizar
                    max = cur;
                    name = movie_names.get(i);
                }
            }

            System.out.println(name + " " + max);

        } else {

            movie_names = movies_rates.keys(); // Buscar linkedlist com os nomes dos filmes

            for (int j = 0; j < movie_names.size(); j++) {
                final double rating = movies_rates.get(movie_names.get(j)); // Numero resultante da soma de todas as reviews
                final double number_ratings = map_movies.get(movie_names.get(j)); // Numero de reviews do filme

                if ( rating / number_ratings >= 5.0 ) { // Se review for positiva então filme passa
                    System.out.println(movie_names.get(j));
                }
            }
        }

        scan.close();
    }
}