package linkedlist;

public class ReverseNodesinkGroup {
	public static ListNode reverseKGroup(ListNode head, int k) {
		if(head == null || head.next == null || k <= 1) return head;
		
		ListNode dummy = new ListNode(0);
		ListNode prev = dummy, tail = dummy, temp;
		dummy.next = head;
		
		
		while(true){			
			int len = 0;
			while(tail != null && len < k){
				tail = tail.next;
				len++;
			}			
			if(tail == null) break;
			
			head = prev.next;
			
			while(prev.next != tail){
				temp = prev.next;
				prev.next = temp.next;
				temp.next = tail.next;
				tail.next = temp;
			}
			
			tail = head;
			prev = head;
		}
		
		return dummy.next;
	}
	
	public static void main(String args[]){
		ListNode head = new ListNode(1);
		ListNode n1 = new ListNode(2);
		ListNode n2 = new ListNode(3);
		ListNode n3 = new ListNode(4);
		ListNode n4 = new ListNode(5);
		
		head.next = n1;
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		
		reverseKGroup(head, 2);
	}
}
