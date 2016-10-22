package Tree;

public class HouseRobberIII {
	public int rob(TreeNode root) {
		int result[] = dfsRob(root);
		return Math.max(result[0], result[1]);
	}	
	
	public int[] dfsRob(TreeNode root){
		if(root == null){
			return new int[2];
		}
		
		int[] left = dfsRob(root.left);
		int[] right = dfsRob(root.right);
		
		int result[] = new int[2];
		result[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
		result[1] = root.val + left[0] + right[0];
		
		return result;	
	}
}
