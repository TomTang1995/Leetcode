package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q018
{
    public List<List<Integer>> fourSum(int[] nums, int target)
    {
        List<List<Integer>> list = new ArrayList<>();
        if(nums==null || nums.length<=3)
            return list;

        Arrays.sort(nums);
        for(int w = 0;w < nums.length-3;w++)
        {
            if(w==0 || nums[w]!=nums[w-1])
            {
                for(int x = w+1;x < nums.length-2;x++)
                {
                    if(x==w+1 || nums[x]!=nums[x-1])
                    {
                        int y = x+1;
                        int z = nums.length-1;
                        while(y < z)
                        {
                            if(nums[w] + nums[x] + nums[y] + nums[z] == target)
                            {
                                list.add(Arrays.asList(nums[w], nums[x], nums[y], nums[z]));
                                while(y<z && nums[y]==nums[y+1])
                                    y++;
                                y++;
                                while(y<z && nums[z]==nums[z-1])
                                    z--;
                                z--;
                            }
                            else if(nums[w] + nums[x] + nums[y] + nums[z] < target)
                                y++;
                            else
                                z--;
                        }
                    }
                }
            }
        }

        return list;
    }
}
