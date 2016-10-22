package tree;

public class ValidateBinarySearchTree {
	public boolean isValidBST(TreeNode root) {
        return helper(root, null, null);
    }
    
    public boolean helper(TreeNode node, Integer low, Integer high){
        if(node == null){
            return true;
        }
        return (low == null || node.val > low) && (high == null || node.val < high) && helper(node.left, low, node.val) && helper(node.right, node.val, high);
        
    }
}
