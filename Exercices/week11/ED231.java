package week11;


/*
Nome: Pedro Campos Vieira
Número mecanográfico: 201905272
Sobre ajudas: A maior parte do codigo tem comentários que ajuda a perceber o meu raciocinio, no entanto ficam aqui outros raciocionios mais gerais:

-- metodo lowProp
- A subida percentual do "dia -1" para o 0, (o dia -1 não faz parte do conjunto de dados) é de 100%, não conta neste caso
por isso começados a fazer a estatistica da subida do dia 0 par ao dia 1 (por isso, no loop,  i = 1) 

-- metodo drawGraph
- Começamos por ir da ultima linha, do topo, para a primeira linha, a linha de baixo. A variavel k representa a altura, 
comparando isso com a altura total de cada dia podemos saber se naquela especifica altura "k", esse dia vai estar presente, imprimindo um "#" ou não imprimindo um "."

Complexidade temporal estimada:
maxMin() -- Theta(n), em que "n" é o numero de dias

lowProp() -- Theta(n), em que "n" é o numero de dias

drawGraph() -- r * n, onde "n" é o numero de dias e "r" é o a altura da maior coluna do dataset.
Por cada nivel de altura de r, r-1 ... 1, nos passamos os pelos n dias.
Resumindo, Theta(r*n), em que "n" é o numero de dias e r é a altura maxima do grafico. Ou seja Theta(n)

*/

import java.util.Scanner;

class DataManage {
    private int[] data;
    
    DataManage (int[] data) {
        this.data = data;
    }

    public void maxMin () {
        int max = data[0];  // Maximo inicial é o numero de casos registados no proprio dia
        int min = data[0];  // Minimo inicial é o numero de casos registados no proprio dia

        for (int i = 0; i < data.length-1; i++) {
            max = Math.max(max, data[i+1]-data[i]);
            min = Math.min(min, data[i+1]-data[i]);
        }
        
        System.out.println(min + " " + max);
        
    }

    public void lowProp () {
        int longest_streak = 0;                     // Numero maximo de dias com percentual < 5%
        int cur_streak = 0;                         // Numero de dias atual com percentual < 5%
        int occurances = 0;                         // Numero de periodos de dias com percentual < 5%
        double percentual;                          // Percentual atual
        double last_percentual = Double.MAX_VALUE;  // Percentual do dia anterior

        
        for (int i = 1; i < data.length; i++) {
            percentual = (double) (data[i]-data[i-1]) / data[i-1];  // Calculo da subida percentual

            if (percentual <= 0.05) 
                cur_streak++;

            // No caso do percentual ser >5% então acaba um streak de dias com percentual <5%
            // Ou no caso de se tratar do ultimo dia em que se tem dados, o streak também acaba
            if (percentual > 0.05 || i == data.length-1) {          
                                                        
                longest_streak = Math.max(longest_streak, cur_streak);
                cur_streak = 0;
                
                // Apenas considerar como periodo com percentual <5% se o percentual do dia atual ja for >5% e o do dia anterior <5%
                // Isto evita que dias consecutivos com percentual >5% sejam contados                
                if (last_percentual <= 0.05)
                    occurances++;
                
            }

            last_percentual = percentual;
        }

        System.out.println(occurances + " " + longest_streak);
    }

    public void drawGraph () {
        // Se é garantido que o numero de casos aumenta sempre, então o dia com mais casos é o ultimo
        int max_height = (data[data.length-1] / 100);   // Altura maxima
        
        /* // Descobrir qual vai ser a altura do gráfico em cada dia 
        // Este array é desnecessário visto que calculo pode ser feito na hora, mas assim fica mais sucinto
        int[] number_cardinal = new int[data.length];
        for (int j = 0; j < data.length; j++)
            number_cardinal[j] = data[j]/100; */

        // Imprimir tantas linhas quanto a altura da maior coluna, começar pelo topo, k representa a altura em consideraçao
        for (int k = max_height; k > 0; k--) {
            // Imprimir tantas colunas como dias do dataset, i representa o dia em consideraçao
            for (int i = 0; i < data.length; i++) {

                // Se o dia em consideração tiver altura suficiente então imprimimos um "#"
                if (data[i]/100 >= k) 
                    System.out.print("#");
                else 
                    System.out.print(".");

            }

            System.out.println();
        }
    }
}


public class ED231 {
    public static void main (String[] args) {
    Scanner scan = new Scanner(System.in);

    int number_of_days = scan.nextInt();  // Saber o numero de dias que foram registados dados
    int[] data = new int[number_of_days]; // Temos informação do numero de dados, array é suficiente    

    for(int i = 0; i < number_of_days; i++)
        data[i] = Integer.parseInt(scan.next());

    int flag = scan.nextInt();

    scan.close();

    DataManage data1 = new DataManage(data);
    if (flag == 1) {
        data1.maxMin();
    } else if (flag == 2) {
        data1.lowProp();
    } else {
        data1.drawGraph();
    }
   }
}