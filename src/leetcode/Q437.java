package leetcode;

import structures.TreeNode;

import java.util.Stack;

public class Q437
{
    int number = 0;

    public int pathSum(TreeNode root, int sum)
    {
        if(root == null)
            return 0;

        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;

        while(!stack.isEmpty() || current!=null)
        {
            while(current != null)
            {
                stack.push(current);
                current = current.left;
            }

            current = stack.pop();
            search(current, sum, 0);

            current = current.right;
        }

        return number;
    }

    public void search(TreeNode root, int target, int currentSum)
    {
        if(root == null)
            return;

        if(root.val + currentSum == target)
            number++;

        search(root.left, target, currentSum+root.val);
        search(root.right, target, currentSum+root.val);
    }
}
