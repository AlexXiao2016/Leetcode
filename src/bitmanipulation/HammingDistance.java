package bitmanipulation;

public class HammingDistance {
	public int hammingDistance(int x, int y) {
        int temp = x ^ y;
        int res = 0;
        for(int i = 0; i < 32; i++){
        	if((temp & 1) == 1) res++;
        	temp = temp >> 1;
        }
        return res;
    }
}
