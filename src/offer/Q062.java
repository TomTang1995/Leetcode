package offer;

import structures.TreeNode;

import java.util.Stack;

public class Q062
{
    public TreeNode KthNode(TreeNode pRoot, int k)
    {
        if(pRoot==null || k<=0)
            return null;

        int count = 0;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = pRoot;
        while(!stack.isEmpty() || current!=null)
        {
            while(current != null)
            {
                stack.push(current);
                current = current.left;
            }

            current = stack.pop();
            count++;
            if(count == k)
                return current;

            current = current.right;
        }

        return null;
    }
}
