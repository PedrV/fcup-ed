package week7;

class LinkedListStack<T> implements MyStack<T> {
    private DoublyLinkedList<T> stack;

    LinkedListStack () {
        stack = new DoublyLinkedList<>();
    }

    public int size () {
       return stack.size();
    }

    public boolean isEmpty () {
        return stack.isEmpty();
    }

    public T top () {
        return stack.getFirst();
    }

    public T pop () {
        T first = stack.getFirst();
        stack.removeFirst();
        return first;
    } 

    public void push (T value) {
        stack.addFirst(value);
    }

    public String toString () {
        return stack.toString();
    }
}