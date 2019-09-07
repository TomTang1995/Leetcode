package leetcode;

import structures.TreeNode;

public class Q226
{
    public TreeNode invertTree(TreeNode root)
    {
        if(root == null)
            return null;

        invertTreeHelper(root);
        return root;
    }

    public void invertTreeHelper(TreeNode root)
    {
        if(root == null)
            return;

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        invertTreeHelper(root.left);
        invertTreeHelper(root.right);
    }
}
