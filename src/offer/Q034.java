package offer;

public class Q034
{
    public int FirstNotRepeatingChar(String str)
    {
        if(str==null || str.length()==0)
            return -1;

        int appearNumber[] = new int[128];
        for(int i = 0;i < str.length();i++)
            appearNumber[str.charAt(i)]++;

        for(int i = 0;i < str.length();i++)
        {
            if(appearNumber[str.charAt(i)] == 1)
                return i;
        }

        return -1;
    }
}
