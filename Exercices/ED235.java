import java.util.Scanner;

public class ED235 {

    public static void triangulos (int size) {

        int draw = size-1;

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (j >= draw)
                    System.out.print("#");
                else 
                    System.out.print(".");
            }

            draw--;
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();

        for (int i = 0; i < n; i++) {
            triangulos(scan.nextInt());
        }  

        scan.close();
    }
}