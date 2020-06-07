package test.recursividadebig;

import java.util.ArrayList;
import java.util.Scanner;

class FloodFlill {
    private int rows;
    private int cols;
    private char[][] petri;
    private boolean[][] visited;

    FloodFlill (int cols, int rows, char[][] petri, boolean[][] visited) {
        this.rows = rows;
        this.cols = cols;
        this.petri = petri;
        this.visited = visited;
    }

    public int t (int i, int j) {

        if (i < 0 || i >= rows)
            return 0;

        if (j < 0 || j >= cols)
            return 0;

        if (petri[i][j] == '.')
            return 0;

        if (visited[i][j])
            return 0;

        visited[i][j] = true;
        int count = 1;
        
        // Flood fill em todas as 8 direçoes
        count += t(i+1, j);
        count += t(i, j+1);
        count += t(i-1, j);
        count += t(i, j-1);
        count += t(i+1, j+1);
        count += t(i+1, j-1);
        count += t(i-1, j+1);
        count += t(i-1, j-1);

        return count;
    }
}


public class ED200 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int cases = scan.nextInt();


        while (cases > 0) {

            int rows = scan.nextInt();
            int cols = scan.nextInt();
            scan.nextLine();

            char[][] petri = new char[rows][cols];
            boolean[][] visited = new boolean[rows][cols];
            
            // Ler placa de petri
            for (int i = 0; i < rows; i++) 
                petri[i] = scan.nextLine().toCharArray();
            

            FloodFlill f = new FloodFlill(cols, rows, petri, visited);

            ArrayList<Integer> micro = new ArrayList<>();   // Nao era necessario, mas eu quis guardar o tamanho de todos os microbios, podia-se fazer Math.max

            // Fazer flood fill em todas as células da placa de petri nao visitadas
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    if (!visited[i][j]) {
                        
                        int temp = f.t(i, j);   // Tamnho do microbio
                        if (temp > 0)
                            micro.add(temp);   
                    }
                }
            }
            
            cases--;

            // Ver maior microbio
            int max = 0;
            for (Integer cel : micro)
                if (cel > max)
                    max = cel;
            
            System.out.println(max);
        }

        scan.close();
    }
}