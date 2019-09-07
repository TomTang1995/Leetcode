package leetcode;

import structures.TreeNode;

public class Q617
{
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2)
    {
        if(t1 == null)
            return t2;

        if(t2 == null)
            return t1;

        TreeNode root = new TreeNode(t1.val + t2.val);
        root.left = mergeTreesHelper(t1.left, t2.left);
        root.right = mergeTreesHelper(t1.right, t2.right);

        return root;
    }

    public TreeNode mergeTreesHelper(TreeNode root1, TreeNode root2)
    {
        if(root1==null && root2==null)
            return null;

        TreeNode root = new TreeNode((root1==null ? 0 : root1.val) + (root2==null ? 0 : root2.val));
        root.left = mergeTreesHelper(root1==null ? null : root1.left, root2==null ? null : root2.left);
        root.right = mergeTreesHelper(root1==null ? null : root1.right, root2==null ? null : root2.right);

        return root;
    }
}
