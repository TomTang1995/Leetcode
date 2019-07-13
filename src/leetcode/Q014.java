package leetcode;

public class Q014
{
    public String longestCommonPrefix(String[] strs)
    {
        StringBuilder sb = new StringBuilder();
        sb.append("");

        if(strs==null || strs.length==0)
            return sb.toString();

        int i, j;
        for(i = 0;i < strs[0].length();i++)
        {
            char current = strs[0].charAt(i);
            for(j = 1;i < strs.length;j++)
            {
                if(i>=strs[j].length() || strs[j].charAt(i)!=current)
                    break;
            }
            if(j==strs.length)
                sb.append(current);
            else
                break;
        }

        return sb.toString();
    }
}
