package leetcode;

import structures.ListNode;

public class Q141
{
    public boolean hasCycle(ListNode head)
    {
        if(head == null)
            return false;

        ListNode slow = head;
        ListNode quick = head;

        while(quick!=null && quick.next!=null && quick.next.next!=null)
        {
            slow = slow.next;
            quick = quick.next.next;
            if(slow == quick)
                return true;
        }

        return false;
    }
}
