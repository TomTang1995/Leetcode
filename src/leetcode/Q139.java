package leetcode;

import java.util.List;

public class Q139
{
    public boolean wordBreak(String s, List<String> wordDict)
    {
        boolean result[] = new boolean[s.length()];

        for(int i = 0;i < s.length();i++)
        {
            if(wordDict.contains(s.substring(0, i+1)))
                result[i] = true;
            else
            {
                for(int j = 0;j < i;j++)
                {
                    if(result[j] && wordDict.contains(s.substring(j+1, i+1)))
                    {
                        result[i] = true;
                        break;
                    }
                }
            }
        }

        return result[result.length-1];
    }
}
