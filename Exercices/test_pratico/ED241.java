package test_pratico;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class ED241 {
    public static void main(String[] args) {
        TreeSet<String> probs = new TreeSet<>();
        TreeMap<String, Integer> number_probs = new TreeMap<>();
        TreeMap<String, Integer> ratio = new TreeMap<>();
        TreeMap<String, TreeSet<String>> all = new TreeMap<>();
        Scanner scan = new Scanner(System.in);

        int flag = scan.nextInt();
        int n = scan.nextInt();
        scan.nextLine();

        if (flag == 1) {
            for (int i = 0; i < n; i++) {
                String[] temp = scan.nextLine().split(" ");
                probs.add(temp[1]);
            }

            System.out.println(probs.size());

        } else if (flag == 2 || flag == 3 || flag == 4) {
            for (int i = 0; i < n; i++) {
                String[] temp = scan.nextLine().split(" ");
                
                if (!number_probs.containsKey(temp[0])) {
                    number_probs.put(temp[0], 1);
                } else {
                    number_probs.replace(temp[0], number_probs.get(temp[0]) + 1);
                }

                if (temp[2].equals("Accepted")) {
                    if (!ratio.containsKey(temp[0])) {
                        ratio.put(temp[0], 1);
                    } else {
                        ratio.replace(temp[0], ratio.get(temp[0]) + 1);
                    }
                }

                if (temp[2].equals("Accepted")) {
                    if (!all.containsKey(temp[1])) {
                        TreeSet<String> t = new TreeSet<>();
                        t.add(temp[0]);
                        all.put(temp[1], t);
                    } else {
                        TreeSet<String> t = all.get(temp[1]);
                        t.add(temp[0]);
                        all.replace(temp[0], t);
                    }
                }

            }
        }


        if (flag == 2) {
            Set<String> keys = number_probs.keySet();
            int max = 0; 
            String name = "";
            for (String key : keys) {
                if (number_probs.get(key) > max) {
                    max = number_probs.get(key);
                    name = key;
                }
            }

            System.out.println(name + " " + max);

        } else if (flag == 3) {

            Set<String> keys = number_probs.keySet();
            double sub = 0; 
            double acc = 0;
            for (String key : keys) {

                if (number_probs.get(key) != null)
                    sub = number_probs.get(key);
                else
                    continue;

                if (ratio.get(key) != null)
                    acc = ratio.get(key);
                else
                    continue;

                if (acc / sub >= 0.5) {
                   System.out.println(key);
                }
            }

        } else if (flag == 4) {

            Set<String> keys = all.keySet();
            int alunos = ratio.size();

            for (String key : keys) {
                if (all.get(key).size() == alunos) {
                    System.out.println(key);
                }
            }
        }
    }
}