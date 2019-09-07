package leetcode;

import structures.TreeNode;

import java.util.*;

public class Q107
{
    public List<List<Integer>> levelOrderBottom(TreeNode root)
    {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> list = new ArrayList<>();
        int thisLevelCount = 0, nextLevelCount = 1;

        if(root == null)
            return list;

        queue.offer(root);
        while(!queue.isEmpty())
        {
            thisLevelCount = nextLevelCount;
            nextLevelCount = 0;
            List<Integer> temp = new ArrayList<>();
            while(thisLevelCount > 0)
            {
                TreeNode currentNode = queue.poll();
                temp.add(currentNode.val);
                if(currentNode.left != null)
                {
                    queue.offer(currentNode.left);
                    nextLevelCount++;
                }
                if(currentNode.right != null)
                {
                    queue.offer(currentNode.right);
                    nextLevelCount++;
                }
                thisLevelCount--;
            }

            list.add(temp);
        }

        Collections.reverse(list);
        return list;
    }
}
