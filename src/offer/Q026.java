package offer;

import structures.TreeNode;

import java.util.Stack;

public class Q026
{
    public TreeNode Convert(TreeNode pRootOfTree)
    {
        TreeNode newHead = null;
        TreeNode pre = null;

        if(pRootOfTree == null)
            return null;

        TreeNode temp = pRootOfTree;
        while (temp.left != null)
            temp = temp.left;
        newHead = temp;

        //inorder the tree
        Stack<TreeNode> stack = new Stack<>();
        temp = pRootOfTree;
        while (!stack.isEmpty() || temp!=null)
        {
            while(temp != null)
            {
                stack.push(temp);
                temp = temp.left;
            }

            temp = stack.pop();
            if(pre == null)
                pre = temp;
            else
            {
                temp.left = pre;
                pre.right = temp;
                pre = pre.right;
            }

            temp = temp.right;
        }

        return newHead;
    }
}
