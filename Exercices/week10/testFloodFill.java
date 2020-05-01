package week10;

import java.util.Scanner;

public class testFloodFill {
    static int rows;            // Numero de linhas
    static int cols;            // Numero de colunas   
    static char m[][];          // Matriz de celulas
    static boolean visited[][]; // Saber se uma dada posicao ja foi visitada

    // Tamanho da mancha que inclui posicao (y,x)
    static int t(int y, int x) {

        if (y<0 || y>=rows || x<0 || x>=cols) // Caso base: fora dos limites
            return 0; 
            
        if (visited[y][x])    // Caso base: celula ja visitada
            return 0;  

        if (m[y][x] == '.')   // Caso base: celula vazia
            return 0; 

        int count = 2;        // celula nao vazia
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
   
   // -----------------------------------------------------------
   
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        // Leitura de uma matriz de caracteres
        rows = scan.nextInt();
        cols = scan.nextInt();
        m = new char[rows][cols];
        visited = new boolean[rows][cols];
        
        for (int i=0; i<rows; i++)
            m[i] = scan.next().toCharArray();

        // Teste do metodo t(y,x)
        System.out.printf("t(0,0) = %d\n", t(0,0));
        System.out.printf("t(2,5) = %d\n", t(2,5));
        System.out.printf("t(4,0) = %d\n", t(4,0));     
        
        scan.close();
    }

}