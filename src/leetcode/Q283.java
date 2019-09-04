package leetcode;

public class Q283
{
    public void moveZeroes(int[] nums)
    {
        if(nums==null || nums.length==0)
            return;

        int insertIndex = 0;
        int searchIndex = 0;
        while(searchIndex < nums.length)
        {
            if(nums[searchIndex] != 0)
            {
                nums[insertIndex] = nums[searchIndex];
                insertIndex++;
            }
            searchIndex++;
        }

        for(;insertIndex < nums.length;insertIndex++)
            nums[insertIndex] = 0;
    }
}
