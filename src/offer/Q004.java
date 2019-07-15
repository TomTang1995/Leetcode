package offer;

import structures.TreeNode;

public class Q004
{
    public static void main(String[] args)
    {
        int pre[] = {1,2,4,7,3,5,6,8};
        int in[] = {4,7,2,1,5,3,8,6};

        Q004 q004 = new Q004();
        TreeNode root = q004.reConstructBinaryTree(pre, in);
    }

    public TreeNode reConstructBinaryTree(int [] pre, int [] in)
    {
        if(pre==null || pre.length==0 || in==null || in.length==0)
            return null;

        TreeNode root = reConstructBinaryTreeHelper(pre, in, 0, 0, pre.length-1);
        return root;
    }

    private TreeNode reConstructBinaryTreeHelper(int pre[], int in[], int currentIndex, int start, int end)
    {
        if(start > end)
            return null;

        TreeNode root = new TreeNode(pre[currentIndex]);
        int rootIndex = searchForIndex(pre[currentIndex], in);
        int leftTreeLength = rootIndex - start;

        root.left = reConstructBinaryTreeHelper(pre, in, currentIndex+1, start, rootIndex-1);
        root.right = reConstructBinaryTreeHelper(pre, in, currentIndex+leftTreeLength+1, rootIndex+1, end);

        return root;
    }

    private int searchForIndex(int target, int in[])
    {
        for(int i = 0;i < in.length;i++)
        {
            if(in[i] == target)
                return i;
        }

        return -1;
    }
}
