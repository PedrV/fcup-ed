package test;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class ED234 {
    public static void main(final String[] args) {
        final TreeMap<String, Pair<Integer, Integer>> movies = new TreeMap<>();
        final TreeSet<String> movies_titles = new TreeSet<>();

        final Scanner scan = new Scanner(System.in);

        final int flag = scan.nextInt();
        final int n = scan.nextInt();
        scan.nextLine();

        if (flag == 1) {
            for (int i = 0; i < n; i++) {
                final String[] temp = scan.nextLine().split(" ");
                movies_titles.add(temp[0]);
            }

            System.out.println(movies_titles.size());

        } else if (flag == 2 || flag == 3) {
            for (int i = 0; i < n; i++) {

                final String[] temp = scan.nextLine().split(" ");

                if (movies.containsKey(temp[0])) {

                    final Pair<Integer, Integer> t = movies.get(temp[0]);
                    t.setXvalue(t.getXvalue() + 1);
                    t.setYvalue(t.getYvalue() + Integer.parseInt(temp[1]));
                    movies.replace(temp[0], t);

                } else {

                    final Pair<Integer, Integer> t = new Pair<>(1, Integer.parseInt(temp[1]));
                    movies.put(temp[0], t);
                }
            }
        }

        if (flag == 2) {
            String movie = "";
            int rate = 0;

            final Set<String> keys = movies.keySet();

            for (final String key : keys) {
                if (movies.get(key).getXvalue() > rate) {
                    rate = movies.get(key).getXvalue();
                    movie = key;
                }
            }

            System.out.println(movie + " " + rate);

        } else if (flag == 3) {
            final Set<String> keys = movies.keySet();

            for (final String key : keys) {
                final double total_reviews = movies.get(key).getXvalue();
                final double total_rating = movies.get(key).getYvalue();

                if (total_rating / total_reviews >= 5.0) {
                    System.out.println(key);
                }
            }
        }
        
        scan.close();
    } 
}