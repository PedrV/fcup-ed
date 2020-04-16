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

        while ((!a.isEmpty()) || (!b.isEmpty())) {

            if (!a.isEmpty() && !b.isEmpty()) { // podia usar o first para ver o elemento e depois dar enqueue naquele que fosse menor
              
                if (a.first() < b.first()) {
                    merged_queue.enqueue(a.dequeue());
                } else {
                    merged_queue.enqueue(b.dequeue());
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


public class ED196ED197 {    public static void main (String[] args) {
    // MyQueue<String> q = new DoublyLinkedListQueue<>();
    MyQueue<Integer> a = new LinkedListQueue<>();
    MyQueue<Integer> b = new LinkedListQueue<>();
    MyQueue<Integer> merge = new LinkedListQueue<>();

    a.enqueue(10);
    a.enqueue(20);
    a.enqueue(30);
    a.enqueue(40);
    a.enqueue(50);
    a.enqueue(60);
    a.enqueue(70);

    b.enqueue(1);
    b.enqueue(2);
    b.enqueue(3);
    b.enqueue(44);
    b.enqueue(50);
    b.enqueue(60);
    b.enqueue(70);
    b.enqueue(90);

    merge = ED197.merge(a, b);

    System.out.println(merge);
    }       
}