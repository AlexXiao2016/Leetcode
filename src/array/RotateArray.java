package array;

public class RotateArray {
	public void rotate(int[] nums, int k) {
		if(nums == null || nums.length <= 1 || k == 0){
			return;
		}
		k = k % nums.length;
		
		swap(nums, 0, nums.length - 1);
		swap(nums, 0, k - 1);
		swap(nums, k, nums.length - 1);		
	}
	
	public void swap(int[] nums, int start, int end){
		while(start < end){
			int temp = nums[start];
			nums[start] = nums[end];
			nums[end] = temp;
			start++;
			end--;
		}
	}
}
