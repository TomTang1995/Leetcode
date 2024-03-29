package leetcode;

import structures.ListNode;

public class Q021
{
    public ListNode mergeTwoLists(ListNode l1, ListNode l2)
    {
        if(l1 == null)
            return l2;
        else if(l2 == null)
            return l1;

        ListNode head;
        if(l1.val < l2.val)
        {
            head = l1;
            l1 = l1.next;
        }
        else
        {
            head = l2;
            l2 = l2.next;
        }

        ListNode current = head;
        while(l1!=null && l2!=null)
        {
            if(l1.val < l2.val)
            {
                current.next = l1;
                l1 = l1.next;
            }
            else
            {
                current.next = l2;
                l2 = l2.next;
            }
            current = current.next;
        }

        if(l1 == null)
            current.next = l2;
        else
            current.next = l1;

        return head;
    }
}
