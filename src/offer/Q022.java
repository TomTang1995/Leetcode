package offer;

import structures.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Q022
{
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root)
    {
        ArrayList<Integer> list = new ArrayList<>();
        if(root == null)
            return list;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty())
        {
            TreeNode currentNode = queue.poll();
            if(currentNode.left != null)
                queue.offer(currentNode.left);
            if(currentNode.right != null)
                queue.offer(currentNode.right);

            list.add(currentNode.val);
        }

        return list;
    }
}
