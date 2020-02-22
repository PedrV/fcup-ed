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

public class Calculadora {

    public static double decoder(String input) {
        
        int size = input.length();
        double[] numbers = new double[size];
        int index_numbers = 0;

        for(int i = 0; i < size; i++){
            if( Character.isDigit(input.charAt(i)) ){

                /* sutracting the '0' because the input.charAt(i) returns
                   the ASCII representation of the number */ 
                numbers[index_numbers] = numbers[index_numbers] * 10 + (input.charAt(i) - '0');

            } else if (input.charAt(i) == '+' || input.charAt(i) == '-' ||
                       input.charAt(i) == '*' || input.charAt(i) == '/' ){
                    
                    index_numbers++;
                    numbers[index_numbers] = input.charAt(i);
                    index_numbers++;
            }
        }

        return calc(numbers);
    } 

    public static double calc(double[] numbers){

       /* TODO: The loops used to calculate the operations do unnecessary iterations
          TODO: When only one number is passed it returns 0 */

        double result = 0;
        int size = numbers.length;

         /* Beacause all the acceptable input is of the form 20+100-100
           the signal are going to stay at the odd positions and the numbers at the even positions
           so it's handy to just consider the cases i%2 != 0*/
        
        for(int i = 0; i < size; i++){
            if( i % 2 != 0 ){
                switch ((int)numbers[i]) {
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
              switch ((int)numbers[i]) {
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
            System.out.println(decoder(input));
        }

        scan.close();

    }
}