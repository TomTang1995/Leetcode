package offer;

import structures.TreeNode;

public class Q017
{
    public boolean HasSubtree(TreeNode root1, TreeNode root2)
    {
        if(root1==null || root2==null)
            return false;

        return searchTree(root1, root2);
    }

    private boolean searchTree(TreeNode root1, TreeNode root2)
    {
        if(root1!=null && root2!=null)
        {
            if(root1.val == root2.val)
            {
                if(isSubTree(root1, root2))
                    return true;
            }

            return searchTree(root1.left, root2) || searchTree(root1.right, root2);
        }
        else
            return false;
    }

    private boolean isSubTree(TreeNode root1, TreeNode root2)
    {
        if(root2 == null)
            return true;

        if(root1 == null)
            return false;

        if(root1.val == root2.val)
            return isSubTree(root1.left, root2.left) && isSubTree(root1.right, root2.right);
        else
            return false;
    }
}
