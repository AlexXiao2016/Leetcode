package dp;

public class CountingBits {
	public static int[] countBits(int num) {
        int[] result = new int[num + 1];
        int max = 0;
        result[0] = 0;
        for(int i = 1; i <= num; i++){        	
            if(((i - 1) & i) == 0){
            	result[i] = 1;
            	max = i;
            }else{
            	result[i] = result[max] + result[i - max]; 
            }                  
        }
        
        return result;        
    }
	
	public static void main(String args[]){
		countBits(10);
	}
}
