package leetcode;

public class Q152
{
    public int maxProduct(int[] nums)
    {
        if(nums==null || nums.length==0)
            return 0;

        int currentMax = Integer.MIN_VALUE;
        int temp = 1;
        for(int i = 0;i < nums.length;i++)
        {
            temp = temp * nums[i];
            currentMax = Math.max(temp, currentMax);

            if(nums[i] == 0)
                temp = 1;
        }

        temp = 1;
        for(int i = nums.length-1;i >= 0;i--)
        {
            temp = temp * nums[i];
            currentMax = Math.max(temp, currentMax);

            if(nums[i] == 0)
                temp = 1;
        }

        return currentMax;
    }
}
