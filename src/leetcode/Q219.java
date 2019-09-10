package leetcode;

import java.util.HashMap;
import java.util.Map;

public class Q219
{
    public boolean containsNearbyDuplicate(int[] nums, int k)
    {
        if(nums == null)
            return false;

        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0;i < nums.length;i++)
        {
            if(map.containsKey(nums[i]))
            {
                int lastIndex = map.get(nums[i]);
                if(i-lastIndex <= k)
                    return true;
                else
                    map.put(nums[i], i);
            }
            else
                map.put(nums[i], i);
        }

        return false;
    }
}
