package linkedlist;

public class ReverseLinkedList {
	public ListNode reverseList(ListNode head) {

		ListNode newHead = null;

		while(head != null){
			ListNode tmp = head.next;
			head.next = newHead;
			newHead = head;
			head = tmp;
		}
		
		return newHead;
	}
	
	
	public ListNode reverseListFromMid(ListNode head){
		
		ListNode slow = head;
		ListNode fast = head;
		
		while(fast != null){
			slow = slow.next;
			fast = fast.next.next;
		}
		
		fast = slow;
		ListNode midHead = null;
		while(slow.next != null){
			ListNode temp = slow.next.next;
			
		}
		
		
		return head;
	}
}
