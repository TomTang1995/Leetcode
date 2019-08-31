package leetcode;

import java.util.HashSet;
import java.util.Set;

public class Q136
{
    public int singleNumber(int[] nums)
    {
        int result = 0;
        for(int each : nums)
            result = result ^ each;

        return result;
    }

    /* A linear time complexity solution with eatra space
    public int singleNumber(int[] nums)
    {
        Set<Integer> set = new HashSet<>();

        for(int each : nums)
        {
            if(set.contains(each))
                set.remove(each);
            else
                set.add(each);
        }

        int result = 0;
        for(int each : set)
            result = each;

        return result;
    }
    */
}
