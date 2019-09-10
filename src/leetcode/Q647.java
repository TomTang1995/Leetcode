package leetcode;

public class Q647
{
    public int countSubstrings(String s)
    {
        if(s == null)
            return 0;

        boolean dp[][] = new boolean[s.length()][s.length()];
        for(int i = 0;i < s.length();i++)
            dp[i][i] = true;

        for(int i = s.length()-1;i >= 0;i--)
        {
            for(int j = i+1;j < s.length();j++)
            {
                if(j == i+1)
                    dp[i][j] = s.charAt(i) == s.charAt(j);
                else
                    dp[i][j] = (s.charAt(i)==s.charAt(j)) && dp[i+1][j-1];
            }
        }

        int count = 0;
        for(int i = 0;i < s.length();i++)
        {
            for(int j = i;j < s.length();j++)
                count = count + (dp[i][j] ? 1 : 0);
        }

        return count;
    }
}
