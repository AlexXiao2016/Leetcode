package tree;

public class BinaryTreeMaximumPathSum {
	
	private int max = Integer.MIN_VALUE;
	
	public int maxPathSum(TreeNode root) {
        helper(root);
        return max;
    }
	
	public int helper(TreeNode node){
		if(node == null) return 0;
		int left = Math.max(0, helper(node.left));
		int right = Math.max(0, helper(node.right));
		max = Math.max(max, left + right + node.val);
		return Math.max(left, right) + node.val;
	}
}
