package tree;

public class CountCompleteTreeNodes {
	public int countNodes(TreeNode root) {
		int left = leftDepth(root);
		int right = rightDepth(root);
		
		if(left == right){
			return (1 << left) - 1;
		}
		
		return 1 + countNodes(root.left) + countNodes(root.right);
	}
	
	private int leftDepth(TreeNode root){
		int depth = 0;
		while(root != null){
			root = root.left;
			depth++;
		}
		return depth;
	}
	
	private int rightDepth(TreeNode root){
		int depth = 0;
		while(root != null){
			root = root.right;
			depth++;
		}
		return depth;
	}
}
