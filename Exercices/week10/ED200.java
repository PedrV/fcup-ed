package week10;

import java.util.Scanner;

class FloodFill {
    private int rows;            // Numero de linhas
    private int cols;            // Numero de colunas   
    private char m[][];          // Matriz de celulas
    private boolean visited[][]; // Saber se uma dada posicao ja foi visitada

    FloodFill (int rows, int cols, char[][] m, boolean[][] visited) {
        this.rows = rows;
        this.cols = cols;
        this.m = m;
        this.visited = visited; 
    }

    // Tamanho da mancha que inclui posicao (y,x)
    public int t(int y, int x) {

        if (y<0 || y>=rows || x<0 || x>=cols) // Caso base: fora dos limites
            return 0; 
            
        if (visited[y][x])    // Caso base: celula ja visitada
            return 0;  

        if (m[y][x] == '.')   // Caso base: celula vazia
            return 0; 

        int count = 1;        // celula nao vazia
        visited[y][x] = true; // marcar como visitada
    
        // Adicionando celulas nao vizinhas
        count += t(y-1, x);   
        count += t(y+1, x);
        count += t(y, x+1);
        count += t(y, x-1);
        count += t(y-1, x-1);
        count += t(y-1, x+1);
        count += t(y+1, x+1);
        count += t(y+1, x-1);

        return count;
    }
}
   
public class ED200 {
    public static void main(String[]args) {

        int rows;            // Numero de linhas
        int cols;            // Numero de colunas   
        char m[][];          // Matriz de celulas
        boolean visited[][]; // Saber se uma dada posicao ja foi visitada
        int inputs;          // Numero de inputs que programa vai ler
        Scanner scan = new Scanner(System.in);

        // Ler numero de inputs
        inputs = scan.nextInt();


        for(int i = 0; i < inputs; i++) {

            // Leitura de uma matriz de caracteres
            scan.nextLine();
            rows = scan.nextInt();
            cols = scan.nextInt();
            m = new char[rows][cols];
            visited = new boolean[rows][cols];
            
            for (int j=0; j<rows; j++) 
                m[j] = scan.next().toCharArray();
            

            // Instanciar class para contar microbios    
            FloodFill start = new FloodFill(rows, cols, m, visited);
            
            // Verificar cada célula da matriz exceto se esta ja tiver sido contada ou nao contenha nada
            int max_so_far = 0;
            for(int k = 0; k < rows; k++) 
                for (int k1 = 0; k1 < cols; k1++) 
                    if (!visited[k][k1] || m[k][k1] == '.')
                        max_so_far = Math.max(max_so_far, start.t(k, k1));
            

            // Reinicializar a matriz
            for (int j1 = 0; j1 < rows; j1++) 
                for (int j2 = 0; j2 < cols; j2++) 
                    visited[j1][j2] = false;
        
            System.out.println(max_so_far);
        }
        
        scan.close();
    } 
}