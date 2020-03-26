package week5;

class BooleanArrayIntSet implements IntSet {
    private final int MAX_VALUE = 100;
    private int size;
    private boolean[] isElem;

    public BooleanArrayIntSet () {
        isElem = new boolean[MAX_VALUE];
        size = 0;
    }


    public boolean contains (int x){
        if (isElem[x]) {
            return true;
        }
        return false;
    }

    public boolean add (int x){
        if (isElem[x]) {
            return false;
        } else {
            isElem[x] = true;
            size++;
            return true;
        }
    }

    public boolean remove (int x){
        if (isElem[x]) {
            isElem[x] = false;
            size--;
            return true;
        } else {
            return false;
        }
    }

    public int size(){
        return size;
    }

    public void clear() {
        size = 0;
    }

}

public class ED184_BOOL {

    public static void main (String[] args) {
        BooleanArrayIntSet s = new BooleanArrayIntSet();
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
    }
}