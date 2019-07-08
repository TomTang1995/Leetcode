package leetcode;

import structures.ListNode;

public class Q002
{
    public ListNode addTwoNumbers(ListNode l1, ListNode l2)
    {
        boolean hasMore = false;
        ListNode head = new ListNode(0);
        head.next = null;
        ListNode current = head;
        while(l1!=null || l2!=null)
        {
            int sum = (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val) + (hasMore ? 1 : 0);
            current.next = new ListNode(sum % 10);
            hasMore = sum >= 10 ? true : false;
            current = current.next;
            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
        }

        if(hasMore)
        {
            current.next = new ListNode(1);
            current.next.next = null;
        }
        else
            current.next = null;

        return head.next;
    }
}
