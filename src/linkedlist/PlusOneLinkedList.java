package linkedlist;

public class PlusOneLinkedList {
	public static ListNode plusOne(ListNode head) {
        ListNode newHead = reverseLinkedList(head);
        ListNode curr = newHead;
        
        int carry = 0;
        while(curr != null){
            int sum = curr.val + carry;
            if(curr == newHead) sum += 1;
            curr.val = sum % 10;
            carry = sum / 10;
            if(curr.next == null && carry == 1){
                ListNode node = new ListNode(1);
                node.next = null;
                curr.next = node;
                break;
            }
            curr = curr.next;
        }
        
        return reverseLinkedList(newHead);
    }
    
    private static ListNode reverseLinkedList(ListNode head){
        ListNode newHead = null;
        
        while(head != null){
            ListNode temp = head.next;
            head.next = newHead;
            newHead = head;
            head = temp;
        }
        
        return newHead;
    }
    
    
    public static ListNode plusOne1(ListNode head){
    	ListNode newHead = new ListNode(0);
        newHead.next = head;
        ListNode nonNine = newHead;
        ListNode cur = newHead;
        
        while(cur.next != null){
            cur = cur.next;
            if(cur.val != 9){
                nonNine = cur;
            }
        }
        
        nonNine.val++;
        cur = nonNine.next;
        while(cur != null){
            cur.val = 0;
            cur = cur.next;
        }
        
        if(newHead.val == 0) return newHead.next;
        return newHead;
    }
    
    public static void main(String args[]){
    	ListNode head = new ListNode(9);
    	plusOne1(head);
    }
    
}
