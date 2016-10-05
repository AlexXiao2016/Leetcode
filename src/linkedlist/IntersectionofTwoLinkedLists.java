package linkedlist;

import java.util.HashMap;

public class IntersectionofTwoLinkedLists {
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		if(headA == null || headB == null){
			return null;
		}
		
		HashMap<ListNode, Boolean> map = new HashMap<>();
		
		while(headA != null){
			if(!map.containsKey(headA)){
				map.put(headA, true);
			}
			headA = headA.next;
		}
		
		while(headB != null){
			if(map.containsKey(headB)){
				return headB;
			}
			headB = headB.next;
		}
		
		
		return null;
	}
}


class ListNode {
	int val;
	ListNode next;
	ListNode(int x) {
		val = x;
		next = null;
	}
}