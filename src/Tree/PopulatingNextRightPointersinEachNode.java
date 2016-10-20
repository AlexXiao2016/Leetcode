package Tree;

import java.util.*;

public class PopulatingNextRightPointersinEachNode {
	public void connect(TreeLinkNode root) {
		if(root == null){
			return;
		}
		
		Queue<TreeLinkNode> queue = new LinkedList<>();
		TreeLinkNode pre = null;
		queue.add(root);
		while(!queue.isEmpty()){
			int size = queue.size();
			for(int i = 0; i < size; i++){
				TreeLinkNode curr = queue.poll();
				if(i == size - 1){
					curr.next = null;
				}
				if(i != 0){
					pre.next = curr;
				}
				if(curr.left != null){
					queue.offer(curr.left);
				}
				if(curr.right != null){
					queue.offer(curr.right);
				}
				pre = curr;
			}			
		}
	}
	
	
}


class TreeLinkNode {
	int val;
	TreeLinkNode left, right, next;
	TreeLinkNode(int x) { val = x; }
 }