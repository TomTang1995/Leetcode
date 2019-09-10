package iqiyi;

import java.util.*;

public class Q01
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] p = new int[n - 1];
        for (int i = 0; i < p.length; i++)
            p[i] = sc.nextInt();

        int[][] dp = new int[n][n];
        Arrays.fill(dp[0], 1);
        for (int i = 1; i < n; i++)
        {
            for (int j = 0; j <= i; j++)
            {
                if (p[i - 1] == 1)
                {
                    for (int k = j; k < i; k++)
                    {
                        dp[i][j] += dp[i - 1][k];
                        dp[i][j] = dp[i][j] % 1000000007;
                    }
                }
                else {
                    for (int k = 0; k < j; k++)
                    {
                        dp[i][j] += dp[i - 1][k];
                        dp[i][j] = dp[i][j] % 1000000007;
                    }
                }
            }
        }

        int ans = 0;
        for (int each : dp[n - 1])
        {
            ans = ans + each;
            ans = ans % 1000000007;
        }

        System.out.println(ans);
    }
}