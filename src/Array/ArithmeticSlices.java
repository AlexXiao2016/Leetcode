package Array;

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
}
