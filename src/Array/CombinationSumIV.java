package Array;

import java.util.Arrays;
import java.util.*;

public class CombinationSumIV {
	public int combinationSum4(int[] nums, int target) {
		Arrays.sort(nums);
		List<List<Integer>> result = new ArrayList<>();
		
		dfs(nums, target, 0, new ArrayList<Integer>(), result);
		return result.size();
	}
	
	
	public void dfs(int[] nums, int target, int start, List<Integer> list, List<List<Integer>> result){
		if(target == 0){
			List<Integer> tep = new ArrayList<>(list);
			result.add(tep);
		}else if(target > 0){
			for(int i = start; i < nums.length && target >= nums[i]; i++ ){
				List<Integer> temp = new ArrayList<>();
				temp.add(i);
				dfs(nums, target - nums[i], i, temp, result);
				temp.remove(temp.size() - 1);
			}
		}
	}
}
