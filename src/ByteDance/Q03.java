package ByteDance;

import java.util.Scanner;

public class Q03
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int nums[] = new int[n+1];
        for(int i = 1;i <= n;i++)
            nums[i] = in.nextInt();

        System.out.println(search(n, nums));
    }

    public static int search(int n, int nums[])
    {
        int sum[] = new int[n+1];
        int dp[][] = new int[n+1][n+1];

        for(int i = 1;i <= n;i++)
        {
            sum[i] = sum[i-1] + nums[i];
            dp[i][1] = nums[i];
        }

        for(int l = 2; l <= n; l++)
        {
            for(int i = 1; i + l - 1 <= n; i++)
                dp[i][l] = Math.max(sum[i+l-1] - sum[i-1] - dp[i][l-1], sum[i+l-1] - sum[i-1] - dp[i+1][l-1]);
        }
        return dp[1][n];
    }
}
