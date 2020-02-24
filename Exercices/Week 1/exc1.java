public class exc1 {

    public static void topBotton(char a, char b , int n){
        System.out.print(a);
        for(int i = 0; i <= n; i++){
            System.out.print(b);
        }
        System.out.println(a);
    }

    public static void middle(char a, char b, int n){
        System.out.print(a);
        for(int i = 0; i <= n; i++){
            System.out.print(b);
        }
        System.out.println(a);
    }

    static void square (int b){
        topBotton('+', '-', b);
        for(byte i = 0; i < b-2; i++){
            middle('|', '.', b);
        }
        topBotton('+', '-', b);
    }


    public static void main(String[] args) {
        square(8);
    }
}