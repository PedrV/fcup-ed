package week7;

import java.util.Scanner;

class Expression {
    public void evaluate (Scanner scan) {

        boolean flag = true;
        int cnt = 0;
        MyStack<String> string_stack = new LinkedListStack<>();

        int how_many_exp = scan.nextInt();
        scan.nextLine();

        while(how_many_exp > 0) {


            Scanner line = new Scanner(scan.nextLine());


            while (line.hasNext()) {
                String c = line.next();

                if ( c.equals("(") || c.equals("[") ) {
                    string_stack.push(c);

                } else if ( c.equals(")") ) {

                    if (string_stack.isEmpty()) {
                        System.out.println("Erro na posicao" +  " " + cnt);
                        clearStack(string_stack);
                        flag = false;
                        break;
                    }

                    if ( !string_stack.top().equals("(") ) {
                        System.out.println("Erro na posicao" +  " " + cnt);
                        clearStack(string_stack);
                        flag = false; 
                        break;
                    } else {
                        string_stack.pop ();
                    }

                } else if ( c.equals("]") ) {

                    if (string_stack.isEmpty()) {
                        System.out.println("Erro na posicao" +  " " + cnt);
                        clearStack(string_stack);
                        flag = false;
                        break;
                    }

                    if ( !string_stack.top().equals("[") ) {
                        System.out.println("Erro na posicao" +  " " + cnt);
                        clearStack(string_stack);
                        flag = false; 
                        break;
                    } else {
                        string_stack.pop ();
                    }
                }
                cnt += 2;
            }

            if (!string_stack.isEmpty() && flag) {
                System.out.println("Ficam parenteses por fechar");
            } else if (flag) {
                System.out.println("Expressao bem formada");
            }
            
            flag = true; 
            cnt = 0;

            how_many_exp--;
            clearStack(string_stack);
        }

    }

    private void clearStack (MyStack<String> string_stack) {
        while (!string_stack.isEmpty()) {
            string_stack.pop();
        }
    }
}


public class ED007 {
    public static void main (String[] args) {
        Scanner scan = new Scanner(System.in);
        Expression exp1 = new Expression();

        exp1.evaluate(scan);

    }
}