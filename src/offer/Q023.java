package offer;

public class Q023
{
    public boolean VerifySquenceOfBST(int [] sequence)
    {
        if(sequence==null || sequence.length==0)
            return false;

        return recursiveVerifySequenceOfBST(sequence, 0, sequence.length-1);
    }

    private boolean recursiveVerifySequenceOfBST(int sequence[], int start, int end)
    {
        if(start >= end)
            return true;

        int currentNode = sequence[end];
        int diff, index;
        for(diff = 0;diff < end;diff++)
        {
            if(sequence[diff] > currentNode)
                break;
        }

        index = diff;
        for(;diff < end;diff++)
        {
            if(sequence[diff] < currentNode)
                break;
        }

        if(diff < end)
            return false;
        else
            return recursiveVerifySequenceOfBST(sequence, start, index-1) && recursiveVerifySequenceOfBST(sequence, index, end-1);
    }
}
