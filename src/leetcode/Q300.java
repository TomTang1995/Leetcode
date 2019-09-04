package leetcode;

public class Q300
{
    public int lengthOfLIS(int[] nums)
    {
        if(nums==null || nums.length==0)
            return 0;

        int result[] = new int[nums.length];
        for(int i = 0;i < result.length;i++)
            result[i] = 1;

        for(int i = 1;i < nums.length;i++)
        {
            for(int j = 0;j < i;j++)
            {
                if(nums[i] > nums[j])
                    result[i] = Math.max(result[i], result[j]+1);
            }
        }

        int max = 0;
        for(int each : result)
            max = Math.max(max, each);

        return max;
    }
}
