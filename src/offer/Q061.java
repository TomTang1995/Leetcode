package offer;

import structures.TreeNode;

public class Q061
{
    public String Serialize(TreeNode root)
    {
        StringBuilder sb = new StringBuilder();
        if(root == null)
            return "";

        recursiveSerialize(sb, root);
        return sb.toString();
    }

    public void recursiveSerialize(StringBuilder sb, TreeNode root)
    {
        if(root == null)
        {
            sb.append('#');
            sb.append(',');
            return;
        }

        sb.append(root.val);
        sb.append(',');
        recursiveSerialize(sb, root.left);
        recursiveSerialize(sb, root.right);
    }


    int currentIndex = 0;
    public TreeNode Deserialize(String str)
    {
        if(str==null || str.length()==0)
            return null;

        String strSplited[] = str.split(",");
        return recursiveDeserialize(strSplited);
    }

    public TreeNode recursiveDeserialize(String[] strSplited)
    {
        if(currentIndex >= strSplited.length)
            return null;

        if(strSplited[currentIndex].equals("#"))
        {
            currentIndex = currentIndex + 1;
            return null;
        }
        else
        {
            TreeNode currentNode = new TreeNode(Integer.valueOf(strSplited[currentIndex]));
            currentIndex = currentIndex + 1;
            currentNode.left = recursiveDeserialize(strSplited);
            currentNode.right = recursiveDeserialize(strSplited);
            return currentNode;
        }
    }
}
