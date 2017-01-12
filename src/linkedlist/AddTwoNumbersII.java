package linkedlist;
import java.util.*;

public class AddTwoNumbersII {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		Stack<ListNode> s1 = new Stack<>(); 
		Stack<ListNode> s2 = new Stack<>();
		
		ListNode cur = l1;
		while(cur != null){
			s1.push(cur);
			cur = cur.next;
		}
		
		cur = l2;
		while(cur != null){
			s2.push(cur);
			cur = cur.next;
		}
		
		ListNode head = null;
		int carry = 0, num = 0, sum = 0;
		while(!s1.isEmpty() || !s2.isEmpty()){			
			if(s1.isEmpty()){
				sum = s2.pop().val + carry;			
			}else if(s2.isEmpty()){
				sum = s1.pop().val + carry;				
			}else{
				sum = s1.pop().val + s2.pop().val + carry;
			}
			num = sum % 10;
			carry = sum / 10;
			ListNode node = new ListNode(num);
			node.next = head;
			head = node;
		}
		
		if(carry == 1){
		    ListNode node = new ListNode(1);
			node.next = head;
			head = node;
		}
		
		return head;
	}
}
