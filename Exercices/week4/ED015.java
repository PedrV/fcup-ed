package week4;

import java.util.Scanner;

class Leters{
    private int rows, cols;
    private char[][] game;
    private int howManyWords;
    private String[] words;

    public Leters (int rows, int cols) {
        if (rows == 0 && cols == 0) {
            System.exit(0);
        }
        this.rows = rows;
        this.cols = cols;
        game = new char[rows][cols];
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
        Leters game1 = new Leters (scan.nextInt(), scan.nextInt());

        scan.nextLine(); // consume the new line left by nextInt

        game1.getBoard(scan);
        game1.passTheWords(scan);
        System.out.println(game1.getHowManyWords());
        game1.printWords();

    }
}