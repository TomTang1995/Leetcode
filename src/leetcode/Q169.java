package leetcode;

public class Q169
{
    public int majorityElement(int[] nums)
    {
        if(nums==null || nums.length==0)
            return 0;

        int current=nums[0], count=1;
        for(int i = 1;i < nums.length;i++)
        {
            if(count == 0)
            {
                current = nums[i];
                count++;
            }
            else if(nums[i] == current)
                count++;
            else
                count--;
        }

        return current;
    }
}
