public class ext1 {

    static void losangulo(final int n) {
        // 1º parete do losangulo
        for (int i = 1; i <= n; i++) {
            for (int k = i; k <= n / 2; k++) {
                System.out.print("a");
            }
            for (int j = i; j <= 2 * i - 1; j+=2) {
                System.out.print("#");
            }
            System.out.println();
        }
    }

    public static void main(final String[] args) {
        losangulo(5);
    }
}