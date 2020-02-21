public class exc3 {
    
    static boolean isPolindrome(String word){

        int size = word.length();
        for (int i = 0, j = size-1; i < size/2; i++, j--){
            if (word.charAt(i) != word.charAt(j)){
                return false;
            }
        }
        return true;
    }

    public static void main (String[] args){
        String word = "racecar";
        if (isPolindrome(word)){ 
            System.out.println("Poliandro");
        } else {
            System.out.println("Nao");
        }
    }
}