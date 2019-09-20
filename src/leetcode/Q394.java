package leetcode;

import java.util.Stack;

public class Q394
{
    public static void main(String[] args)
    {
        Q394 q394 = new Q394();
        System.out.println(q394.decodeString("3[a2[c]]"));
    }

    public String decodeString(String s)
    {
        if(s==null || s.length()==0)
            return "";

        Stack<Integer> intStack = new Stack<>();
        Stack<String> strStack = new Stack<>();
        String result = "";
        strStack.push(result);

        for(int i = 0;i < s.length();i++)
        {
            if('0'<=s.charAt(i) && s.charAt(i)<='9')
            {
                int times = 0;
                while('0'<=s.charAt(i) && s.charAt(i)<='9')
                {
                    times = 10*times + s.charAt(i) - '0';
                    i++;
                }
                intStack.push(times);
                i--;
            }
            else if(s.charAt(i) == '[')
            {
                strStack.push(result);
                result = "";
            }
            else if(s.charAt(i) == ']')
            {
                int times = intStack.pop();
                StringBuilder sb = new StringBuilder();
                while(times > 0)
                {
                    sb.append(result);
                    times--;
                }
                result = strStack.pop() + sb.toString();
            }
            else
                result = result + s.charAt(i);
        }

        return result;
    }
}
