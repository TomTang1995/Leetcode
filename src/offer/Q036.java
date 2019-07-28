package offer;

import structures.ListNode;

import java.util.HashSet;
import java.util.Set;

public class Q036
{
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2)
    {
        if(pHead1==null || pHead2==null)
            return null;

        Set<ListNode> set = new HashSet<>();
        while (pHead1 != null)
        {
            set.add(pHead1);
            pHead1 = pHead1.next;
        }

        while (pHead2 != null)
        {
            if(set.contains(pHead2))
                return pHead2;

            pHead2 = pHead2.next;
        }
        return null;
    }

    /*
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2)
    {
        if(pHead1==null || pHead2==null)
            return null;

        int length1=0, length2=0;
        ListNode temp = pHead1;
        while(temp != null)
        {
            length1++;
            temp = temp.next;
        }

        temp = pHead2;
        while(temp != null)
        {
            length2++;
            temp = temp.next;
        }

        if(length1 > length2)
        {
            int diff = length1 - length2;
            while(diff > 0)
            {
                pHead1 = pHead1.next;
                diff--;
            }
        }
        else
        {
            int diff = length2 - length1;
            while(diff > 0)
            {
                pHead2 = pHead2.next;
                diff--;
            }
        }

        while(pHead1!=null && pHead2!=null && pHead1!=pHead2)
        {
            pHead1 = pHead1.next;
            pHead2 = pHead2.next;
        }

        return pHead1==null ? null : pHead1;
    }
    */
}
