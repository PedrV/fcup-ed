package week3;

// Uma classe simples para representar um aluno
class Aluno {
    public static int contador = 0;

    // Atributos da classe (variáveis para conter informação)
    String nome;
    int numero;
 
    // Construtor "padrão"
    Aluno() {
       nome   = "indefinido";
       numero = -1;
       contador++;
    }

    Aluno(String n, int mec) {
        nome = n;
        numero = mec;
        contador++;
     }

    public int ano() {
        return numero / 100000;
     }

    public String toString() {
        return "(" + nome + "," + numero + ")";
     }
 }
 
 // Classe principal contendo o main para testar a classe Aluno
 public class walkthrough {
    public static void main(String[] args) {
        Aluno a = new Aluno();
        a.nome = "Pedro";
        a.numero = 201905272;

        Aluno b = new Aluno("Pedro Vieira", 201905272);
        Aluno d = new Aluno();
       
        /* System.out.println("b = " + b);
        System.out.println("d = " + d);
        System.out.println("a = " + a);
        System.out.println("ano de a = " + a.ano()); */

        int n = 3;
        Aluno[] v = new Aluno[n];
        for (int i=0; i<n; i++){
            v[i] = new Aluno();
            System.out.println("v[" + i + "] = " + v[i]);
        }
        v[0].nome = "Pedro";
        System.out.println( v[0].nome);

        System.out.println("contador = " + Aluno.contador);
    }
 }