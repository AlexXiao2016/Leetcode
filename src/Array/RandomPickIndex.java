package Array;

import java.util.Random;

public class RandomPickIndex {
	public int[] nums;

	public RandomPickIndex(int[] nums) {
		this.nums = nums;
	}

	public int pick(int target) {
		Random rand = new Random();
		int count = 1;
		int result = 0;
		for(int i = 0; i < nums.length; i++){
			if(nums[i] != target){
				continue;
			}
			if(rand.nextInt(count++) == 0){
				result = i;
			}
		}

		return result;
	}
}
