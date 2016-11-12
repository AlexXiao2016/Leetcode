package tree;

public class LongestConsecutiveSequence {
	int max = 0;
	
	public int longestConsecutive(TreeNode root) {
		if(root == null) return 0;
		dfs(root, 0, root.val);
		return max;
	}
	
	public void dfs(TreeNode node, int cur, int target){
		if(node == null) return;
		if(node.val == target){
			cur++;
		}else{
			cur = 1;
		}
		max = Math.max(cur, max);
		dfs(node.left, cur, node.val + 1);
		dfs(node.right, cur, node.val + 1);	
	}
	
}
