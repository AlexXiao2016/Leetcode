package math;

public class MinimumMovestoEqualArrayElements {
	public int minMoves(int[] nums) {
        if(nums == null || nums.length <= 1){
            return 0;
        }
        
        int min = Integer.MAX_VALUE;
        int sum = 0;
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
            min = min > nums[i] ? nums[i] : min; 
        }
        
        return sum - min * nums.length;
    }
}
