public class test {
    public static void main(String[] args) {
        MyStack<Integer> s = new LinkedListStack<>();

        s.push(42);
        System.out.println(s.top());
    }
}