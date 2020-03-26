package week5;

class ArayListIntSet implements IntSet {
    private int size;
    private int[] numbers;
    
    public ArayListIntSet () {
        size = 0;
        numbers = new int[100];
    }


    public boolean contains (int x) {
        for(int i = 0; i < size; i++ ) {
            if (numbers[i] == x) {
                return true; 
            }
        }
        return false;
    }

    public boolean add (int x) {
        for(int i = 0; i < size; i++ ) {
            if (numbers[i] == x) {
                return false; 
            }
        }
        numbers[size] = x;
        size++;
        return true;
    }

    public boolean remove (int x) {
        for(int i = 0; i < size; i++ ) {
            if (numbers[i] == x) {
                numbers[i] = numbers[size-1];
                size--;
                return true;
            }
        }
        return false;
    }

    public int size() {
        return size;
    }

    public void clear() {
        size = 0;
    }

    public String toString () {
        String s = "";
        s = "[";
        for(int i = 0; i < size; i++ ) {
            if ( i == size-1) {
                s += numbers[i];
            } else {
                s += numbers[i] + ",";
            }
        }
        s += "]";
        return s;
    }
}

public class ED184 {
    public static void main(String[] args) {
       IntSet s = new ArayListIntSet();

       s.clear();
       System.out.println(s.size());      // Escreve "0"
       
       System.out.println(s.add(1));      // Escreve "true"
       System.out.println(s.add(5));      // Escreve "true"
       System.out.println(s.add(7));      // Escreve "true"
       System.out.println(s.add(1));      // Escreve "false"
       System.out.println(s.size());      // Escreve "3
 
       System.out.println(s.remove(5));   // Escreve "true"
       System.out.println(s.remove(5));   // Escreve "false"
       System.out.println(s.size());      // Escreve "2"
 
       System.out.println(s.contains(1)); // Escreve "true"
       System.out.println(s.contains(2)); // Escreve "false"
 
       s.clear();
       System.out.println(s.size());      // Escreve "0"

       System.out.println(s.toString());
    }
}