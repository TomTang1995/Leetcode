package leetcode;

public class Q279
{
    public int numSquares(int n)
    {
        if(n <= 0)
            return 0;

        int result[] = new int[n+1];
        result[0] = 0;

        for(int i = 1;i < n+1;i++)
        {
            int temp = Integer.MAX_VALUE;
            for(int j = 1;i-j*j >= 0;j++)
                temp = Math.min(temp, result[i-j*j]+1);

            result[i] = temp;
        }

        return result[n];
    }
}
