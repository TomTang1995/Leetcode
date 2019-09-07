package leetcode;

import structures.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Q257
{
    public List<String> binaryTreePaths(TreeNode root)
    {
        List<String> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        List<List<Integer>> list = new ArrayList<>();

        if(root == null)
            return result;

        findPath(root, temp, list);
        adjust(list, result);
        return result;
    }

    public void findPath(TreeNode root, List<Integer> temp, List<List<Integer>> list)
    {
        if(root == null)
            return;

        if(root.left==null && root.right==null)
        {
            temp.add(root.val);
            list.add(new ArrayList<>(temp));
            temp.remove(temp.size()-1);
        }
        else
        {
            temp.add(root.val);
            findPath(root.left, temp, list);
            findPath(root.right, temp, list);
            temp.remove(temp.size()-1);
        }
    }

    public void adjust(List<List<Integer>> list, List<String> result)
    {
        for(List<Integer> each : list)
        {
            StringBuilder sb = new StringBuilder();
            for(Integer eachInteger : each)
                sb.append(String.valueOf(eachInteger) + "->");

            sb.deleteCharAt(sb.length()-1);
            sb.deleteCharAt(sb.length()-1);
            result.add(sb.toString());
        }
    }
}
