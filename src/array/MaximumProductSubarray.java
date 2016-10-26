package array;

public class MaximumProductSubarray {
	public int maxProduct(int[] nums) {
		if(nums == null || nums.length == 0){
			return 0;
		}
		
		int max = nums[0];
		for(int i = 1, imax = max, imin = max; i < nums.length; i++){
			if(nums[i] < 0){
				int temp = imax;
				imax = imin;
				imin = temp;
			}
			
			imax = Math.max(nums[i], nums[i] * imax);
			imin = Math.min(nums[i], nums[i] * imin);
			
			max = Math.max(max, imax);
		}
		
		return max;
	}
}
