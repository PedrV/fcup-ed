package week13;

import java.util.Comparator;
import java.util.Scanner;

class comparator implements Comparator<String> {
    // Comparador para compradores que sao comparados pela maior oferta
    public int compare(String o1, String o2) {
        String[] temp1 = o1.split(" ");     // Dividir o input temporiamente no " " e 1º campo vai ter oferta e sengundo nome
        String[] temp2 = o2.split(" ");     // Dividir o input temporiamente no " " e 1º campo vai ter oferta e sengundo nome
        return -(Integer.parseInt(temp1[0]) - Integer.parseInt(temp2[0])); // Fazendo a diferença entre os 2, temos um numero negativo se o 1º oferta for maior, logo negando esse numero obtemos a comparaçao >0, para maior
    }
    
}

public class ED215 {
    public static void main (String[] args) {
        Scanner scan = new Scanner(System.in);
        MinHeap<String> offers = new MinHeap<>(10_000_000, new comparator());  // Suporta 10M de compradores simultaneos

        int objects_sale = scan.nextInt();      // Contidade de ocorrencias
        scan.nextLine();

        for (int i = 0; i < objects_sale; i++) {
            Scanner line = new Scanner(scan.nextLine());  

            if (line.next().equals("OFERTA")) { // Se linha de input for uma oferta
                String name = line.next();      // Sabemos pelas restriçoes dadas que vai ter mais 2 campos separados por " ": Nome 
                String offer = line.next();     // e Oferta

                offers.insert(offer + " " + name); // O output é da forma oferta mais nome, por isso invertemos a ordem
            } else {
                System.out.println(offers.removeMin());
            }

        }

        scan.close();
    }
}