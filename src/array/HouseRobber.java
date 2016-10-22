package array;

public class HouseRobber {
	public static int rob(int[] nums) {
		int[] max = new int[nums.length];
		if(nums == null || nums.length == 0){
			return 0;
		}if(nums.length == 1){
			return nums[0];
		}else{
			max[0] = nums[0];  
			max[1] = Math.max(nums[0], nums[1]);
			for(int i = 2; i < nums.length; i++){
				max[i] = Math.max(nums[i] + max[i - 2], max[i - 1]);
			}
		}
		return max[nums.length - 1];
	}

	public static void main(String args[]){
		int[] nums = {1,3,1};
		System.out.println(rob(nums));
	}
}
