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

    public void finder(String word) {
        int size = word.length();
        int index = 0;

        
    }

    public boolean checkSurroundings (int i, int j, String word, int index) {
        for(int k = -1; k < 2; k += 2) {
            if ((i+k) % rows > 0 && (j+k) % cols > 0){
                if (game[i+k][j] == word.charAt(index)){ // check above and bellow
                    return true;
                } else if (game[i][j+k] == word.charAt(index)){ // check left and right
                    return true;
                }
            }
        }
        return false;
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

        int value1 = -1, value2 = -1;

        while (value1 != 0 && value2 != 0) {
            value1 = scan.nextInt();
            value2 = scan.nextInt();

            Leters game1 = new Leters (value1, value2);

            scan.nextLine(); // consume the new line left by nextInt

            game1.getBoard(scan);
            game1.printBoard();

            game1.passTheWords(scan);
            System.out.println(game1.getHowManyWords());
            game1.printWords();
        }

    }
}