package greedy;

public class JumpGame {
	public boolean canJump(int[] nums) {
		int last = nums.length - 1;
		for(int i = nums.length - 2; i >= 0; i--){
			if(i + nums[i] > last) last = i;
		}
		return last <= 0;
	}
	
	public boolean canJump2(int[] nums){
		int max = 0;
		for(int i = 0; i < nums.length; i++){
			if(i > max) return false;
			max = Math.max(max, i + nums[i]);
		}
		return true;
	}
}
