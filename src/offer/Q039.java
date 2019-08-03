package offer;

import structures.TreeNode;

public class Q039
{
    boolean flag = true;

    public boolean IsBalanced_Solution(TreeNode root)
    {
        if(root == null)
            return true;

        IsBalanced_Solution_Helper(root);
        return flag;
    }

    private int IsBalanced_Solution_Helper(TreeNode root)
    {
        if(root == null)
            return 0;

        int leftDepth = IsBalanced_Solution_Helper(root.left);
        int rightDepth = IsBalanced_Solution_Helper(root.right);

        if(Math.abs(leftDepth-rightDepth) > 1)
            flag = false;

        return Math.max(leftDepth, rightDepth) + 1;
    }
}
