package offer;

public class Q002
{
    //A general solution : merge 2 arrays or insert 1 string to another
    public String replaceSpace(StringBuffer str)
    {
        String s = str.toString();
        int spaceCount = 0;
        for(int i = 0;i < s.length();i++)
        {
            if(s.charAt(i) == ' ')
                spaceCount++;
        }

        char newString[] = new char[s.length() + 2*spaceCount];
        int i = s.length()-1;
        for(int j = newString.length-1;j >= 0;j--)
        {
            if(s.charAt(i) != ' ')
            {
                newString[j] = s.charAt(i);
                i--;
            }
            else
            {
                newString[j] = '0';
                newString[j-1] = '2';
                newString[j-2] = '%';
                j = j - 2;
                i--;
            }
        }

        return String.valueOf(newString);
    }

    /*
    public String replaceSpace(StringBuffer str)
    {
        String s = str.toString();
        StringBuilder sb = new StringBuilder();
        for(int i = 0;i < s.length();i++)
        {
            if(s.charAt(i) == ' ')
                sb.append("%20");
            else
                sb.append(s.charAt(i));
        }

        return sb.toString();
    }
    */
}
