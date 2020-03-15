package week4;

import java.util.Scanner;

class Pairs {
    int steps;
    char direction;

    public Pairs () {this(0,'0');}

    public Pairs (int p1, char p2) {
        this.steps = p1;
        this.direction = p2;
    }

    public int getInt () {
        return steps;
    }

    public char getChar () {
        return direction;
    }
}


class Turtle {
    private int option;
    private int cols, rows;
    private char[][] data;
    private Pairs result;
    private boolean marker;
    private char current = 'E';
    private int i = 0, j = 0;

    public Turtle (int option) {
        this.option = option;
    }

    public void receiveOrder (Scanner scan) {
        String catchEnd = "42";
        scan.nextLine();
        while (!catchEnd.equals("end")) {
            catchEnd = scan.nextLine();
            decode(catchEnd);
            navigate(result.direction, result.steps);
        }
        whatOption();
    }

    private void whatOption () {
        if (option == 0) {
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    System.out.print(data[i][j]);
                }
                System.out.println();
            }
        }
    }

    private void navigate(char direction, int steps) {
        if (direction == 'D') {
            marker = true;
            data[i][j] = '*';
            return;
        } else if (direction == 'U') {
            marker = false;
            return;
        } else if (direction == 'F') {
            execute(current, steps);
            return;
        } else if (direction == '0') {
            return;
        }

        if (direction == 'L') {
            if (current == 'E') {
                current = 'N';
            } else if (current == 'N') {
                current = 'W';
            } else if (current == 'W') {
                current = 'S';
            } else if (current == 'S') {
                current = 'E';
            }
        } else if (direction == 'R') {
            if (current == 'E') {
                current = 'S';
            } else if (current == 'S') {
                current = 'W';
            } else if (current == 'W') {
                current = 'N';
            } else if (current == 'N') {
                current = 'E';
            }
        }
    }

    private void execute (char current, int steps) {
        if (current == 'E') {
            while (steps > 0) {
                if ( (j+1) <= cols ) {
                    j++;
                    if (marker) {
                        data[i][j] = '*';
                    }
                }
                steps--;
            }
        } else if (current == 'N') {
            while (steps > 0) {
                if ( (i-1) >= 0 ) {
                    i--;
                    if (marker) {
                        data[i][j] = '*';
                    }
                }
                steps--;
            }
        } else if (current == 'W') {
            while (steps > 0) {
                if ( (j-1) >= 0 ) {
                    j--;
                    if (marker) {
                        data[i][j] = '*';
                    }
                }
                steps--;
            }
        } else if (current == 'S') {
            while (steps > 0) {
                if ( (i+1) <= rows ) {
                    i++;
                    if (marker) {
                        data[i][j] = '*';
                    }
                }
                steps--;
            }
        }
    }

    public Pairs decode(String catchEnd) {
        char direction = catchEnd.charAt(0);

        if (catchEnd.length() == 3) {
            if (catchEnd.equals("end")) {
                result = new Pairs(0, '0');
            } else {
                int steps = catchEnd.charAt(2) - '0';
                result = new Pairs(steps,direction);
            }
        } else {
            result = new Pairs(0,direction);
        }
        return result;
    }

    public void getGrid () {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(data[i][j]);
            }
            System.out.println();
        }
    }
    public int getOption() {
        return option;
    }
    public void setGrid (Scanner scan) {
        rows = scan.nextInt();
        cols = scan.nextInt();

        data = new char[rows][cols];
        setData();
    }
    private void setData () {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                data[i][j] = '.';
            }
        }
    }
}


public class ED101 {
    public static void main (String[] args) {
        Scanner scan = new Scanner(System.in);

        Turtle turtle1 = new Turtle(scan.nextInt());

        scan.nextLine(); // consume the new line left by the nexInt

        turtle1.setGrid(scan);
        turtle1.receiveOrder(scan);
    }
}