package week8;


class ArrayQueue {
    private MyQueue <String> queue;

    ArrayQueue () {
        queue = new LinkedListQueue<>();
    }
}

public class test {
    public static void main (String[] args) {
        ArrayQueue arrayq[];

        arrayq = new ArrayQueue[5];
        for (int i = 0; i < 5; i++) {
            arrayq[i] = new ArrayQueue();
        }
    }
}