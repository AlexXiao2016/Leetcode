package array;

public class LongestIncreasingSubsequence {
	public static int lengthOfLIS(int[] nums) {
		int[] tails = new int[nums.length];
	    int size = 0;
	    for (int x : nums) {
	        int i = 0, j = size;
	        while (i != j) {
	            int m = (i + j) / 2;
	            if (tails[m] < x)
	                i = m + 1;
	            else
	                j = m;	            	           
	            printArray(tails);
	        }
	        tails[i] = x;
	        if (i == size) ++size;
	    }
	    return size;
	}
	
	public static void printArray(int[] nums){
		for(int i: nums){
			System.out.print(i + " ");			
		}
		System.out.println();
	}
	
	public static void main(String args[]){
		int[] nums = {1,5,3,2,8,4,6};
		System.out.println(lengthOfLIS(nums));
	}
}
