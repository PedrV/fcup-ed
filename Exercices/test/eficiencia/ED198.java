package test.eficiencia;

import java.util.Arrays;

class Kadane {

    public int[] maxSubArray (int[] numbers) {
        int right_side = 0; // Definitive right side of the window
        int left_side = 0;  // Definitive left side of the window

        int lft = 0;    // Temporary right side
        int rts = 0;    // Temporary left side

        int biggest_sum = 0; 
        int biggest_so_far = 0; 


        for (int i = 0; i < numbers.length; i++) {

            biggest_so_far += numbers[i];

            if (biggest_so_far < 0) {
                lft = rts + 1;      // If the current sum is smaller than 0, lft catches rts and advaces 1 for the next rts movement
                biggest_so_far = 0;


            } else if (biggest_so_far > biggest_sum) {
                biggest_sum = biggest_so_far;
                left_side = lft;    // If biggest sum encountered update the definitive values of the right and left side of the window
                right_side = rts;   // so it can move without loosing track of the current biggest window
            }

            rts++;  // Always increment the temp right side to see if the sum can get larger
        }

        // Copy the values to a new Array
        int[] maxArray = new int[right_side-left_side+1];
        for (int i = left_side, j = 0; i <= right_side; i++, j++) 
            maxArray[j] = numbers[i];
    
        return maxArray;
    }

    public int biggestSum (int[] numbers) {
        int biggest_sum = 0;
        int biggest_so_far = 0;
        int single_max = Integer.MIN_VALUE;

        for (int i = 0; i < numbers.length; i++) {

            // Caso de os numeros serem todos negativos, o maior não pode ser 0 que seria o resultado do alg padrao
            if (numbers[i] > single_max)
                single_max = numbers[i];


            // Quando numero < 0 é preciso cuidados especias
            if (numbers[i] < 0) {

                biggest_so_far += numbers[i];

                // Se numero atual for < 0 entao so vai prejudicar a soma atual, logo coloca-lo a 0
                if (biggest_so_far < 0) 
                    biggest_so_far = 0;

                // Atualizar o maior numero já visto
                if (biggest_so_far > biggest_sum) 
                    biggest_sum = biggest_so_far;
                
                
            } else {    // No caso de o numero não ser negativo, apenas melhor o resultado
                biggest_so_far += numbers[i];
                biggest_sum = Math.max(biggest_so_far, biggest_sum); // Basta apenas ver o se o maior numero se alterou
            }

        }


        if (biggest_sum == 0 && single_max < 0)
            return single_max;
        else
            return biggest_sum;
    }

    public int minSubArray (int[] nums) {
        int final_min = 0;
        int cur_min = 0;
        int single_min = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++) {

            single_min = Math.min(single_min, nums[i]);

            if (nums[i] > 0) {

                cur_min += nums[i];

                if (cur_min > 0) {
                    cur_min = 0;
                }

                if (cur_min < final_min) {
                    final_min = cur_min;
                }

            } else {
                cur_min += nums[i];
                final_min = Math.min(final_min, cur_min);
            }
        }

        if (single_min > final_min && final_min == 0) 
            return single_min;
        else 
            return final_min;
    }
}


public class ED198 {
    public static void main (String[] args) {
        Kadane test = new Kadane();

        int[] numbers = {-1,-5,4,-2,5,-5,-2,-20,6};
        int[] numbers1 = {1,2,4,-5};

        System.out.println(Arrays.toString(test.maxSubArray(numbers)));
        System.out.println(test.minSubArray(numbers1));

    }

}