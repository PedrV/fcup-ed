package week6;

public class Pair <A,B> {
    private A first;
    private B second;

    public Pair (A first, B second) {
        this.first = first;
        this.second = second;
    }

    public A getFirst () {
        return first;
    } 

    public B getSecond () {
        return second;
    } 

    public void setFirst (A new_value) {
        first = new_value;
    } 

    public void setSecond (B new_value) {
        second = new_value;
    } 

    public boolean equals (Pair<A,B> pair) {
        if(first.equals(pair.toString()) && second.equals(pair.second)) {
            return true;
        }

        return false;
    }

    public String toString() {
        String s = "(";
        s += first + "," + second + ")";
        return s;
    } 
}