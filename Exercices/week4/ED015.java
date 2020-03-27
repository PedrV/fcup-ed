package week4;

import java.util.Scanner;


/* 
SLCDA
OFGED
PJKLE
ARTEL */

class Leters{
    private int rows, cols;
    private char[][] game;
    private int howManyWords;
    private String[] words;
    private char[][] gameResult;
    private int inputs;

    public Leters (int rows, int cols, int inputs) {
        // 0 0 is the signal to stop the program
        if (rows == 0 && cols == 0) {
            System.exit(0);
        }

        this.rows = rows;
        this.cols = cols;
        this.inputs = inputs;
        game = new char[rows][cols];
        gameResult = new char[rows][cols];
        setResult();  
    }


    public void giveResults () {
        int index  = 0;
        for (int i = 0; i < howManyWords; i++) {
            startSearch(words[i],0,0,index);
        }
    }

    private void startSearch (String word, int i, int j, int index) {
        boolean up = false;
        boolean lr = false;

        for (i = 0; i < rows; i++) {
            for (j = 0; j < cols; j++) {
                if (game[i][j] == word.charAt(index)){
                    up = isUP(word, i, j, index+1);
                    lr = isLR(word, i, j, index+1);
                }
                if (up) {
                    writeUP(i, j, word);
                    return;
                } else if (lr) {
                    writeLR(i, j, word);
                    return;
                }
            }
        }
    }

    private void writeUP (int i, int j, String word) {
        int index = 0;
        gameResult[i][j] = word.charAt(index);
        index++;
        while(word.length() > index) {
            for(int k = -1; k < 2; k += 2) {
                if (((i+k) >= 0 && (i+k) < rows) && index < word.length()){
                    if (game[i+k][j] == word.charAt(index)){ // check above and bellow
                        i = i+k;
                        gameResult[i][j] = word.charAt(index);
                        index++;
                    }
                } 
            }
        }
    }
    
    private void writeLR (int i, int j, String word) {
        int index = 0;
        gameResult[i][j] = word.charAt(index);
        index++;

        while(word.length() > index) {
            for(int k = -1; k < 2; k += 2) {
                if (((j+k) >= 0 && (j+k) < cols) && index < word.length()){
                    if (game[i][j+k] == word.charAt(index)){ // check above and bellow
                        j = j+k;
                        gameResult[i][j] = word.charAt(index);
                        index++;
                    }
                } 
            }
        }
    }
    //TODO once the up or down side is encountered, the other should be blocked
    private boolean isUP (String word, int i, int j, int index) {
        int size = word.length();
        int index_copy = index;
        while ( size > 1) {
            for(int k = -1; k < 2; k += 2) {
                if (((i+k) >= 0 && (i+k) < rows) && index < word.length()){
                    if (game[i+k][j] == word.charAt(index)){ // check above and bellow
                        i = i+k;
                        index++;
                    }
                } 
            }
            index_copy++;
            if (index != index_copy) { // if the char hasn't occurred
                return false;
            }
            size--;
        }
        return true;
    }

     //TODO once the left or right side is encountered, the other should be blocked
    private boolean isLR (String word, int i, int j, int index) {
        int size = word.length();
        int index_copy = index;
        while ( size > 1) {
            for(int k = -1; k < 2; k += 2) {
                if ( ((j+k) >= 0 && (j+k) < cols) && index < word.length()) {
                    if (game[i][j+k] == word.charAt(index)){ // check left and right
                        j = j+k;
                        index++;
                    }
                }
            }
            index_copy++;
            if (index != index_copy) { // if the char hasn't occurred
                return false;
            }
            size--;
        }
        return true;
    }

    public void passTheWords (Scanner scan) {
        howManyWords = scan.nextInt();
        scan.nextLine(); // consume the new line left by nexInt
        words = new String[howManyWords];

        for (int i = 0; i < howManyWords; i++) {
            words[i] = scan.nextLine();
        }
    }

    public void printBoard(){
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(game[i][j]);
            }
            System.out.println();
        }
    }

    public void printResult() {
        System.out.println("Input #" + inputs);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(gameResult[i][j]);
            }
            System.out.println();
        }
    }

    public void printWords() {
        for (int i = 0; i < howManyWords; i++) {
            System.out.println(words[i]);
        }
    }

    private void setResult () {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                gameResult[i][j] = '.';
            }
        }
    }

    public void getBoard(Scanner scan) {
        for (int i = 0; i < rows; i++) {
            String s = scan.nextLine();
            for (int j = 0; j < cols; j++) {
                game[i][j] = s.charAt(j);
            }
        }
        System.out.println("Words to be found:");
    }

    public int getHowManyWords (){
        return howManyWords;
    }
}

public class ED015 {
    public static void main (String[] args){
        Scanner scan = new Scanner(System.in);
        int inputs = 1;
        //int value1 = -1, value2 = -1;

       //while (value1 != 0 && value2 != 0) {
            //value1 = scan.nextInt();
            //value2 = scan.nextInt();

            Leters game1 = new Leters (scan.nextInt(), scan.nextInt(), inputs);

            scan.nextLine(); // consume the new line left by nextInt

            game1.getBoard(scan);
            game1.passTheWords(scan);
            game1.giveResults();
            game1.printResult();
            //inputs++;
        //}

    }
}