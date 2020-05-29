package week13;

import java.util.Comparator;

public class MinHeap <T> {
    private T[] data;
    private int size;
    private Comparator<T> comparator;


    @SuppressWarnings ("unchecked")     // Java não admite cast para array de genericos
    MinHeap (int capacity) {
        size = 0;
        data = (T[]) new Object[capacity+1];
    }

    MinHeap (int capacity, Comparator<T> comp) {
        this(capacity);
        comparator = comp;
    }

    // -----------------------------------------------------------

    public int size () { return size;}

    public boolean isEmpty () { return size==0; }

    public T min () {
        if (isEmpty()) return null;
        return data[1];
    }

    // -----------------------------------------------------------

    public void insert (T value) {
        if (size+1 >= data.length) throw new RuntimeException("Heap is full");
        data[++size] = value;   // Inserir no fim, ultima posiçao do array
        upHeap(size);           // Depois de inserir no fim temos de verificar que o heap nao foi alterado (a sua ordem de niveis)
    }

    public T removeMin () {
        if (isEmpty()) return null;

        T temp = data[1];           // Obter elemento na raiz
        data[1] = data[size];       // Mudar o elemento da raiz para o elemento no fim do array, nó terminal mais à direita
        data[size] = null;          // Ajudar garbage collection
        size--;
        downHeap(1);                // Reconstruir a heap, pois agora o elemento à raiz nao é o mais pequeno (ou o maior no caso de maxHeap)
        return temp;                
    }


    // -----------------------------------------------------------

    private void upHeap (int i) {
        while (i > 1 && smaller(i, i/2)) {      // Enquanto o nosso elemento nao estiver na raiz e for menor que o pai (o maior no caso da maxHeap)
            swap(i, i/2);                       // Trocar filho e pai
            i /= 2;
        }
    }


    private void downHeap (int i) {             
        while (i*2 <= size) {                   // Enquanto houver pelo menos o filho da esquerda disponivel para ir para lá
            int j = i*2;                        // Preparar index do filho da esquerda que sabemos que existe

            if (j < size && smaller(j+1, j))    // Se filho da esquerda for menor que size, então sabemos que o seu "irmao", o filho da direita vai existir pois é o index ao lado ou seja é no pior caso igual ao size,
                j++;                            // Podemos comparar entre os dois filhos e decidir qual é o menor (maior no caso maxHeap)
            
            if (smaller(j, i))                  // Se o menor filho for menor que o pai
                swap(i, j);                     // Troca-los de posiçao, filho vai para cima na árvore e o pai, que consideramos inicialmente vai para baixo
            else
                break;                          // Se isto não ocorrer nao nos interessa a troca

            i = j;                              // Update da poisção do pai (que ja nao é mais pai dos filhos anteriores :D)
        }

    }

    private void swap (int i, int j) {
        T temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }

    @SuppressWarnings ("unchecked")     // Java não suporta cast de um tipo T para um tipo comparavel
    private boolean smaller (int i, int j) {
        if (comparator == null) // Caso nao seja passado comparador customizado usar o default
            return ((Comparable <? super T>) data[i]).compareTo(data[j]) < 0;   // Para criar maxHeap, trocar este sinal
        else 
            return comparator.compare(data[i], data[j]) < 0;    // Para criar maxHeap, trocar este sinal
    }

}