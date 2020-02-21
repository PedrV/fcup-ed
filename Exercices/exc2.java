
public class exc2 {

    static void primes(int n, boolean prime[]){
        int size = prime.length;
        
        // set array true
        for(int i = 2; i < size; i++){ 
                prime[i] = true;
            }

        for(int i = 0; i*i < size; i++){ 
            if(prime[i]){
                for(int j = i + i; j < size; j += i){
                    prime[j] = false;
                }
            }
        }     
    }

    public static void main(String[] args){

        int n=10_000_000;
        boolean[] prime = new boolean[n+1];

        primes(n, prime);

        for (int i=0; i<n; i++){
	        if (prime[i]){
                System.out.print(i + " ");
            }
        }
    }
}