package array;

public class RotateImage {
	public void rotate(int[][] matrix) {
		if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
			return;
		}
		
		int n = matrix.length;
		int temp;
		
		int k = n;
		// when i reach n/2, the rotate process will be done
		for(int i = 0; i < n / 2; i++){
			for(int j = i; j < k - 1; j++, k--){
				temp = matrix[i][j];
				matrix[i][j] = matrix[n - j - 1][i];
				matrix[n - i - 1][i] = matrix[n - i - 1][n - j - 1];
				matrix[n - i - 1][n - j - 1] = matrix[j][n - i - 1];
				matrix[j][n - i - 1] = temp;
			}
		}
	}
	
	public void rotate(int[][] matrix, int flag){
		
	}
}
