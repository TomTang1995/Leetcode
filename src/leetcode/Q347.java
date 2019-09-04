package leetcode;

import java.util.*;

public class Q347
{
    public List<Integer> topKFrequent(int[] nums, int k)
    {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0;i < nums.length;i++)
        {
            if(map.containsKey(nums[i]))
                map.put(nums[i], map.get(nums[i])+1);
            else
                map.put(nums[i], 1);
        }

        Set<Map.Entry<Integer, Integer>> set = map.entrySet();
        int number[][] = new int[set.size()][2];
        int i = 0;
        for(Map.Entry<Integer, Integer> each : set)
        {
            number[i][0] = each.getKey();
            number[i][1] = each.getValue();
            i++;
        }

        Arrays.sort(number, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2)
            {
                if(o1[1] > o2[1])
                    return -1;
                else if(o1[1] == o2[1])
                    return 0;
                else
                    return 1;
            }
        });

        List<Integer> list = new ArrayList<>();
        for(int j = 0;j < k;j++)
            list.add(number[j][0]);

        return list;
    }
}
