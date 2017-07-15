package tree;
import java.util.*;

public class CountUnivalueSubtrees {
	public int countUnivalSubtrees(TreeNode root) {
		int[] res = new int[1];
		helper(res, root);
		return res[0];
	}
	
	public boolean helper(int[] res, TreeNode node){
		if(node == null){
			return true;
		}
		
		boolean left = helper(res, node.left);
		boolean right = helper(res, node.right);
		if(left && right){
			if(node.left != null && node.left.val != node.val) return false;
			if(node.right != null && node.right.val != node.val) return false;
			res[0]++;
			return true;
		}
		return false;
	}

	public int countUnivalSubtrees2(TreeNode root) {
		HashMap<Integer, Integer> map = new HashMap<>();
		getValue(root, map);

		System.out.println(map.size());
		int res = 0;
		for(int key : map.keySet()){
			if(map.get(key) == 1){
				res++;
			}
		}

		return res;
	}

	private int getValue(TreeNode root, HashMap<Integer, Integer> map){
		if(root == null)    return 0;


		int left = getValue(root.left, map);
		map.put(left, map.getOrDefault(left, 0) + 1);
		int right = getValue(root.right, map);
		map.put(right, map.getOrDefault(right, 0) + 1);
		int sum = left + root.val + right;
		map.put(sum, map.getOrDefault(sum, 0) + 1);
		return sum;
	}

	public static void main(String[] args){
		TreeNode root = new TreeNode(5);
		TreeNode left = new TreeNode(1);
		TreeNode right = new TreeNode(5);
		TreeNode left_l = new TreeNode(5);
		TreeNode left_r = new TreeNode(5);
		TreeNode right_r = new TreeNode(5);

		root.left = left;
		root.right = right;
		left.left = left_l;
		left.right = left_r;
		right.right = right_r;

		CountUnivalueSubtrees cs = new CountUnivalueSubtrees();
		cs.countUnivalSubtrees2(root);
	}
}
