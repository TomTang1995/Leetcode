package leetcode;

import structures.ListNode;

public class Q019
{
    public ListNode removeNthFromEnd(ListNode head, int n)
    {
        ListNode tempHead = new ListNode(0);
        tempHead.next = head;

        ListNode front = head;
        ListNode tail = head;
        ListNode prev = tempHead;

        for(int i = 1;i < n;i++)
        {
            if(tail == null)
                return null;
            else
                tail = tail.next;
        }

        while(tail.next != null)
        {
            prev = front;
            front = front.next;
            tail = tail.next;
        }

        prev.next = prev.next.next;
        return tempHead.next;
    }
}
