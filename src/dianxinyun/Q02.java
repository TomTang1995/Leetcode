package dianxinyun;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Q02
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        String original = in.nextLine();
        String s = original.split(";")[0];
        String t = original.split(";")[1];

        System.out.println(isIsomorphic(s, t));
    }

    public static boolean isIsomorphic(String s, String t)
    {
        if(s==null || t==null || s.length()!=t.length())
            return false;

        Map<Character, Character> map = new HashMap<>();
        for(int i = 0;i < s.length();i++)
        {
            char current = s.charAt(i);
            if(map.containsKey(current))
            {
                if(t.charAt(i) != map.get(current))
                    return false;
            }
            else if(map.containsValue(t.charAt(i)))
                return false;
            else
                map.put(current, t.charAt(i));
        }

        return true;
    }
}
