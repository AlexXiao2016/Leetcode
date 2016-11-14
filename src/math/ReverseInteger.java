package math;

public class ReverseInteger {
	public int reverse(int x) {
        if(x == 0) return 0;
        
        int flag = x > 0 ? 1 : -1;
        
        x = Math.abs(x);
        int sum = 0;
        while(x != 0){
            int tail = x % 10;
            int newSum = sum * 10 + tail;
            if((newSum - tail) / 10 != sum){
                return 0;
            }
            sum = newSum;
            x = x / 10;
        }
        
        return sum * flag;
    }
}
