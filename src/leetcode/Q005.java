package leetcode;

public class Q005
{
    int currentMax = 0;
    int p1 = 0, p2 = 0;

    public String longestPalindrome(String s)
    {
        if(s==null ||s.length()<=1)
            return s;

        for(int i = 0;i < s.length()-1;i++)
        {
            explore(s, i, i);
            explore(s, i, i+1);
        }

        return s.substring(p1, p2+1);
    }

    public void explore(String s, int front, int end)
    {
        while(front>=0 && end<=s.length()-1)
        {
            if(s.charAt(front) == s.charAt(end))
            {
                if(end-front+1 > currentMax)
                {
                    currentMax = end - front + 1;
                    p1 = front;
                    p2 = end;
                }
                front--;
                end++;
            }
            else
                break;
        }
    }
}
