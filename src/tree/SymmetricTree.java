package tree;
import java.util.*;

public class SymmetricTree {
	public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;                      
        return isSymmetricSubTree(root.left, root.right);
    }
	
	public boolean isSymmetricSubTree(TreeNode left, TreeNode right){
		if(left == null || right == null)  return left == right;
		if(left.val != right.val) return false;
		return isSymmetricSubTree(left.right, right.left) && isSymmetricSubTree(left.left, right.right);
	}
	
	public boolean isSymmetric2(TreeNode root){
		if(root == null) return true;
		
		if(root.left == null || root.right == null) return root.left == root.right;
		
		Stack<TreeNode> s = new Stack<>();
		s.push(root.left);
		s.push(root.right);
		
		TreeNode right, left;
		while(!s.isEmpty()){
			if(s.size() % 2 != 0) return false;
			right = s.pop();
			left = s.pop();
			if(right.val != left.val) return false;
			
			if(left.left != null){
				if(right.right == null) return false;
				s.push(left.left);
				s.push(right.right);
			}else if(right.right != null){
				return false;
			}
			
			if(left.right != null){
				if(right.left == null) return false;
				s.push(left.right);
				s.push(right.left);
			}else if(right.left != null){
				return false;
			}			
		}
		return true;
	}
	
	public static void main(String args[]){
		TreeNode root = new TreeNode(1);
		TreeNode n1 = new TreeNode(2);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(3);
//		TreeNode n4 = new TreeNode(4);
//		TreeNode n5 = new TreeNode(4);
		TreeNode n6 = new TreeNode(3);
		
		root.left = n1;
		root.right = n2;
		n1.right = n3;
//		n1.right = n4;
//		n2.left = n5;
		n2.right = n6;
		SymmetricTree st = new SymmetricTree();
		st.isSymmetric(root);
		
	}
}
