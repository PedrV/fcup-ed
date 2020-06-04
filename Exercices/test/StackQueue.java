package test;

import java.util.ArrayList;
import java.util.Stack;

import week14.util.*;

public class StackQueue {
    
    public static void reverse (final MyStack<Integer> s, final int n) {

        final ArrayList<Integer> arrList = new ArrayList<>(s.size());

        for (int i = 0; i < n; i++)
            arrList.add(s.pop());

        for (int i = 0; i < n; i++)
            s.push(arrList.get(i));

    }

    public static boolean balanced(final String s) {
        final Stack<Character> par = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '[')
                par.add('[');

            else if (s.charAt(i) == '(')
                par.add('(');

            else if (s.charAt(i) == ']') {

                if (par.size() == 0) {
                    return false;

                } else {
                    if (par.peek() != '[')
                        return false;
                    else
                        par.pop();
                }

            } else {

                if (par.size() == 0) {
                    return false;

                } else {
                    if (par.peek() != '(')
                        return false;
                    else
                        par.pop();
                }
            }
        }

        return par.size() == 0;
    }

    public static void process(final MyQueue<String> q, final MyQueue<String> a, final MyQueue<String> b) {
        final int size_c = q.size();

        for (int i = 0; i < size_c / 2; i++) {
            final String name = q.dequeue();
            final String line = q.dequeue();

            if (line.equals("A"))
                a.enqueue(name);
            else if (line.equals("B"))
                b.enqueue(name);
            else {
                if (a.size() > b.size())
                    b.enqueue(name);
                else if (b.size() > a.size())
                    a.enqueue(name);
            }
        }

    }

    public static MyQueue<Integer> merge(final MyQueue<Integer> a, final MyQueue<Integer> b) {
        final MyQueue<Integer> merged = new LinkedListQueue<>();

        while (a.size() != 0 && b.size() != 0) {

            if (a.first() <= b.first())
                merged.enqueue(a.dequeue());
            else
                merged.enqueue(b.dequeue());

        }

        if (a.size() == 0) {

            while (b.size() != 0)
                merged.enqueue(b.dequeue());

        } else if (b.size() == 0) {

            while (a.size() != 0)
                merged.enqueue(a.dequeue());
        }

        return merged;
    }

    public static void main(final String[] args) {
        final MyQueue<Integer> a = new LinkedListQueue<>();
        final MyQueue<Integer> b = new LinkedListQueue<>();
        
        a.enqueue(1);
        a.enqueue(2);
        a.enqueue(4);
        a.enqueue(5);


        b.enqueue(2);
        b.enqueue(3);
        b.enqueue(5);
        b.enqueue(6);
        b.enqueue(8);

        System.out.println(merge(a, b).toString());
        
    }
}