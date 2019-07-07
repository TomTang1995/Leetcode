package offer;

public class Q009
{
    public int JumpFloorII(int target)
    {
        int result[] = new int[target+1];
        result[0] = 1;
        result[1] = 1;

        for(int i = 2;i <= target;i++)
        {
            for(int j = 0;j < i;j++)
                result[i] = result[i] + result[j];
        }

        return result[target];
    }
}
