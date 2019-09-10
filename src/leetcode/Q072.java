package leetcode;

public class Q072
{
    public int minDistance(String word1, String word2)
    {
        int dp[][] = new int[word1.length()+1][word2.length()+1];
        for(int j = 0;j < word2.length()+1;j++)
            dp[0][j] = j;
        for(int i = 0;i < word1.length()+1;i++)
            dp[i][0] = i;

        for(int i = 1;i < word1.length()+1;i++)
        {
            for(int j = 1;j < word2.length()+1;j++)
            {
                // add
                int p1 = dp[i-1][j] + 1;
                // delete
                int p2 = dp[i][j-1] + 1;
                // replace
                int p3 = dp[i-1][j-1] + (word1.charAt(i-1)==word2.charAt(j-1) ? 0 : 1);
                dp[i][j] = Math.min(p1, Math.min(p2, p3));
            }
        }

        return dp[dp.length-1][dp[0].length-1];
    }
}
