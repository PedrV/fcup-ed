package test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

public class ED172 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        TreeMap<String,Integer> map  = new TreeMap<>();
        ArrayList<Integer> a = new ArrayList<>();

        while (scan.hasNextLine()) {

/*             String[] line = scan.nextLine().split(" ");
            for (int i = 0; i < line.length; i++) {

                if (map.containsKey(line[i])) 
                    map.replace(line[i], map.get(line[i]) + 1);
                else
                    map.put(line[i], 1);
            } */


/*             Scanner line1 = new Scanner(scan.nextLine());
            while (line1.hasNext()) {
                String s = line1.next();

                if (map.containsKey(s)) 
                    map.replace(s, map.get(s)+1);
                else
                    map.put(s, 1);
            } */
        }

        Set<String> keys = map.keySet();

/*         Iterator<String> it = keys.iterator();
        while (it.hasNext()) {
            String key = it.next();

            if (key.equals("ao") || key.equals("o"))
                it.remove();
            else
                System.out.println(key + ": " + map.get(key));
        }
 */
        for (String key : keys) {
            System.out.println(key + ": " + map.get(key));
        }


    }
}