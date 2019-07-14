package leetcode;

import java.util.Arrays;

public class Q016
{
    public int threeSumClosest(int[] nums, int target)
    {
        if(nums==null || nums.length<=2)
            return 0;

        Arrays.sort(nums);
        int currentClosest = nums[0] + nums[1] + nums[2];
        int currentDiff = Math.abs(target-currentClosest);

        for(int i = 0;i < nums.length-2;i++)
        {
            int j = i+1;
            int k = nums.length-1;
            if(i==0 || nums[i]!=nums[i-1])
            {
                while(j < k)
                {
                    if(Math.abs(target-nums[i]-nums[j]-nums[k]) < currentDiff)
                    {
                        currentClosest = nums[i] + nums[j] + nums[k];
                        currentDiff = Math.abs(target-currentClosest);
                    }

                    if(nums[i] + nums[j] + nums[k] < target)
                    {
                        while(j<k && nums[j]==nums[j+1])
                            j++;
                        j++;
                    }
                    else
                    {
                        while(j<k && nums[k]==nums[k-1])
                            k--;
                        k--;
                    }
                }
            }
        }

        return currentClosest;
    }
}
