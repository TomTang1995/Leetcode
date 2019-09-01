package leetcode;

import structures.ListNode;

public class Q160
{
    public ListNode getIntersectionNode(ListNode headA, ListNode headB)
    {
        if(headA==null || headB==null)
            return null;

        ListNode temp = headA;
        int lengthA = 0;
        while(temp != null)
        {
            temp = temp.next;
            lengthA++;
        }

        temp = headB;
        int lengthB = 0;
        while(temp != null)
        {
            temp = temp.next;
            lengthB++;
        }

        if(lengthA > lengthB)
        {
            temp = headA;
            int diff = Math.abs(lengthA - lengthB);
            while(diff > 0)
            {
                temp = temp.next;
                diff--;
            }
            while(temp != headB)
            {
                temp = temp.next;
                headB = headB.next;
            }
        }
        else
        {
            temp = headB;
            int diff = Math.abs(lengthA - lengthB);
            while(diff > 0)
            {
                temp = temp.next;
                diff--;
            }
            while(temp != headA)
            {
                temp = temp.next;
                headA = headA.next;
            }
        }

        return temp;
    }
}
