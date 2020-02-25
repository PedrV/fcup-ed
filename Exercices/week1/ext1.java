
package week1;

public class ext1 {

    static void losangulo(final int n) {
        // 1º parte do losangulo
        for (int i = 1; i <= n/2 + 1; i++) {
           for(int j = i; j <= n/2; j++){
                System.out.print(" ");
           }
           for(int k = 0; k < 2*i -1; k++){
               System.out.print("#");
           }
           System.out.println();
        }

        // 2º parte do losangulo
        for (int i = n/2; i >= 1; i--) {
           for(int j = n/2; j >= i; j--){
                System.out.print(" ");
           }
           for(int k = 2*i - 1; k > 0; k--){
               System.out.print("#");
           }
           System.out.println();
        }
    }

    public static void main(final String[] args) {
        losangulo(7);
    }
}