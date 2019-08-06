package offer;

import structures.TreeNode;

public class Q058
{
    public boolean isSymmetrical(TreeNode pRoot)
    {
        if(pRoot == null)
            return true;

        return isSymmetricalHelper(pRoot.left, pRoot.right);
    }

    public boolean isSymmetricalHelper(TreeNode root1, TreeNode root2)
    {
        if(root1==null && root2==null)
            return true;
        else if(root1!=null && root2!=null)
        {
            if(root1.val == root2.val)
                return isSymmetricalHelper(root1.left, root2.right) && isSymmetricalHelper(root1.right, root2.left);
            else
                return false;
        }
        else
            return false;
    }
}
