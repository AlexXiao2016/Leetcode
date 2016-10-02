package Array;

import java.util.List;
import java.util.ArrayList;

public class CombinationSumIII {
	public List<List<Integer>> combinationSum3(int k, int n) {
		List<List<Integer>> result = new ArrayList<>();
		dfs(k, n, 1, new ArrayList<Integer>(), result);
		return result;
	}
	
	public void dfs(int k, int n, int start, List<Integer> list, List<List<Integer>> result){
		if(n == 0 && list.size() == k){
			List<Integer> temp = new ArrayList<>(list);
			result.add(temp);
			return;
		}
		for(int i = start; i <= 9; i++){
			list.add(i);
			dfs(k, n - i, i + 1, list, result);
			list.remove(list.size() - 1);
		}
	}
}
