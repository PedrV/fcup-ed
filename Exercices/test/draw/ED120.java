package test.draw;

public class ED120 {

    public static void losangulo (final int x) {
        int left = x/2;
        int right = x/2;

        for (int i = 0; i < x; i++) {
            for (int j = 0; j < x; j++) {

                if (j == left || j == right) 
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

    public static void heart(final int x) {

        for (int i = -3 * x/2; i <= x; i++) {
            for (int j = -3*x/2; j <= 3* x/2; j++) {
                if ( (Math.abs(i) + Math.abs(j) < x) || ((-x/2-i) * (-x/2-i) + (x/2-j) * (x/2-j) <= x*x/2)
                    || ((-x/2-i) * (-x/2-i) + (-x/2-j) * (-x/2-j) <= x*x/2)) {
                    System.out.print(" *");
                }
                else 
                    System.out.print(" .");
            }
            
            System.out.println();
        }
    }

    public static void heartV2 (final int x) {
        int p1 = 0, p2 = x-1;

        for (int i = 0; i < x; i++) {
            for (int j = 0; j < x; j++) {

                if (i == 0 && j%3 != 0)
                    System.out.print(" *");
                else if (i == 1 && j%3 == 0)
                    System.out.print(" *");
                else if (i >= 2 && (j == p1 || j == p2))
                    System.out.print(" *");
                else 
                    System.out.print(" .");
            }

            if (i > 2) {
                p1++;
                p2--;
            }

            System.out.println();
        }
    }

    // Numeros impares
    public static void triangleOutside(int x) {
        int l = x/2;
        int r = x/2;

        for (int i = 0; i < x/2 +1; i++) {
            for (int j = 0; j < x; j++) {
                if (j >= r || j <= l) {
                    System.out.print("#");
                } else {
                    System.out.print(".");
                }
            }

            r++;
            l--;

            System.out.println();
        }
    }

    // Numeros impares
    public static void triangle(int x) {
        int l = x/2;
        int r = x/2;

        for (int i = 0; i < x/2 +1; i++) {
            for (int j = 0; j < x; j++) {
                if (j >= l && j <= r) {
                    System.out.print("#");
                } else {
                    System.out.print(".");
                }
            }

            r++;
            l--;

            System.out.println();
        }
    }

    // Numeros pares
    public static void triangleInverted(int x) {
        int l = 0;
        int r = x;

        for (int i = 0; i < x/2 +1; i++) {
            for (int j = x; j >= 0; j--) {
                if (j >= l && j <= r) {
                    System.out.print("#");
                } else {
                    System.out.print(".");
                }
            }

            r--;
            l++;

            System.out.println();
        }
    }


    // Numeros pares
    public static void triangleOutsideInverted(int x) {
        int l = 0;
        int r = x;

        for (int i = 0; i < x/2 +1; i++) {
            for (int j = x; j >= 0; j--) {
                if (j >= r || j <= l) {
                    System.out.print("#");
                } else {
                    System.out.print(".");
                }
            }

            r--;
            l++;

            System.out.println();
        }
    }

    public static void circle(int r) {
        int N = 2*r+1; 
  
        int x, y; // Coordinates inside the rectangle 
      
        // Draw a square of size N*N. 
        for (int i = 0; i < N; i++) 
        { 
            for (int j = 0; j < N; j++) 
            { 
                // Start from the left most corner point 
                x = i-r; 
                y = j-r; 
      
                // If this point is inside the circle, print it 
                if (x*x + y*y <= r*r+1 ) 
                    System.out.print("."); 
                else 
                    // If outside the circle, print space 
                    System.out.print(" "); 
      
                System.out.print(" "); 
            } 
      
            System.out.println(); 
        } 
    }
    

    public static void main(final String[] args) {
        circle(7);
    }
}