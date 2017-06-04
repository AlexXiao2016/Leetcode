package bitmanipulation;

public class CountingBits {
	public static int[] countBits(int num) {
        int res[] = new int[num + 1];
        int pow = 0;
        
        for(int i = 1; i <= num; i++){
            if(i == (int) Math.pow(2, pow)){
                res[i] = 1;
                pow++;
            }else{
                int lastPow = (int) Math.pow(2, pow - 1);
                res[i] = res[lastPow] + res[i - lastPow];
            }
        }
        
        return res;
    }
	
	public static int[] countBits2(int num) {
        int res[] = new int[num + 1];
        
        for(int i = 1; i <= num; i++){
        	res[i] = res[i / 2] + i % 2;
        }
        
        return res;
    }
	
	
	public static void main(String args[]){
		System.out.println(countBits(10)[7]);
		System.out.println(countBits2(10)[7]);
	}
}
