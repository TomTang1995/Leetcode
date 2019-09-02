package leetcode;

public class Q171
{
    public int titleToNumber(String s)
    {
        if(s==null || s.length()==0)
            return 0;

        int result = 0, pow = 1;
        for(int i = s.length()-1;i >= 0;i--)
        {
            int current = s.charAt(i) - 'A' + 1;
            result = result + current*pow;
            pow = pow*26;
        }

        return result;
    }
}
