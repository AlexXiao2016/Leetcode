package array;

public class RotateFunction {
	public int maxRotateFunction(int[] A) {
		if(A == null || A.length == 0){
			return 0;
		}
		
		int n = A.length;
		int sum = 0;
		int F = 0;
		
		for(int i = 0; i < n; i++){
			F += i * A[i];
			sum += A[i];
		}
		
		int max = F;
		for(int i = 1; i < n; i++){
			F = F + sum - n * A[n - i];
			if(F > max){
				max = F;
			}
		}

		return max;
	}
}
