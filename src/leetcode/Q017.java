package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Q017
{
    public List<String> letterCombinations(String digits)
    {
        Map<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");

        List<String> result = new ArrayList<>();
        List<String> temp = new ArrayList<>();

        if(digits==null || digits.length()==0)
            return result;

        result.add("");
        for(int i = 0;i < digits.length();i++)
        {
            String current = map.get(digits.charAt(i));
            temp = new ArrayList<>(result);
            result.clear();

            for(String each : temp)
            {
                for(int j = 0;j < current.length();j++)
                    result.add(each + current.charAt(j));
            }
        }

        return result;
    }
}
