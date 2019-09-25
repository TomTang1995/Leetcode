package Huawei;

import java.util.Scanner;

public class Q01
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        String original = str.split(" ")[0];
        String target = str.split(" ")[1];

        if(original.contains(target))
        {
            int index = original.indexOf(target);
            StringBuilder sb = new StringBuilder();
            sb.append(original.substring(0, index));
            for(int i = 0;i < target.length();i++)
                sb.append('*');

            sb.append(original.substring(index+target.length(), original.length()));

            System.out.println(sb.toString());
        }
        else
            System.out.println(original);
    }
}
