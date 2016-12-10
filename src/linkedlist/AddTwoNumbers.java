package linkedlist;

public class AddTwoNumbers {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		if (l1 == null && l2 == null)
			return null;

		ListNode res = new ListNode(0);
		ListNode cur = res;
		int sum = 0, value, carry = 0;
		while (l1 != null && l2 != null) {
			sum = l1.val + l2.val + carry;
			value = sum % 10;
			cur.next = new ListNode(value);
			carry = sum / 10;
			cur = cur.next;
			l1 = l1.next;
			l2 = l2.next;
		}

		ListNode node = (l1 == null ? l2 : l1);

		while (node != null) {
			sum = node.val + carry;
			value = sum % 10;
			cur.next = new ListNode(value);
			carry = sum / 10;
			cur = cur.next;
			node = node.next;
		}

		if (carry != 0) {
			cur.next = new ListNode(carry);
		}
		return res.next;
	}

	public static void main(String args[]) {
		ListNode l1 = new ListNode(9);
		ListNode l2 = new ListNode(9);
		l1.next = l2;
		ListNode l3 = new ListNode(1);

		AddTwoNumbers atn = new AddTwoNumbers();
		atn.addTwoNumbers(l1, l3);
	}
}
