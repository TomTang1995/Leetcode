package offer;

import structures.TreeNode;

import java.util.ArrayList;

public class Q059
{
    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot)
    {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if(pRoot == null)
            return result;

        int line = 1;
        ArrayList<TreeNode> list1 = new ArrayList<>();
        ArrayList<TreeNode> list2 = new ArrayList<>();
        list1.add(pRoot);

        while(!list1.isEmpty() || !list2.isEmpty())
        {
            ArrayList<Integer> temp = new ArrayList<>();
            if(line%2 == 1)
            {
                for(int i = list1.size()-1;i >= 0;i--)
                {
                    TreeNode currentNode = list1.get(i);
                    temp.add(currentNode.val);
                    if(currentNode.left != null)
                        list2.add(currentNode.left);
                    if(currentNode.right != null)
                        list2.add(currentNode.right);
                }
                list1.clear();
            }
            else
            {
                for(int i = list2.size()-1;i >= 0;i--)
                {
                    TreeNode currentNode = list2.get(i);
                    temp.add(currentNode.val);
                    if(currentNode.right != null)
                        list1.add(currentNode.right);
                    if(currentNode.left!= null)
                        list1.add(currentNode.left);
                }
                list2.clear();
            }
            result.add(temp);
            line++;
        }

        return result;
    }
}
