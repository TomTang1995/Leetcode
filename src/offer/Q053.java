package offer;

public class Q053
{
    public boolean isNumeric(char[] str)
    {
        if(str==null || str.length==0)
            return false;

        boolean dot=false, eNature=false, negative=false;
        for(int i = 0;i < str.length;i++)
        {
            if('0'<=str[i] && str[i]<='9')
                continue;
            else if(str[i]=='+' || str[i]=='-')
            {
                if(!eNature)
                {
                    if(i == 0)
                        continue;
                    else
                        return false;
                }
                else
                {
                    if(str[i-1]=='e' || str[i-1]=='E')
                    {
                        if(i != str.length-1)
                            continue;
                        else
                            return false;
                    }
                    else
                        return false;
                }
            }
            else if(str[i] == '.')
            {
                if(!dot)
                {
                    if(eNature)
                        return false;
                    else
                        dot = true;
                }
                else
                    return false;
            }
            else if(str[i]=='e' || str[i]=='E')
            {
                if(!eNature)
                {
                    if(i == str.length-1)
                        return false;
                    else
                        eNature = true;
                }
                else
                    return false;
            }
            else
                return false;
        }

        return true;
    }
}
