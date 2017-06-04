package tree;
import java.util.*;

public class FindLargestValueinEachTreeRow {
	public List<Integer> largestValues(TreeNode root) {
		List<Integer> res = new ArrayList<>();
		dfs(root, 0, res);
		return res;
	}
	
	public void dfs(TreeNode root, int depth, List<Integer> res){
		if(root == null){
			return;
		}
		if(depth == res.size()){
			res.add(root.val);
		}else{
			res.set(depth, Math.max(root.val, res.get(depth)));
		}
		dfs(root.left, depth + 1, res);
		dfs(root.right, depth + 1, res);		
	}
}
