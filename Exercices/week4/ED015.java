package week4;

import java.util.Scanner;

class Leters{
    private int rows, cols;
    private char[][] game;
    private int howManyWords;
    private String[] words;

    public Leters (int rows, int cols) {
        // 0 0 is the signal to stop the program
        if (rows == 0 && cols == 0) {
            System.exit(0);
        }

        this.rows = rows;
        this.cols = cols;
        game = new char[rows][cols];
    }

    public void startSearch (String word) {
        int i = 0, j = 0;
        int index = 0;

        outerloop:
        for (; i < rows; i++) {
            for (; j < cols; j++) {
                if ((word.charAt(index) == game[i][j])){
                    index++;
                    break outerloop;
                }       
            }
        }
        finder(word, index, i, j);
    }

    private void finder(String word,int index, int i, int j) {
        int size = word.length();

        for(; i < rows; i++){
            for(; j < cols; j++) {
                int neighborhood = checkSurroundings(i, j, word, index);
                if (neighborhood == 9 || neighborhood == 11) { // the result is up or down
                    index++;
                    finder(word,index, neighborhood-10, j);
                } else if (neighborhood == 19 || neighborhood == 21) { // the result is left or right
                    index++;
                    finder(word,index, i, neighborhood-20);
                }
            }
        }
    }

    private int checkSurroundings (int i, int j, String word, int index) {
        for(int k = -1; k < 2; k += 2) {
            if ((i+k) % (rows+1) > 0){
                if (game[i+k][j] == word.charAt(index)){ // check above and bellow
                    return k+10;
                }
            } 
            if ((j+k) % (cols+1) >= 0) {
                if (game[i][j+k] == word.charAt(index)){ // check left and right
                    return k+20;
                }
            }
        }
        return 0;
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

    public void printWords() {
        for (int i = 0; i < howManyWords; i++) {
            System.out.println(words[i]);
        }
    }

    public void getBoard(Scanner scan) {
        for (int i = 0; i < rows; i++) {
            String s = scan.nextLine();
            for (int j = 0; j < cols; j++) {
                game[i][j] = s.charAt(j);
            }
        }
    }

    public int getHowManyWords (){
        return howManyWords;
    }
}

public class ED015 {
    public static void main (String[] args){
        Scanner scan = new Scanner(System.in);

        //int value1 = -1, value2 = -1;

       //while (value1 != 0 && value2 != 0) {
            //value1 = scan.nextInt();
            //value2 = scan.nextInt();

            Leters game1 = new Leters (scan.nextInt(), scan.nextInt());

            scan.nextLine(); // consume the new line left by nextInt

            game1.getBoard(scan);
            game1.passTheWords(scan);
            game1.startSearch("DHL");
        //}

    }
}