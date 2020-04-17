/* --------------------------------------------------------- */
//                         Recap                             //
/* --------------------------------------------------------- */

package week8;

public class TestImplementations {
    public static void main (String[] args) {
        MyStack1<String> stack = new LinkedListStack1<>();


        stack.push("Pedro");
        stack.push("Campos");
        stack.push("Vieira");

        System.out.println(stack);
        System.out.println(stack.pop());
        System.out.println(stack);
    }
}