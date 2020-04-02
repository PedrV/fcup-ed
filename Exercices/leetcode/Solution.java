package leetcode;

// 30 days challange LeetCode (solvend in multiple languages)

// 1 - Spot the number that appears only once in a array (Solution, constant space, linear time, comparing bits wit (xor) (^) )
/* class Solution {
public:
    int singleNumber(vector<int>& nums) {
        int a = 0;
        for(int i : nums) {
            a ^= i;
        }
        return a;
    }
}; */

// 2 - Happy number, given a number see if summing the squre of each digit the final answer is 1 or loops forever
class Solution1 {
    public static int sqrt(int n) {
        int i = n, sum = 0;
        while (n > 0) {
            i = n % 10;
            sum += i * i;
            n = n / 10;
        }
        return sum;
    }

    public static boolean isHappy(int n) {
        int i = n;

        while (i != 1 && i != 4) { // if it loops for ever the result ois going to be 4
            i = sqrt(i);
        }

        if(i == 1) {
            return true;
        } else {
            return false;
        }
    }

}

////////////////////////
////////*Extra*/////////
///////////////////////

/* // give the postions where the bit is on (1)

    public static void bitON(int n) {
        for (int i = 0; i <= 30; i++) {
            if ((n & (1 << i)) != 0) {
                System.out.print(i);
            } 
        }
    }

// give the binary representation of a number
    public static void bitRep(int n) {
        for (int i = 30; i >= 0; i--) {
            if ((n & (1 << i)) != 0) {
                System.out.print("1");
            } else {
                System.out.print("0");
            }
        }
    } */

////////////////////////
////////*Extra*/////////
///////////////////////


public class Solution {
    public static void main(String[] args) {
        System.out.println(Solution1.isHappy(19));
    }
}