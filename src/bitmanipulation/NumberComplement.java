package bitmanipulation;

public class NumberComplement {
	public int findComplement(int num) {
		int res = 0;
		int count = 0;
		while(num != 0){
			if((num & 1) == 0){
				res += (int) Math.pow(2, count);
			}
			count++;
			num = num >> 1;
		}
		return res;
	}
}
