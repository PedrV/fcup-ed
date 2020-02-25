
package week1;

import java.util.Scanner;

/* Desafio Semana numero 1:

Criar calculadora com visor que dê display dos numeros na forma:

.##. .... .##. .##. .... .##. .##. .##. .##. .##.
#..# ...# ...# ...# #..# #... #... #..# #..# #..#
#..# ...# ...# ...# #..# #... #... #..# #..# #..#
.... .... .##. .##. .##. .##. .##. .... .##. .##.
#..# ...# #... ...# ...# ...# #..# ...# #..# ...#
#..# ...# #... ...# ...# ...# #..# ...# #..# ...#
.##. .... .##. .##. .... .##. .##. .... .##. .##.

"/":47, "-":45, "+":43, "*":42
*/

/* Pedro Vieira 2/22/2020 */

public class Calculadora {

    public static void writer(int number) {
        /* TODO: Make possible resizing the font 
        (but its to much work to draw the numbers again and dont now another way :D)  */

        // Change font
        String a = "#";
        String b = ".";
                                  
        String[][] digits = {//   0     1       2        3       4       5       6       7       8       9  
                             {b+a+a+b,b+b+b+b,b+a+a+b,b+a+a+b,b+b+b+b,b+a+a+b,b+a+a+b,b+a+a+b,b+a+a+b,b+a+a+b}, // 0 
                             {a+b+b+a,b+b+b+a,b+b+b+a,b+b+b+a,a+b+b+a,a+b+b+b,a+b+b+b,a+b+b+a,a+b+b+a,a+b+b+a}, // 1
                             {a+b+b+a,b+b+b+a,b+b+b+a,b+b+b+a,a+b+b+a,a+b+b+b,a+b+b+b,a+b+b+a,a+b+b+a,a+b+b+a}, // 2
                             {b+b+b+b,b+b+b+b,b+a+a+b,b+a+a+b,b+a+a+b,b+a+a+b,b+a+a+b,b+b+b+b,b+a+a+b,b+a+a+b}, // 3
                             {a+b+b+a,b+b+b+a,a+b+b+b,b+b+b+a,b+b+b+a,b+b+b+a,a+b+b+a,b+b+b+a,a+b+b+a,b+b+b+a}, // 4
                             {a+b+b+a,b+b+b+a,a+b+b+b,b+b+b+a,b+b+b+a,b+b+b+a,a+b+b+a,b+b+b+a,a+b+b+a,b+b+b+a}, // 5
                             {b+a+a+b,b+b+b+b,b+a+a+b,b+a+a+b,b+b+b+b,b+a+a+b,b+a+a+b,b+b+b+b,b+a+a+b,b+a+a+b}, // 6
                            };
        
        int size = 0, number1 = number;

        // how "big" is the number 
        while(number1 != 0){
            number1 /= 10;
            size++;
        }

        int size1 = size;
        int[] k = new int[size];

        while(size > 0){
            int pop = number % 10;
            number /= 10;
            k[size-1] = pop;
            size--;
        }

        for(int i = 0;i <= 6; i++){
            for(int j = 0; j <= size1-1; j++){
                System.out.print(" " + digits[i][k[j]]);
            }
            System.out.println();
        }
    }

    public static void decoder(String input) {
        
        int size = input.length();
        int[] numbers = new int[size];
        int index_numbers = 0;
        boolean operations = false;

        for(int i = 0; i < size; i++){
            if( Character.isDigit(input.charAt(i)) ){

                /* sutracting the '0' because the input.charAt(i) returns
                   the ASCII representation of the number */ 
                numbers[index_numbers] = numbers[index_numbers] * 10 + (input.charAt(i) - '0');

            } else if (input.charAt(i) == '+' || input.charAt(i) == '-' ||
                       input.charAt(i) == '*' || input.charAt(i) == '/' ){
                    
                    operations = true;

                    index_numbers++;
                    numbers[index_numbers] = input.charAt(i);
                    index_numbers++;
            }
        }

        writer(calc(numbers,operations));
    } 

    public static int calc(int[] numbers, boolean operations){

       /* TODO: The loops used to calculate the operations do unnecessary iterations*/

        int result = 0;
        int size = numbers.length;

        // Special case 1 number passed
        if(!operations){
            return numbers[0];
        }

         /* Beacause all the acceptable input is of the form 20+100-100
           the signal are going to stay at the odd positions and the numbers at the even positions
           so it's handy to just consider the cases i%2 != 0*/
        
        for(int i = 0; i < size; i++){
            if( i % 2 != 0 ){
                switch (numbers[i]) {
                        case '/':
                            result = numbers[i-1] / numbers [i+1];
                            /* Set the values of the numbers already calculated
                               for easy transportation for the other operations
                               since I dont know if 50+10*10 or 10*10+50, so its safer to set 
                               all the values already used */
                            numbers[i-1] = result;
                            numbers[i] = result;
                            numbers[i+1] = result;
                            break;
                        case '*':
                            result = numbers[i-1] * numbers [i+1];
                            numbers[i-1] = result;
                            numbers[i] = result;
                            numbers[i+1] = result;
                            break;
                    }
            } 
        }

        for(int i = 0; i < size; i++){
            if( i % 2 != 0 ){
              switch (numbers[i]) {
                    case '-':
                        result = numbers[i-1] - numbers [i+1];
                        numbers[i-1] = result;
                        numbers[i] = result;
                        numbers[i+1] = result; 
                        break;
                    case '+':
                        result = numbers[i-1] + numbers [i+1]; 
                        numbers[i-1] = result;
                        numbers[i] = result;
                        numbers[i+1] = result; 
                        break;
                }
            }
        } 

        return result;
    } 

    public static void main (String[] args){


        Scanner scan = new Scanner(System.in);


        System.out.println("                    ----//----");
        System.out.println("                     Starting");
        System.out.println("                    ----//----");
        System.out.println("    [!] All the input MUST be passed like: 10+5+4 ...");
        System.out.println("    [!] To exit the calculator please type: \"exit\" ");

        String input = ":D";

        while(!input.equals("exit")){
            System.out.print("> ");
            input = scan.nextLine();
            if(input.equals("exit")){
                break;
            }
            decoder(input);
        }
        scan.close();

    }
}