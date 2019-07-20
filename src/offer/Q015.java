package offer;

import structures.ListNode;

public class Q015
{
    public ListNode ReverseList(ListNode head)
    {
        if(head==null || head.next==null)
            return head;

        ListNode front=head, middle=head.next, end=head.next.next;
        head.next = null;
        while(end != null)
        {
             middle.next = front;
             front = middle;
             middle = end;
             end = end.next;
        }

        middle.next = front;
        return middle;
    }
}
