package tree;

public class ClosestBinarySearchTreeValue {
	
	public int closestValue(TreeNode root, double target) {
		int res = root.val;
		while(root != null){
			if(Math.abs(root.val - target) < Math.abs(res - target)){
				res = root.val;
			}
			root = root.val > target ? root.left : root.right;
		}
		
		return res;
	}
	
	
	public int closestValue2(TreeNode root, double target) {
		int result = root.val;
		TreeNode node = root.val > target ? root.left : root.right;
		if(node == null){
			return result;
		}
		int b = closestValue2(node, target);
		return Math.abs(result - target) > Math.abs(b - target)? b : result;
	}

}
