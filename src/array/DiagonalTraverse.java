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

	public static void main(String args[]) {
		int[][] arr = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		findDiagonalOrder(arr);
	}
}
