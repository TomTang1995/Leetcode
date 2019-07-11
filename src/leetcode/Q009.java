package leetcode;

public class Q009
{
    public boolean isPalindrome(int x)
    {
        if(x < 0)
            return false;

        String origin = String.valueOf(x);
        StringBuilder reversed = new StringBuilder(String.valueOf(x));

        return origin.equals(reversed.reverse().toString());
    }
}
