package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q015
{
    public List<List<Integer>> threeSum(int[] nums)
    {
        List<List<Integer>> list = new ArrayList<>();
        if(nums==null || nums.length<=2)
            return list;

        Arrays.sort(nums);
        int length = nums.length;

        for(int i = 0;i < length-2;i++)
        {
            if(i==0 || nums[i]!=nums[i-1])
            {
                int j = i + 1;
                int k = length - 1;
                while (j < k)
                {
                    if (nums[i] + nums[j] + nums[k] == 0)
                    {
                        list.add(new ArrayList<>(Arrays.asList(nums[i], nums[j], nums[k])));
                        while(j<k && nums[j]==nums[j+1])
                            j++;
                        j++;
                        while(j<k && nums[k]==nums[k-1])
                            k--;
                        k--;
                    }
                    else if(nums[i] + nums[j] + nums[k] < 0)
                        j++;
                    else
                        k--;
                }
            }
        }

        return list;
    }
}
