package offer;

import java.util.ArrayList;
import java.util.Arrays;

public class Q027
{
    public static void main(String[] args)
    {
        String s = "abc";
        Q027 q027 = new Q027();
        ArrayList<String> list = q027.Permutation(s);
        for(String each : list)
            System.out.println(each);
    }

    public ArrayList<String> Permutation(String str)
    {
        StringBuilder sb = new StringBuilder();
        ArrayList<String> list = new ArrayList<>();
        if(str==null || str.length()==0)
            return list;

        char charArray[] = str.toCharArray();
        boolean isUsed[] = new boolean[charArray.length];
        Arrays.sort(charArray);
        recursivePermutation(sb, list, charArray, isUsed);

        return list;
    }

    private void recursivePermutation(StringBuilder sb, ArrayList<String> list, char charArray[], boolean isUsed[])
    {
        if(sb.length() == charArray.length)
        {
            list.add(sb.toString());
            return;
        }

        for(int i = 0;i < charArray.length;i++)
        {
            if(!isUsed[i])
            {
                if(i==0 || charArray[i]!=charArray[i-1] || (charArray[i]==charArray[i-1] && isUsed[i-1]))
                {
                    isUsed[i] = true;
                    sb.append(charArray[i]);
                    recursivePermutation(sb, list, charArray, isUsed);
                    sb.deleteCharAt(sb.length()-1);
                    isUsed[i] = false;
                }
            }
        }
    }
}
