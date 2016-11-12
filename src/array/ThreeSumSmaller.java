package array;

import java.util.Arrays;

public class ThreeSumSmaller {
	public static int threeSumSmaller(int[] nums, int target) {
		if(nums == null || nums.length < 3){
			return 0;
		}

		Arrays.sort(nums);
		int count = 0;
		for(int i = 0; i < nums.length -2; i++){
			int low = i + 1, high = nums.length - 1;
			while(low < high){
				int sum = nums[i] + nums[low] + nums[high];
				if(sum < target){
					count += high - low;
					low++;
				}else{
					high--;
				}
			}
		}		
		return count;			
	}

	public static void main(String args[]){
		int nums[] = {-2, 0, 1, 3};
		threeSumSmaller(nums, 2);
	}
}
