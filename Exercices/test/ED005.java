package test;

import java.util.Scanner;
import java.util.Stack;

class RPN {
    private Stack<Integer> s;
    private Scanner scan;

    RPN (Scanner scan) {
        s = new Stack<>();
        this.scan = scan;
    }

    public Integer doMath () {
        String line = scan.nextLine();
        Scanner l = new Scanner(line);

        while (l.hasNext()) {
            if (l.hasNextInt()) {
                s.add(l.nextInt());

            } else {

                if (s.size() < 2) {
                    s.clear();
                    return null;
                }
                
                int d1 = s.pop(), d2= s.pop();
                String op = l.next();

                if (op.equals("+")) 
                    s.add(d2+d1);
                else if (op.equals("-"))
                    s.add(d2-d1);
                else if (op.equals("*"))
                    s.add(d2*d1);
                else 
                    s.add(d2/d1);         
            }   
        }

        l.close();

        if (s.size() != 1) {
            s.clear();
            return null;
         } else 
            return s.pop();
    }
}


public class ED005 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();
        scan.nextLine();

        RPN calc = new RPN(scan);

        for (int i = 0; i < n; i++) {
            Integer result = calc.doMath();

            if (result == null)
                System.out.println("Expressao Incorrecta");
            else
                System.out.println(result);
        }


        scan.close();
    }
}