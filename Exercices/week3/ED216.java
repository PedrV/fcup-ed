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
            String s = scan.nextLine();
            for(int j = 0; j < cols; j++){
                mat[i][j] = s.charAt(j);
            }
        }
    }

    public void longestSeg(){ 

        int longest = 0, longest_def = 0;
        int how_many = 0;

        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                try {
                    if( mat[i][j] == '#'){
                        longest++;
                    } else if (mat[i][j] == '.'){
                        if(longest_def < longest ){
                            longest_def = longest;
                            longest = 0;
                            how_many = 1;
                        } else if (longest == longest_def && (mat[i][j+1] == '#')){
                            how_many++;
                            longest = 0;
                        }
                    } 
                } catch (ArrayIndexOutOfBoundsException e) {
                    ;
                }
            }
            longest = 0;
        }
        System.out.print(how_many + " " + longest_def);
    }
}

public class ED216 {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        MatrixOrg matrix = new MatrixOrg(3,3);
        matrix.read(scan);
        matrix.longestSeg();
    }
}