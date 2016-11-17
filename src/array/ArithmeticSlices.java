package array;

public class ArithmeticSlices {
	public int numberOfArithmeticSlices(int[] A) {
		int sum = 0, flag = 0;
        for(int i = 2; i < A.length; i++){
            if(A[i] - A[i - 1] == A[i - 1] - A[i - 2]){
                flag += 1;
                sum += flag;
            }else{
                flag = 0;
            }
        }
        
        return sum;
	}
	
	
	public static int numberOfArithmeticSlices2(int[] A) {
        if(A == null || A.length < 3){
            return 0;
        }
        
        int count = 1;
        int sum = 0;
        for(int i = 2; i < A.length; i++){
            if(A[i] - A[i - 1] == A[i - 1] - A[i - 2]){
                sum += count;
                count++;
            }else{
                count = 1;
            }
        }
        
        return sum;
    }
	
	public static void main(String args[]){
		int[] nums = {1,2,3,4};
		numberOfArithmeticSlices2(nums);
	}
}
