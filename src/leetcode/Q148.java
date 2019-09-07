package leetcode;

import structures.ListNode;

public class Q148
{
    public ListNode sortList(ListNode head)
    {
        if(head==null || head.next==null)
            return head;

        ListNode prev = null, nextHead = head, tail = head;
        while(tail!=null && tail.next!=null)
        {
            prev = nextHead;
            nextHead = nextHead.next;
            tail = tail.next.next;
        }

        prev.next = null;
        ListNode head1 = sortList(head);
        ListNode head2 = sortList(nextHead);
        return merge(head1, head2);
    }

    public ListNode merge(ListNode head1, ListNode head2)
    {
        ListNode head = new ListNode(0);
        ListNode current = head;

        while(head1!=null && head2!=null)
        {
            if(head1.val <= head2.val)
            {
                current.next = head1;
                head1 = head1.next;
            }
            else
            {
                current.next = head2;
                head2 = head2.next;
            }
            current = current.next;
        }

        current.next = head1==null ? head2 : head1;
        return head.next;
    }
}
