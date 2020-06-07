package test.adt_qsld;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Person {
    private String name;
    private int chegada;
    private int prods;
    private int saida;
    
    Person (String name, int chegada, int prods) {
        this.prods = prods;
        this.chegada = chegada;
        this.name = name;
        saida = 0;
    }

    /**
     * @param saida the saida to set
     */
    public void setSaida(int saida) {
        this.saida = saida;
    }
    
    /**
     * @return the saida
     */
    public int getSaida() {
        return saida;
    }

    /**
     * @return the chegada
     */
    public int getChegada() {
        return chegada;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @return the prods
     */
    public int getProds() {
        return prods;
    }
}

class Caixa {
    int tempo;
    int clients;
    int prods;
    Deque<Person> line;
    final int checkout = 10;

    Caixa (int tempo) {
        this.tempo = tempo;
        line = new LinkedList<>();
        clients = 0;
        prods = 0;
    }
}


class SuperMarket {
    private Caixa[] caixas;

    SuperMarket (Caixa[] caixas) {
        this.caixas = caixas;
    }

    private int nextCaixa (){
        if (caixas.length == 2)
            return 0;

        ArrayList<Integer> next = new ArrayList<>();
        next.add(0);

        for (int i = 1; i < caixas.length; i++) {
            if (caixas[i].line.size() < caixas[next.get(0)].line.size()) {
                next.clear();;
                next.add(i);
            } else if (caixas[i].line.size() == caixas[next.get(0)].line.size()) {
                next.add(i);
            }
        }

        ArrayList<Integer> new_next = new ArrayList<>();
        
        if (next.size() != 1) {
            new_next.add(next.get(0));
            for (int i = 1; i < next.size(); i++) {
                if (!caixas[next.get(i)].line.isEmpty() && !caixas[next.get(0)].line.isEmpty()) {

                    if (caixas[next.get(i)].line.getLast().getProds() < caixas[next.get(0)].line.getLast().getProds()) {
                        new_next.clear();
                        new_next.add(next.get(i));
                    } else if (caixas[next.get(i)].prods == caixas[next.get(0)].prods) {
                        new_next.add(next.get(i));
                    }
                }
            }
        }

        if (new_next.size() != 0) {
            return new_next.get(0);
        } else {
            return next.get(0);
        }
    }

    public void moreCaixas (Person[] persons) {
        int time = 0;

        for (int i = 0; i < persons.length; i++) {
            Person p = persons[i];
            
            int j = nextCaixa();
            p.setSaida(p.getChegada() + p.getProds()*caixas[j].tempo + caixas[j].checkout);

            caixas[j].prods += p.getProds();
            caixas[j].clients++;
            caixas[j].line.add(p);
            

            for (int k = 0; k < caixas.length; k++) {
                if (!caixas[k].line.isEmpty())
                    if(caixas[k].line.peek().getSaida() <= time)
                        caixas[k].line.poll();
            }

            if (i+1 < persons.length) 
                time = persons[i+1].getChegada(); 
            
        }
    }
}

public class ED115 {
    public static void main(String[] args) {
        Scanner scan = new Scanner (System.in);

        int flag = scan.nextInt();
        int caixas = scan.nextInt();
        Caixa[] caixasArr = new Caixa[caixas];

        for (int i = 0; i < caixas; i++) {
            int tempo = scan.nextInt();
            caixasArr[i] = new Caixa(tempo);
        }

        int npeople = scan.nextInt();
        scan.nextLine();

        Person[] persons = new Person[npeople];
        for (int i = 0; i < npeople; i++) {
            persons[i] = new Person(scan.next(), scan.nextInt(), scan.nextInt());
        }

        scan.close();

        SuperMarket s = new SuperMarket(caixasArr);
        
        s.moreCaixas(persons);


        if (flag == 1) {
            for (Person person : persons)
                System.out.println(person.getName() + " " + person.getChegada() + " " + person.getSaida());
        } else {
            for (int i = 0; i < caixas; i++) 
                System.out.println("Caixa #" + (i+1) + ":" + " " + caixasArr[i].clients + " " + caixasArr[i].prods);
        }
    }

}