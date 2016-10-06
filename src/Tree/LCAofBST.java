package Tree;

public class LCAofBST {

	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if(root == null || p == null || q == null){
			return null;
		}
		if(p.val < root.val && q.val < root.val){
			return lowestCommonAncestor(root.left, p, q);
		}else if(p.val > root.val && q.val > root.val){
			return lowestCommonAncestor(root.left, p, q);
		}else{
			return root;
		}
	}
}


// Definition for a binary tree node.
class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }
}

