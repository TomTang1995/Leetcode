package leetcode;

import structures.ListNode;

import java.util.Stack;

public class Q234
{
    public boolean isPalindrome(ListNode head)
    {
        if(head == null)
            return true;

        Stack<ListNode> stack = new Stack<>();
        ListNode current = head;
        while(current != null)
        {
            stack.push(current);
            current = current.next;
        }

        current = head;
        while(!stack.isEmpty())
        {
            if(current.val != stack.pop().val)
                return false;

            current = current.next;
        }

        return current == null;
    }
}
