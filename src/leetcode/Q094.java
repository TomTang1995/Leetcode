package leetcode;

import structures.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Q094
{
    // iterative solution
    public List<Integer> inorderTraversal(TreeNode root)
    {
        List<Integer> list = new ArrayList<>();
        if(root == null)
            return list;

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
            list.add(current.val);

            current = current.right;
        }

        return list;
    }

    /* recursive solution
    public List<Integer> inorderTraversal(TreeNode root)
    {
        List<Integer> list = new ArrayList<>();
        if(root == null)
            return list;

        inorder(root, list);
        return list;
    }

    public void inorder(TreeNode root, List<Integer> list)
    {
        if(root == null)
            return;

        inorder(root.left, list);
        list.add(root.val);
        inorder(root.right, list);
    }
    */
}
