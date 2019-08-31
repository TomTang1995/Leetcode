package leetcode;

import structures.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Q102
{
    public List<List<Integer>> levelOrder(TreeNode root)
    {
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        int nextLevelCount, thisLevelCount;

        if(root == null)
            return result;

        queue.offer(root);
        nextLevelCount = 1;
        while(!queue.isEmpty())
        {
            thisLevelCount = nextLevelCount;
            nextLevelCount = 0;
            List<Integer> temp = new ArrayList<>();
            while (thisLevelCount > 0)
            {
                TreeNode current = queue.poll();
                temp.add(current.val);
                if(current.left != null)
                {
                    queue.offer(current.left);
                    nextLevelCount++;
                }
                if(current.right != null)
                {
                    queue.offer(current.right);
                    nextLevelCount++;
                }
                thisLevelCount--;
            }
            result.add(temp);
        }

        return result;
    }
}
