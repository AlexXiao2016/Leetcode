package linkedlist;

import java.util.PriorityQueue;

public class MergekSortedLists {
	public ListNode mergeKLists(ListNode[] lists) {
		if(lists == null || lists.length == 0){
			return null;
		}
		
		PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);
		
		for(ListNode node : lists){
			if(node != null){
				pq.add(node);
			}
		}
		
		ListNode fakeHead = new ListNode(0);
		ListNode curr = fakeHead;
		
		while(!pq.isEmpty()){
			ListNode temp = pq.poll();
			curr.next = temp;
			curr = curr.next;
			
			if(temp.next != null){
				pq.offer(temp);
			}
		}
		
		return fakeHead.next;
	}
}
