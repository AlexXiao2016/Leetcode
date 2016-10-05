package Tree;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths {
	public List<String> binaryTreePaths(TreeNode root) {
        
		String s = "";
		List<String> list = new ArrayList<>();
		if(root == null){
	        return list;
   	    }else{
			s += root.val;
		}
		
		if(root.left == null && root.right == null){
		    list.add(s);
		}
		if(root.left != null){
			treePathHelper(root.left, s, list);
		}
		if(root.right != null){
			treePathHelper(root.right, s, list);
		}
		
		return list;
	}	


	public void treePathHelper(TreeNode node, String s, List<String> list){
		if(node != null){
			s += "->" + node.val;
		}
		if(node.left == null && node.right == null){
			list.add(s);
		}
		if(node.left != null){
		    treePathHelper(node.left, s, list);
		}
		if(node.right != null){
		    treePathHelper(node.right, s, list);
		}
	}

}

