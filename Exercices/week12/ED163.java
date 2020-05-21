package week12;

import java.util.Scanner;
import java.util.Arrays;

class Team implements Comparable<Team> {
    private String name;
    private int victory;
    private int tie;
    private int defeat;
    private int scored;
    private int suffered;
    private Integer points;
    private Integer goal_avg;

    Team (String name, int victory, int tie, int defeat, int scored, int suffered) {
        this.name = name;
        this.victory = victory;
        this.defeat = defeat;
        this.scored = scored;
        this.suffered = suffered;

        points = 3 * victory + 1 * tie;
        goal_avg = scored - suffered;
    }

    public int compareTo (Team t) {
        int comp = -points.compareTo(t.points);
        int comp1 = -goal_avg.compareTo(t.goal_avg);

        if (comp == 0) {
            if (comp1 == 0) 
                return name.compareTo(t.name);
            else 
                return comp1;
        } else {
            return comp;
        }
    }

    public String toString () {
        return String.format("%s %d %d", name, points, goal_avg);
    }
}

public class ED163 {
    
    public static void main (String[] args) {
        Scanner scan = new Scanner (System.in);

        int table_size = scan.nextInt();
        scan.nextLine();
        Team[] teams = new Team[table_size];

        for (int i = 0; i < table_size; i++) {
            String[] s = scan.nextLine().split(" ");
            teams[i] = new Team(s[0], Integer.parseInt(s[1]), Integer.parseInt(s[2]), Integer.parseInt(s[3]), Integer.parseInt(s[4]), Integer.parseInt(s[5]));
        }

        scan.close();

        Arrays.sort(teams);
        System.out.println();

        for (int i = 0; i < table_size; i++)
            System.out.println(teams[i].toString());
    } 
}