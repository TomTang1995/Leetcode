package offer;

public class Q044
{
    public static void main(String[] args)
    {
        Q044 q044 = new Q044();
        System.out.println(q044.ReverseSentence("      "));
    }

    public String ReverseSentence(String str)
    {
        if(str==null || str.length()==0)
            return str;

        String strArray[] = str.split(" ");
        if(strArray.length == 0)
            return str;

        StringBuilder sb = new StringBuilder();
        for(int i = strArray.length-1;i >=0;i--)
        {
            sb.append(strArray[i]);
            sb.append(' ');
        }

        return sb.toString().substring(0, sb.length()-1);
    }
}
