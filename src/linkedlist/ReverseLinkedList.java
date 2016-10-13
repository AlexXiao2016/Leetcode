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
	
	
	public static ListNode reverseListFromMid(ListNode head){
		
		ListNode slow = head;
		ListNode fast = head;
		
		while(fast.next != null && fast.next.next != null){
			slow = slow.next;
			fast = fast.next.next;
		}
		
		ListNode rightHalfHead = slow.next;
		slow.next = null;
		ListNode newHead = null;
		while(rightHalfHead != null){
			ListNode temp = rightHalfHead.next;
			rightHalfHead.next = newHead;
			newHead = rightHalfHead;
			rightHalfHead = temp;			
		}
		slow.next = newHead;		
		return head;
	}
	
	
	public static void main(String args[]){
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(4);
		ListNode n5 = new ListNode(5);
		
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = null;
		
		reverseListFromMid(n1);
		
		while(n1 != null){
			System.out.print(n1.val + " ");	
			n1 = n1.next;
		}
		
		
		
	}
}
