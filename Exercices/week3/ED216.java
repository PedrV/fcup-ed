package week3;

import java.util.Scanner;


class GetValues{
    private int howManyOfThem;
    private int theLongest;

    public GetValues(){ this(0,0); }  // if no args are passed, construct with (0,0)

    public GetValues(int howManyOfThem, int theLongest){
        this.howManyOfThem = howManyOfThem;
        this.theLongest = theLongest;
    }

    public int getHowManyOfThem(){
        return howManyOfThem;
    }

    public int getTheLongest(){
        return theLongest;
    }
}

class MatrixOrg {

    private int rows;
    private int cols;
    private char[][] mat;

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

    public GetValues longestSegRows(){ 

        int longest = 0, longest_def = 0;
        int how_many = 0;

        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){

                if( mat[i][j] == '#'){
                    longest++;
                } else if (mat[i][j] == '.'){
                    if(longest_def < longest ){
                        longest_def = longest;
                        longest = 0;
                        how_many = 1;
                    } else if (longest == longest_def){
                        how_many++;
                        longest = 0;
                    } else {
                        longest = 0;
                    }
                }

                if(j == cols-1){
                    if(longest_def < longest ){
                        longest_def = longest;
                        longest = 0;
                        how_many = 1;
                    } else if (longest == longest_def){
                        how_many++;
                        longest = 0;
                    } else {
                        longest = 0;
                    }
                } 
            }  
        }
        
        GetValues rowsVal = new GetValues(how_many, longest_def);
        return rowsVal;
    }

    public GetValues longestSegCols(){ 

        int longest = 0, longest_def = 0;
        int how_many = 0;

        for(int j = 0; j < cols; j++){
            for(int i = 0; i < rows; i++){

                if( mat[i][j] == '#'){
                    longest++;
                } else if (mat[i][j] == '.'){
                    if(longest_def < longest ){
                        longest_def = longest;
                        longest = 0;
                        how_many = 1;
                    } else if (longest == longest_def){
                        how_many++;
                        longest = 0;
                    } else {
                        longest = 0;
                    }
                }

                if(i == rows-1){
                    if(longest_def < longest ){
                        longest_def = longest;
                        longest = 0;
                        how_many = 1;
                    } else if (longest == longest_def){
                        how_many++;
                        longest = 0;
                    } else {
                        longest = 0;
                    }
                    
                }
            } 
        }

        GetValues colsVal = new GetValues(how_many, longest_def);
        return colsVal;
    }

    public void longestSeg(){
        GetValues colsVals = longestSegCols();
        GetValues rowsVals =  longestSegRows();

        if(colsVals.getTheLongest() > rowsVals.getTheLongest()){
            System.out.print(colsVals.getTheLongest() + " " + colsVals.getHowManyOfThem());
        } else if (colsVals.getTheLongest() < rowsVals.getTheLongest()){
            System.out.print(rowsVals.getTheLongest() + " " + rowsVals.getHowManyOfThem());
        } else {
            System.out.print(rowsVals.getTheLongest() + " " + (rowsVals.getHowManyOfThem()+colsVals.getHowManyOfThem()));
        }
    }
}

public class ED216 {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        MatrixOrg matrix = new MatrixOrg(4,8);
        matrix.read(scan);
        matrix.longestSeg();
    }
}