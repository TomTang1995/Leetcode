package offer;

import structures.ListNode;

public class Q056
{
    public ListNode deleteDuplication(ListNode pHead)
    {
        if(pHead==null || pHead.next==null)
            return pHead;

        ListNode newHead = new ListNode(Integer.MIN_VALUE);
        newHead.next = pHead;

        ListNode currentNode = newHead;
        ListNode nextNode = newHead.next;
        int currentInt = nextNode.val;

        while(nextNode != null)
        {
            if(nextNode.next == null)
                break;
            else if(nextNode.next.val == currentInt)    //duplicate
            {
                while(nextNode!=null && nextNode.val==currentInt)
                    nextNode = nextNode.next;

                if(nextNode == null)
                {
                    currentNode.next = null;
                    break;
                }

                currentNode.next = nextNode;
                currentInt = nextNode.val;
            }
            else    //no duplicate
            {
                currentNode = currentNode.next;
                nextNode = nextNode.next;
                currentInt = nextNode.val;
            }
        }

        return newHead.next;
    }
}
