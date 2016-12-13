package math;

public class PalindromeNumber {
	public static boolean isPalindrome(int x) {
        int sum = 0;
        if(x < 0 || (x!=0 && x%10==0) ) return false;
        
        while(x > sum){
        	sum = sum * 10 + x % 10;
        	x = x / 10;
        }
        return x == sum || x * 10 + sum % 10 == sum;  
    }
	
	public static void main(String args[]){
		isPalindrome(10);
	}
}
