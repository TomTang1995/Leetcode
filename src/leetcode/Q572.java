package leetcode;

import structures.TreeNode;

public class Q572
{
    public boolean isSubtree(TreeNode s, TreeNode t)
    {
        if(s==null || t==null)
            return false;

        if(s.val == t.val)
        {
            if(judge(s, t))
                return true;
        }

        return isSubtree(s.left, t) || isSubtree(s.right, t);
    }

    public boolean judge(TreeNode s, TreeNode t)
    {
        if(s==null && t==null)
            return true;
        else if(s!=null && t!=null)
        {
            if(s.val == t.val)
                return judge(s.left, t.left) && judge(s.right, t.right);
            else
                return false;
        }
        else
            return false;
    }
}
