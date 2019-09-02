package leetcode;

import structures.ListNode;

public class Q206
{
    public ListNode reverseList(ListNode head)
    {
        if(head==null || head.next==null)
            return head;

        ListNode prev = head;
        ListNode middle = head.next;
        ListNode back = head.next.next;

        prev.next = null;
        while (back != null)
        {
            middle.next = prev;
            prev = middle;
            middle = back;
            back = back.next;
        }
        middle.next = prev;
        return middle;
    }
}
