package tree;

import java.util.*;

public class FindBottomLeftTreeValue {
	public static int findBottomLeftValue(TreeNode root) {
        int res = root.val;
        
        Queue<TreeNode> queue = new LinkedList<>();
        
        queue.offer(root);
        while(!queue.isEmpty()){
            res = queue.peek().val;
            int size = queue.size();
            for(int i = 0; i < size; i++){
                TreeNode node = queue.poll();
                if(node.left != null) queue.offer(node.left);
                if(node.right != null) queue.offer(node.right);
            }
        }
        
        return res;
    }
	
	
	public static int findBottomLeftValue2(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        
        int res = root.val;
        while(!queue.isEmpty()){
            res = queue.peek().val;
            for(int i = 0; i < queue.size(); i++){
                TreeNode cur = queue.poll();
                if(cur.left != null) queue.add(cur.left);
                if(cur.right != null) queue.add(cur.right);
            }
        }
        return res;
    }
	
	public static void main(String args[]){
		TreeNode root = new TreeNode(1);
		TreeNode node1 = new TreeNode(2);
		TreeNode node2 = new TreeNode(3);
		
		root.left = node1;
		root.right = node2;
		
		findBottomLeftValue2(root);
		
	}
}
