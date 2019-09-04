package leetcode;

import structures.ListNode;

public class Q237
{
    public void deleteNode(ListNode node)
    {
        if(node!=null && node.next!=null)
        {
            node.val = node.next.val;
            node.next = node.next.next;
        }
    }
}
