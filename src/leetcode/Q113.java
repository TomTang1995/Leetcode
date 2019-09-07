package leetcode;

import structures.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Q113
{
    public List<List<Integer>> pathSum(TreeNode root, int sum)
    {
        List<Integer> temp = new ArrayList<>();
        List<List<Integer>> list = new ArrayList<>();

        if(root == null)
            return list;

        findPath(root, temp, list, 0, sum);
        return list;
    }

    public void findPath(TreeNode root, List<Integer> temp, List<List<Integer>> list, int sum, int target)
    {
        if(root == null)
            return;

        if(root.left==null && root.right==null)
        {
            if(sum+root.val == target)
            {
                temp.add(root.val);
                list.add(new ArrayList<>(temp));
                temp.remove(temp.size()-1);
            }
            else
                return;
        }
        else
        {
            temp.add(root.val);
            findPath(root.left, temp, list, sum+root.val, target);
            findPath(root.right, temp, list, sum+root.val, target);
            temp.remove(temp.size()-1);
        }
    }
}
