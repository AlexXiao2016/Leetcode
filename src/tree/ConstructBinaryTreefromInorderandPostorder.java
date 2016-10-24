package tree;

import java.util.*;

public class ConstructBinaryTreefromInorderandPostorder {
	public static TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder == null || postorder == null || inorder.length != postorder.length || inorder.length == 0){
        	return null;
        }
        HashMap<Integer, Integer> indexMap = new HashMap<>();
        for(int i = 0; i < inorder.length; i++){
        	indexMap.put(inorder[i], i);
        }        
        return buildTree(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1, indexMap);
    }
	
	
	public static TreeNode buildTree(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd, HashMap<Integer, Integer> map){
		if(inStart > inEnd || postStart > postEnd){
			return null;
		}
		TreeNode root = new TreeNode(postorder[postEnd]);
		int index = map.get(root.val);
		TreeNode left = buildTree(inorder, inStart, index - 1, postorder, postStart, postStart + index - inStart - 1, map);
		TreeNode right = buildTree(inorder, index + 1, inEnd, postorder, postStart + index - inStart, postEnd - 1, map);
		root.left = left;
		root.right = right;
		return root;
	}
	
	public static void main(String args[]){
		int[] a = {2, 1};
		int[] b = {2, 1};
		
		buildTree(a, b);		
	}
}
