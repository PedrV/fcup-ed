package week8;

import java.util.Scanner;
import java.util.LinkedList;

// Classe para representar um Doente
class Doente {
    public String nome;     // Nome
    public int chegada;     // Tempo de chegada
    public int atendimento; // Tempo que demora a ser atendido
    public int entrada;     // Tempo em que comecou a ser atendido

    // Construtor: inicializa os atributos
    Doente(String n, int c, int a) {
        nome        = n;
        chegada     = c;
        atendimento = a;
        entrada     = -1;
    }
}

// Classe para representar uma fila de atendimento de uma cor (necessaria criar array)
// Ao criar o array, vai ser criado um array de "classes" FilaAtendimento em que cada uma dessas FilaAtendimento tem um atributo que é uma queue (aka total 5 filas)
// (nota: Java nao permite criacao direta de array de genericos)
class FilaAtendimento {
    public MyQueue<Doente> fila;

    FilaAtendimento() {
	    fila = new LinkedListQueue<Doente>();
    }
}

// Classe para representar uma equipa da urgencia
class Equipa {
    int numDoentes;       // Numero de doentes que atenderam
    int totalAtendimento; // Total de tempo passado a atender
    int livre;            // Tempo em que ficam livres para poder atender novo doente

    Equipa() {
        numDoentes       = 0;
        totalAtendimento = 0;
        livre            = 0;
    }

    // Novo doente d comecou a ser atendido num dado tempo t nesta equipa
    void novoDoente(Doente d, int t) {
        livre = d.atendimento + t;                  // Equipa fica livre depois de passar o tempo que o doente demora a ser atendido
        totalAtendimento += d.atendimento;          // Juntar todo esse tempo
        numDoentes++;                               // Incrementar o numero de doentes atendidos por essa equipa
    }
}

// Classe principal que contem o metodo main
class ED098 {
    // Constantes que nao mudam durante o programa: numero de cores e seus nomes
    private static final int NUM_CORES = 5;
    private static final String[] CORES = {"Vermelho","Laranja","Amarelo","Verde","Azul"};

    private static int numEquipas;               // Numero de equipas
    private static int numDoentes;               // Numero total de doentes
    private static FilaAtendimento emEspera[];   // Array com uma fila para cada cor
    private static LinkedList<Doente> atendidos; // Lista de doentes ja atendidos
    private static Equipa equipas[];             // Equipas da urgencia

    // Metodo para devolver indice de uma cor representada pela string s
    private static int indiceCor(String s) {
        
        if (s.equals(CORES[0])) {           // Vermelho retorna 0 -- mais prioritario
            return 0;
        } else if (s.equals(CORES[1])) {    // Laranga retorna 1
            return 1;   
        } else if (s.equals(CORES[2])) {    // Amarelo retorna 2
            return 2;
        } else if (s.equals(CORES[3])) {    // Verde retorna 3
            return 3;
        } else {                            // Azul retorna 4     -- menos prioritario
            return 4;                      
        }
    }

    // Ler os doentes a partir do input e coloca-los nas respetivas filas
    private static void lerDoentes(Scanner in) {	
        while (in.hasNext()) {
            String nome     = in.next();
            String cor      = in.next();
            int chegada     = in.nextInt();
            int atendimento = in.nextInt();
            //System.out.printf("Li [%s,%s,%d,%d]%n", nome, cor, chegada, atendimento);
            
            Doente d = new Doente (nome, chegada, atendimento);
            int tempInd = indiceCor(cor);

            // Com base no indice da cor atribuir o doente há sua respetiva fila
            emEspera[tempInd].fila.enqueue(d);

            numDoentes++;
        }
    }

