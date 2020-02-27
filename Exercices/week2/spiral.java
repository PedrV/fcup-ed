package week2;


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

    |      +--+--+--+--+--+--+
    |  +2  |21|22|23|24|25|26|
    |      +--+--+--+--+--+--+
    |  +1  |20|07|08|09|10|27|
            +--+--+--+--+--+--+
    Y   0  |19|06|01|02|11|28|
            +--+--+--+--+--+--+
    |  -1  |18|05|04|03|12|29|
    |      +--+--+--+--+--+--+
    |  -2  |17|16|15|14|13|30|
    |      +--+--+--+--+--+--+
                    ...
            -2 -1  0 +1 +2 +3
            ------- X --------
     */

public class spiral {


    public static void spiral (int n){
    
        int x = 0, y = 0, limits = 2, counter = 0; 
        double partial_limits = 1;
        char move = 'r';
        counter++;

    for(int i = 2; i <= n;){

        if(counter < limits){
            switch (move) {
                case 'r':
                    x++;
                    counter++;
                    if( counter == partial_limits ){
                        move = 'd';
                        partial_limits = limits;
                    } else if ( counter > partial_limits ){
                        move = 'd';
                    }
                    break;
                case 'l':
                    x--;
                    counter++;
                    if( counter == partial_limits ){
                        move = 'u';
                        partial_limits = limits;
                    } else if ( counter > partial_limits ){
                        move = 'u';
                    }
                    break;
                case 'u':
                    y++;
                    counter++;
                    if( counter == partial_limits ){
                        move = 'r';
                        partial_limits = limits;
                    } else if ( counter > partial_limits ){
                        move = 'r';
                    }
                    break;
                case 'd':
                    y--;
                    counter++;
                    if( counter == partial_limits ){
                        move = 'l';
                        partial_limits = limits;
                    } else if ( counter > partial_limits ){
                        move = 'l';
                    }
                    break;
            }
            i++;
        } else {
            counter = 0;
            limits += 2;
            partial_limits = Math.ceil(limits/2);
        }
    }

}


    public static void main (String[] args){

        spiral(30);
    }

}