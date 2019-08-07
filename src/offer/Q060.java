package offer;

import structures.TreeNode;

import java.util.ArrayList;

public class Q060
{
    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot)
    {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        if(pRoot == null)
            return list;

        ArrayList<TreeNode> currentLevel = new ArrayList<>();
        ArrayList<TreeNode> nextLevel = new ArrayList<>();
        nextLevel.add(pRoot);

        while (!nextLevel.isEmpty())
        {
            currentLevel = nextLevel;
            nextLevel = new ArrayList<>();
            ArrayList<Integer> temp = new ArrayList<>();
            for(int i = 0;i < currentLevel.size();i++)
            {
                TreeNode currentNode = currentLevel.get(i);
                temp.add(currentNode.val);
                if(currentNode.left != null)
                    nextLevel.add(currentNode.left);
                if(currentNode.right != null)
                    nextLevel.add(currentNode.right);
            }
            list.add(temp);
        }

        return list;
    }
}
