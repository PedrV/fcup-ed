package week4;

import java.util.Scanner;

class Galo {
    private int dimensions;
    private char[][] board;
    private boolean dot = false, win = false;

    public Galo (int dimensions){
        this.dimensions = dimensions;
        board = new char[dimensions][dimensions];
    }

    public void getBoard(Scanner scan){
        for(int i = 0; i < dimensions; i++){
            String s = scan.nextLine();
            for(int j = 0; j < dimensions; j++){
                board[i][j] = s.charAt(j);
            }
        }
    }

    public void printBoard(){
        for(int i = 0; i < dimensions; i++){
            for(int j = 0; j < dimensions; j++){
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }

    public void checkWinner(){
        for(int k = 0; k < dimensions; k++){
            if (verify(k, 0, 0, 1, 0, 1)){   // check rows
                declareWinner(board[k][0]);
                return;
            } else if (verify(0, 1, k, 0, 0, 1)){   // check cols
                declareWinner(board[0][k]);
                return;
            }
        }

        if (verify(0, 1, 0, 1, 0, 1)){ // check diagonal
            declareWinner(board[0][0]);
            return;
        } else if(verify(0, 1, dimensions-1, -1, 0, 1)){ // check next diagonal
            declareWinner(board[0][dimensions-1]);
            return;
        }

        if(dot && !win){
            declareWinner('N');
            return;
        } else {
            declareWinner('T');
            return;
        }
    }

    private boolean verify(int i, int incri, int j, int incrj, int start, int incrstart){
        for(; start < dimensions; j+=incrj, i += incri, start+=incrstart){
            if(board[i][j] == '.'){
                dot = true;
                return false;
            }
            try { // TODO replace this try catch works perfectly but looks bad
                if(board[i][j] != board[i+incri][j+incrj]) {
                    return false;
                }
            } catch (Exception ArrayIndexOutOfBoundsException) {
                if(board[i][j] != board[i-incri][j-incrj]) {
                    return false;
                }
            }
        }
        win = true;
        return true;
    }

    public void declareWinner(char winner){
        if (winner == 'T'){
            System.out.println("Empate");
        } else if (winner == 'X' || winner == 'O') {
            System.out.println("Ganhou o " + winner);
        } else {
            System.out.println("Jogo incompleto");
        }
    }

    public static void printBoard(int dimensions, char madeOf){
        for(int i = 0; i < dimensions; i++){
            for(int j = 0; j < dimensions; j++){
                System.out.print(madeOf);
            }
            System.out.println();
        }
    }

}

public class ED004 {

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        Galo game1 = new Galo(scan.nextInt());

        scan.nextLine(); // consume line left by the enter in nextInt

        game1.getBoard(scan);
        game1.checkWinner();
    }
}