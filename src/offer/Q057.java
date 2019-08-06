package offer;

import structures.TreeLinkNode;

public class Q057
{
    public TreeLinkNode GetNext(TreeLinkNode pNode)
    {
        if(pNode == null)
            return null;

        if(pNode.right != null)
        {
            pNode = pNode.right;
            while(pNode.left != null)
                pNode = pNode.left;

            return pNode;
        }

        if(pNode.next == null)
            return null;

        if(pNode.next.left == pNode)
            return pNode.next;

        while(pNode.next!=null && pNode.next.right==pNode)
            pNode = pNode.next;

        return pNode.next==null ? null : pNode.next;
    }
}
