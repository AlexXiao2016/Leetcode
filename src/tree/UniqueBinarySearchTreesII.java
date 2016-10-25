package tree;

import java.util.*;

public class UniqueBinarySearchTreesII {
	public static List<TreeNode> generateTrees(int n) {
		if(n == 0){
			return new ArrayList<TreeNode>();
		}
		return generateTrees(1, n);
	}
	
	public static List<TreeNode> generateTrees(int start, int end){
		ArrayList<TreeNode> result = new ArrayList<>();
		if(start > end){
			result.add(null);
			return result;
		}
		for(int i = start; i <= end; i++){
			List<TreeNode> lefts = generateTrees(start, i - 1);
			List<TreeNode> rights = generateTrees(i + 1, end);
			
			for(TreeNode left : lefts){
				for(TreeNode right : rights){
					TreeNode temp = new TreeNode(i);
					temp.left = left;
					temp.right = right;
					result.add(temp);
				}
			}
		}
		return result;
	}
	
	public static void main(String args[]){
		generateTrees(3);
	}
}
