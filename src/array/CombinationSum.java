package array;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class CombinationSum {
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		Arrays.sort(candidates);
		List<List<Integer>> result = new ArrayList<>();
		helper(candidates, target, 0, new ArrayList<Integer>(), result);

		return result;
	}

	public void helper(int[] candidates, int target, int start, List<Integer> list, List<List<Integer>> result){
		if(target > 0){
			for(int i = start; i < candidates.length && target >= candidates[i]; i++){
				list.add(candidates[i]);
				helper(candidates, target - candidates[i], i, list, result);
				list.remove(list.size() - 1);
			}
		}else if(target == 0){
			result.add(new ArrayList<Integer>(list));
		}
	}

	public List<List<Integer>> combinationSum1(int[] candidates, int target){
		Arrays.sort(candidates);
		List<List<List<Integer>>> result = new ArrayList<>();
		for (int i = 1; i <= target; i++) {
			List<List<Integer>> newList = new ArrayList<>();
			 for (int j = 0; j < candidates.length && candidates[j] <= i; j++) {
				 if (i == candidates[j]) newList.add(Arrays.asList(candidates[j]));
				 
				 else for (List<Integer> l : result.get(i-candidates[j]-1)) {
	                    if (candidates[j] <= l.get(0)) {
	                        List<Integer> cl = new ArrayList<>();
	                        cl.add(candidates[j]); 
	                        cl.addAll(l);
	                        newList.add(cl);
	                    }
	                }
			 }
			 result.add(newList);
		}
		return result.get(target - 1);
		
	}

}
