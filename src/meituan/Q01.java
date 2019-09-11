package meituan;

import java.util.Scanner;

public class Q01
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        String n1 = in.nextLine();
        String n2 = in.nextLine();

        if(n1==null && n2 == null)
            System.out.println("");
        if(n1==null || n1.length()==0)
            System.out.println(n2);
        if(n2==null || n2.length()==0)
            System.out.println(n1);

        String result = addBinary(n1, n2);
        System.out.println(result);
    }

    public static String addBinary(String a, String b)
    {
        if(a==null || b==null || a.length()==0 || b.length()==0)
            return "";

        if((a.charAt(0)!='-' && b.charAt(0)!='-') || (a.charAt(0)=='-' && b.charAt(0)=='-'))
        {
            boolean isAllNegative = false;
            if(a.charAt(0)=='-' && b.charAt(0)=='-')
            {
                a = a.substring(1, a.length());
                b = b.substring(1, b.length());
                isAllNegative = true;
            }

            int lengthA = a.length();
            int lengthB = b.length();
            if(lengthA < lengthB)
            {
                for(int i = 1;i <= lengthB-lengthA;i++)
                    a = "0" + a;
            }
            else
            {
                for(int i = 1;i <= lengthA-lengthB;i++)
                    b = "0" + b;
            }

            boolean flag = false;
            String result = "";
            for(int i = a.length()-1;i >= 0;i--)
            {
                char charA = a.charAt(i);
                char charB = b.charAt(i);
                result = ((charA-'0'+charB-'0'+(flag?1:0)) % 10) + result;
                flag = (charA-'0'+charB-'0'+(flag?1:0)) >= 10 ? true : false;
            }
            if(flag)
                result = "1" + result;

            return isAllNegative ? "-"+result : result;
        }
        else
        {
            if(a.charAt(0) == '-')
                return bigDigitalSub(b, a.substring(1, a.length()));
            else
                return bigDigitalSub(a, b.substring(1, b.length()));
        }
    }

    public static String bigDigitalSub(String a, String b)
    {
        char[] aArray = new StringBuilder(a).reverse().toString().toCharArray();
        char[] bArray = new StringBuilder(b).reverse().toString().toCharArray();
        int aLength = aArray.length;
        int bLength = bArray.length;
        int maxLength = aLength > bLength ? aLength : bLength;
        int[] result = new int[maxLength];
        char sign = '+';
        if (aLength < bLength)
            sign = '-';
        else if (aLength == bLength)
        {
            int i = maxLength - 1;
            while (i > 0 && aArray[i] == bArray[i])
                i--;
            if (aArray[i] < bArray[i])
                sign = '-';
        }

        for (int i = 0; i < maxLength; i++)
        {
            int aInt = i < aLength ? aArray[i] - '0' : 0;
            int bInt = i < bLength ? bArray[i] - '0' : 0;
            if (sign == '-') result[i] = bInt - aInt;
            else result[i] = aInt - bInt;
        }

        for (int i = 0; i < maxLength - 1; i++)
        {
            if (result[i] < 0)
            {
                result[i + 1] -= 1;
                result[i] += 10;
            }
        }

        StringBuffer realResult = new StringBuffer();
        if (sign == '-') realResult.append('-');
        boolean isBeginning = true;
        for (int i = maxLength - 1; i >= 0; i--)
        {
            if (result[i] == 0 && isBeginning)
                continue;
            else
                isBeginning = false;

            realResult.append(result[i]);
        }
        if (realResult.toString().equals(""))
            realResult.append('0');

        return realResult.toString();
    }
}
