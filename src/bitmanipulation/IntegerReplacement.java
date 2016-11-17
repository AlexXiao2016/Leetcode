package bitmanipulation;

public class IntegerReplacement {
	public int integerReplacement(int n) {
		if(n == Integer.MAX_VALUE) return 32;
		int res = 0;
		while(n != 1){
			if(n % 2 == 0) {
				n = n / 2;
			}else{
				if((n + 1) % 4 == 0 && n != 3){
					n = n + 1;
				}else{
					n = n - 1;
				}
			}
			res++;
		}
		return res;
	}
}
