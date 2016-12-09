package tree;

import java.util.*;

public class LowestCommonAncestorofaBinaryTree {
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if(root == null || p == null || q == null){
			return null;
		}
		HashMap<TreeNode, TreeNode> parents = new HashMap<>();
		Stack<TreeNode> stack = new Stack<>();
		
		parents.put(root, null);
		stack.push(root);
		
		while(!parents.containsKey(p) || !parents.containsKey(q)){
			TreeNode node = stack.pop();
			if(node.left != null){
				parents.put(node.left, node);
				stack.push(node.left);
			}
			if(node.right != null){
				parents.put(node.right, node);
				stack.push(node.right);
			}			
		}
		Set<TreeNode> ancestors = new HashSet<>();
		while(p != null){
			ancestors.add(p);
			p = parents.get(p);
		}
		while(!ancestors.contains(q)){
			q = parents.get(q);
		}
		return q;	
	}
	
	
	//Recurssive
	public TreeNode lowestCommonAncestorRes(TreeNode root, TreeNode p, TreeNode q) {
		if(root == null || root == p || root == q) return root;
		
		TreeNode left = lowestCommonAncestorRes(root.left, p, q);
		TreeNode right = lowestCommonAncestorRes(root.right, p, q);
		if(left != null && right != null) return root;
		return left == null ? right : left;
	}
}
