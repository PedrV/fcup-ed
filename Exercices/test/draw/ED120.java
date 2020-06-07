package test.draw;

public class ED120 {

    public static void losangulo (int x) {
        int left = x/2;
        int right = x/2;

        for (int i = 0; i < x; i++) {
            for (int j = 0; j < x; j++) {

                if (j >= left && j <= right) 
                    System.out.print("#");
                else  
                    System.out.print(".");
            }

            if (i < x/2) {
                left--;
                right++;
            } else {
                left++;
                right--;
            }

            System.out.println();
        }
    }

    public static void main(String[] args) {
        losangulo(9);
    }
}