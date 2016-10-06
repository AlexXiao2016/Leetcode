package linkedlist;

import java.util.Random;

public class LinkedListRandomNode {
	
	public ListNode head;
	
	public LinkedListRandomNode(ListNode head) {
		this.head = head;
	}

	/** Returns a random node's value. */
	public int getRandom() {
		ListNode result = null;
		ListNode curr = head;
		Random random = new Random();
		
		for(int i = 1; curr != null; i++){
			if(random.nextInt(i) == 0){
				result = curr;
			}
			
			curr = curr.next;
		}
		
		return result.val;
	}
}
