package offer;

import structures.RandomListNode;

public class Q025
{
    public RandomListNode Clone(RandomListNode pHead)
    {
        if(pHead == null)
            return null;
        else if(pHead.next == null)
        {
            RandomListNode temp = new RandomListNode(pHead.label);
            temp.next = pHead.next;
            temp.random = pHead.random;
            return temp;
        }

        RandomListNode currentNode = pHead;
        //1. duplicate the whole linked list
        while(currentNode.next != null)
        {
            RandomListNode temp = new RandomListNode(currentNode.label);
            temp.next = currentNode.next;
            currentNode.next = temp;
            currentNode = currentNode.next.next;
        }
        RandomListNode temp = new RandomListNode(currentNode.label);
        temp.next = null;
        currentNode.next = temp;

        //2. duplicate the 'random' of each node
        currentNode = pHead;
        while(currentNode != null)
        {
            currentNode.next.random = currentNode.random==null ? null : currentNode.random.next;
            currentNode = currentNode.next.next;
        }

        //3. split the linked list
        RandomListNode newHead = pHead.next;
        RandomListNode currentNextNode = newHead;
        currentNode = pHead;
        while(currentNode != null)
        {
            currentNode.next = currentNextNode.next;
            currentNextNode.next = currentNode.next==null ? null : currentNode.next.next;
            currentNode = currentNode.next;
            currentNextNode = currentNextNode.next;
        }

        return newHead;
    }
}
