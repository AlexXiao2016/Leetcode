package tree;

public class CountUnivalueSubtrees {
	public int countUnivalSubtrees(TreeNode root) {
		int[] res = new int[1];
		helper(res, root);
		return res[0];
	}
	
	public boolean helper(int[] res, TreeNode node){
		if(node == null){
			return true;
		}
		
		boolean left = helper(res, node.left);
		boolean right = helper(res, node.right);
		if(left && right){
			if(node.left != null && node.left.val != node.val) return false;
			if(node.right != null && node.right.val != node.val) return false;
			res[0]++;
			return true;
		}
		return false;
	}
}