    // Mostrar numero de doentes em cada cor (necessario para flag==0)
    private static void mostrarCores() {
        int gap = 4; // remove and add String.format instead

        System.out.println("------------");
        System.out.println("Cores     ND");
        System.out.println("------------");
	
        System.out.printf("Vermelho" + "%" + gap + "s\n", emEspera[0].fila.size());
        System.out.printf(" Laranja" + "%" + gap + "s\n", emEspera[1].fila.size());
        System.out.printf(" Amarelo" + "%" + gap + "s\n", emEspera[2].fila.size());
        System.out.printf("   Verde" + "%" + gap + "s\n", emEspera[3].fila.size());
        System.out.printf("    Azul" + "%" + gap + "s\n", emEspera[4].fila.size());

        System.out.println("------------");

        System.out.println("Numero doentes atendidos: " + numDoentes);
    }
    

    // Mostrar estatisticas dos doentes atendidos (necessario para flag==1 e flag==2)
    private static void mostrarAtendidos() {
        double stt_entrada = 0;

        System.out.println("---------------------------");
        System.out.println("Lista dos doentes atendidos");
        System.out.println("---------------------------");
        // itera sobre todos os doentes já¡ atendidos (instrução for-each)
        for (Doente d : atendidos) { 
            System.out.println(d.nome + " " + d.chegada + " " + d.entrada + " " + d.atendimento);
            stt_entrada += d.entrada;
	    }
        System.out.println("---------------------------");
        System.out.println("Tempo medio de espera: " + String.format("%.1f", stt_entrada/numDoentes));
    }

    // Mostrar estatisticos das equipas (necessario para flag==2)
    private static void mostrarEquipas() {
        System.out.println("-----------------------");
        System.out.println("Equipa NDoentes MediaTA");
        System.out.println("-----------------------");
        for (int i = 0; i < numEquipas; i++) {
            System.out.printf (String.format("%6d %8d %7.1f\n", i, equipas[i].numDoentes, (double) equipas[i].totalAtendimento/equipas[i].numDoentes));
        }
        
    }

    // Ver o doente com chegou à menos tempo, quando anteriormente não havia nenhum doente à espera
    private static int updateTempDoentes () {

        if (emEspera[0].fila.isEmpty() && emEspera[1].fila.isEmpty() && emEspera[2].fila.isEmpty() && emEspera[3].fila.isEmpty() && emEspera[4].fila.isEmpty()) {
            System.out.println("All lines empty");
        }

        int r = Integer.MAX_VALUE, o = Integer.MAX_VALUE, y = Integer.MAX_VALUE;
        int g = Integer.MAX_VALUE, b = Integer.MAX_VALUE;

        if (!emEspera[0].fila.isEmpty()) 
            r = emEspera[0].fila.first().chegada;
        if (!emEspera[1].fila.isEmpty())
            o = emEspera[1].fila.first().chegada;
        if (!emEspera[2].fila.isEmpty())
            y = emEspera[2].fila.first().chegada;
        if (!emEspera[3].fila.isEmpty())
            g = emEspera[3].fila.first().chegada;
        if (!emEspera[4].fila.isEmpty())
            b = emEspera[4].fila.first().chegada;


        // Não estou orgulhoso disto, mas funciona. Substituir por loop, mais compacto e simples
        if (r <= o) {
            if (y <= g) {
                if (r <= y) {
                    if (r <= b) {
                        return r;
                    } else {
                        return b;
                    }
                } else {
                    if (y <= b) {
                        return y;
                    } else {
                        return b;
                    }
                }
            } else {
                if (r <= g) {
                    if (r <= b) {
                        return r;
                    } else {
                        return b;
                    }
                } else {
                    if (g <= b) {
                        return g;
                    } else {
                        return b;
                    }
                }
            }
        } else {
            if (y <= g) {
                if (o <= y) {
                    if (o <= b) {
                        return o;
                    } else {
                        return b;
                    }
                } else {
                    if (y <= b) {
                        return y;
                    } else {
                        return b;
                    }
                }
            } else {
                if (o <= g) {
                    if (o <= b) {
                        return o;
                    } else {
                        return b;
                    }
                } else {
                    if (g <= b) {
                        return g;
                    } else {
                        return b;
                    }
                }
            }
        }
    }

