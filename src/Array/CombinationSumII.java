package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII {
	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
		Arrays.sort(candidates);
		List<List<Integer>> result = new ArrayList<>();
		dfs(candidates, target, new ArrayList<Integer>(), result, 0);
		return result;
	}
	
	
	public void dfs(int[] candidates, int target, List<Integer> list, List<List<Integer>> res, int start){
		if(target == 0){
			res.add(new ArrayList<Integer>(list));
		}else if(target > 0){
			for(int i = start; i < candidates.length && target >= candidates[i]; i++){
				if(i > start && candidates[i] == candidates[i - 1]) continue;
				list.add(candidates[i]);
				dfs(candidates, target - candidates[i], list, res, i + 1);
				list.remove(list.size() - 1);
			}
		}
	}
}
