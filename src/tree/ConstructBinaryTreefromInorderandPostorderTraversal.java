package tree;

import java.util.*;

public class ConstructBinaryTreefromInorderandPostorderTraversal {
	public static TreeNode buildTreePostIn(int[] inorder, int[] postorder) {
        if(inorder == null || postorder == null || inorder.length != postorder.length || inorder.length == 0){
        	return null;
        }
        HashMap<Integer, Integer> indexMap = new HashMap<>();
        for(int i = 0; i < inorder.length; i++){
        	indexMap.put(inorder[i], i);
        }        
        return buildTreePostIn(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1, indexMap);
    }
	
	
	public static TreeNode buildTreePostIn(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd, HashMap<Integer, Integer> map){
		if(inStart > inEnd || postStart > postEnd){
			return null;
		}
		TreeNode root = new TreeNode(postorder[postEnd]);
		int index = map.get(root.val);
		TreeNode left = buildTreePostIn(inorder, inStart, index - 1, postorder, postStart, postStart + index - inStart + 1, map);
		TreeNode right = buildTreePostIn(inorder, index + 1, inEnd, postorder, postStart + index - inStart, postEnd - 1, map);
		root.left = left;
		root.right = right;
		return root;
	}
	
	public static void main(String args[]){
		int[] a = {};
		int[] b = {};
		
		buildTreePostIn(a, b);		
	}
}
