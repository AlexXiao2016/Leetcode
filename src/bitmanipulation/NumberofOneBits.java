package bitmanipulation;

public class NumberofOneBits {
	public int hammingWeight(int n) {
        if(n == 0){
            return 0;
        }
        
        int count = 0;
        while(n != 0){
            count += (n & 1);
            n = n >>> 1;
        }
        return count;
    }
}
