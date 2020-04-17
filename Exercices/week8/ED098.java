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
        // a completar ...
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
            if (tempInd == 0) {
                emEspera[0].fila.enqueue(d);
            } else if (tempInd == 1 ) {
                emEspera[1].fila.enqueue(d);
            } else if (tempInd == 2 ) {
                emEspera[2].fila.enqueue(d);
            } else if (tempInd == 3 ) {
                emEspera[3].fila.enqueue(d);
            } else {
                emEspera[4].fila.enqueue(d);
            }

            numDoentes++;
        }
    }

    // Mostrar numero de doentes em cada cor (necessario para flag==0)
    private static void mostrarCores() {
        System.out.println("------------");
        System.out.println("Cores     ND");
        System.out.println("------------");
	
        System.out.println("Vermelho " + emEspera[0].fila.size());
        System.out.println("Laranja " + emEspera[1].fila.size());
        System.out.println("Amarelo " + emEspera[2].fila.size());
        System.out.println("Verde " + emEspera[3].fila.size());
        System.out.println("Azul " + emEspera[4].fila.size());

        System.out.println("------------");

        System.out.println("Numero doentes atendidos: " + numDoentes);
    }
    

    // Mostrar estatisticas dos doentes atendidos (necessario para flag==1 e flag==2)
    private static void mostrarAtendidos() {
        System.out.println("---------------------------");
        System.out.println("Lista dos doentes atendidos");
        System.out.println("---------------------------");
        // itera sobre todos os doentes já¡ atendidos (instrução for-each)
        for (Doente d : atendidos) { 
            System.out.println(d.nome);
            // a completar ...
	    }
	    System.out.println("---------------------------");
    }

    // Mostrar estatisticos das equipas (necessario para flag==2)
    private static void mostrarEquipas() {
        System.out.println("-----------------------");
        System.out.println("Equipa NDoentes MediaTA");
        System.out.println("-----------------------");

        // a completar ...
    }

    // Qual a cor da proxima equipa a ficar livre?
    private static int proximaEquipaLivre() {
        // a completar ...
        return -1;
    }

    // Qual a cor mais prioritaria com doente ainda por ser atendido no tempo atual?
    private static int proximoDoente(int tempo) {
        // a completar ...
        return -1;
    }

    // Simular processo de atendimento pelas varias equipas medicas
        private static void simular() {
        // a completar ...
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