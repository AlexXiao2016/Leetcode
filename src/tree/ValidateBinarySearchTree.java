package tree;
import java.util.*;

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
    
    public boolean isValidBSTInOrder(TreeNode root){
    	if(root == null) return true;
    	
    	Stack<TreeNode> stack = new Stack<>();
    	TreeNode cur = root;
    	
    	while(cur != null){
    		stack.push(cur);
    		cur = cur.left;
    	}
    	
    	TreeNode pre = null;
    	while(!stack.isEmpty()){
    		TreeNode temp = stack.pop();
    		if(pre != null && pre.val >= temp.val) return false;
    		pre = temp;
    		if(temp.right != null){
    			TreeNode right = temp.right;
    			
    			while(right != null){
    				stack.push(right);
    				right = right.left;
    			}
    		}
    	}
    	return true;
    }
    
    public static void main(String args[]){
    	TreeNode root = new TreeNode(2);
    	TreeNode t1 = new TreeNode(2);
//    	TreeNode t2 = new TreeNode(3);
    	
    	root.left = t1;
//    	root.right = t2;
    	ValidateBinarySearchTree vBst = new ValidateBinarySearchTree();
    	vBst.isValidBSTInOrder(root);
    }
}
