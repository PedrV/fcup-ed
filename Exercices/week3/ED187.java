package week3;

import java.util.Scanner;

class Matrix {
   int data[][]; // os elementos da matriz em si
   int rows;     // numero de linhas
   int cols;     // numero de colunas

   // construtor padrao de matriz
   Matrix(int r, int c) {
      data = new int[r][c];
      rows = r;
      cols = c;
   }

   // Ler os rows x cols elementos da matriz
   public void read(Scanner in) {
      for (int i=0; i<rows; i++)
         for (int j=0; j<cols; j++)
            data[i][j] = in.nextInt();
   }

    public Matrix transpose(){
        Matrix transposeM = new Matrix(cols, rows);
        for (int i = 0; i < cols; i++){
            for (int j = 0; j < rows; j++){
               transposeM.data[i][j] =  data[j][i];
            }
        }
        return (transposeM);
   }

    public static Matrix identity(int n){
        Matrix iden = new Matrix (n, n);

        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                if( i == j) {
                    iden.data[i][j] = 1;
                } else {
                    iden.data[i][j] = 0;
                }
            }
       }
       return iden;
   } 

    public Matrix sum (Matrix mS){
        Matrix sumM = new Matrix(rows, cols);
        for (int i = 0; i < rows; i++){
            for (int j = 0; j < cols; j++){
                sumM.data[i][j] = data[i][j] + mS.data[i][j];
            }
        }
        return sumM;
    }

    public Matrix multiply (Matrix mM){
        Matrix multiplyM = new Matrix(rows, mM.cols);
        int sum = 0, ii = 0, jj = 0;

        for (int i = 0; i < rows; i++){
            for (int j2 = 0; j2 < mM.cols; j2++){
                for (int i2 = 0, j = 0; i2 < cols; i2++, j++){
                    sum += data[i][j] * mM.data[i2][j2];
                }
                            
                if(jj < multiplyM.cols){
                    multiplyM.data[ii][jj] = sum;
                    jj++;
                } else {
                    jj = 0;
                    ii++;
                    multiplyM.data[ii][jj] = sum;
                    jj++;
                }
                sum = 0;
            }
        }


        return multiplyM;
    }

   // Representacao em String da matrix
   public String toString() {
      String ans = "";
      for (int i=0; i<rows; i++) {
         for (int j=0; j<cols; j++)
            ans += data[i][j] + " ";
         ans += "\n";
      }
      return ans;
   }
   
}

public class ED187 {
    public static void main(String[] args) {
        Scanner stdin = new Scanner(System.in);

        Matrix m2 = new Matrix(stdin.nextInt(), stdin.nextInt());
        m2.read(stdin);
        Matrix m3 = new Matrix(stdin.nextInt(), stdin.nextInt());
        m3.read(stdin);


        Matrix m4 = m2.multiply(m3);
        System.out.println(m4);

   }    
}