package offer;

public class Q043
{
    public String LeftRotateString(String str,int n)
    {
        if(str==null || str.length()==0)
            return "";

        return str.substring(n % str.length(), str.length()) + str.substring(0, n % str.length());
    }
}
