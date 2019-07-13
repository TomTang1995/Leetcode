package offer;

public class Q011
{
    public int NumberOf1(int n)
    {
        int result = 0;
        for(int i = 0;i < 32;i++)
        {
            if(((n>>>i)&1) == 1)
                result++;
        }

        return result;
    }
}
