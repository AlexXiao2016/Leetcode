package math;

public class NumberofDigitOne {
	public static int countDigitOne(int n) {
		if (n <= 0)
			return 0;

		int count = 0, num = n, x= 1;
		do{
			int digit = num % 10;
			num /= 10;
			count += num * x;
			if(digit == 1) count += n % x + 1;
			if(digit > 1) count += x;
			x *= 10;
		}while(num > 0);
		return count;
	}
	
	public static void main(String args[]){
		countDigitOne(18);
	}
}
