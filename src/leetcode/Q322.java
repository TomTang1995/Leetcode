package leetcode;

import java.util.Arrays;

public class Q322
{
    public int coinChange(int[] coins, int amount)
    {
        if(coins==null || coins.length==0 || amount<0)
            return 0;

        // initial
        int result[] = new int[amount+1];
        for(int i = 1;i < amount+1;i++)
            result[i] = Integer.MAX_VALUE;

        // dp
        Arrays.sort(coins);
        for(int i = 1;i < amount+1;i++)
        {
            for(int j = 0;j < coins.length;j++)
            {
                if(i < coins[j])
                    break;

                result[i] = result[i-coins[j]]==Integer.MAX_VALUE ? result[i] : Math.min(result[i], result[i-coins[j]]+1);
            }
        }

        return result[amount]==Integer.MAX_VALUE ? -1 : result[amount];
    }
}
