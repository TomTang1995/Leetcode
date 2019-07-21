package offer;

import structures.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Q024
{
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target)
    {
        int sum = 0;
        ArrayList<Integer> temp = new ArrayList<>();
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();

        if(root == null)
            return list;

        searchTree(root, list, temp, target, 0);
        Collections.sort(list, new Comparator<ArrayList<Integer>>() {
            @Override
            public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
                if(o1.size() >= o2.size())
                    return -1;
                else
                    return 1;
            }
        });
        return list;
    }

    private void searchTree(TreeNode root, ArrayList<ArrayList<Integer>> list, ArrayList<Integer> temp, int target, int sum)
    {
        if(root == null)
            return;

        if(root.left==null && root.right==null)
        {
            if(sum + root.val == target)
            {
                temp.add(root.val);
                list.add(new ArrayList<>(temp));
                temp.remove(temp.size()-1);
            }
        }
        else
        {
            temp.add(root.val);
            searchTree(root.left, list, temp, target, sum+root.val);
            searchTree(root.right, list, temp, target, sum+root.val);
            temp.remove(temp.size()-1);
        }
    }
}
