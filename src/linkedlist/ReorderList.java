package linkedlist;

public class ReorderList {
	public void reorderList(ListNode head) {
		if(head == null || head.next == null || head.next.next == null){
			return;
		}
		ListNode slow = head, fast = head;
		
		while(fast.next != null && fast.next.next != null){
			slow = slow.next;
			fast = fast.next.next;
		}
		
		ListNode rightNewHead = null;
		ListNode curr = slow.next;
		slow.next = null;
		
		while(curr != null){
			ListNode temp = curr.next;
			curr.next = rightNewHead;
			rightNewHead = curr;
			curr = temp;
		}
		
		curr = head;
		while(curr != null && rightNewHead != null){
			ListNode temp1 = curr.next;
			ListNode temp2 = rightNewHead.next;
			curr.next = rightNewHead;
			rightNewHead.next = temp1;
			curr = temp1;
			rightNewHead = temp2;
		}
		
	}
}
