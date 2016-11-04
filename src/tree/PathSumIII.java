package tree;

import java.util.HashMap;

public class PathSumIII {
	public int pathSum(TreeNode root, int sum) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        return dfs(root, 0, sum, map);
    }
	
	public int dfs(TreeNode root, int sum, int target, HashMap<Integer, Integer> map){
		if(root == null){
			return 0;
		}
		
		sum += root.val;
		int res = map.getOrDefault(sum - target, 0);
		map.put(sum, map.getOrDefault(sum, 0) + 1);
		
		res += dfs(root.left, sum, target, map) + dfs(root.right, sum, target, map);
		map.put(sum, map.get(sum) - 1);
		return res;
	}
}
