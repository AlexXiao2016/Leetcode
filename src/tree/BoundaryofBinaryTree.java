package tree;

import java.util.*;

public class BoundaryofBinaryTree {
	public List<Integer> boundaryOfBinaryTree(TreeNode root) {
		List<Integer> left = new ArrayList<>();
		List<Integer> right = new ArrayList<>();
		preOrder(root, left, right, 0);
		left.addAll(right);
		return left;
	}

	private void preOrder(TreeNode curr, List<Integer> left, List<Integer> right, int flag) {
		if (curr == null)
			return;
		if (flag == 2)
			right.add(0, curr.val);
		else if (flag <= 1 || curr.left == null && curr.right == null)
			left.add(curr.val);
		preOrder(curr, left, right, flag <= 1 ? 1 : (flag == 2 || curr.right == null) ? 2 : 3);
		preOrder(curr, left, right, flag % 2 == 0 ? 2 : (flag == 1 || curr.left == null) ? 1 : 3);
	}

	List<Integer> result = new ArrayList<>();

	public List<Integer> boundaryOfBinaryTree2(TreeNode root) {
		if (root == null)
			return result;

		result.add(root.val);
		leftBoundary(root.left);
		leaves(root.left);
		leaves(root.right);
		rightBoundary(root.right);

		return result;
	}

	public void leftBoundary(TreeNode curr) {
		if(curr == null || (curr.left == null && curr.right == null)) return;
		result.add(curr.val);
		if(curr.left == null) leftBoundary(curr.right);
		else leftBoundary(curr.left);		
	}

	public void rightBoundary(TreeNode curr) {
		if(curr == null || (curr.left == null && curr.right == null)) return;		
		if(curr.right == null) leftBoundary(curr.left);
		else leftBoundary(curr.right);
		result.add(curr.val);
	}

	public void leaves(TreeNode curr) {
		if(curr == null) return;
		if(curr.left == null && curr.right == null){
			result.add(curr.val);
			return;
		}
		leaves(curr.left);
		leaves(curr.right);
	}
}
