package week12;

import java.util.LinkedList;
import java.util.Scanner;


public class ED165 {
    public static void main(String[] args) {
        LinkedList<Integer> num = new LinkedList<>();   // Store the first input set of numbers
        BSTree<Integer> tree = new BSTree<>();          // Tree to receive all possible sums of 2 numbers from the first input set         
        Scanner scan = new Scanner(System.in);

        int size_set = scan.nextInt();  // Get size of first int set 
        scan.nextLine();

        Scanner line = new Scanner(scan.nextLine());   

        // Read the numbers for the first int set
        for (int i = 0; i < size_set; i++) 
            num.addLast(Integer.parseInt(line.next()));
        

        // Insert all the possible combinations of sums from to integers in the first set, since we are insert them into a tree it doenst matter there is duplicate sums
        for (int i = 0; i < size_set; i++) {
            for (int j = i; j < size_set; j++) {
                tree.insert(num.get(i) + num.get(j));
            }
        }

        line.close();


        int size_numbers = scan.nextInt();  // Get size for the second set
        scan.nextLine();

        line = new Scanner(scan.nextLine());
        
        // Every sum will appear only once in the tree, no duplicates since is a Binary Search Tree, ence we just need to check if the element is in the tree
        for (int i = 0; i < size_numbers; i++) {
            String value = line.next();

            // Check if the binary tree contains the int in the second int set, if it contains then we can form it by adding to integers in the first set
            if (tree.contains(Integer.parseInt(value))) {
                System.out.println(value + ":" + " " + "sim" );
            } else {
                System.out.println(value + ":" + " " + "nao" );
            }
        }


        line.close();
        scan.close();

    }
}