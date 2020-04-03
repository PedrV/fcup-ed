package week7;


class ED194 {

    public static void reverse (MyStack<Integer> stack, int s) {
        int[] temp = new int[s];
        int j = 0;

        while (j < s) {
            temp[j] = stack.pop();
            j++;
        }

        for(int i = 0; i < s; i++) {
            stack.push(temp[i]);
        }
    }
}

class ED195 {

    // mesmo principio para ED007
    /* Usar uma pilha de caracteres (MyStack<Character>) para ir guardando os parenteses de abertura: '(' e '['.
     Cada vez que apanhar um parenteses de fecho, verifiquar se corresponde ao tipo do último parenteses aberto 
     (que está no topo da pilha) */

    public static boolean balanced (String s) {
        MyStack<Character> stack = new LinkedListStack<>();

        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);

            if (ch == '[' || ch == '(') {
                stack.push(ch);
            } else {
                if(!stack.isEmpty()) {

                    if (ch == ')') {

                        if (stack.top() == '(' ) {
                            stack.pop();
                        } else {
                            return false;
                        } 

                    } else {

                        if (stack.top() == '[' ) {
                            stack.pop();
                        } else {
                            return false;
                        } 
                    }

                } else {
                    return false;
                }
            }
        }

        if(stack.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }
}

public class ED194ED195 {
    public static void main (String[] args) {
       // MyStack<Integer> s = new StackLinkedList<>();
        


        System.out.println(ED195.balanced("(()]"));
        System.out.println(ED195.balanced("[()[]"));
        System.out.println(ED195.balanced("([])]"));

    }
}