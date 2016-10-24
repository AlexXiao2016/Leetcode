package backtracking;

import java.util.*;

public class PermutationsII {
	public List<List<Integer>> permuteUnique(int[] nums) {
        
		List<List<Integer>> result = new ArrayList<>();
		if(nums == null || nums.length == 0){
			return result;
		}
		Arrays.sort(nums);
		boolean used[] = new boolean[nums.length];
		dfs(nums, used, new ArrayList<Integer>(), result);
		return result;		
    }
	
	public void dfs(int[] nums, boolean[] used, List<Integer> list, List<List<Integer>> result){
		if(list.size() == nums.length){
			result.add(new ArrayList<>(list));
			return;
		}
		for(int i = 0; i < nums.length; i++){
			if(used[i]){
				continue;
			}
			if(i > 0 && nums[i - 1] == nums[i] && !used[i - 1]){
				continue;
			}
			used[i] = true;
			list.add(nums[i]);
			dfs(nums, used, list, result);
			list.remove(list.size() - 1);
		}
	} 
}
