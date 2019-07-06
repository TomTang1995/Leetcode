package offer;

import structures.ListNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class Q003
{
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode)
    {
        ArrayList<Integer> list = new ArrayList<>();

        while (listNode != null)
        {
            list.add(listNode.val);
            listNode = listNode.next;
        }

        Collections.reverse(list);
        return list;

        /*
        Stack<Integer> stack = new Stack<>();
        while(listNode != null)
        {
            stack.add(listNode.val);
            listNode = listNode.next;
        }

        while(!stack.isEmpty())
            list.add(stack.pop());

        return list;
        */
    }
}
