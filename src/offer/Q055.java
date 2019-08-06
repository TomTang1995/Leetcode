package offer;

import structures.ListNode;

public class Q055
{
    public ListNode EntryNodeOfLoop(ListNode pHead)
    {
        if(pHead == null)
            return null;

        ListNode slow=pHead, quick=pHead;

        do {
            if(quick.next==null || quick.next.next==null)
                return null;

            slow = slow.next;
            quick = quick.next.next;
        } while(slow != quick);

        slow = pHead;
        while(slow != quick)
        {
            slow = slow.next;
            quick = quick.next;
        }
        return slow;
    }
}
