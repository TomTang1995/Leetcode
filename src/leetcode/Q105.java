package leetcode;

import structures.TreeNode;

public class Q105
{
    public TreeNode buildTree(int[] preorder, int[] inorder)
    {
        if(preorder==null || inorder==null || preorder.length==0 || inorder.length==0 || preorder.length!=inorder.length)
            return null;

        return buildTreeHelper(preorder, inorder, 0, 0, preorder.length-1);
    }

    public TreeNode buildTreeHelper(int[] preorder, int[] inorder, int next, int low, int high)
    {
        if(low > high)
            return null;

        TreeNode current = new TreeNode(preorder[next]);
        int index = findIndex(inorder, preorder[next]);
        int leftLength = index - low;
        current.left = buildTreeHelper(preorder, inorder, next+1, low, index-1);
        current.right = buildTreeHelper(preorder, inorder, next+leftLength+1, index+1, high);

        return current;
    }

    public int findIndex(int[] inorder, int target)
    {
        for(int i = 0;i < inorder.length;i++)
        {
            if(inorder[i] == target)
                return i;
        }

        return -1;
    }
}
