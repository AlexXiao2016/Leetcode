package linkedlist;

public class PartitionList {
	public static ListNode partition(ListNode head, int x) {
        ListNode preHeadLess = new ListNode(0);
        ListNode preHeadNoLess = new ListNode(0);
        
        preHeadLess = head;
        preHeadNoLess = head;
        
        ListNode tempHead1 = preHeadLess;
        ListNode tempHead2 = preHeadNoLess;
        
        while(head != null){
        	if(head.val < x){
        		preHeadLess.next = head;
        		preHeadLess = head;
        	}else{
        		preHeadNoLess.next = head;
        		preHeadNoLess = head;
        	}
        	head = head.next;
        }
        preHeadNoLess.next = null;
        preHeadLess.next =  tempHead2.next;
        
        
        
        return tempHead1.next;
    }
	
	public static void main(String args[]){
		ListNode a = new ListNode(1);
		ListNode b = new ListNode(4);
		ListNode c = new ListNode(3);
		ListNode d = new ListNode(2);
		ListNode e = new ListNode(5);
		ListNode f = new ListNode(2);
		
		a.next = b;
		b.next = c;
		c.next = d;
		d.next = e;
		e.next = f;
		f.next = null;
		
		partition(a,3);
		System.out.println(a);
	}
}
