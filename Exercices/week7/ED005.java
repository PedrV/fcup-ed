package week7;

import java.util.Scanner;

class RPN {

    public void evaluate (Scanner scan) {
        MyStack<Integer> stackNum = new LinkedListStack<>();

        int number_of_expr = scan.nextInt();
        boolean flag = true;
        scan.nextLine(); // consume nextline left by "enter"

        while (number_of_expr > 0) {
            Scanner expr = new Scanner (scan.nextLine());

            while(expr.hasNext()) {
                String aux = expr.next();

                if (!aux.equals("*") && !aux.equals("+") && !aux.equals("/") && !aux.equals("-")) { // notchecking would result in NumberFormat Exception
                    stackNum.push(Integer.parseInt(aux));
                } else {
                    if (doDaMath(aux, stackNum) == null) {
                        System.out.println("Expressao Incorrecta");
                        flag = false;
                        break;
                    }
                }

            }

            number_of_expr--;        
            if (stackNum.size() != 1) {
                System.out.println("Expressao Incorrecta");
            } else if (flag) {
                System.out.println(stackNum.pop()); 
            }
            flag = true;
            clearStack(stackNum);
         }
    }

    private Integer doDaMath (String aux, MyStack<Integer> stack) {
        int result = 0;

        if (stack.isEmpty() || (stack.size() == 1 && aux.length() != 0)) {
            return null;
        } else if (stack.size() == 1 && aux.length() == 0) {
            return stack.top();
        }

        if (aux.equals("+")) {

            result = stack.pop() + stack.pop();
            
        } else if (aux.equals("-")) {

            int temp = stack.pop();
            result = stack.pop() - temp;

        } else if (aux.equals("*")) {

            result = stack.pop() * stack.pop();

        } else {

            int temp = stack.pop();
            result = stack.pop() / temp;

        }

        stack.push(result);
        return result;
    }

    private void clearStack (MyStack<Integer> s) {
        while(!s.isEmpty()) {
            s.pop();
        }
    }

} 


public class ED005 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        RPN x = new RPN();

        x.evaluate(scan);
    }   
}