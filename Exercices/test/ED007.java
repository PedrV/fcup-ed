package test;

import java.util.Scanner;
import java.util.Stack;

public class ED007 {

    static void expre (Stack<Character> s, String line) {

        for (int i = 0; i < line.length(); i++) {
            if (line.charAt(i) == '(')
                s.add('(');
            else if (line.charAt(i) == '[')
                s.add('[');
            else if (line.charAt(i) == ')') {
                if (s.isEmpty()) {
                    System.out.println("Erro na posicao " + i);
                    return;
                    
                } else if (s.peek() != '(') {
                    System.out.println("Erro na posicao " + i);
                    return;

                } else 
                    s.pop();

            } else if (line.charAt(i) == ']') {
                if (s.isEmpty()) {
                    System.out.println("Erro na posicao " + i);
                    return;

                } else if (s.peek() != '[') {
                    System.out.println("Erro na posicao " + i);
                    return;

                } else 
                    s.pop();
            }
            
        }

        if (s.isEmpty())
            System.out.println("Expressao bem formada");
        else 
            System.out.println("Ficam parenteses por fechar");

    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Stack<Character> s = new Stack<>();

        int n = scan.nextInt();
        scan.nextLine();

        while (n > 0) {
            String line = scan.nextLine();
        
            expre(s, line);

            s.clear();
            n--;
        }

        scan.close();
    }
}