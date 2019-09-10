package leetcode;

import structures.TreeNode;

public class Q337
{
    public int rob(TreeNode root)
    {
        if(root == null)
            return 0;

        int number[] = robHelper(root);
        return number[0] > number[1] ? number[0] : number[1];
    }

    // number[0]:rob
    // number[1]:not rob
    public int[] robHelper(TreeNode root)
    {
        if(root == null)
            return new int[]{0,0};

        // leaf
        if(root.left==null && root.right==null)
            return new int[]{root.val, 0};

        // not leaf
        int[] leftSubTree = robHelper(root.left);
        int[] rightSubTree = robHelper(root.right);

        return new int[]{leftSubTree[1]+rightSubTree[1]+root.val, Math.max(leftSubTree[0],leftSubTree[1])+Math.max(rightSubTree[0], rightSubTree[1])};
    }
}
