package leetcode;

public class Q268
{
    public int missingNumber(int[] nums)
    {
        int sum = 0;
        for(int each : nums)
            sum = sum + each;

        return (nums.length)*(nums.length+1)/2 - sum;
    }
}
