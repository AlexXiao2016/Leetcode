import java.util.ArrayList;
import java.util.List;

public class Combinations {
	public List<List<Integer>> combine(int n, int k) {
		List<List<Integer>> list = new ArrayList<>();
		dfs(1, n, k, new ArrayList<>(), list);
		return list;
	}

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
}
