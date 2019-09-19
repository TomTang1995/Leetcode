package leetcode;

public class Q494
{
    public int findTargetSumWays(int[] nums, int S)
    {
        if(nums==null || nums.length==0)
            return 0;

        int sum = 0;
        for(int each : nums)
            sum = sum + each;

        if(sum < S)
            return 0;

        int temp[][] = new int[2*sum+1][nums.length+1];
        temp[sum][0] = 1;
        for(int i = 1;i < temp[0].length;i++)
        {
            for(int j = 0;j < temp.length;j++)
            {
                if(temp[j][i-1] != 0)
                {
                    temp[j+nums[i-1]][i] = temp[j+nums[i-1]][i] + temp[j][i-1];
                    temp[j-nums[i-1]][i] = temp[j-nums[i-1]][i] + temp[j][i-1];
                }
            }
        }

        return temp[S+sum][temp[0].length-1];
    }
}
