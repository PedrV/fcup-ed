package week4;

import java.util.Scanner;


/* 
.O...
.....
...O.
...O.
....O
 */

class DeadOrAlive {
    private final char DEAD = 'O';
    private final char ALIVE = '.';
    private int rows, cols, generations;
    private char[][] allCels;


    public DeadOrAlive(int rows, int cols, int generations){
        this.rows = rows;
        this.cols = cols;
        this.generations = generations;
        allCels = new char[rows][cols];
    }

    public void generateCells(Scanner scan){
        for(int i = 0; i < rows; i++){
            String s = scan.nextLine();
            for(int j = 0; j < cols; j++){
                allCels[i][j] = s.charAt(j);
            }
        }
    }

    public void printCells(){
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(allCels[i][j]);
            }
            System.out.println();
        }
    }

    public int countAlive(int i, int j){
        int count = 0;   

        /* verify if operation is out of bounds doing the (%),
        if it goes to a negative index, the (%) will be negative,
        if it goes beyond the index the modules   */

        // view the line above the point, each coord is
        /* (i - 1, j - 1), (i - 1, j), (i - 1, j + 1) */ 
        for(int k = -1; k < 2; k++){
            if((j+k) % cols > 0 && (i-1 % rows > 0)){  
                if(allCels[i-1][j+k] == 'O'){
                    count++;
                }
            }
        }

        // view the line below the point, each coord is
        /* (i + 1, j - 1), (i + 1, j), (i + 1, j + 1) */
        for(int k = -1; k < 2; k++){
            if((j+k) % cols > 0 && (i+1) % rows > 0){
                if(allCels[i+1][j+k] == 'O'){
                    count++;
                }
            }
        }

        // view the the left cord and the right cord
        /* (i, j - 1), (i, j + 1) */
        for(int k = -1; k < 2; k += 2){
            if((j+k) % cols > 0){
                if(allCels[i][j+k] == 'O'){
                    count++;
                }
            }
        }

        return count;
    }
}

public class ED088 {
    public static void main (String[] args) {
        Scanner scan = new Scanner(System.in);
        DeadOrAlive simulation1 = new DeadOrAlive(scan.nextInt(), scan.nextInt(), scan.nextInt());

        scan.nextLine(); // consume new line inserted after getting next int

        simulation1.generateCells(scan);
        simulation1.countAlive(4, 4);
    }
}