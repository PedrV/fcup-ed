package week8;


/* class ArrayQueue {
    private MyQueue <String> queue;

    ArrayQueue () {
        queue = new LinkedListQueue<>();
    }
} */

public class test {
    public static void main (String[] args) {
        int tempo_avancado = 0;
        int[] equipas = {55,56,3,5,1};

        for (int i = 0, j = i+1; j < 5; j++) {
            if(equipas[i] >= equipas[j]) {
                i = j;
            }
            tempo_avancado = equipas[i];
        }
        System.out.println(tempo_avancado);
    }  
}