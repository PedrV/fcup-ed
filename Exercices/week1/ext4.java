
package week1;

public class ext4 {

    public static void writer(String word, String word1, int n){
        
        // go only to 2 because the first 2 words are already printed
        if(n == 2){
            return;
        }

        n -= 1;
        /* Each word is made like the Fibonnaci sequence, given 2 base words A AB,
           the next would be AB + A, the next ABA + AB, following the formula
           W(n) = W(n-1) + W(n-2) , n >= 2 (pelo menos foi o que me pareceu)
        */
        String word2 = word1 + word;


        String temp = word1;
        word1 = word2;
        word = temp;

        System.out.println(word2);
        writer(word, word1, n);
    }

    public static void main(String[] args){
        int n = 7;

        // primordial gen
        String word = "A";
        // 1st gen
        String word1 = "AB";

        System.out.println(word);
        System.out.println(word1);

        writer(word, word1, n);
    }
}           
