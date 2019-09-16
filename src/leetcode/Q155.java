package leetcode;

import java.util.Stack;

// A complex solution
public class Q155
{
    static class StackNode
    {
        int min;
        int data;

        public StackNode()
        {

        }

        public StackNode(int min, int data)
        {
            this.min = min;
            this.data = data;
        }
    }

    Stack<StackNode> stack;

    public Q155()
    {
        stack = new Stack<>();
    }

    public void push(int x)
    {
        int min = stack.isEmpty() ? x : (x < stack.peek().min ? x : stack.peek().min);
        int data = x;
        StackNode stackNode = new StackNode(min, data);
        stack.push(stackNode);
    }

    public void pop()
    {
        stack.pop();
    }

    public int top()
    {
        return stack.peek().data;
    }

    public int getMin()
    {
        return stack.peek().min;
    }
}