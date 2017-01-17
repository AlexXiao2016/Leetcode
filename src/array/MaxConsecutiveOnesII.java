package array;

public class MaxConsecutiveOnesII {
	public int findMaxConsecutiveOnes(int[] nums) {
		
		int max = 0;
		int count = 0, preZero = 0;
		for(int start = 0, end = 0; end < nums.length; end++){
			if(nums[end] == 0) {
				count++;
				preZero = end;
			}else{
			    max = Math.max(max, end - start + 1);
			}
			if(count == 1){
				start = preZero + 1;
				count--;
			}
		}
		return max;
	}
}
