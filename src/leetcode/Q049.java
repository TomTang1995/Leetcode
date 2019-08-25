package leetcode;

import java.util.*;

public class Q049
{
    public List<List<String>> groupAnagrams(String[] strs)
    {
        List<List<String>> list = new ArrayList<>();
        if(strs==null || strs.length==0)
            return list;

        int count = 0;
        Map<String, Integer> map = new HashMap<>();
        for(int i = 0;i < strs.length;i++)
        {
            char charArray[] = strs[i].toCharArray();
            Arrays.sort(charArray);
            if(map.containsKey(String.valueOf(charArray)))
                list.get(map.get(String.valueOf(charArray))).add(strs[i]);
            else
            {
                map.put(String.valueOf(charArray), count);
                count++;
                List<String> temp = new ArrayList<>();
                temp.add(strs[i]);
                list.add(temp);
            }
        }

        return list;
    }
}
