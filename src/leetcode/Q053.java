package leetcode;

import java.util.Arrays;

public class Q053
{
    public int maxSubArray(int[] nums)
    {
        if(nums==null || nums.length==0)
            return 0;

        int currentMax[] = new int[nums.length];
        currentMax[0] = nums[0];
        for(int i = 1;i < nums.length;i++)
            currentMax[i] = currentMax[i-1]+nums[i] > nums[i] ? currentMax[i-1]+nums[i] : nums[i];

        Arrays.sort(currentMax);
        return currentMax[currentMax.length-1];
    }
}
