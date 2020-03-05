
package week2;
// spiral

/* 
    Desafio semana 2: Criar espiral de numeros que de cordenadas de numeros:
                    e.g 1: (0,0)
                        2: (1,0) +1 0
                        3: (1,-1) 0 -1
                        4: (0,-1) -1 0 
                        5: (-1,-1) -1 0
                        6: (-1,0) 0 +1
                        7: (-1,1) 0 +1
                        8: (0,1) +1 0
                        9: (1,1) 0 +1
                        10:(2,1) +1 0
                        11:(2,0) 0 -1 
           
    |      +--+--+--+--+--+--+--+--+
           |43|44|45|46|47|48|49|50|
    |      +--+--+--+--+--+--+--+--+
    |  +2  |42|21|22|23|24|25|26|51|
    |      +--+--+--+--+--+--+--+--+
    |  +1  |41|20|07|08|09|10|27|52|
           +--+--+--+--+--+--+--+--+
    Y   0  |40|19|06|01|02|11|28|53|
           +--+--+--+--+--+--+--+--+
    |  -1  |39|18|05|04|03|12|29|54|
    |      +--+--+--+--+--+--+--+--+
    |  -2  |38|17|16|15|14|13|30|55|
    |      +--+--+--+--+--+--+--+--+
           |37|36|35|34|33|32|31|56|
           +--+--+--+--+--+--+--+--+
                    ...
            -3 -2 -1 0  +1  +2 +3
            ------- X --------~

            0,0 1 1
            1,1 3 9 
            2,2 5 25
            3,3 7 49
            4,4 9 81
            5,5 11 121
     */

// Complexity O(start_coods(n))

public class ED122v2 {

    public static int start_coods = 0;
    public static long start_value = 0;

/*      public static void cordenadas(int num) {

        if(num < 9) {
            start_coods = 0;
            start_value = 1;
            return;
        } 
        double sqrt = Math.sqrt(num);  
        long floor = (long) Math.floor(sqrt);
        if(floor % 2 != 0) floor--; 
        start_coods = (int) (floor / 2);
        start_value = (start_coods + 1)*(start_coods + 1);  
    } */ 

    public static void spiral(int n) {

        for(int i = 0; start_coods == 0 ; i++){ 
            if( ((i+i) + 1)*((i+i) + 1) > n ){
                start_coods = i - 1;
                start_value = ((i-1+i-1) + 1)*((i-1+i-1) + 1); 
            }
        }
     
        int y = start_coods, x = start_coods, final_limit = 2 * x + 1;
    
        // in case of the value is already the perfect square stop !
        if(start_value != n){
            // first right step
            x++;
            start_value++;
        }   
   

        int public_limit = final_limit;
        int moves = 1;

        while (start_value < n) { 
            if(public_limit > 0){ 
            switch (moves) {
                case 1: 
                    y--; 
                    public_limit--; 
                    break;  
                case 2:
                    x--;
                    public_limit--;
                    break;
                case 3:
                    y++;
                    public_limit--;
                    break;
                case 4:
                    x++;
                    public_limit--;
                    break;
            }
            start_value++; 
        } else {  
            moves++;
            public_limit = final_limit + 1;
        }
    }
    System.out.println("("+ x + "," + y + ")");
}

    public static void main(String[] args) {
        spiral(7654321);
    }

}
