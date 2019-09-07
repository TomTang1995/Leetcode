package leetcode;

import structures.TreeNode;

public class Q543
{
    int max = 0;
    public int diameterOfBinaryTree(TreeNode root)
    {
        if(root == null)
            return 0;

        findMax(root);
        return max;
    }

    public int findMax(TreeNode root)
    {
        if(root == null)
            return 0;

        int left = findMax(root.left);
        int right = findMax(root.right);

        max = left+right > max ? left+right : max;

        return Math.max(left, right) + 1;
    }
}
