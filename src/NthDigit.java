
public class NthDigit {
	public int findNthDigit(int n) {
		if(n <= 9){
			return n;
		}
		
		int digits = 1;
		long count = 9;
		int start = 1;
		
		while(n > digits * count){
			n -= digits * count;
			count *= 10;
			digits++;
			start *= 10;
		}
		
		start += (n - 1) / digits;
		return String.valueOf(start).charAt((n - 1) % digits) - '0';
	}
}
