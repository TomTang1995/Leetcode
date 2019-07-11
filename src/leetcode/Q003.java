package leetcode;

public class Q003
{
    public static void main(String[] args)
    {
        String s = "tmmzuxt";
        Q003 q003 = new Q003();
        int result = q003.lengthOfLongestSubstring(s);
        System.out.println(result);
    }

    public int lengthOfLongestSubstring(String s)
    {
        if(s==null || s.length()==0)
            return 0;

        int currentMax = 0;
        int front = 0, end = 0;
        boolean hasAppeared[] = new boolean[128];

        while(end < s.length())
        {
            if(hasAppeared[s.charAt(end)])
            {
                while(s.charAt(front) != s.charAt(end))
                {
                    hasAppeared[s.charAt(front)] = false;
                    front++;
                }
                front++;
            }
            else
            {
                hasAppeared[s.charAt(end)] = true;
                currentMax = Math.max(currentMax, end-front+1);
            }
            end++;
        }

        return currentMax;
    }
}
