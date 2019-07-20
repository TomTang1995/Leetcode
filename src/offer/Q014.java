package offer;

import structures.ListNode;

public class Q014
{
    public ListNode FindKthToTail(ListNode head, int k)
    {
        if(head==null || k<=0)
            return null;

        ListNode tempHead = new ListNode(0);
        tempHead.next = head;

        ListNode tail = tempHead;

        while(tail!=null && k>0)
        {
            tail = tail.next;
            k--;
        }

        if(tail == null)
            return null;

        while(tail != null)
        {
            tempHead = tempHead.next;
            tail = tail.next;
        }

        return tempHead;
    }
}
