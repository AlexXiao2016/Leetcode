package tree;

import java.util.*;	

public class ConstructBinaryTreefromPreorderandInorder {
	public static TreeNode buildTree(int[] preorder, int[] inorder) {        
        if(preorder == null || inorder == null || preorder.length != inorder.length || preorder.length == 0){
        	return null;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < inorder.length; i++){
        	map.put(inorder[i], i);
        }
        return buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, map);
        
    }
	
	public static TreeNode buildTree(int[] preorder, int pstart, int pend,int[] inorder, int istart, int iend, HashMap<Integer, Integer> map){
		if(pstart > preorder.length - 1 || istart > iend){
			return null;
		}
		int index = map.get(preorder[pstart]);
		TreeNode root = new TreeNode(preorder[pstart]);
		TreeNode left = buildTree(preorder, pstart + 1, index - 1, inorder, 0, index - 1, map);
		TreeNode right = buildTree(preorder, pstart + index - istart + 1, pend, inorder, index + 1, iend, map);
		root.left = left;
		root.right = right;
		return root;
	}
	
	public static void main(String args[]){
		int a[] = {1, 2};
		int b[] = {2, 1};
		buildTree(a, b);
	}
}