    // Avançar o tempo até ter uma equipa livre
    private static int updateTempEquipas () {
        int tempo_avancado = 0;

        for (int i = 0, j = i+1; j < numEquipas; j++) {
            if(equipas[i].livre >= equipas[j].livre) {
                i = j;
            }
            tempo_avancado = equipas[i].livre;
         }
         
        return tempo_avancado;
    }

    // Qual a cor da proxima equipa a ficar livre?
    private static int proximaEquipaLivre(int tempo) {
        if (numEquipas == 1) {
            return 0;
        }

        for (int i = 0; i < numEquipas; i++) {
           if(equipas[i].livre <= tempo) {
               return i;
           }
        }
        
        // se nenhuma equipa estiver livre fazer avançar o tempo
        return -1;
    }

    // Qual a cor mais prioritaria com doente ainda por ser atendido no tempo atual?
    private static int proximoDoente(int tempo) {
        
        int r = Integer.MAX_VALUE, o = Integer.MAX_VALUE, y = Integer.MAX_VALUE;
        int g = Integer.MAX_VALUE, b = Integer.MAX_VALUE;

        if (!emEspera[0].fila.isEmpty()) 
            r = emEspera[0].fila.first().chegada;
        if (!emEspera[1].fila.isEmpty())
            o = emEspera[1].fila.first().chegada;
        if (!emEspera[2].fila.isEmpty())
            y = emEspera[2].fila.first().chegada;
        if (!emEspera[3].fila.isEmpty())
            g = emEspera[3].fila.first().chegada;
        if (!emEspera[4].fila.isEmpty())
            b = emEspera[4].fila.first().chegada;
        

        if (r <= tempo) {
            return 0;
        } else if (o <= tempo) {
            return 1;
        } else if(y <= tempo) {
            return 2;
        } if (g <= tempo ) {
            return 3;
        } if (b <= tempo ) {
            return 4;
        }
        // se não estiver no tempo de nenhum, fazer avançar o tempo
        return -1;
    }

    // Simular processo de atendimento pelas varias equipas medicas
        private static void simular() {
            int time = 0;
            Doente d;

/*             while (atendidos.size() < numDoentes) {

                int fila_a_sair = proximoDoente(time);

                if (fila_a_sair == -1) {
                    time = updateTemp();
                } else {
                    d = emEspera[fila_a_sair].fila.dequeue();
                    d.entrada = time - d.chegada;
                    time += d.atendimento;
                    d.atendimento = time;
                    atendidos.addLast(d);
                }
            } */

            while (atendidos.size() < numDoentes) {
                int equipa_a_ficar_livre = proximaEquipaLivre(time);

                if (equipa_a_ficar_livre == -1) {
                   time = updateTempEquipas();
                } else {

                    int doente_a_ser_atendido = proximoDoente(time);

                    if (doente_a_ser_atendido == -1) {
                        time = updateTempDoentes();
                    } else {
                        d = emEspera[doente_a_ser_atendido].fila.dequeue();

                        //time = equipas[equipa_a_ficar_livre].livre;
                        equipas[equipa_a_ficar_livre].novoDoente(d, time);

                        d.entrada = time - d.chegada;   // tempo que o doente demorou até entrar
                        d.atendimento += d.chegada;     // tempo total gasto pelo doente no hospital

                        atendidos.addLast(d);
                    }
                }

            }
    }

    // Inicializar variaveis
    private static void inicializar() {
        numDoentes = 0;

        emEspera = new FilaAtendimento[NUM_CORES];	
        for (int i=0; i<NUM_CORES;i++) {
            emEspera[i] = new FilaAtendimento();
        }

        atendidos = new LinkedList<Doente>();

        equipas = new Equipa[numEquipas];
        for (int i=0; i<numEquipas; i++){
            equipas[i] = new Equipa();
        }
    }

    // ----------------------------------------------------------------
    // Funcao principal chamada no inicio do codigo
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int flag   = in.nextInt();
        numEquipas = in.nextInt();
        
        inicializar();

        lerDoentes(in);

        if (flag==0) {
            mostrarCores();
        } else {
            simular();
            if (flag==2){ 
                mostrarEquipas(); 
            }
            mostrarAtendidos();
        } 
    }
}