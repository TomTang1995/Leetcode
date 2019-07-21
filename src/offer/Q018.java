package offer;

import structures.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class Q018
{
    // A Non-Recursive Implementation
    public void Mirror(TreeNode root)
    {
        if(root == null)
            return;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty())
        {
            TreeNode temp = queue.poll();
            if(temp.left != null)
                queue.offer(temp.left);
            if(temp.right != null)
                queue.offer(temp.right);

            TreeNode treeNode = temp.left;
            temp.left = temp.right;
            temp.right = treeNode;
        }
    }

    /* A Recursive Implementation
    public void Mirror(TreeNode root)
    {
        if(root == null)
            return;

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        Mirror(root.left);
        Mirror(root.right);
    }
    */
}
