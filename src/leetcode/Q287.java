package leetcode;

public class Q287
{
    public int findDuplicate(int[] nums)
    {
        int number[] = new int[nums.length];
        for(int i = 0;i < nums.length;i++)
        {
            if(number[nums[i]] != 0)
                return nums[i];
            else
                number[nums[i]]++;
        }

        return 0;
    }
}
