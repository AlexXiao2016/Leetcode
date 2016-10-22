package tree;

public class ConvertSortedListtoBinarySearchTree {
	public static TreeNode sortedListToBST(ListNode head){
		return sortedListToBST(head, null);
	}
	
	public static TreeNode sortedListToBST(ListNode head, ListNode end){
		if(head == end){
			return null;
		}
		ListNode slow = head, fast = head;
		while(fast.next != end && fast.next.next != end){
			slow = slow.next;
			fast = fast.next.next;
		}
		
		TreeNode node = new TreeNode(slow.val);
		node.left = sortedListToBST(head, slow);
		node.right = sortedListToBST(slow.next, end);
		return node;
	}
	
	public static void preOrderTraverse(TreeNode node){
		if(node == null){
			return;
		}else{
			System.out.print(node.val + " ");
			preOrderTraverse(node.left);
			preOrderTraverse(node.right);
		}
	}
	
	public static void main(String args[]){
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(4);
		ListNode n5 = new ListNode(5);
		ListNode n6 = new ListNode(6);
		ListNode n7 = new ListNode(7);
		
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = n6;
		n6.next = n7;
		n7.next = null;
		
		TreeNode head = sortedListToBST(n1);
		preOrderTraverse(head);
		
		
	}
}


class ListNode {
	int val;
	ListNode next;
	ListNode(int x) { 
		val = x;
		}
}
