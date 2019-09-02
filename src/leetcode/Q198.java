package leetcode;

public class Q198
{
    public int rob(int[] nums)
    {
        if(nums==null || nums.length==0)
            return 0;

        int profit[][] = new int[nums.length][2];
        profit[0][0] = nums[0];
        for(int i = 1;i < profit.length;i++)
        {
            // rob
            profit[i][0] = profit[i-1][1] + nums[i];
            // not rob
            profit[i][1] = Math.max(profit[i-1][0], profit[i-1][1]);
        }

        return Math.max(profit[profit.length-1][0], profit[profit.length-1][1]);
    }
}
