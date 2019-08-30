package leetcode;

import structures.TreeNode;

public class Q098
{
    public boolean isValidBST(TreeNode root)
    {
        if(root == null)
            return true;

        return valid(root.left, Long.MIN_VALUE, root.val) && valid(root.right, root.val, Long.MAX_VALUE);
    }

    public boolean valid(TreeNode root, long min, long max)
    {
        if(root == null)
            return true;

        if(min<root.val && root.val<max)
            return valid(root.left, min, root.val) && valid(root.right, root.val, max);

        return false;
    }
}
