package linkedlist;

public class RemoveDuplicatesfromSortedListII {
	public static ListNode deleteDuplicates(ListNode head) {
		if(head == null || head.next == null){
			return head;
		}
		
        ListNode FakeHead=new ListNode(0);
        FakeHead.next=head;
        ListNode pre=FakeHead;
        ListNode cur=head;
        while(cur!=null){
            while(cur.next !=null && cur.val == cur.next.val){
                cur = cur.next;
            }
            if(pre.next == cur){
                pre = pre.next;
            }else{
                pre.next = cur.next;
            }
            cur=cur.next;
        }
        return FakeHead.next;
	}

	public static void main(String args[]){
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(1);
		ListNode node3 = new ListNode(1);
		ListNode node4 = new ListNode(2);
		ListNode node5 = new ListNode(3);
		ListNode node6 = new ListNode(4);
		ListNode node7 = new ListNode(4);
		ListNode node8 = new ListNode(5);

		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		node5.next = node6;
		node6.next = node7;
		node7.next = node8;

		ListNode node  = deleteDuplicates(node1);
		while(node != null){
			System.out.print(node.val + " ");
			node = node.next;
		}
	}
}
