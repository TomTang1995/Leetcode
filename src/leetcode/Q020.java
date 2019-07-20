package leetcode;

import java.util.Stack;

public class Q020
{
    public boolean isValid(String s)
    {
        Stack<Character> stack = new Stack<>();
        for(int i = 0;i < s.length();i++)
        {
            if(s.charAt(i)=='(' || s.charAt(i)=='[' || s.charAt(i)=='{')
                stack.push(s.charAt(i));
            else
            {
                if(stack.isEmpty())
                    return false;

                if((s.charAt(i)==')' && stack.peek()=='(')||(s.charAt(i)==']' && stack.peek()=='[')||(s.charAt(i)=='}' && stack.peek()=='{'))
                    stack.pop();
                else
                    return false;
            }
        }

        return stack.isEmpty() ? true : false;
    }
}