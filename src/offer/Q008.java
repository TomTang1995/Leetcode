package offer;

public class Q008
{
    public int JumpFloor(int target)
    {
        if(target == 1)
            return 1;
        else if(target == 2)
            return 2;

        int old1 = 1;
        int old2 = 2;
        int newResult = 0;
        for(int i = 3;i <= target;i++)
        {
            newResult = old1 + old2;
            old1 = old2;
            old2 = newResult;
        }

        return newResult;
    }
}
