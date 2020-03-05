package week3;

import java.util.Scanner;

class MatrixOrg {

    int rows;
    int cols;
    char[][] mat;

    public MatrixOrg (int rows, int cols){
        this.rows = rows;
        this.cols = cols;
        mat = new char[rows][cols];
    }

    public void read (Scanner scan){
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                mat[i][j] = scan.next().charAt(j);
            }
        }
    }

    public void longestSeg(){ 

        int[] window = {0, 0};
        int how_many = 0;
        int window_index = 0;

        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if( mat[i][j] == '#'){
                    window[window_index]++;
                } else if (mat[i][j] == '.'){
                    window_index++;
                    if(window[window_index-1] > window[window_index] ){
                        window[window_index-1] = window[window_index-1];
                        window[window_index] = 0;
                        how_many++;
                    } else {
                        window[window_index-1] = window[window_index];
                        window[window_index] = 0;
                        how_many = 0; 
                    }
                }
            }
        }
    }
}


public class ED216 {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        MatrixOrg matrix = new MatrixOrg(4, 8);
        matrix.read(scan);
        matrix.longestSeg();
    }
}