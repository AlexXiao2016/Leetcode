package array;

public class HouseRobberII {
	public int rob(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        int length = nums.length;
        
        if(length == 1){
            return nums[0];
        }
        return Math.max(rob(nums, 0, length - 2), rob(nums, 1, length - 1));
    }
    
    public int rob(int[] nums, int start, int end){
        int now = 0, last = 0;
        for(int i = start; i <= end; i++){
            int temp = last;
            last = now;
            now = Math.max(now, temp + nums[i]);
        }
        return now;
    }
}
