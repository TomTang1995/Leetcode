package offer;

public class Q010
{
    public int RectCover(int target)
    {
        if(target <= 0)
            return 0;
        else if(target == 1)
            return 1;
        else if(target == 2)
            return 2;

        int result[] = new int[target+1];
        result[1] = 1;
        result[2] = 2;

        for(int i = 3;i < result.length;i++)
            result[i] = result[i-2] + result[i-1];

        return result[target];
    }
}
