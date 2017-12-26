package leetcode;

class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
}

public class AddingTwoNumbers {
	/**
	You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
	*/

	/**
	 * Definition for singly-linked list.
	 * public class ListNode {
	 *     int val;
	 *     ListNode next;
	 *     ListNode(int x) { val = x; }
	 * }
	 */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode a = l1, b = l2, curr = head;
        int carry = 0;
        while (a != null || b != null) {
            int x = 0, y=0;
            if(a != null)
                x = a.val;
            if(b != null)
                y = b.val;
            int sum = carry + x + y;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (a != null) 
                a = a.next;
            if (b != null) 
                b = b.next;
        }
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }
        return head.next;
    }
}
