package offer;

import java.util.Stack;

public class Q021
{
    public static void main(String[] args)
    {
        int pushA[] = {1,2,3,4,5};
        int popA[] = {4,3,5,2,1};

        Q021 q021 = new Q021();
        System.out.println(q021.IsPopOrder(pushA, popA));
    }

    public boolean IsPopOrder(int [] pushA,int [] popA)
    {
        if(pushA==null || pushA.length==0)
            return true;

        Stack<Integer> stack = new Stack<>();
        int pPushA = 0, pPopA = 0;
        while(pPushA < pushA.length)
        {
            stack.push(pushA[pPushA]);
            pPushA++;

            while(!stack.isEmpty() && stack.peek()==popA[pPopA])
            {
                stack.pop();
                pPopA++;
            }
        }

        while(!stack.isEmpty())
        {
            if(stack.peek() != popA[pPopA])
                return false;
        }

        return true;
    }
}
