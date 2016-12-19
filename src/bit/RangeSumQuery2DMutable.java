package bit;

public class RangeSumQuery2DMutable {
	
	private int[][] colSums;
	private int[][] matrix;
	
	public RangeSumQuery2DMutable(int[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
        	return;
        }
        
        this.matrix = matrix;
        
        int m = matrix.length;
        int n = matrix[0].length;
        colSums = new int[m + 1][n];
        
        for(int i = 1; i <= m; i++){
        	for(int j = 0; j < n; j++){
        		colSums[i][j] = colSums[i - 1][j] + matrix[i - 1][j];
        	}
        }
    }

	public void update(int row, int col, int val) {
		for(int i = row + 1; i < colSums.length; i++){
			colSums[i][col] = colSums[i][col] - matrix[row][col] + val;
		}
		
		matrix[row][col] = val;
	}

	public int sumRegion(int row1, int col1, int row2, int col2) {
		int res = 0;
		for(int i = col1; i <= col2; i++){
			res += colSums[row2 + 1][i] - colSums[row1][i];
		}
		return res;
	}
	
	public static void main(String args[]){
		int[][] matrix = {{1,2,3,4}, {5, 6, 2, 1}, {2, 3, 2, 2}, {4, 7, 9, 5}};
		RangeSumQuery2DMutable sum = new RangeSumQuery2DMutable(matrix);
		sum.sumRegion(1, 2, 3, 3);
		sum.update(1, 2, 20);
		sum.sumRegion(1, 2, 3, 3);
	}
}
