package week12;

// -----------------------------------------------------------
// Estruturas de Dados 2019/2020 (CC1007) - DCC/FCUP
// http://www.dcc.fc.up.pt/~pribeiro/aulas/edados1920/
// -----------------------------------------------------------
// Exemplo de utilizacao da uma arvore binaria de pesquisa
// Ultima alteracao: 02/05/2018
// -----------------------------------------------------------

class TestBSTree {
    public static void main(String[] args) {

        // Criacao da Arvore
        BSTree<Integer> t = new BSTree<Integer>();

        // Inserindo 11 elementos na arvore binaria de pesquisa
        int[] data = {14, 4, 18, 3, 9, 16, 20, 7, 15, 17, 5};
        int[] data1 = {6, 3, 10, 1, 4, 8, 42, 2, 7, 23, 54};
        for (int i=0; i<data1.length; i++)
            t.insert(data1[i]);

        // Escrever resultado de chamada a alguns metodos
/*         System.out.println("numberNodes = " + t.numberNodes());
        System.out.println("depth = " + t.depth());
        System.out.println("contains(2) = " + t.contains(2));
        System.out.println("contains(3) = " + t.contains(3));
 */
        // Escrever nos da arvore seguindo varias ordens possiveis
        t.printPreOrder();
        t.printInOrder();
        t.printPostOrder();

        System.out.println();
        t.remove(54);
        
        // Experimentando remocao
        t.remove(14);
        t.printPreOrder();
        t.printInOrder();
        t.printPostOrder();

/*         System.out.println(t.countBetween(7, 10));
        System.out.println(t.countBetween(0, 90));
        System.out.println(t.countBetween(60, 80));
        System.out.println(t.countBetween(8, 54));
        System.out.println(t.countBetween(2, 22));
        System.out.println(t.countBetween(2, 2)); */
    }
 }