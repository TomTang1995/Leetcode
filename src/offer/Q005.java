package offer;

import java.util.Stack;

public class Q005
{
    //push
    Stack<Integer> stack1 = new Stack<Integer>();
    //temp
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node)
    {
        stack1.push(node);
    }

    public int pop()
    {
        if(stack1.isEmpty())
            return -1;
        else if(stack1.size() == 1)
            return stack1.pop();

        while(stack1.size() > 1)
            stack2.push(stack1.pop());

        int result = stack1.pop();

        while(!stack2.isEmpty())
            stack1.push(stack2.pop());

        return result;
    }
}
