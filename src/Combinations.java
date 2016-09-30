import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Combinations {
	public List<List<Integer>> combine(int n, int k) {
		List<List<Integer>> list = new ArrayList<>();
		dfs(1, n, k, new ArrayList<>(), list);
		return list;
	}
	
	//recursive solution
	public void dfs(int curr, int n, int level, List<Integer> comb, List<List<Integer>> res){
		if(level == 0){
			List<Integer> temp = new ArrayList<>(comb);
			res.add(temp);
			return;
		}
		
		int size = comb.size();
		for(int i = curr; i <= n - level + 1; i++){
			comb.add(i);
			dfs(i + 1, n, level - 1, comb, res);
			comb.remove(size);
		}
	}
	
	
	//iterative solution
	public List<List<Integer>> combine1(int n, int k) {
		List<List<Integer>> result = new ArrayList<>();
		for(int i = 1; i <= n; i++){
			result.add(Arrays.asList(i));
		}
		for(int i = 2; i <= k; i++){
			List<List<Integer>> temp = new ArrayList<>();
			for(List<Integer> list : result){
				for(int j = list.get(list.size() - 1) + 1; j < n - k + 1; j++){
					List<Integer> newTemp = new ArrayList<>(list);
					newTemp.add(j);
					temp.add(newTemp);
				}
			}			
			result = temp;
		}
		
		
		return result;
	}
}
