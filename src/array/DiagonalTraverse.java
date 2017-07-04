package array;

public class DiagonalTraverse {
	public static int[] findDiagonalOrder(int[][] matrix) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
			return new int[0];

		int m = matrix.length;
		int n = matrix[0].length;

		int row = 0, col = 0;
		int res[] = new int[m * n];

		for (int i = 0; i < res.length; i++) {
			res[i] = matrix[row][col];
			if ((row + col) % 2 == 0) {
				if (col == n - 1) {
					row++;
				} else if (row == 0) {
					col++;
				} else {
					row--;
					col++;
				}
			} else {
				if (row == m - 1) {
					col++;
				} else if (col == 0) {
					row++;
				} else {
					row++;
					col--;
				}
			}
		}

		return res;
	}
	
	public static int[] findDiagonalOrder2(int[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return new int[0];
        int m = matrix.length, n = matrix[0].length;
        int i = 0, j = 0, k = 0;
        int res[] = new int[m * n];
        while(i < m && j < n){
            res[k++] = matrix[i][j];
            if((i + j) % 2 == 0){
            	if(j == n - 1){
                    i++;
                    continue;
                }
            	if(i == 0){
                    j++;
                    continue;
                }                
                i--;
                j++;
            }else{                
                if(i == m - 1){
                    j++;
                    continue;
                }
                if(j == 0){
                    i++;
                    continue;
                }
                i++;
                j--;
            }
        }
        
        return res;
    }

	public static void main(String args[]) {
		int[][] arr = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		char[] ch = new char[2];
		System.out.println(ch[0] + " Test");
	}
}
