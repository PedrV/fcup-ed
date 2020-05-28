package week13;

import java.util.LinkedList;
import java.util.Scanner;

public class ED172 {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        BSTMap<String,Integer> dic = new BSTMap<>();

        while (in.hasNextLine()) {
            String line = in.nextLine();

            String[] words = line.split(",");

            Integer count = dic.get(words[3]);

            if (count != null)
                dic.put(words[3], count+1);
            else 
                dic.put(words[3], 1);
            

/*   OU           Scanner scan = new Scanner(line);

            while (scan.hasNext()) {
                String word = scan.next();
                Integer count = dic.get(word);

                if (count != null)
                    dic.put(word, count+1);
                else 
                    dic.put(word, 1);

            }

            scan.close(); */

        }

        LinkedList<String> keys = new LinkedList<>();
        keys = dic.keys();

        for (String key : keys) 
            System.out.println(key + ": " + dic.get(key));
        
    
        in.close();

    }
}