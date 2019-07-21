package offer;

import java.util.Stack;

public class Q020
{
    Stack<minStackNode> stack = new Stack<>();

    public void push(int node)
    {
        if(stack.isEmpty())
            stack.push(new minStackNode(node, node));
        else
            stack.push(new minStackNode(node, node < stack.peek().min ? node : stack.peek().min));
    }

    public void pop()
    {
        if(!stack.isEmpty())
            stack.pop();
    }

    public int top()
    {
        return stack.isEmpty() ? 0 : stack.peek().data;
    }

    public int min()
    {
        return stack.peek().min;
    }

    //static inner-class
    public static class minStackNode
    {
        int data;
        int min;

        public minStackNode(int data, int min)
        {
            this.data = data;
            this.min = min;
        }
    }
}
