package tree;

public class LargestBSTSubtree {
	
	private class Result{
		private int size, lower, upper;

		public Result(int size, int lower, int upper){
			this.size = size;
			this.lower = lower;
			this.upper = upper;
		}
	}

	public int largestBSTSubtree(TreeNode root) {
		Result res = traverse(root);
		return Math.abs(res.size);
	}
	
	public Result traverse(TreeNode root){
		if(root == null){
			return new Result(0, Integer.MAX_VALUE, Integer.MIN_VALUE);
		}
		Result left = traverse(root.left);
		Result right = traverse(root.right);
		if(left.size < 0 || right.size < 0 || root.val < left.upper || root.val > right.lower){
			return new Result(-1 * Math.max(Math.abs(left.size), Math.abs(right.size)), 0, 0);
		}else{
			return new Result(left.size + 1 + right.size, Math.min(root.val, left.lower), Math.max(root.val, right.upper));
		}		
	}
	
	
	
	
	public static void main(String args[]){
		TreeNode root = new TreeNode(1);
		TreeNode node1 = new TreeNode(2);
//		TreeNode node2 = new TreeNode(15);
//		TreeNode node3 = new TreeNode(2);
//		TreeNode node4 = new TreeNode(7);
//		TreeNode node5 = new TreeNode(11);
//		TreeNode node6 = new TreeNode(18);
		root.left = node1;
//		root.right = node2;
//		node1.left = node3;
//		node1.right = node4;
//		node2.left = node5;
//		node2.right = node6;
		LargestBSTSubtree tree = new LargestBSTSubtree();
		System.out.print(tree.largestBSTSubtree(root));
	}
}
