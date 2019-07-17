package leetcode;

import structures.ListNode;

public class Q023
{
    public ListNode mergeKLists(ListNode[] lists)
    {
        if(lists==null || lists.length==0)
            return null;

        ListNode head = lists[0];
        for(int i = 1;i < lists.length;i++)
            head = mergeList(head, lists[i]);

        return head;
    }

    private ListNode mergeList(ListNode list1, ListNode list2)
    {
        ListNode tempHead = new ListNode(0);
        ListNode current = tempHead;

        while(list1!=null && list2!=null)
        {
            if(list1.val < list2.val)
            {
                current.next = list1;
                list1 = list1.next;
            }
            else
            {
                current.next = list2;
                list2 = list2.next;
            }
            current = current.next;
        }

        current.next = list1==null ? list2 : list1;
        return tempHead.next;
    }
}
