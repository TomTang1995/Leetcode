package leetcode;

import java.util.Arrays;

public class Q242
{
    public boolean isAnagram(String s, String t)
    {
        if(s==null || s.length()==0 || t==null || t.length()==0)
            return true;

        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();

        Arrays.sort(sChars);
        Arrays.sort(tChars);

        return String.valueOf(sChars).equals(String.valueOf(tChars));
    }
}
