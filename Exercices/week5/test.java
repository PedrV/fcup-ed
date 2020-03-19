package week5;

interface Set {
    public void add (int x);
    public void remove (int x);
    public void clear ();
    public boolean contains (int x);
    public int size ();
    public void test ();
} 


class Xpto implements Set {
    public void add (int x) {

    }
    public void remove (int x){

    }
    public void clear () {

    }
    public boolean contains (int x) {
        return false;
    }
    public int size () {
        return 0;
    }

    public void test () {
        System.out.println("Hello");
    }
}


public class test {
    public static void main (String[] args) {
        Set s = new Xpto();

        s.test();
    }
}