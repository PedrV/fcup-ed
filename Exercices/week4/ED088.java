package week4;

import java.util.Scanner;


/* 12 13 6
.............
.............
.............
.............
....OOOOO....
....OOOOO....
....OOOOO....
.............
.............
.............
.............
.............
 */

class DeadOrAlive {
    private final char DEAD = '.';
    private final char ALIVE = 'O';
    private int rows, cols, generations;
    private char[][] colony;


    public DeadOrAlive(int rows, int cols, int generations){
        this.rows = rows;
        this.cols = cols;
        this.generations = generations;
        colony = new char[rows][cols];
    }

    public void generateCells(Scanner scan){
        for(int i = 0; i < rows; i++){
            String s = scan.nextLine();
            for(int j = 0; j < cols; j++){
                colony[i][j] = s.charAt(j);
            }
        }
    }

    public void printCells(char[][] colony){
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(colony[i][j]);
            }
            System.out.println();
        }
    }

    public void printCells(){
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(colony[i][j]);
            }
            System.out.println();
        }
    }

    public int countAlive(int i, int j){
        int count = 0;   

        // view the line above the point, each coord is
        /* (i - 1, j - 1), (i - 1, j), (i - 1, j + 1) */ 
        for(int k = -1; k < 2; k++){
            if( ((j+k) >= 0 && (j+k) < cols) && ((i-1) > 0) ){  
                if(colony[i-1][j+k] == ALIVE){
                    count++;
                }
            }
        }

        // view the line below the point, each coord is
        /* (i + 1, j - 1), (i + 1, j), (i + 1, j + 1) */
        for(int k = -1; k < 2; k++){
            if( ((j+k) >= 0 && (j+k) < cols) && ((i+1) < rows) ){
                if(colony[i+1][j+k] == ALIVE){
                    count++;
                }
            }
        }

        // view the the left cord and the right cord
        /* (i, j - 1), (i, j + 1) */
        for(int k = -1; k < 2; k += 2){
            if( ((j+k) >= 0 && (j+k) < cols) ){
                if(colony[i][j+k] == ALIVE){
                    count++;
                }
            }
        }

        return count;
    }

    public void simulateGenerations (){
        char[][] newColony = new char[rows][cols];

        while (generations >= 0) {
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    int neighborhood = countAlive(i, j);
                    if (colony[i][j] == ALIVE) {
                        if (neighborhood <= 1){
                            newColony[i][j] = DEAD;
                        } else if (neighborhood >= 4){
                            newColony[i][j] = DEAD;
                        } else if (neighborhood >= 2 && neighborhood <=3){
                            newColony[i][j] = ALIVE;
                        }
                    } else if (colony[i][j] == DEAD){
                        if (neighborhood == 3) {
                            newColony[i][j] = ALIVE; 
                        } else {
                            newColony[i][j] = DEAD;
                        }
                    }
                }
            }
            printCells(newColony);
            System.out.println();
            colonyCopy(newColony, colony);
            generations--;
        }
    }

    private void colonyCopy(char[][] targetColony, char[][] nextColony){
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                nextColony[i][j] = targetColony[i][j];
            }
        }
    }
}


public class ED088 {
    public static void main (String[] args) {
        Scanner scan = new Scanner(System.in);
        DeadOrAlive simulation1 = new DeadOrAlive(scan.nextInt(), scan.nextInt(), scan.nextInt());

        scan.nextLine(); // consume new line inserted after getting next int

        simulation1.generateCells(scan);
        
        simulation1.simulateGenerations();
    }
}