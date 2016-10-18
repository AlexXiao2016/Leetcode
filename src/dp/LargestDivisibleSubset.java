package dp;

import java.util.*;

public class LargestDivisibleSubset {
	public static List<Integer> largestDivisibleSubset(int[] nums) {
		List<Integer> result = new ArrayList<>();
		if(nums == null || nums.length == 0){
			return result;
		}
		
		Arrays.sort(nums);
		
		int dp[] = new int[nums.length];
		dp[0] = 1;
		for(int i = 1; i < nums.length; i++){
			for(int j = i - 1; j >= 0; j--){
				if(nums[i] % nums[j] == 0){
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
			}
		}
		
		int maxIndex = 0;
		for(int i = 0; i < nums.length; i++){
			maxIndex = dp[i] > dp[maxIndex] ? i : maxIndex;
		}
		
		int count = dp[maxIndex];
		int value = nums[maxIndex];
		for(int i = maxIndex; i >= 0; i--){
			if(value % nums[i] == 0 && dp[i] == count){
				result.add(0, nums[i]);
				value = nums[i];
				count--;
			}
		}
		
		return result;
	}
	
	public static void main(String args[]){
		int[] nums = {1,4,2,8};
		List<Integer> result = largestDivisibleSubset(nums);
		for(Integer i:result){
			System.out.print(i + " ");
		}
	}
}
