package tree;
import java.util.*;

public class FindLeavesofBinaryTree {
	public List<List<Integer>> findLeaves(TreeNode root) {
		List<List<Integer>> result = new ArrayList<>();
		if(root == null){
			return result;
		}
		
		while(root != null){
			List<Integer> list = new ArrayList<>();
			if(dfs(list, root)) root = null;
			result.add(list);
		}
		
		return result;
		
	}
	
	public boolean dfs(List<Integer> list, TreeNode root){
		if(root.left == null && root.right == null){
			list.add(root.val);
			return true;
		}
		
		if(root.left != null){
			if(dfs(list, root.left)){
				root.left = null;
			}
		}
		
		if(root.right != null){
			if(dfs(list, root.right)){
				root.right = null;
			}
		}
		
		return false;
	}
}
