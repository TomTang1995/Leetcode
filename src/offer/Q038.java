package offer;

import structures.TreeNode;

public class Q038
{
    public int TreeDepth(TreeNode root)
    {
        if (root == null)
            return 0;

        return TreeDepthHelper(root);
    }

    private int TreeDepthHelper(TreeNode root)
    {
        if(root == null)
            return 0;
        else if(root.left==null && root.right==null)
            return 1;

        int left = TreeDepthHelper(root.left);
        int right = TreeDepthHelper(root.right);

        return Math.max(left, right) + 1;
    }
}
