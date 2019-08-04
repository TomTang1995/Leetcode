package offer;

public class Q049
{
    public int StrToInt(String str)
    {
        if(str==null || str.length()==0)
            return 0;

        int result = 0;
        boolean isNegative = false;
        for(int i = 0;i < str.length();i++)
        {
            if(str.charAt(i)<'0' || str.charAt(i)>'9')
            {
                if(str.charAt(i)=='+' || str.charAt(i)=='-')
                {
                    if(i == 0)
                    {
                        if(str.charAt(i) == '-')
                            isNegative = true;

                        continue;
                    }
                    else
                        return 0;
                }
                else
                    return 0;
            }
            else
                result = result * 10 + str.charAt(i) - '0';
        }

        return isNegative ? -result : result;
    }
}
