package test.adt_qsld;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Scanner;

class Show {
    public static void mostrarCores(int[] numDoentes) {
        int gap = 4; // remove and add String.format instead

        System.out.println("------------");
        System.out.println("Cores     ND");
        System.out.println("------------");

        System.out.printf("Vermelho" + "%" + gap + "s\n", numDoentes[0]);
        System.out.printf(" Laranja" + "%" + gap + "s\n", numDoentes[1]);
        System.out.printf(" Amarelo" + "%" + gap + "s\n", numDoentes[2]);
        System.out.printf("   Verde" + "%" + gap + "s\n", numDoentes[3]);
        System.out.printf("    Azul" + "%" + gap + "s\n", numDoentes[4]);

        System.out.println("------------");

        System.out.println("Numero doentes atendidos: " + Arrays.stream(numDoentes).sum());
    }


    // Mostrar estatisticas dos doentes atendidos (necessario para flag==1 e flag==2)
    public static void mostrarAtendidos(LinkedList<Doente> atendidos) {
        double stt_entrada = 0;

        System.out.println("---------------------------");
        System.out.println("Lista dos doentes atendidos");
        System.out.println("---------------------------");
        // itera sobre todos os doentes já atendidos (instrução for-each)
        for (Doente d : atendidos) { 
            System.out.println(d.nome + " " + d.tempo_chegada + " " + d.tempo_espera + " " + (d.tempo_espera+d.consulta));
            stt_entrada += d.tempo_espera;
        }
        System.out.println("---------------------------");
        System.out.println("Tempo medio de espera: " + String.format("%.1f", stt_entrada/atendidos.size()));
    }

    // Mostrar estatisticos das equipas (necessario para flag==2)
    public static void mostrarEquipas(Equipa[] equipas) {
        System.out.println("-----------------------");
        System.out.println("Equipa NDoentes MediaTA");
        System.out.println("-----------------------");
        for (int i = 0; i < equipas.length; i++) {
            System.out.printf (String.format("%6d %8d %7.1f\n", i, equipas[i].numDoentes, (double) equipas[i].totalAtendimento/equipas[i].numDoentes));
        }
        
    }
}

class Atender {
    private PriorityQueue<Doente> fila;

    Atender (PriorityQueue<Doente> fila) {
        this.fila = fila;
    }

    public int oneEquipa (LinkedList<Doente> atendidos) {
        int time = 0;

        while (fila.size() > 0) {
            Doente d = fila.poll();
            d.tempo_espera = time-d.tempo_chegada;
            time += d.consulta;
            atendidos.addLast(d);
        }

        return time;
    }

    public void moreEquipa (LinkedList<Doente> atendidos, Equipa[] teams) {
        int time = 0;
        boolean livre = false;

        while (fila.size() > 0) {
            Doente d = fila.poll();
            
            for (int i = 0; i < teams.length; i++) {
                if (teams[i].livre <= time) {
                    teams[i].livre += d.consulta;
                    teams[i].numDoentes++;
                    teams[i].totalAtendimento += d.consulta;
                    livre = true;
                    break;
                }
            }

            if (!livre) {
                time = proxLivre(teams);
            } 

            atendidos.addLast(d);
        }
    }

    private int proxLivre (Equipa[] teams) {
        int next = 0; 
        for (int i = 0; i < teams.length-1; i++) {
            if (teams[i].livre < teams[i+1].livre)
                next = teams[i].livre;
            else
                next = teams[i+1].livre;
        }

        return next;
    }
}

class Doente {
    String nome;
    int tempo_chegada;
    int consulta;
    int prioridade;
    int tempo_espera;

    Doente (String nome, int tempo_chegada, int consulta, int prioridade) {
        this.nome = nome;
        this.tempo_chegada = tempo_chegada;
        this.consulta = consulta;
        this.prioridade = prioridade;
        this.tempo_espera = 0;
    }

    /**
     * @param prioridade the prioridade to set
     */
    public void setPrioridade(int prioridade) {
        this.prioridade = prioridade;
    }
}

class Equipa {
    int numDoentes;       // Numero de doentes que atenderam
    int totalAtendimento; // Total de tempo passado a atender
    int livre;            // Tempo em que ficam livres para poder atender novo doente

    Equipa() {
        numDoentes       = 0;
        totalAtendimento = 0;
        livre            = 0;
    }
}

class compararDoentes implements Comparator<Doente> {

    public int compare(Doente d1, Doente d2) {
        if (d1.prioridade-d2.prioridade == 0) {
            return d1.tempo_chegada-d2.tempo_chegada;
        }
        return d1.prioridade-d2.prioridade;
    }
}


public class ED098 {
    public static void main(String[] args) {
        final String[] CORES = {"Vermelho","Laranja","Amarelo","Verde","Azul"};
        int[] numDoentes = new int[5];

        Scanner scan = new Scanner (System.in);
        PriorityQueue<Doente> line = new PriorityQueue<>(new compararDoentes());
        LinkedList<Doente> atendidos = new LinkedList<>();

        int flag = scan.nextInt();
        int numEquipas = scan.nextInt();
        scan.nextLine();

        int n = 3;
        while (n > 0) {
            String[] dl = scan.nextLine().split(" ");
            Doente d = new Doente(dl[0], Integer.parseInt(dl[2]), Integer.parseInt(dl[3]), -1);

            for (int i = 0; i < 5; i++) {
                if (dl[1].equals(CORES[i])) {
                    d.setPrioridade(i);
                    numDoentes[i]++;
                    break;
                }
            }

            line.add(d);
            n--;
        }

        scan.close();
        Atender at = new Atender(line);

        if (flag == 0) {
            Show.mostrarCores(numDoentes);
        } else if (flag == 1) {
            at.oneEquipa(atendidos);
            Show.mostrarAtendidos(atendidos);
        } else {
            Equipa[] teams = new Equipa[numEquipas];
            for (int i = 0; i < teams.length; i++) {
                teams[i] = new Equipa();
            }

            at.moreEquipa(atendidos, teams);
            Show.mostrarEquipas(teams);
            Show.mostrarAtendidos(atendidos);
        }
        
    }
}