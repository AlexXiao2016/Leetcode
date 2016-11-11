package array;

public class SparseMatrixMultiplication {
	public int[][] multiply(int[][] A, int[][] B) {
		int rowsA = A.length;
		int colsA = A[0].length;
		int colsB = B[0].length;


		int[][] result = new int[rowsA][colsB];

		for(int i = 0; i < rowsA; i++){
			for(int k = 0; k < colsA; k++){
				if(A[i][k] != 0){
					for(int j = 0; j < colsB; j++){								
						if(B[k][j] != 0) {
							result[i][j] += A[i][k] * B[k][j];
						}
					}
				}
			}
		}

		return result;
	}
}
