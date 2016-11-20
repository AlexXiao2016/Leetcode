package array;

public class Searcha2DMatrix {
	public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return false;
        }
        
        int m = matrix.length;
        int n = matrix[0].length;
        
        int start = 0, end = m * n - 1;
        while(start <= end){
        	int mid = start + (end  - start) / 2;
        	if(matrix[mid / n][mid % n] == target){
        		return true;
        	}else if(matrix[mid / n][mid % n] < target){
        		start = mid + 1;
        	}else{
        		end = mid - 1;
        	}
        }
        return false;
    }
	
	/*
	 * 
	public boolean searchMatrix2(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return false;
        }
        
        int m = matrix.length;
        int n = matrix[0].length;
        if(target < matrix[0][0] || target > matrix[m - 1][n - 1]) return false;        
        
        
        int start = 0, end = m - 1;
        while(start != end && matrix[end][0] > target){
        	int mid = (start + end + 1) / 2;        	
        	if(target > matrix[mid][0]){
        		start = mid;
        	}else if(target < matrix[mid][0]){
        		end = mid - 1;
        	}else{
        		return true;
        	}
        }
        
        int row = end;
        start = 0;
        end = n - 1;
        while(start <= end){
        	int mid = start + (end  - start) / 2;
        	if(matrix[row][mid] == target){
        		return true;
        	}else if(matrix[row][mid] < target){
        		start = mid + 1;
        	}else{
        		end = mid - 1;
        	}
        }
        
        return false;
    }
    */
	
	
	public static void main(String args[]){
//		int[][] nums = {{1,  3,  5,  7},{10, 11, 16, 20},{23, 30, 34, 50}};
		int[][] nums = {{1}, {3}};
		Searcha2DMatrix s = new Searcha2DMatrix();
		s.searchMatrix(nums, 2);
	}
}
