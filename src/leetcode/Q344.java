package leetcode;

public class Q344
{
    public void reverseString(char[] s)
    {
        if(s==null || s.length==0)
            return;

        int low=0, high=s.length-1;
        while(low <= high)
        {
            char temp = s[low];
            s[low] = s[high];
            s[high] = temp;
            low++;
            high--;
        }
    }
}
