package hashTable;
import java.util.*;

public class MaximumSizeSubarraySumEqualsk {
	public static int maxSubArrayLen(int[] nums, int k) {
		if(nums == null || nums.length == 0){
			return 0;
		}
		
		for(int i = 1; i < nums.length; i++){
			nums[i] += nums[i - 1];
		}
		
		HashMap<Integer, Integer> map = new HashMap<>();
		map.put(0, -1);
		int max = 0;
		for(int i = 0; i < nums.length; i++){
			if(map.containsKey(nums[i] - k)){
				max = Math.max(max, i - map.get(nums[i] - k));
			}
			if(!map.containsKey(nums[i])){
				map.put(nums[i], i);
			}
		}
		
		return max;
	}
	
	public static void main(String args[]){
		int[] nums = {1, -1, 5, -2, 3};		
		System.out.println(maxSubArrayLen(nums, 3));
	}
}
