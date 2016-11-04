package linkedlist;

public class RemoveNthNodeFromEndofList {
	public ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode newHead = new ListNode(0);
		newHead.next = head;
        ListNode slow = newHead, fast = newHead;		
		
		
		for(int i = 0; i < n + 1; i++){
			fast = fast.next;
		}
		
		while(fast != null){
			fast = fast.next;
			slow = slow.next;
		}
		
		slow.next = slow.next.next;		
		
		return newHead.next;
	}
}
