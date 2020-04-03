package week7;

class ED196 {
    public static void process (MyQueue<String> q, MyQueue<String> a, MyQueue<String> b) {
        String temp_name, temp_line;

        while (q.size() > 0) {
            temp_name = q.dequeue(); // get first name out
            temp_line = q.dequeue(); // get the line

            if (temp_line.equals("A")) {
                a.enqueue(temp_name);

            } else if (temp_line.equals("B")) {
                b.enqueue(temp_name);

            } else if (temp_line.equals("X")) {

                if (a.size() > b.size()) {
                    b.enqueue(temp_name);
                } else if (a.size() < b.size()) {
                    a.enqueue(temp_name);
                }

            }
        }
    }
}

class ED197 {
    public static MyQueue<Integer> merge (MyQueue<Integer> a, MyQueue<Integer> b) {
        MyQueue<Integer> merged_queue = new LinkedListQueue<> ();

        int int_a, int_b;

        while ((!a.isEmpty()) || (!b.isEmpty())) {

            System.out.println(merged_queue.first());

            if (!a.isEmpty() && !b.isEmpty()) { // podia usar o first para ver o elemento e depois dar enqueue naquele que fosse
                int_a = a.dequeue();            // menor
                int_b = b.dequeue();
              
                if (int_a < int_b) {
                    merged_queue.enqueue(int_a);
                    merged_queue.enqueue(int_b);
                } else {
                    merged_queue.enqueue(int_b);
                    merged_queue.enqueue(int_a);
                }

            } else if (a.isEmpty()) {
                merged_queue.enqueue(b.dequeue());
            } else {
                merged_queue.enqueue(a.dequeue());
            }

        }

        return merged_queue;
    }
}


public class ED196ED197 {
    public static void main (String[] args) {
        // MyQueue<String> q = new DoublyLinkedListQueue<>();
        MyQueue<Integer> a = new LinkedListQueue<>();
        MyQueue<Integer> b = new LinkedListQueue<>();

        MyQueue<Integer> merged;

        a.enqueue(2); a.enqueue(4); a.enqueue(8); a.enqueue(10); a.enqueue(42); a.enqueue(242); 
        b.enqueue(1);  b.enqueue(4);  b.enqueue(9);  b.enqueue(45);

        merged = ED197.merge(a, b);

        System.out.println(merged.toString());;
    }   
}